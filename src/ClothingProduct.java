package src;

public class ClothingProduct extends Product {
    private String size, brand;

    public ClothingProduct(String productId, String name, double price, int stockQuantity, String size, String brand) {
        super(productId, name, price, stockQuantity);
        this.size = size;
        this.brand = brand;
    }

    @Override
    public double calculateDiscount() {
        if (size.equals("L") || size.equals("XL")) return this.getPrice() * 0.15;
        return 0.0;
    }

    @Override
    public void getProductInfo() {
        super.getProductInfo();
        System.out.printf(" Ukuran : %-16s |", size);
    }

    public String getSize() {
        return size;
    }

    public String getBrand() {
        return brand;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
