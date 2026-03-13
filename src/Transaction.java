package src;

import java.util.ArrayList;

public class Transaction {
    private String transactionId;
    private ArrayList<Product> items;
    private ArrayList<Integer> itemQty;
    private int totalItems = 0;

    public Transaction(String transactionId){
        this.transactionId = transactionId;
        this.items = new ArrayList<>();
        this.itemQty = new ArrayList<>();
    }

    public double processSale() {
        double totalPrice = 0;
        int terproses = 0;
        for (int i = 0; i < items.size(); i++) {
            Product item = items.get(i);
            int qty = itemQty.get(i);
            if (item != null) {
                if(item.getStockQuantity() >= qty){
                    totalPrice += item.getPrice() - item.calculateDiscount();
                    item.updateStock(qty);
                    item.updateSold(qty);
                    terproses++;
                }
            }
        }
        totalItems = terproses;
        System.out.println("Item yang terproses di Transaksi " + this.transactionId + " : " + terproses + " / " + totalItems);
        return totalPrice;
    }

    public void addItem(Product item) {
        if(items.contains(item)) {
            int index = items.indexOf(item);
            itemQty.set(index, itemQty.get(index) + 1);
        } else {
            items.add(item);
            itemQty.add(1);
        }
        totalItems++;
    }

    public void addItem(Product item, int quantity) {
        if(items.contains(item)) {
            int index = items.indexOf(item);
            itemQty.set(index, itemQty.get(index) + quantity);
        } else {
            items.add(item);
            itemQty.add(quantity);
        }
        totalItems += quantity;
    }

    // Accessor
    public String getTransactionId() {
        return this.transactionId;
    }

    public int getTotalItems() {
        return this.totalItems;
    }

    public ArrayList<Product> getItems() {
        return this.items;
    }

    public int getTotalPrice() {
        double totalPrice = 0;
        for (Product item : items) {
            if (item != null) {
                totalPrice += item.getPrice() - item.calculateDiscount();
            }
        }
        return (int) totalPrice;
    }

    public void showAllItems() {
        System.out.println("Daftar Item:");
        System.out.println("-".repeat(65));
        System.out.printf("| %-30s | %-10s | %-15s |\n", "Nama", "Jumlah", "Diskon");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("| %-30s | %-10d | %-15.2f |\n", items.get(i).getName(), itemQty.get(i), items.get(i).calculateDiscount());
        }
        System.out.println("-".repeat(65));
    }
}