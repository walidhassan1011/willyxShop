public class Mobile extends NonExpireProduct{
    public Mobile(String name, double price, int quantity) {
        super(name, price, quantity);
    }
    
    @Override
    public boolean requiredShipping() {
        return false; 
    }
}
