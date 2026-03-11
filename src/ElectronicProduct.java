package src;

public class ElectronicProduct extends Product {
    private String warrantyPeriod;
    public ElectronicProduct(String productId, String name, double price, int stockQuantity, String warrantyPeriod){
        super(productId, name, price, stockQuantity);
        this.warrantyPeriod = warrantyPeriod;
    }
    @Override
    public Double calculateDiscount(){
        if (getPrice() > 500000){
            return 0.069;
        }
        return 0.05;
    }
    @Override
    public void getProductInfo() {
        super.getProductInfo();
        System.out.println("Warranty Period: " + warrantyPeriod);
    }
}
