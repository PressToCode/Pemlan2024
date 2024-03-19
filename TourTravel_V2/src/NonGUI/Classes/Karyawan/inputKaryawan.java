package NonGUI.Classes.Karyawan;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class inputKaryawan {
    // * Variable
    private static int Data = 1;
    private int localData;
    private boolean stopLoop = false;

    // * Deklarasi array untuk class "templateKaryawan"
    protected static templateKaryawan[] Karyawan = new templateKaryawan[6];

    // * Deklarasi Validator Class
    private validatorKaryawan valid = new validatorKaryawan();

    // * Deklarasi Scanner
    private static Scanner Input = new Scanner(System.in);

    public inputKaryawan() {
        cleanTerminal();

        // * Kalimat Pembuka
        System.out.println("Selamat datang di aplikasi manajemen karyawan!");

        for(; Data < Karyawan.length; Data++) {
            // * Data ke-n
            System.out.println("Masukkan data karyawan ke-" + Data + " : ");

            // ? Inisialisasi Objek (IMPORTANT)
            Karyawan[Data] = new templateKaryawan();

            // * Input Method
            inputData();

            if(stopLoop) {
                break;
            }

            if(Data%5 == 0) {
                // Memperbesar Array jika data > 5
                templateKaryawan[] KaryawanTemp = Arrays.copyOf(Karyawan, Karyawan.length + 5);
                Karyawan = Arrays.copyOf(KaryawanTemp, KaryawanTemp.length);
            }
        }
    }

    private void cleanTerminal() {
        // * Membersihkan Terminal
        System.out.print("\033[H\033[2J");

        try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    private void inputData() {
        // Nama
        System.out.println("\n==================");
        System.out.print("Nama Karyawan " + Data + " = ");
        while(valid.Nama(Input.nextLine())) { /* Kosong */}

        // Alamat
        System.out.println();
        System.out.print("Alamat Karyawan " + Data + " = ");
        Karyawan[Data].Alamat = Input.nextLine();

        // Telfon
        System.out.println();
        System.out.print("No. Telp Karyawan " + Data + " = ");
        while(valid.Telfon(Input.nextLine())) { /* Kosong */ }

        // Jenis Kelamin
        System.out.println();
        System.out.print("Jenis Kelamin Karyawan " + Data + " (L/P) = ");
        while(valid.JenisKelamin(Input.nextLine())) { /* Kosong */ }

        // Kategori
        System.out.println("\n==================");
        System.out.println("Pilihan Kategori : ");
        System.out.println("1) Supir Travel (ST)");
        System.out.println("2) Supir Rentcar (SR)");
        System.out.println("3) Admin (A)");

        System.out.println("==================");
        System.out.print("Kategori Karyawan " + Data + " = ");
        while(valid.Kategori(Input.nextLine())) { /* Kosong */ }

        // Status
        System.out.println("\n==================");
        System.out.println("Pilihan Status : ");
        System.out.println("1) Bekerja");
        System.out.println("2) Istirahat");
        System.out.println("3) Cuti");

        System.out.println("==================");
        System.out.print("Status Karyawan " + Data + " = ");
        while(valid.Status(Input.nextLine())) { /* Kosong */ }

        // Rute (Jika status bekerja dan bukan admin)
        if(Karyawan[getData()].getStatus().equalsIgnoreCase("Bekerja") && !Karyawan[getData()].getKategori().equalsIgnoreCase("Admin")) {
            System.out.println("\n==================");
            System.out.println("Pilihan rute : ");
            System.out.println("1) Surabaya - Malang");
            System.out.println("2) Madura - Malang");
            System.out.println("3) Banyuwangi - Malang");
            System.out.println("4) Situbondo - Malang");
            System.out.println("5) Tulungagung - Malang");
            
            System.out.println("==================");
            System.out.print("Rute Karyawan " + Data + " = ");
            while(valid.Rute(Input.nextLine())) { /* Kosong */ }
        }

        // Lanjutkan program atau tidak
        System.out.println();
        System.out.print("Isi data lagi? (Y/N; default 'Y') : ");
        if(valid.YesNo(Input.nextLine())) {
            localData = Data;
            Data = 1;
            stopLoop = true;
        }
    }

    public void outputData() {
        cleanTerminal();

        for(int i = 1; i <= localData; i++) {
            System.out.println("\n==================");
            System.out.print("Nama Karyawan " + i + " = " + Karyawan[i].getNama());
            System.out.print("\nAlamat Karyawan " + i + " = " + Karyawan[i].Alamat);
            System.out.print("\nTelfon Karyawan " + i + " = " + Karyawan[i].getTelfon());
            System.out.print("\nJenis Kelamin Karyawan " + i + " = " + Karyawan[i].getJenisKelamin());
            System.out.print("\nKategori Karyawan " + i + " = " + Karyawan[i].getKategori());
            System.out.print("\nStatus Karyawan " + i + " = " + Karyawan[i].getStatus());
            System.out.print("\nRute yang dituju oleh karyawan " + i + " = " + Karyawan[i].getRute());
            System.out.println("\n");
        }
    }

    public static int getData() {
        return Data;
    }
}
