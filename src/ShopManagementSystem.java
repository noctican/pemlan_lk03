package src;

// import java.util.ArrayList;

public class ShopManagementSystem {
    public static void main(String[] args) {
        Product[] barangBarang = new Product[2];

        // food product
        // barang[0] = new FoodProduct();
        // barang[1] = new FoodProduct();

        // electronic product
        // barang[2] = new ElectronicProduct();
        // barang[3] = new ElectronicProduct();

        // clothing product
        barangBarang[0] = new ClothingProduct("SHIRT-112", "Blue Shirt", 300.000, 10, "L", "Polo");
        barangBarang[1] = new ClothingProduct("PANTS-111", "Grey Jeans", 150.000, 15, "M", "Levi's");

        for (Product barang : barangBarang) {
            barang.getProductInfo();
        }
    }
}

