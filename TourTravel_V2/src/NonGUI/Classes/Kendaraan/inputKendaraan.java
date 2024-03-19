package NonGUI.Classes.Kendaraan;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class inputKendaraan {
    // * Variable
    private static int Data = 1;
    private int localData;
    private boolean stopLoop = false;
    
    // * Deklarasi array 'templateKendaraan'
    protected static templateKendaraan[] Kendaraan = new templateKendaraan[6];

    // * Deklarasi validator class
    private validatorKendaraan valid = new validatorKendaraan();

    // * Deklarasi Scanner
    private Scanner Input = new Scanner(System.in);

    public inputKendaraan() {
        cleanTerminal();

        // * Kalimat Pembuka
        System.out.println("Selamat datang di aplikasi pendataan kendaraan!");

        for(; Data < Kendaraan.length; Data++) {
            // * Data ke-n
            System.out.println("Masukkan data kendaraan ke-" + Data + " : ");
            
            // ? Inisialisasi Objek (IMPORTANT)
            Kendaraan[Data] = new templateKendaraan();

            // * Input Method
            inputData();

            if(stopLoop) {
                break;
            }

            if(Data%5 == 0) {
                // Memperbesar Array jika data > 5
                templateKendaraan[] KendaraanTemp = Arrays.copyOf(Kendaraan, Kendaraan.length + 5);
                Kendaraan = Arrays.copyOf(KendaraanTemp, KendaraanTemp.length);
            }
        }

    }

    public void cleanTerminal() {
        // * Membersihkan Terminal
        System.out.print("\033[H\033[2J");

        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    public void inputData() {
        // Plat
        System.out.println("\n==================");
        System.out.print("Plat Kendaraan " + Data + " = ");
        Kendaraan[Data].noPlat = Input.nextLine();

        // Merk
        System.out.println();
        System.out.print("Merk Kendaraan " + Data + " = ");
        Kendaraan[Data].merkMobil = Input.nextLine();

        // Warna
        System.out.println();
        System.out.print("Warna Kendaraan " + Data + " = ");
        Kendaraan[Data].warnaMobil = Input.nextLine();

        // Tahun Keluaran
        System.out.println();
        System.out.print("Tahun Keluaran Kendaraan " + Data + " = ");
        while(valid.Tahun(Input.nextLine())) { /* Kosong */ }

        // Status
        System.out.println("\n==================");
        System.out.println("Pilihan Status : ");
        System.out.println("1) Bergerak");
        System.out.println("2) Diam");

        System.out.println("==================");
        System.out.print("Status Kendaraan " + Data + " = ");
        while(valid.Status(Input.nextLine())) { /* Kosong */ }

        // Lanjutkan program atau tidak
        System.out.println();
        System.out.print("Isi data lagi? (Y/N) : ");
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
            System.out.print("Plat Kendaraan " + i + " = " + Kendaraan[i].noPlat);
            System.out.print("\nMerk Kendaraan " + i + " = " + Kendaraan[i].merkMobil);
            System.out.print("\nWarna Kendaraan " + i + " = " + Kendaraan[i].warnaMobil);
            System.out.print("\nTahun Keluaran Kendaraan " + i + " = " + Kendaraan[i].getTahun());
            System.out.print("\nStatus Kendaraan " + i + " = " + Kendaraan[i].getStatus());
            System.out.println("\n");
        }
    }

    public static int getData() {
        return Data;
    }
}
