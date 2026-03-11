<h1>pemlan-03</h1>
Praktikum Pemrograman Lanjut Bab 3. Constructor dan Instance Method

Buatlah sebuah Program Mesin ATM yang menerima input berupa nomor kartu ATM, dan password. Setiap Kartu ATM menyimpan data sebuah rekening yang berisikan nomor rekening, nama pemilik rekening, saldo, bank. Setiap Bank memiliki kode bank dan nama bank. Kartu ATM dapat digunakan untuk mengambil uang, mengecek saldo, dan transfer uang. Semua bank memiliki ketentuan

Uang dapat diambil jika sisa sisa saldo setelah diambil lebih dari sama dengan 10rb rupiah
Uang dapat di transfer jika sisa saldo setelah di transfer lebih dari sama dengan 25rb rupiah
Uang yang di transfer ke rekening bank yang sama tidak ada potongan
Uang yang di transfer ke rekening bank lain akan memiliki potongan 5rb rupiah (dan tetap harus lebih dari sama dengan 25rb rupiah setelah potongan)
Harus ada constructor dari setiap kelas

Misal: Rekening A Bank BRI Saldo 150rb Transfer 125rb ke Rekening B BANK BCA Saldo 50rb Transfer gagal karena 150rb - 125rb+5rb < 25rb Rekening A Bank BRI Saldo 150rb Transfer 120rb ke Rekening B BANK BCA Saldo 50rb Transfer berhasil karena 150rb - 120rb+5rb = 25rb, Saldo Rekening B 170rb

Class ATM
noAtm: int
password: int
rekening: Rekening
cekPassword(int): boolean
Class Bank +kode: int +nama: String

Class Rekening

noRek: int

nama: String //Nama Pemilik Rekening

saldo: double

bank: Bank

cekSaldo(): void //Mengecek saldo

ambil(int): boolean //Mengambil uang

transfer(Rekening, jumlah): void //Mentransfer dari rekening asal, ke rekening tujuan

Class Main (Masukan Kartu ATM, Masukan Password, Pilih (Cek Saldo, Ambil, Transfer), Jika Ambil Masukkan Nominal, Jika Transfer Masukkan Rekening, Masukkan Nominal)
