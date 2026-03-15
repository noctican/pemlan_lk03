package src;

public class ElectronicProduct extends Product {
    private String warrantyPeriod;
    public ElectronicProduct(String productId, String name, double price, int stockQuantity, String warrantyPeriod){
        super(productId, name, price, stockQuantity);
        this.warrantyPeriod = warrantyPeriod;
    }
    @Override
    public double calculateDiscount(){
        if (getPrice() > 500000){
            return this.getPrice() * 0.069;
        }
        return this.getPrice() * 0.05;
    }
    @Override
    public void getProductInfo() {
        super.getProductInfo();
        System.out.printf(" Garansi : %-15s |", warrantyPeriod);
    }

    // Accessor
    public String getWarrantyPeriod(){
        return this.warrantyPeriod;
    }

    // Setter
    public void setWarrantyPeriod(String x){
        this.warrantyPeriod = x;
    }

}
