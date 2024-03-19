package NonGUI.Classes.Kendaraan;

public class templateKendaraan {
    // * Variable
    public String noPlat;
    public String merkMobil;
    public String warnaMobil;
    private String tahunKeluaran;
    private String status;

    // * Setter
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
    public String getTahun() {
        return tahunKeluaran;
    }

    public String getStatus() {
        return status;
    }
}
