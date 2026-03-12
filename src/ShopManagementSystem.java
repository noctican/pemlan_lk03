package src;
import java.util.ArrayList;

public class ShopManagementSystem {
    public static void main(String[] args) {
        Product[] barangBarang = new Product[6];

        // food product
        barangBarang[0] = new FoodProduct("J-1000", "Roti Sari", 10000, 30, "22-04-2026");
        barangBarang[1] = new FoodProduct("P-1001", "Beras 1Kg", 17000, 12, "01-02-2027");

        // electronic product
        barangBarang[2] = new ElectronicProduct("E-2000", "Kipas Angin Samsung", 1000000, 5, "2 Years");
        barangBarang[3] = new ElectronicProduct("HP-2001", "Oneplus 15", 15000000, 11, "3 Years");

        // clothing product
        barangBarang[4] = new ClothingProduct("SHIRT-112", "Blue Shirt", 300.000, 10, "L", "Polo");
        barangBarang[5] = new ClothingProduct("PANTS-111", "Grey Jeans", 150.000, 15, "M", "Levi's");

        for (Product barang : barangBarang) {
            barang.getProductInfo();
        }
    }
}

