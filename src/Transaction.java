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
        double totalDiscount = 0;

        int terproses = 0;
        for (int i = 0; i < items.size(); i++) {
            Product item = items.get(i);
            int qty = itemQty.get(i);
            if (item != null) {
                if(item.getStockQuantity() >= qty){
                    for(int j = 0; j < qty; j++) {
                        totalDiscount += item.calculateDiscount();
                        totalPrice += item.getPrice();
                        item.updateStock(1);
                        item.updateSold(1);
                    }
                    terproses++;
                }
            }
        }
        System.out.println("Item yang terproses di Transaksi " + this.transactionId + " : " + terproses + " / " + items.size());
        System.out.println("Total pembelian : Rp " + totalPrice);
        System.out.println("Total diskon : Rp " + totalDiscount);
        return totalPrice - totalDiscount;
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
        System.out.printf("| %-38s | %-20s |\n", "Nama", "Jumlah");
        System.out.println("-".repeat(65));
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("| %-38s | %-20d |\n", items.get(i).getName(), itemQty.get(i));
        }
        System.out.println("-".repeat(65));
    }
}