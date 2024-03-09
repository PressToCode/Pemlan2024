package NonGUI.Object;

public class test {
    public static void main(String[] args) {
        System.out.println("Testing..");
        pauseSecond();
        cleanTerminal();

        System.out.println("Berhasil...?");
        pauseSecond();
    }

    public static void cleanTerminal() {
        // * Membersihkan Terminal
        System.out.print("\033[H\033[2J");
    }

    public static void pauseSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
