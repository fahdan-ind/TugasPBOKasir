import java.util.ArrayList;
import java.util.Scanner;

public class Perpustakaan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String namaPeminjam = "";
        String dummy = "";
        double total = 0; 
        int pilihan, jumlah = 0;
        String lanjut = "y";

        // Daftar buku
        ArrayList<String> daftarBuku = new ArrayList<>();
        daftarBuku.add("Laskar Pelangi");
        daftarBuku.add("Bumi Manusia");
        daftarBuku.add("Negeri 5 Menara");
        daftarBuku.add("Dilan 1990");
        daftarBuku.add("Mariposa");

        ArrayList<String> bukuDipinjam = new ArrayList<>();
        try {
            System.out.println("=== Selamat Datang di Perpustakaan ===");
            System.out.print("Masukkan nama peminjam: ");
            namaPeminjam = input.nextLine();

            do {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Lihat Daftar Buku");
                System.out.println("2. Pinjam Buku");
                System.out.println("3. Kembalikan Buku");
                System.out.println("4. Keluar");
                System.out.print("Pilih menu (1-4): ");
                pilihan = input.nextInt();

                switch (pilihan) {
                    case 1 -> {
                        System.out.println("\n=== Daftar Buku ===");
                        for (int i = 0; i < daftarBuku.size(); i++) {
                            System.out.println((i + 1) + ". " + daftarBuku.get(i));
                        }
                    }

                    case 2 -> {
                        System.out.println("\n=== Pinjam Buku ===");
                        for (int i = 0; i < daftarBuku.size(); i++) {
                            System.out.println((i + 1) + ". " + daftarBuku.get(i));
                        }

                        System.out.print("Pilih nomor buku: ");
                        int pilihBuku = input.nextInt();

                        if (pilihBuku >= 1 && pilihBuku <= daftarBuku.size()) {
                            System.out.println("Buku \"" + daftarBuku.get(pilihBuku - 1)
                                    + "\" berhasil dipinjam!");
                        } else {
                            System.out.println("Nomor buku tidak valid!");
                        }
                    }

                    case 3 -> {
                        System.out.println("\n=== Kembalikan Buku ===");
                        System.out.println("Buku berhasil dikembalikan!");
                    }
                    case 4 -> {
                        System.out.println("\n=== Daftar Buku Diinjam ===");
                        if (bukuDipinjam.isEmpty()) {
                            System.out.println("Tidak ada buku yang dipinjam.");
                        } else {
                            for (int i = 0; i < bukuDipinjam.size(); i++) {
                                System.out.println((i + 1) + ". " + bukuDipinjam.get(i));
                            }
                        }
                    }

                    case 5 -> {
                        System.out.println("\nTerima kasih, " + namaPeminjam +
                                ", telah menggunakan aplikasi perpustakaan!");
                        lanjut = "n";
                    }

                    default -> {
                        System.out.println("Pilihan tidak ada -_-");
                    }
                }

                if (pilihan != 4) {
                    System.out.print("\nKembali ke menu? (y/n): ");
                    lanjut = input.next();
                }

            } while (lanjut.equalsIgnoreCase("y"));

            System.out.println("\n=== Program Selesai ===");

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }

        input.close();
    }
}
// End of Perpustakaan.java