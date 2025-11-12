import java.util.ArrayList;
import java.util.Scanner;

public class Bioskop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String namaPemesan, metodePembayaran = "";
        double totalBelanja = 0, diskon = 0;
        int pilihan, harga = 0, jumlah = 0;
        String lanjut = "y";

        // Daftar film, jumlah, dan subtotal
        ArrayList<String> daftarFilm = new ArrayList<>();
        ArrayList<Integer> daftarJumlah = new ArrayList<>();
        ArrayList<Integer> daftarHarga = new ArrayList<>();

        try {
            System.out.println("=== Selamat Datang di Bioskop AyamGolek ===");
            System.out.print("Masukkan nama pemesan: ");
            namaPemesan = input.nextLine();

            // Pilih metode pembayaran
            do {
                System.out.println("\nPilih Metode Pembayaran");
                System.out.println("1. OVO");
                System.out.println("2. Dana");
                System.out.println("3. Gopay");
                System.out.println("4. ShopeePay");
                System.out.print("Pilih metode pembayaran (1-4): ");
                pilihan = input.nextInt();

                switch (pilihan) {
                    case 1 -> metodePembayaran = "OVO";
                    case 2 -> metodePembayaran = "Dana";
                    case 3 -> metodePembayaran = "Gopay";
                    case 4 -> metodePembayaran = "ShopeePay";
                    default -> System.out.println("Pilih yang ada dong -_-");
                }
            } while (pilihan < 1 || pilihan > 4);

            // Pemesanan film
            do {
                System.out.println("\nPilih Film yang ingin ditonton:");
                System.out.println("1. Tenki No Ko (Rp 35.000)");
                System.out.println("2. Kimi No Na Wa (Rp 30.000)");
                System.out.println("3. Suzume (Rp 40.000)");
                System.out.println("4. Chainsawman: Reze Arc (Rp 50.000)");
                System.out.print("Masukkan pilihan Anda (1-4): ");
                pilihan = input.nextInt();

                String namaFilm = "";
                switch (pilihan) {
                    case 1 -> { namaFilm = "Tenki No Ko"; harga = 35000; }
                    case 2 -> { namaFilm = "Kimi No Na Wa"; harga = 30000; }
                    case 3 -> { namaFilm = "Suzume"; harga = 40000; }
                    case 4 -> { namaFilm = "Chainsawman: Reze Arc"; harga = 50000; }
                    default -> {
                        System.out.println("Yang bener aja milih film yang ga ada di sini -_-");
                        continue;
                    }
                }

                System.out.print("Masukkan jumlah tiket untuk " + namaFilm + ": ");
                jumlah = input.nextInt();

                daftarFilm.add(namaFilm);
                daftarJumlah.add(jumlah);
                daftarHarga.add(harga);

                totalBelanja += harga * jumlah;

                System.out.print("Apakah Anda ingin memesan tiket lagi? (y/n): ");
                lanjut = input.next();

            } while (lanjut.equalsIgnoreCase("y"));

            // Hitung diskon
            if (totalBelanja > 100000) diskon = totalBelanja * 0.1;
            else if (totalBelanja > 50000) diskon = totalBelanja * 0.05;

            double totalAkhir = totalBelanja - diskon;

            System.out.println("\nTotal Belanja: Rp " + totalBelanja);
            System.out.println("Diskon: Rp " + diskon);
            System.out.println("Total Bayar Setelah Diskon: Rp " + totalAkhir);

            System.out.print("Masukkan uang pembayaran: Rp ");
            double bayar = input.nextDouble();

            double kembalian = bayar - totalAkhir;

            // STRUK PEMBAYARAN
            System.out.println("\n=========================================");
            System.out.println("          STRUK PEMESANAN BIOSKOP        ");
            System.out.println("=========================================");
            System.out.println("Nama Pemesan     : " + namaPemesan);
            System.out.println("Metode Pembayaran: " + metodePembayaran);
            System.out.println("-----------------------------------------");
            System.out.printf("%-25s %5s %10s\n", "Film", "Qty", "Subtotal");
            System.out.println("-----------------------------------------");

            for (int i = 0; i < daftarFilm.size(); i++) {
                String film = daftarFilm.get(i);
                int qty = daftarJumlah.get(i);
                int hrg = daftarHarga.get(i);
                double sub = qty * hrg;
                System.out.printf("%-25s %5d %10.0f\n", film, qty, sub);
            }

            System.out.println("-----------------------------------------");
            System.out.printf("%-30s: Rp %.0f\n", "Total Belanja", totalBelanja);
            System.out.printf("%-30s: Rp %.0f\n", "Diskon", diskon);
            System.out.printf("%-30s: Rp %.0f\n", "Total Bayar", totalAkhir);
            System.out.printf("%-30s: Rp %.0f\n", "Uang Bayar", bayar);
            System.out.printf("%-30s: Rp %.0f\n", "Kembalian", kembalian);
            System.out.println("=========================================");
            System.out.println("Terima kasih, " + namaPemesan + 
                               ", telah memesan tiket di Bioskop AyamGolek!");
            System.out.println("Selamat menonton! :)");
            System.out.println("=========================================");

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }

        input.close();
    }
}
