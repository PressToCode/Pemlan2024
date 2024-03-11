package NonGUI.Classes;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import NonGUI.Classes.Karyawan.*;
import NonGUI.Classes.Kendaraan.*;

public class Options {
    // Variable
    int instanceKaryawan = 0;
    int instanceKendaraan = 0;
    boolean shutDown = false;

    // * Deklarasi Scanner
    static Scanner Input = new Scanner(System.in);

    // Array instance dari class 'inputKaryawan'
    inputKaryawan[] Karyawan = new inputKaryawan[6];

    // Array instance dari class 'inputKendaraan'
    inputKendaraan[] Kendaraan = new inputKendaraan[6];

    public Options() {

        isRunning: while(true) {
            cleanTerminal();
            
            showKalimat();

            switch (Input.nextInt()) {
                case 1:
                    instanceKaryawan += 1;
                    mulaiProgram("Karyawan");
                    break;

                case 2:
                    instanceKendaraan += 1;
                    mulaiProgram("Kendaraan");
                    break;

                case 3:
                    opsiKaryawan();

                    if(shutDown) {
                        break isRunning;
                    } 

                    break;

                case 4:
                    opsiKendaraan();

                    if(shutDown) {
                        break isRunning;
                    } 

                    break;

                case 5:
                    matikanProgram();
                    break isRunning;

                case 6:
                    cleanTerminal();
                    break;

                default:
                    System.out.println("Input invalid. Tolong ulangi (Angka 1-5).");
                    break;
            }
        }
    }

    public void showKalimat() {
        System.out.println("Pilih program yang ingin dijalankan :");
        System.out.println("1) Program Input Data Karyawan (Kasus 2.1a)");
        System.out.println("2) Program Input Data Kendaraan (Kasus 3.1a)");
        System.out.println("3) Tampilkan data program karyawan");
        System.out.println("4) Tampilkan data program kendaraan");
        System.out.println("5) Matikan Program");
        System.out.println("6) Clean Terminal");
        System.out.print("\n= ");
    }

    public static void cleanTerminal() {
        // * Membersihkan Terminal
        System.out.print("\033[H\033[2J");

        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    public void mulaiProgram(String Program) {
        cleanTerminal();

        if(Program.equals("Karyawan")) {
            System.out.println("Membuat Datasheet Karyawan Ke-" + instanceKaryawan + "...");
            pauseSecond();

            if(instanceKaryawan%5 == 0) {
                // Memperbesar Array jika data > 5
                inputKaryawan[] KaryawanTemp = Arrays.copyOf(Karyawan, Karyawan.length + 5);
                Karyawan = Arrays.copyOf(KaryawanTemp, KaryawanTemp.length);
            }

            Karyawan[instanceKaryawan] = new inputKaryawan();
        } else if(Program.equals("Kendaraan")) {
            System.out.println("Membuat Datasheet Kendaraan ke-" + instanceKendaraan + "...");
            pauseSecond();

            if(instanceKendaraan%5 == 0) {
                // Memperbesar Array jika data > 5
                inputKendaraan[] KendaraanTemp = Arrays.copyOf(Kendaraan, Kendaraan.length + 5);
                Kendaraan = Arrays.copyOf(KendaraanTemp, KendaraanTemp.length);
            }

            Kendaraan[instanceKendaraan] = new inputKendaraan();
        } else {
            System.out.println("Error in 'Options.java'");
        }
    }

    public void matikanProgram() {
        cleanTerminal();
        System.out.println("Menutup program...");
        pauseSecond();
    }

    public void pauseSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void opsiKaryawan() {
        cleanTerminal();

        if(instanceKaryawan != 0) {
            System.out.println("Datasheet Karyawan yang tersedia :");
            
            for(int i = 1; i <= instanceKaryawan; i++ ) {
                System.out.println(i + ") Datasheet " + i);
            }

            System.out.print("\n= ");
            Karyawan[Input.nextInt()].outputData();
            Input.nextLine();

            System.out.println("\nKembali ke menu utama? (Y/N)");
            System.out.print("= ");
            
            String jawaban = Input.nextLine();
            if (jawaban.equalsIgnoreCase("N")) {
                matikanProgram();
                shutDown = true;
            }

        } else {
            System.out.println("Tidak tersedia data karyawan");
            pauseSecond();
        }
    }

    public void opsiKendaraan() {
        cleanTerminal();
        
        if(instanceKendaraan != 0) {
            System.out.println("Datasheet Kendaraan yang tersedia :");
            
            for(int i = 1; i <= instanceKendaraan; i++ ) {
                System.out.println(i + ") Datasheet " + i);
            }

            System.out.print("\n= ");
            Kendaraan[Input.nextInt()].outputData();
            Input.nextLine();

            System.out.println("\nKembali ke menu utama? (Y/N)");
            System.out.print("= ");
            
            String jawaban = Input.nextLine();
            if (jawaban.equalsIgnoreCase("N")) {
                matikanProgram();
                shutDown = true;
            }

        } else {
            System.out.println("Tidak tersedia data kendaraan");
            pauseSecond();
        }
    }
}
