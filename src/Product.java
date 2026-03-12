package src;

public abstract class Product {
    // Atribut
    private String productId;
    private String name;
    private double price;
    private int stockQuantity;
    private int soldQuantity = 0;

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

    public void updateStock(int dikurang){
        this.stockQuantity -= dikurang;
    }

    public void updateStock(int dikurang, String info){
        this.stockQuantity -= dikurang;
        System.out.println(info);
    }

    public void updateSold(int ditambah){
        this.soldQuantity += ditambah;
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

    public int getSoldQuantity(){
        return this.soldQuantity;
    }

    // Setter
    public void setProductId(String x){
        this.productId = x;
    }

    public void setName(String x){
        this.name = x;
    }

    public void setPrice(double x){
        this.price = x;
    }

    public void setStockQuantity(int x){
        this.stockQuantity = x;
    }

    public void setSoldQuantity(int x){
        this.soldQuantity = x;
    }
}
