public abstract class NonExpireProduct extends Product {

    public NonExpireProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isExpired() {
        return false; // Non-expire products are never expired
    }
    

}
