public class TV extends NonExpireProduct implements Iship {
    private double weight;
    
    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
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
