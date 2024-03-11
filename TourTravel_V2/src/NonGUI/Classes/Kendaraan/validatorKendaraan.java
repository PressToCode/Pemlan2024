package NonGUI.Classes.Kendaraan;

import java.io.IOException;

public class validatorKendaraan {
    public boolean Tahun(String x) {
        if(x.length() < 5 && x.length() > 0) {
            
            // Cek apakah input merupakan angka semua
            try {
                // Ubah string ke long
                Long.valueOf(x.replaceAll("\\s+",""));

                // Apabila valid, input data
                inputKendaraan.Kendaraan[inputKendaraan.Data].setTahun(x);

                return false;
            } catch(NumberFormatException e) {
                System.out.println("Tahun invalid. Ulangi lagi! (4 digit)");
                System.out.print("= ");
                return true;
            }
        } else {
            System.out.println("Tahun invalid. Ulangi lagi! (4 digit)");
            System.out.print("= ");
            return true;
        }
    }

    public boolean Status(String x) {
        if(x.replaceAll("\\s+","").equalsIgnoreCase("Bergerak") || x.equals("1")) {
            inputKendaraan.Kendaraan[inputKendaraan.Data].setGerak();
            return false;
        } else if (x.replaceAll("\\s+","").equalsIgnoreCase("Diam") || x.equals("2")) {
            inputKendaraan.Kendaraan[inputKendaraan.Data].setDiam();
            return false;
        } else {
            System.out.println("Status invalid. Ulangi lagi!");
            System.out.print("= ");
            return true;
        }
    }

    public void YesNo(String YesNo) {
        if(YesNo.equals("N") || YesNo.equals("n")) {
            inputKendaraan.temp = true;

            cleanTerminal();

            System.out.println("Menutup program...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cleanTerminal();
        } else {
            inputKendaraan.stopLoop = false;
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
}
