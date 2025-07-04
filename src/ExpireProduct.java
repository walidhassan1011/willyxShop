import java.time.LocalDate;

public abstract class ExpireProduct extends Product{

    private LocalDate _expiryDate;

    public ExpireProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        if (expiryDate == null || expiryDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Expiry date must be a future date");
        }
        this._expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(_expiryDate);
    }
    public LocalDate getExpiryDate() {
        return _expiryDate;
    }
    
}
