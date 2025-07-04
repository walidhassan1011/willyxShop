import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {

         
          Customer customer = new Customer("WALID HASSAN", "WALIDHASSAN@gmail.com", 100000.0);
        //   System.out.println("Customer: " + customer.toString() + "\n");
          
          Cheese cheese = new Cheese("Cheese", 100.0, 10, LocalDate.now().plusDays(7), 200.0); 
          TV tv = new TV("TV", 500.0, 5, 5000.0); 
            Mobile mobile = new Mobile("Mobile", 200.0, 10);
            Biscuit biscuit = new Biscuit("Biscuit", 50.0, 20, LocalDate.now().plusDays(30));
          Cart cart = new Cart();
          CheckoutService checkoutService = new CheckoutService();

          //System.out.println("=== Adding items to cart ===");
        cart.addItem(cheese, 2);
         cart.addItem(tv, 1); 
         cart.addItem(mobile, 1);
         cart.addItem(biscuit, 2);
       // System.out.println("=== Performing Checkout ===");
        checkoutService.checkout(customer, cart);
        //System.out.println("\nCustomer balance after purchase: $" + customer.getBalance());
        
        
        //System.out.println("\n=== Error Case Demonstrations ===");
        // try {
        //     // Attempt to add an expired product
        //     Cheese expiredCheese = new Cheese("Expired Cheese", 50.0, 5, LocalDate.now().minusDays(1), 100.0);
        //     cart.addItem(expiredCheese, 1);
        // } catch (IllegalArgumentException e) {
        //     System.out.println("Error: " + e.getMessage());
        // }

        // try {
        //     Customer poorCustomer = new Customer("Poor John", "poor@example.com", 10.0);
        //     Cart expensiveCart = new Cart();
        //     expensiveCart.addItem(tv, 1);
        //     checkoutService.checkout(poorCustomer, expensiveCart);
        // } catch (IllegalStateException e) {
            
        //     System.out.println("Error: " + e.getMessage());
        // }

        // try {
        //     Cart bigCart = new Cart();
        //     bigCart.addItem(cheese, 20); // More than available quantity
        // } catch (IllegalArgumentException e) {
        //     System.out.println("Out of stock error: " + e.getMessage());
        // }
        //System.out.println("\n=== End of Demo ===");
    }
}
