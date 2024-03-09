package NonGUI.Classes.Kendaraan;

public class templateKendaraan {
    // * Variable
    private String noPlat;
    private String merkMobil;
    private String warnaMobil;
    private String tahunKeluaran;
    private String status;

    // * Setter
    public void setPlat(String Plat) {
        noPlat = Plat;
    }

    public void setMerk(String Merk) {
        merkMobil = Merk;
    }

    public void setWarna(String Warna) {
        warnaMobil = Warna;
    }

    public void setTahun(String Tahun) {
        tahunKeluaran = Tahun;
    }

    public void setGerak() {
        status = "Sedang Bergerak";
    }

    public void setDiam() {
        status = "Sedang Diam";
    }

    // * Getter
    public String getPlat() {
        return noPlat;
    }

    public String getMerk() {
        return merkMobil;
    }

    public String getWarna() {
        return warnaMobil;
    }

    public String getTahun() {
        return tahunKeluaran;
    }

    public String getStatus() {
        return status;
    }
}
