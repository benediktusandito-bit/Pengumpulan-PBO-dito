package github;

public class PDF extends Tugas {
    private int ukuranFile;

    public PDF(String nama, String nim, int tugasKe, int nilaiAwal, int ukuranFile) {
        super(nama, nim, tugasKe, "PDF", nilaiAwal);
        this.ukuranFile = ukuranFile;
    }

    @Override
    public String pengumpulan() {
        return "Tugas PDF ukuran " + ukuranFile + " MB";
    }
}
