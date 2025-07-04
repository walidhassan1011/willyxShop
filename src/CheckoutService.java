import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    
    private ShippingService _shippingService;
    public CheckoutService() {
        
        this._shippingService = new ShippingService();
    }

    public void checkout (Customer customer, Cart cart){
        valiateCheckout(customer, cart);
        double totalPrice = cart.getTotalPrice();
        List<Iship> shippingItems = getShipItems(cart);
        double shippingCost = _shippingService.calculateShippingCost(shippingItems);
        totalPrice += shippingCost;
        customer.reduceBalance(totalPrice);
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            product.sell(item.getQuantity());
        }
        if (!shippingItems.isEmpty()) {
            _shippingService.processShipping(shippingItems);
        }
        PrintReceipt( totalPrice,shippingCost, customer, cart);
        cart.clear();

    }

    private void valiateCheckout(
            Customer customer,
            Cart cart
    ){

        for (CartItem item : cart.getItems()) {
            if (item.getProduct().isExpired()) {
                throw new IllegalArgumentException("Cannot checkout expired product: " + item.getProduct().getName());
            }
            if(!item.getProduct().isAvaible(item.getQuantity())){
                throw new IllegalArgumentException("Not enough quantity available for product: " + item.getProduct().getName());
            }

        }
     double totalPrice = cart.getTotalPrice();
     List<Iship> shippingItems = getShipItems(cart);
    double shippingCost = _shippingService.calculateShippingCost(shippingItems);
        totalPrice += shippingCost;
        if (customer.getBalance() < totalPrice) {
            throw new IllegalArgumentException("no enough balance for checkout. Total price: " + totalPrice + ", Balance: " + customer.getBalance());
        }
        
        

    }

    private List<Iship> getShipItems(Cart cart) {
        List<Iship> shippingItems = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().requiredShipping() && item.getProduct() instanceof Iship) {
                Iship shipItem = (Iship) item.getProduct();
                shippingItems.add(shipItem);
            }

        }
        return shippingItems;
    }

    private void PrintReceipt(
            double totalPrice,
            double shippingCost,
            Customer customer,
            Cart cart
    ) {
        System.out.println("** Checkout Receipt **");
        // System.out.println("Customer: " + customer.getName());
        System.out.println("Items purchased:");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() +" x "+"  "+item.getProduct().getName() +"      " + item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtolal" +" "+ totalPrice);
        System.out.println("Shipping "+" " + shippingCost);
        System.out.println("Amount  " +" " + (totalPrice + shippingCost));
    }
}
