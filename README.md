# LK03 - Kelas, Obyek, Constructor, Inheritance, Polymorphism, Overloading dan Overriding

## Kelompok
<table>
    <thead>
        <tr>
            <th>Nama</th>
            <th>NIM</th>
            <th>Kontribusi</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Candra Andika Putra</td>
            <td>255150200111035</td>
            <td>
                <ul>
                    <li>Mengimplementasikan class ClothingProduct.</li>
                    <li>Mengimplementasikan class Transaction.</li>
                    <li>Melakukan perbaikan class ShopManagementSystem.</li>
                    <li>Penyesuaian laporan LK03.</li>
                </ul>
            </td>
        </tr>
        <tr>
            <td>Haidar Nadhifa Putra</td>
            <td>255150201111031</td>
            <td>
                <ul>
                    <li>Mengimplementasikan abstract class Product.</li>
                    <li>Memperbaiki beberapa aturan untuk menyesuaikan LK03.</li>
                    <li>Menyamakan logika antar subclass.</li>
                    <li>Membuat kerangka laporan.</li>
                    <li>Membuat class diagram. </li>
                </ul>
            </td>
        </tr>
        <tr>
            <td>Bagas Zakaria</td>
            <td>255150207111064</td>
            <td>
                <ul>
                    <li>Mengimplementasikan class FoodProduct.</li>
                    <li>Melakukan penyesuaian pada abstract class Product.</li>
                </ul>
            </td>
        </tr>
        <tr>
            <td>Muhammad Hilmi Isnaeni</td>
            <td>255150201111026</td>
            <td>
                <ul>
                    <li>Mengimplementasikan class main ShopManagementSystem.</li>
                    <li>Penyesuaian laporan LK03.</li>
                </ul>
            </td>
        </tr>
        <tr>
            <td>Noval Zakky Ramadhan</td>
            <td>255150201111030</td>
            <td>
                <ul>
                    <li>Mengimplementasikan class ElectronicProduct</li>
                    <li>Kerangka awal tampilan output</li>
                </ul>
            </td>
        </tr>
    </tbody>
</table>

## Deskripsi Soal
Sebagai seorang developer software , Anda diminta untuk merancang struktur dasar perangkat lunak untuk sebuah toko ritel offline bernama "Filkom Mart". Toko ini menjual berbagai kategori produk dengan aturan tertentu. Tugas Anda adalah membuat model class diagram dan aplikasi Point Of Sale (POS) dari toko Filkom Mart dan kemudian mengimplementasikannya kedalam program java menggunakan paradigma Pemrograman Berorientasi Object (PBO). 

## Spesifikasi Teknis

### 1. Class Utama (Product)

Definisikan class abstrak Product sebagai superclass dimana Atributnya sbb:
- String productId
- String name
- double price
- int stockQuantity

Sedangkan Methodnya adalah sbb:
- Konstruktor default dan parameterized.
- Method abstrak double calculateDiscount() — menghitung diskon untuk setiap produk.
- Method getProductInfo() — menampilkan informasi produk dasar.
- Overload method updateStock(int quantity) dan updateStock(int quantity, String
reason).

### 2. Subclass (FoodProduct, ElectronicProduct, ClothingProduct)

Buat tiga subclass yang mewarisi dari Product:
- FoodProduct: Produk makanan/minuman
    - Atribut tambahan: String expiryDate
    - Override calculateDiscount(): 10% jika stok > 10
- ElectronicProduct: Produk elektronik
    - Atribut tambahan: String warrantyPeriod
    - Override calculateDiscount(): 5% + bonus 2% jika harga > 500rb
- ClothingProduct: Produk pakaian
    - Atribut tambahan: String size, String brand
    - Override calculateDiscount(): 15% untuk ukuran L-XL

### 3. Class Transaction

Mengelola penjualan satu transaksi.
- Atribut: String transactionId, Product[] items, int totalItems
- Method:
    - double processSale() — hitung total harga setelah diskon semua item
    - Method overloading addItem(Product item) dan addItem(Product item, int quantity)

### 4. Class Utama ShopManagementSystem Di method main():

- Buat array bertipe Product[] berisi minimum 6 objek (2 per subclass).
- Gunakan polymorphism untuk menampilkan info dan hitung diskon semua produk.
- Simulasikan 2 transaksi penjualan menggunakan class Transaction.
- Tampilkan laporan: total penjualan, produk terlaris, dll.

## Ketentuan

Filtur yang wajib ada adalah:
1. Enkapsulasi (getter/setter private fields)
2. Inheritance (3 subclass dari Product)
3. Method Overriding (calculateDiscount())
4. Method Overloading (updateStock, addItem)
5. Polymorphism (array Product[] + method calls)
6. Object instantiation dan array (Pelajari arrayList)