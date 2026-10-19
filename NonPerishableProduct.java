public class NonPerishableProduct extends Product {
    private String warrantyPeriod;

    public NonPerishableProduct(String productId, String name, double price, int quantity, String warrantyPeriod) {
        super(productId, name, price, quantity);
        setWarrantyPeriod(warrantyPeriod);
    }

    public String getWarrantyPeriod() { return warrantyPeriod; }

    public void setWarrantyPeriod(String warrantyPeriod) {
        if (warrantyPeriod == null || warrantyPeriod.trim().isEmpty()) {
            throw new IllegalArgumentException("Warranty period cannot be empty.");
        }
        this.warrantyPeriod = warrantyPeriod.trim();
    }

    @Override
    public String getProductInfo() {
        return "Non-Perishable Product [" + baseInfo() + ", Warranty Period: " + warrantyPeriod + "]";
    }
}