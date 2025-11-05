import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String namaBarang = "";
        try (Scanner input = new Scanner(System.in)) {
        int pilihan, jumlah, harga = 0;
        double totalBelanja = 0;
        String lanjut = "y";

        System.out.println("=== Program Kasir Sederhana ===");

        do {
            System.out.println("/nDaftar menu barang");
            System.out.println("1. Pensil (Rp 2.000)");
            System.out.println("2. Buku Tulis (Rp 5.000)");
            System.out.println("3. Penghapus (Rp 1.500)");
            System.out.println("4. Pulpen (Rp 3.000)");
            System.out.println("Penggaris (Rp 2.500)");
            System.out.print("Masukkan pilihan barang (1-5): ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    namaBarang = "Pensil";
                    harga = 2000;
                    break;
                case 2:
                    namaBarang = "Buku Tulis";
                    harga = 5000;
                    break;
                case 3:
                    namaBarang = "Penghapus";
                    harga = 1500;
                    break;
                case 4:
                    namaBarang = "Pulpen";
                    harga = 3000;
                    break;
                case 5:
                    namaBarang = "Penggaris";
                    harga = 2500;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silahkan coba lagi!");
                    continue;

            }

            System.out.print("Masukkan jumlah " + namaBarang + ": ");
            jumlah = input.nextInt(); // Assign user input to jumlah
            double total = harga * jumlah;
            totalBelanja += total;
            
            System.out.print("/nApakah Anda ingin membeli barang lain? (y/n):");
            lanjut = input.next();
            
        } while (lanjut.equalsIgnoreCase("y"));
        //menghitung diskon

        double diskon = 0;
        if (totalBelanja >= 50000) {
            diskon = 0.10;
        } else if (totalBelanja >= 25000) {
            diskon = 0.05;
        }
        double totalAkhir = totalBelanja - (totalBelanja * diskon);
        System.out.println("/nTotal belanja Anda: Rp" + totalBelanja);
        
        System.out.println("\n=== Struk Pembayaran ===");
        System.out.println("Total Belanja : Rp " + totalBelanja);
        System.out.println("Diskon        : " + (diskon * 100) + "%");
        System.out.println("Total Bayar   : Rp " + totalAkhir);
        
        System.out.println("Masukkan uang pembayaran: Rp");
        double bayar = input.nextDouble();

        double kembalian = bayar - totalAkhir;
        System.out.println("Kembalian Anda: Rp" + kembalian);
        System.out.println("Terima kasih telah berbelanja!");

        input.close();
        }

    }
}