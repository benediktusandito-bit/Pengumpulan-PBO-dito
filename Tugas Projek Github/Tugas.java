package github;

import java.time.LocalDateTime;
import java.time.Duration;

public abstract class Tugas implements Manage{
    protected String nama;
    protected String nim;
    protected int tugasKe;
    protected String tipeTugas;
    protected int nilaiAwal;
    protected int nilaiAkhir;
    protected LocalDateTime waktuKumpul;
    
    protected LocalDateTime DEADLINE = LocalDateTime.of(2026, 5, 20, 23, 0);

    public Tugas(String nama, String nim, int tugasKe, String tipeTugas, int nilaiAwal) {
        this.nama = nama;
        this.nim = nim;
        this.tugasKe = tugasKe;
        this.tipeTugas = tipeTugas;
        this.nilaiAwal = nilaiAwal;
        this.nilaiAkhir = nilaiAwal;
    }

    public void setWaktuKumpul(int tahun, int bulan, int tanggal, int jam, int menit) {
        this.waktuKumpul = LocalDateTime.of(tahun, bulan, tanggal, jam, menit);
    }

    public void cekTerlambat() {
        if (waktuKumpul.isAfter(DEADLINE)) {
            long jamTerlambat = Duration.between(DEADLINE, waktuKumpul).toHours();
            int pengurangan = (int) jamTerlambat * 3;
            nilaiAkhir = Math.max(0, nilaiAwal - pengurangan);
            System.out.println("Tugas ke-" + tugasKe + " melebihi tenggat waktu (" + jamTerlambat + " jam telat)");
        }
    }

    public int getNilaiAkhir() {
        return nilaiAkhir;
    }

    public abstract String pengumpulan();
}
