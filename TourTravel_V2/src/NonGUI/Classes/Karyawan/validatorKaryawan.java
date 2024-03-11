package NonGUI.Classes.Karyawan;

import java.io.IOException;

public class validatorKaryawan {
    public boolean Telfon(String Telfon) {
        /* 
            ! Syarat
            ! - 12 digit atau kurang
            ! - Merupakan angka semua
        */
        if(Telfon.replaceAll("\\s+","").length() < 13 && Telfon.length() > 0) {
            
            // Cek apakah input merupakan angka semua
            try {
                // Ubah string ke long
                Long.valueOf(Telfon.replaceAll("\\s+",""));

                // Apabila valid, input data
                inputKaryawan.Karyawan[inputKaryawan.Data].setTelfon(Telfon);

                return false;
            } catch(NumberFormatException e) {
                System.out.println("Nomor telfon invalid. Ulangi lagi!");
                System.out.print("= ");
                return true;
            }
        } else {
            System.out.println("Nomor telfon invalid. Ulangi lagi!");
            System.out.print("= ");
            return true;
        }
    }

    public boolean JenisKelamin(String Gender) {
        if(Gender.equalsIgnoreCase("L") || Gender.equalsIgnoreCase("Pria")) {
            inputKaryawan.Karyawan[inputKaryawan.Data].setJenisKelamin("Lelaki");
            return false;
        } else if (Gender.equalsIgnoreCase("P") || Gender.equalsIgnoreCase("Perempuan")) {
            inputKaryawan.Karyawan[inputKaryawan.Data].setJenisKelamin("Perempuan");
            return false;
        } else {
            System.out.println("Jenis Kelamin invalid. Ulangi lagi!");
            System.out.print("= ");
            return true;
        }
    }

    public boolean Kategori(String Category) {
        if(Category.equalsIgnoreCase("ST") || Category.replaceAll("\\s+","").equalsIgnoreCase("SupirTravel") || Category.equals("1")) {
            inputKaryawan.Karyawan[inputKaryawan.Data].setKategori("Supir Travel");
            return false;
        } else if (Category.equalsIgnoreCase("SR") || Category.replaceAll("\\s+","").equalsIgnoreCase("SupirTravel") || Category.equals("2")) {
            inputKaryawan.Karyawan[inputKaryawan.Data].setKategori("Supir Rentcar");
            return false;
        } else if (Category.equalsIgnoreCase("A") || Category.replaceAll("\\s+","").equalsIgnoreCase("Admin") || Category.equals("3")) {
            inputKaryawan.Karyawan[inputKaryawan.Data].setKategori("Admin");
            return false;
        } else {
            System.out.println("Kategori invalid. Ulangi lagi!");
            System.out.print("= ");
            return true;
        }
    }

    public boolean Status(String Status) {
        if(Status.replaceAll("\\s+","").equalsIgnoreCase("Bekerja") || Status.equals("1")) {
            inputKaryawan.Karyawan[inputKaryawan.Data].setStatus("Bekerja");;
            return false;
        } else if (Status.replaceAll("\\s+","").equalsIgnoreCase("Istirahat") || Status.equals("2")) {
            inputKaryawan.Karyawan[inputKaryawan.Data].setStatus("Istirahat");;
            return false;
        } else if (Status.replaceAll("\\s+","").equalsIgnoreCase("Cuti") || Status.equals("3")) {
            inputKaryawan.Karyawan[inputKaryawan.Data].setStatus("Cuti");
            return false;
        } else {
            System.out.println("Status invalid. Ulangi lagi!");
            System.out.print("= ");
            return true;
        }
    }

    public boolean Rute(String Rute) {
        if(Rute.replaceAll("\\s+","").equalsIgnoreCase("Surabaya - Malang") || Rute.equals("1")) {
            inputKaryawan.Karyawan[inputKaryawan.Data].setRute("Surabaya - Malang");;
            return false;
        } else if (Rute.replaceAll("\\s+","").equalsIgnoreCase("Madura - Malang") || Rute.equals("2")) {
            inputKaryawan.Karyawan[inputKaryawan.Data].setRute("Madura - Malang");
            return false;
        } else if (Rute.replaceAll("\\s+","").equalsIgnoreCase("Banyuwangi - Malang") || Rute.equals("3")) {
            inputKaryawan.Karyawan[inputKaryawan.Data].setRute("Banyuwangi - Malang");;
            return false;
        } else if (Rute.replaceAll("\\s+","").equalsIgnoreCase("Situbondo - Malang") || Rute.equals("4")) {
            inputKaryawan.Karyawan[inputKaryawan.Data].setRute("Situbondo - Malang");;
            return false;
        }  else if (Rute.replaceAll("\\s+","").equalsIgnoreCase("Tulungagung - Malang") || Rute.equals("5")) {
            inputKaryawan.Karyawan[inputKaryawan.Data].setRute("Tulungagung - Malang");;
            return false;
        } else {
            System.out.println("Status invalid. Ulangi lagi!");
            System.out.print("= ");
            return true;
        }
    }

    public void YesNo(String YesNo) {
        if(YesNo.equals("N") || YesNo.equals("n")) {
            inputKaryawan.temp = true;

            cleanTerminal();

            System.out.println("Menutup program...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cleanTerminal();
            
        } else {
            inputKaryawan.stopLoop = false;
        }
    }

    public void cleanTerminal() {
        // Membersihkan terminal
        System.out.print("\033[H\033[2J");
        
        try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}
