package NonGUI.Classes.Kendaraan;

import java.util.Arrays;
import java.util.Scanner;

public class inputKendaraan {
    // * Variable
    public static int Data = 1;
    public int localData;
    public static boolean stopLoop = false;
    public static boolean temp = false;
    
    // * Deklarasi array 'templateKendaraan'
    static templateKendaraan[] Kendaraan = new templateKendaraan[6];

    // * Deklarasi validator class
    validatorKendaraan valid = new validatorKendaraan();

    // * Deklarasi Scanner
    Scanner Input = new Scanner(System.in);

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
    }

    public void inputData() {
        // Plat
        System.out.println("\n==================");
        System.out.print("Plat Kendaraan " + Data + " = ");
        Kendaraan[Data].setPlat(Input.nextLine());

        // Merk
        System.out.println();
        System.out.print("Merk Kendaraan " + Data + " = ");
        Kendaraan[Data].setMerk(Input.nextLine());

        // Warna
        System.out.println();
        System.out.print("Warna Kendaraan " + Data + " = ");
        Kendaraan[Data].setWarna(Input.nextLine());

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
        valid.YesNo(Input.nextLine());
        if(temp) {
            localData = Data;
            Data = 1;
            stopLoop = true;
            temp = false;
        }
    }

    public void outputData() {
        cleanTerminal();

        for(int i = 1; i <= localData; i++) {
            System.out.println("\n==================");
            System.out.print("Plat Kendaraan " + i + " = " + Kendaraan[i].getPlat());
            System.out.print("\nMerk Kendaraan " + i + " = " + Kendaraan[i].getMerk());
            System.out.print("\nWarna Kendaraan " + i + " = " + Kendaraan[i].getWarna());
            System.out.print("\nTahun Keluaran Kendaraan " + i + " = " + Kendaraan[i].getTahun());
            System.out.print("\nStatus Kendaraan " + i + " = " + Kendaraan[i].getStatus());
            System.out.println("\n");
        }
    }
}
