public class PerishableProduct extends Product {
    private String expiryDate;

    public PerishableProduct(String productId, String name, double price, int quantity, String expiryDate) {
        super(productId, name, price, quantity);
        setExpiryDate(expiryDate);
    }

    public String getExpiryDate() { return expiryDate; }

    public void setExpiryDate(String expiryDate) {
        if (expiryDate == null || expiryDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Expiry date cannot be empty.");
        }
        this.expiryDate = expiryDate.trim();
    }

    @Override
    public String getProductInfo() {
        return "Perishable Product [" + baseInfo() + ", Expiry Date: " + expiryDate + "]";
    }
}