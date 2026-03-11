package src;

import src.Product;

public class ClothingProduct extends Product {
    private String size;
    private String brand;

    public ClothingProduct(String productId, String name, Double price, int stockQuantity, String size, String brand) {
        super(productId, name, price, stockQuantity);
        this.size = size;
        this.brand = brand;
    }

    @Override
    public Double calculateDiscount() {
        if (size.equals("L") || size.equals("XL")) return this.getPrice() * 0.15;
        return 0.0;
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