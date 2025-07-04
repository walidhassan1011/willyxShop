public class Customer {
    private String _name;
    private String _email;
    private double _balance;

    public Customer(String name, String email, double balance) {
        this._name = name;
        this._email = email;
        this._balance = balance;
      
    }

    public String getName() {
        return _name;
    }

    public String getEmail() {
        return _email;
    }

   
    public void setName(String name) {
        this._name = name;
    }

    public void setEmail(String email) {
        this._email = email;
    }

    public double getBalance() {
        return _balance;
    }
    public void setBalance(double balance) {
        this._balance = balance;
    }

    public void addBalance(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this._balance += amount;
    }

    public void reduceBalance(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > this._balance) {
            throw new IllegalArgumentException("No enough balance");
        }
        this._balance -= amount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "_name='" + _name + '\'' +
                ", _email='" + _email + '\'' +
                ", _balance=" + _balance +
                '}';
    }
}
   
