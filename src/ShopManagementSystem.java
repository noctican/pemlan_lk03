package src;

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

        // info produk, harga, dan diskon
        System.out.println("========== DAFTAR PRODUK FILKOM MART ==========");
        System.out.println();
        
        for (Product p : barangBarang) {
            System.out.println("---------- Informasi Produk ----------");
            p.getProductInfo();
            double diskon = p.calculateDiscount();
            double hargaSetelahDiskon = p.getPrice() - diskon;
            System.out.println("Diskon : Rp" + String.format("%.0f", diskon));
            System.out.println("Harga Setelah Diskon : Rp" + String.format("%.0f", hargaSetelahDiskon));
            System.out.println();
        }

        // contoh penerapan overloading method updateStock()
        System.out.println("========== UPDATE STOK ==========");
        System.out.println();
        
        // mengurangi stok dengan satu parameter
        System.out.println("Stok " + barangBarang[0].getName() + " sebelum update: " + barangBarang[0].getStockQuantity());
        barangBarang[0].updateStock(5);
        System.out.println("Stok " + barangBarang[0].getName() + " setelah update (kurang 5): " + barangBarang[0].getStockQuantity());
        System.out.println();
        
        // mengurangi stok dengan dua parameter (dengan alasan)
        System.out.println("Stok " + barangBarang[2].getName() + " sebelum update: " + barangBarang[2].getStockQuantity());
        barangBarang[2].updateStock(2, "Ada produk rusak, stok dikurangi 2");
        System.out.println("Stok " + barangBarang[2].getName() + " setelah update: " + barangBarang[2].getStockQuantity());
        System.out.println();

        // simulasi transaksi penjualan
        System.out.println("========== SIMULASI TRANSAKSI ==========");
        System.out.println();
        
        // transaksi 1
        Transaction transaksi1 = new Transaction("TRX001");
        transaksi1.addItem(barangBarang[0]);
        transaksi1.addItem(barangBarang[2], 2);
        transaksi1.addItem(barangBarang[4]);
        
        System.out.println(">>> TRANSAKSI 1 (ID: " + transaksi1.getTransactionId() + ") <<<");
        System.out.println("Daftar Item yang dibeli:");
        for (Product item : transaksi1.getItems()) {
            if (item != null) {
                System.out.println("- " + item.getName() + " | Harga: Rp" + String.format("%.0f", item.getPrice()) + " | Diskon: Rp" + String.format("%.0f", item.calculateDiscount()));
            }
        }
        System.out.println();
        
        double totalTrans1 = transaksi1.processSale();
        System.out.println("Total Transaksi 1: Rp" + String.format("%.0f", totalTrans1));
        System.out.println();
        
        // transaksi 2
        Transaction transaksi2 = new Transaction("TRX002");
        transaksi2.addItem(barangBarang[1]); // Coca Cola
        transaksi2.addItem(barangBarang[3], 5); // 5 Kabel USB
        transaksi2.addItem(barangBarang[5], 2); // 2 Kemeja Flanel
        
        System.out.println(">>> TRANSAKSI 2 (ID: " + transaksi2.getTransactionId() + ") <<<");
        System.out.println("Daftar Item yang dibeli:");
        for (Product item : transaksi2.getItems()) {
            if (item != null) {
                System.out.println("- " + item.getName() + " | Harga: Rp" + String.format("%.0f", item.getPrice()) + " | Diskon: Rp" + String.format("%.0f", item.calculateDiscount()));
            }
        }
        System.out.println();
        
        double totalTrans2 = transaksi2.processSale();
        System.out.println("Total Transaksi 2: Rp" + String.format("%.0f", totalTrans2));
        System.out.println();

        // laporan total penjualan, produk terlaris, dll.
        System.out.println("========== LAPORAN PENJUALAN ==========");
        System.out.println();
        
        // total penjualan
        double totalPendapatan = totalTrans1 + totalTrans2;
        double totalTerjual = 0;

        for(Product x : barangBarang){
            totalTerjual += x.getSoldQuantity();
        }

        System.out.println("Total Pendapatan: Rp" + String.format("%.0f", totalPendapatan));
        System.out.println("Total Barang Terjual : " + totalTerjual);
        System.out.println();
        
        // rincian per transaksi
        System.out.println("Rincian per Transaksi:");
        System.out.println("- Transaksi " + transaksi1.getTransactionId() + ": Rp" + String.format("%.0f", totalTrans1) + " (" + transaksi1.getTotalItems() + " item)");
        System.out.println("- Transaksi " + transaksi2.getTransactionId() + ": Rp" + String.format("%.0f", totalTrans2) + " (" + transaksi2.getTotalItems() + " item)");
        System.out.println();
        
        // produk terlaris (berdasarkan quantity terjual)
        System.out.println("Produk Terlaris:");
        Product terlaris = null;
        int maxSold = -1;
        
        for (Product p : barangBarang) {
            int sold = p.getSoldQuantity();
            System.out.println("- " + p.getName() + ": terjual " + sold + " unit");
            
            if (sold > maxSold) {
                maxSold = sold;
                terlaris = p;
            }
        }
        
        if (terlaris != null) {
            System.out.println("\n>>> PRODUK TERLARIS: " + terlaris.getName() + " (Terjual " + maxSold + " unit) <<<");
        }
        System.out.println();
        
        // sisa stok setelah transaksi
        System.out.println("Sisa Stok Setelah Transaksi:");
        for (Product p : barangBarang) {
            System.out.println("- " + p.getName() + ": " + p.getStockQuantity() + " unit");
        }
        System.out.println();
        
        System.out.println("========== TERIMA KASIH TELAH BERBELANJA DI FILKOM MART ==========");
    }
}

