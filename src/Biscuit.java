import java.time.LocalDate;

public class Biscuit extends ExpireProduct  {
   
    
    public Biscuit(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity, expiryDate);
        
        
    }
    
    @Override
    public boolean requiredShipping() {
        return false; 
    }
   
}
