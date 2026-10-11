package github;

public class TautanRepo extends Tugas {
    private String branch;

    public TautanRepo(String nama, String nim, int tugasKe, int nilaiAwal, String branch) {
        super(nama, nim, tugasKe, "Repo", nilaiAwal);
        this.branch = branch;
    }

    @Override
    public String pengumpulan() {
        return "Tugas Repo branch: " + branch;
    }
}
