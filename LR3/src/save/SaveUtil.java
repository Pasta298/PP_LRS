package save;

import java.io.*;

public class SaveUtil {
    private static final PrintWriter printWriter;

    static {
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Saved_Battle.txt", false)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printBattle(String text) {
        printWriter.println(text);
        System.out.println(text);
    }

    public static void importBattle() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Saved_Battle.txt"))) {
            String text = bufferedReader.readLine();
            while(text != null) {
                System.out.println(text);
                text = bufferedReader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeBattle() {
        printWriter.close();
    }
}