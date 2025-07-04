public abstract class Product {
    private String _name;
    private double _price;
    private int _quantity;

    public Product(String name, double price, int quantity) {
        this._name = name;
        this._price = price;
        this._quantity = quantity;
    }

    public String getName() {
        return _name;
    }
    public double getPrice() {
        return _price;
    }
    public int getQuantity() {
        return _quantity;
    }
    public void setName(String name) {
        this._name = name;
    }
    public void setPrice(double price) {
        this._price = price;
    }
    public void setQuantity(int quantity) {
        this._quantity = quantity;
    }
    public boolean isAvaible(int requestedQuantity) {
        return _quantity >= requestedQuantity;
    }
    public void sell(int requestedQuantity) {
        if (isAvaible(requestedQuantity)) {
            _quantity -= requestedQuantity;
        } else {
            throw new IllegalArgumentException("Not enough quantity available of " + _name);
        }
    }
    public void restock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        this._quantity += quantity;
    }

    public abstract boolean isExpired();

    public abstract boolean requiredShipping();

    @Override
    public String toString() {
        return "Product{" +
                "_name='" + _name + '\'' +
                ", _price=" + _price +
                ", _quantity=" + _quantity +
                '}';
    }

}
