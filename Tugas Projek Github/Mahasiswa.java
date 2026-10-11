package github;

public class Mahasiswa {

    private String nama;
    private String nim;
    private int totalSkor;

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public int getTotalSkor() {
        return totalSkor;
    }

    public void setTotalSkor(int skor) {
        this.totalSkor = skor;
    }
}
