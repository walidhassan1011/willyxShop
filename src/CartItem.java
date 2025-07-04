public class CartItem {
    private Product _product;
    private int _quantity;

    public CartItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        this._product = product;
        this._quantity = quantity;
    }

    public Product getProduct() {
        return _product;
    }
    public int getQuantity() {
        return _quantity;
    }
    public double getTotalPrice() {
        return _product.getPrice() * _quantity;
    }
    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        this._quantity = quantity;
    }
    public void reduceQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (quantity > _quantity) {
            throw new IllegalArgumentException("the quantity to reduce is greater than the current quantity");
        }
        this._quantity -= quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "_product=" + _product +
                ", _quantity=" + _quantity +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
