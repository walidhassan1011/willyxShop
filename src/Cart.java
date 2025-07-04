import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> _items;

    public Cart() {
        this._items = new ArrayList<>();
    }
    public List<CartItem> getItems() {
        return _items;
    }

    public void addItem(Product product , int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (!product.isAvaible(quantity)) {
            throw new IllegalArgumentException("Not enough quantity available of " + product.getName());
        }
        for (CartItem item:_items){
            if (item.getProduct().getName().equals(product.getName())) {
                int newQuantity = item.getQuantity() + quantity;
                if (!product.isAvaible(newQuantity)) {
                    throw new IllegalArgumentException("Not enough quantity available of " + product.getName());
                }
                item.setQuantity(newQuantity);
                return;
            }
        }

        _items.add(new CartItem(product, quantity));
    }

    public void removeItem(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        for (CartItem item :_items){
            if (item.getProduct().getName().equals(product.getName())) {
                _items.remove(item);
                item.reduceQuantity(item.getQuantity());
                return;
            }
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : _items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void clear() {
        _items.clear();
    }

    @Override
    public String toString() {
        List<String> itemStrings = new ArrayList<>();
        for (CartItem item : _items) {
            itemStrings.add(item.toString());
        }
        return "Cart{" +
                "_items=" + String.join(", ", itemStrings) +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }

}
