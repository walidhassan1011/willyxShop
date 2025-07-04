import java.time.LocalDate;

public class Cheese extends ExpireProduct implements Iship {
    private double weight;
    
    public Cheese(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weight = weight;
    }
    
    @Override
    public boolean requiredShipping() {
        return true; 
    }
    @Override
    public double getWeight() {
        return weight;
    }   
}   
