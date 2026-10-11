package github;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = sc.nextInt();
        sc.nextLine();

        Mahasiswa[] daftarMahasiswa = new Mahasiswa[jumlahMahasiswa];

        for (int m = 0; m < jumlahMahasiswa; m++) {
            System.out.println("\n=== Mahasiswa ke-" + (m+1) + " ===");
            System.out.print("Masukkan nama: ");
            String nama = sc.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = sc.nextLine();

            Mahasiswa mahasiswa = new Mahasiswa(nama, nim);

            // Jumlah tugas untuk mahasiswa ini
            System.out.print("Berapa banyak tugas yang akan dikumpulkan? : ");
            int jumlahTugas = sc.nextInt();
            sc.nextLine();

            Tugas[] daftarTugas = new Tugas[jumlahTugas];

            for (int i = 0; i < jumlahTugas; i++) {
                System.out.println("\nTugas ke-" + (i+1));
                System.out.print("Pilih tipe tugas (PDF/Repo/YouTube): ");
                String tipe = sc.nextLine();

                System.out.print("Nilai awal (dari dosen): ");
                int nilaiAwal = sc.nextInt();
                sc.nextLine();

                Tugas tugas = null;

                if (tipe.equalsIgnoreCase("PDF")) {
                    System.out.print("Ukuran file (MB): ");
                    int ukuran = sc.nextInt();
                    sc.nextLine();
                    tugas = new PDF(nama, nim, i+1, nilaiAwal, ukuran);
                } else if (tipe.equalsIgnoreCase("Repo")) {
                    System.out.print("Nama branch: ");
                    String branch = sc.nextLine();
                    tugas = new TautanRepo(nama, nim, i+1, nilaiAwal, branch);
                } else if (tipe.equalsIgnoreCase("YouTube")) {
                    System.out.print("Durasi video (menit): ");
                    int durasi = sc.nextInt();
                    sc.nextLine();
                    tugas = new TautanYoutube(nama, nim, i+1, nilaiAwal, durasi);
                }

                // Waktu kumpul
                System.out.print("Masukkan tahun kumpul: ");
                int tahun = sc.nextInt();
                System.out.print("Masukkan bulan kumpul: ");
                int bulan = sc.nextInt();
                System.out.print("Masukkan tanggal kumpul: ");
                int tanggal = sc.nextInt();
                System.out.print("Masukkan jam kumpul: ");
                int jam = sc.nextInt();
                System.out.print("Masukkan menit kumpul: ");
                int menit = sc.nextInt();
                sc.nextLine();

                tugas.setWaktuKumpul(tahun, bulan, tanggal, jam, menit);
                tugas.cekTerlambat();

                daftarTugas[i] = tugas;
            }

            // Hitung total skor mahasiswa ini
            int totalSkor = 0;
            for (int i = 0; i < jumlahTugas; i++) {
                totalSkor += daftarTugas[i].getNilaiAkhir();
            }

            mahasiswa.setTotalSkor(totalSkor);
            daftarMahasiswa[m] = mahasiswa;
        }

        // Output hasil akhir semua mahasiswa
        System.out.println("\n=== HASIL AKHIR SEMUA MAHASISWA ===");
        for (int m = 0; m < jumlahMahasiswa; m++) {
            System.out.println("Mahasiswa ke-" + (m+1));
            System.out.println("Nama: " + daftarMahasiswa[m].getNama());
            System.out.println("NIM: " + daftarMahasiswa[m].getNim());
            System.out.println("Total Skor: " + daftarMahasiswa[m].getTotalSkor());
            System.out.println("-----------------------------");
        }

        sc.close();
    }
}
