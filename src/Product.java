package src;

public abstract class Product {
    // Atribut
    private String productId;
    private String name;
    private double price;
    private int stockQuantity;

    // Constructor
    public Product(String productId, String name, double price, int stockQuantity){
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Method
    public abstract double calculateDiscount();
    public void getProductInfo(){
        System.out.println("Product ID     : " + productId);
        System.out.println("Name           : " + name);
        System.out.println("Price          : " + price);
        System.out.println("Stock Quantity : " + stockQuantity);
    }

    public void updateStock(int x){
        this.stockQuantity = x;
    }

    public void updateStock(int x, String info){
        this.stockQuantity = x;
        System.out.println(info);
    }

    // Accessor
    public String getProductId(){
        return this.productId;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getStockQuantity(){
        return this.stockQuantity;
    }
}
