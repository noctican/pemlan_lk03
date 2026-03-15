package src;
public class FoodProduct extends Product {
    private String expiryDate; 

    public FoodProduct(String productId, String name, double price, int stockQuantity, String expiryDate) {
        super(productId, name, price, stockQuantity);
        this.expiryDate = expiryDate;
    }
    @Override
    public double calculateDiscount() {
        if (getStockQuantity() > 10) {
            return this.getPrice() * 0.10;
        }
        return 0.0;
    }
    @Override
    public void getProductInfo() {
        super.getProductInfo();
        System.out.printf(" kadaluwarsa : %-11s |", expiryDate);
    }

    // Accessor
    public String getExpiryDate(){
        return this.expiryDate;
    }

    // Setter
    public void setExpiryDate(String x){
        this.expiryDate = x;
    }

}
