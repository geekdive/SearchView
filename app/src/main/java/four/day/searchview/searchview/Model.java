package four.day.searchview.searchview;

/**
 * Created by septiyadi on 6/8/17.
 */

public class Model {
    private String judul;
    private int gambar;


    public Model(String judul, int gambar) {
        this.judul = judul;
        this.gambar = gambar;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
