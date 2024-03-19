package NonGUI.Classes.Karyawan;

public class templateKaryawan {
    // * Variabel
    private String Nama;
    public String Alamat;
    private String Telfon;
    private String JenisKelamin;
    private String Kategori;
    private String Status;
    private String Rute = "-";

    // * Setter
    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public void setTelfon(String Telfon) {
        this.Telfon = Telfon;
    }

    public void setJenisKelamin(String Gender) {
        this.JenisKelamin = Gender;
    }

    public void setKategori(String Kategori) {
        this.Kategori = Kategori;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setRute(String rute) {
        this.Rute = rute;
    }

    // * Getter
    public String getNama() {
        return this.Nama;
    }

    public String getTelfon() {
        return this.Telfon;
    }

    public String getJenisKelamin() {
        return this.JenisKelamin;
    }

    public String getKategori() {
        return this.Kategori;
    }

    public String getStatus() {
        return this.Status;
    }

    public String getRute() {
        return this.Rute;
    }
}
