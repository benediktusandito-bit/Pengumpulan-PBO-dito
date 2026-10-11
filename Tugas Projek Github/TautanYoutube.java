package github;

public class TautanYoutube extends Tugas {
    private int durasi;

    public TautanYoutube(String nama, String nim, int tugasKe, int nilaiAwal, int durasi) {
        super(nama, nim, tugasKe, "YouTube", nilaiAwal);
        this.durasi = durasi;
    }

    @Override
    public String pengumpulan() {
        return "Tugas YouTube durasi " + durasi + " menit";
    }
}
