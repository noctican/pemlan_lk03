package src;

import java.util.ArrayList;
import src.Product;

public class Transaction {
    private String transactionId;
    private ArrayList<Product> items;
    private int totalItems = 0;

    public Transaction(String transactionId){
        this.transactionId = transactionId;
        this.items = new ArrayList<>();
    }

    public double processSale() {
        double totalPrice = 0;
        for (Product item : items) {
            if (item != null) {
                totalPrice += item.getPrice() - item.calculateDiscount();
            }
        }
        return totalPrice;
    }

    public void addItem(Product item) {
        items.add(item);
        totalItems++;
    }

    public void addItem(Product item, int quantity) {
        for (int i = 0; i < quantity; i++) items.add(item);
        totalItems += quantity;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public int getTotalItems() {
        return this.totalItems;
    }

    public ArrayList<Product> getItems() {
        return this.items;
    }
}