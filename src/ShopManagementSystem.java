package src;

public class ShopManagementSystem {
    public static void main(String[] args) {
        Product[] barangBarang = new Product[6];
        Transaction[] daftarTransaksi = new Transaction[2];

        // generate product
        generateProduct(barangBarang);

        // show all product
        showAllProduct(barangBarang);

        // contoh penerapan overloading method updateStock()
        simulateUpdateStock(barangBarang);

        // simulasi transaksi penjualan
        simulateTransactions(barangBarang, daftarTransaksi);

        // laporan total penjualan, produk terlaris, dll.
        showTransactionReport(daftarTransaksi, barangBarang);
        
        System.out.println("========== TERIMA KASIH TELAH BERBELANJA DI FILKOM MART =========");
        System.out.println("-".repeat(65));
    }

    private static void generateProduct(Product[] products) {
         // food product
        products[0] = new FoodProduct("J-1000", "Roti Sari", 10000, 30, "22-04-2026");
        products[1] = new FoodProduct("P-1001", "Beras 1Kg", 17000, 12, "01-02-2027");

        // electronic product
        products[2] = new ElectronicProduct("E-2000", "Kipas Angin", 1000000, 5, "2 Tahun");
        products[3] = new ElectronicProduct("P-2001", "Canon 12A", 500000, 11, "3 Tahun");

        // clothing product
        products[4] = new ClothingProduct("SHIRT-112", "Blue Shirt", 300.000, 10, "L", "Polo");
        products[5] = new ClothingProduct("PANTS-111", "Grey Jeans", 150.000, 15, "M", "Levi's");
    }

    private static void showAllProduct(Product[] products) {
        System.out.println("=================== DAFTAR PRODUK FILKOM MART ===================");
        System.out.println("-".repeat(92));
        System.out.printf("| %-12s | %-15s | %-10s | %-5s | %-7s | %-25s |\n", "ID Produk", "Nama Produk", "Harga", "Stok", "Terjual", "Catatan");
        System.out.println("-".repeat(92));
        for (Product p : products) {
            p.getProductInfo();
            System.out.println();
        }
        System.out.println("-".repeat(92));
        System.out.println("\n");
    }

    private static void simulateUpdateStock(Product[] products) {
        System.out.println("========================== UPDATE STOK ==========================");

        // simulasi transaksi 1 (mengirim 1 parameter)
        System.out.println("-".repeat(65));
        System.out.printf("%-11s: %s\n", "Produk", products[0].getName());
        System.out.printf("%-11s: %d\n", "Stok Awal", products[0].getStockQuantity());
        System.out.printf("%-11s: ", "Catatan");
        products[0].updateStock(5);
        System.out.println();
        System.out.printf("%-11s: %d\n", "Stok Akhir", products[0].getStockQuantity());
        
        // simulasi transaksi 2 (mengirim 2 parameter)
        System.out.println("-".repeat(65));
        System.out.printf("%-11s: %s\n", "Produk", products[2].getName());
        System.out.printf("%-11s: %d\n", "Stok Awal", products[2].getStockQuantity());
        System.out.printf("%-11s: ", "Catatan");
        products[2].updateStock(2, "ditemukan 2 produk rusak");
        System.out.println();
        System.out.printf("%-11s: %d\n", "Stok Akhir", products[2].getStockQuantity());
        System.out.println("-".repeat(65));
        System.out.println("\n");
    }

    private static void simulateTransactions(Product[] products, Transaction[] transactions) {
        System.out.println("====================== SIMULASI TRANSAKSI =======================");
        System.out.println("-".repeat(65));
        
        // transaksi 1
        transactions[0] = new Transaction("TRX001");
        transactions[0].addItem(products[0]);
        transactions[0].addItem(products[2], 2);
        transactions[0].addItem(products[4]);
        
        System.out.println(">>> TRANSAKSI 1 (ID: " + transactions[0].getTransactionId() + ") <<<");
        transactions[0].showAllItems();
        
        double totalTrans1 = transactions[0].processSale();
        System.out.println("Total Transaksi 1: Rp" + String.format("%.0f", totalTrans1));
        System.out.println("-".repeat(65));
        System.out.println();
        
        // transaksi 2
        transactions[1] = new Transaction("TRX002");
        transactions[1].addItem(products[1], 2);
        transactions[1].addItem(products[3]);
        transactions[1].addItem(products[5], 3);
        
        System.out.println(">>> TRANSAKSI 2 (ID: " + transactions[1].getTransactionId() + ") <<<");
        transactions[1].showAllItems();
        
        double totalTrans2 = transactions[1].processSale();
        System.out.println("Total Transaksi 2: Rp" + String.format("%.0f", totalTrans2));
        System.out.println("-".repeat(65));
        System.out.println("\n");
    }
    
    private static void showTransactionReport(Transaction[] transactions, Product[] products) {
        System.out.println("======================= LAPORAN PENJUALAN =======================");
        System.out.println("-".repeat(65));
        
        // total penjualan
        double totalPendapatan = transactions[0].getTotalPrice() + transactions[1].getTotalPrice();
        double totalTerjual = 0;
        
        for(Product x : products){
            totalTerjual += x.getSoldQuantity();
        }

        System.out.println("Total Pendapatan: Rp" + String.format("%.0f", totalPendapatan));
        System.out.println("Total Barang Terjual : " + totalTerjual);
        System.out.println("-".repeat(65));
        
        // rincian per transaksi
        System.out.println("Rincian per Transaksi:");
        for (Transaction t : transactions) {
            System.out.println("- Transaksi " + t.getTransactionId() + ": Rp" + t.getTotalPrice() + " (" + t.getTotalItems() + " item)");
        }
        System.out.println("-".repeat(65));
        
        // produk terlaris (berdasarkan quantity terjual)
        Product terlaris = null;
        int maxSold = -1;
        
        for (Product p : products) {
            int sold = p.getSoldQuantity();
            
            if (sold > maxSold) {
                maxSold = sold;
                terlaris = p;
            }
        }
        
        if (terlaris != null) {
            System.out.println(">>> PRODUK TERLARIS: " + terlaris.getName() + " (Terjual " + maxSold + " unit) <<<");
        }
        System.out.println("-".repeat(65));
        
        // sisa stok setelah transaksi
        System.out.println("Sisa Stok Setelah Transaksi:");
        for (Product p : products) {
            System.out.println("- " + p.getName() + ": " + p.getStockQuantity() + " unit");
        }
        System.out.println("-".repeat(65));
    }
}

