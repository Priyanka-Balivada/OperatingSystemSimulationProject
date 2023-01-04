import java.io.*;
import java.util.*;

public class Write {

    static int IR[] = new int[4];
    static int[][] M = new int[100][4];

    public static void ExecuteProgram() {
        System.out.println("Merge part");
    }

    public static void main(String[] args) throws IOException {
        FileWriter myWriter = new FileWriter("filename.txt");
        String print = "";

        int idx1 = Integer.parseInt("" + IR[2] + "0");
        for (int i = idx1; i < idx1 + 10; i++) {
            for (int j = 0; j < 4; j++) {
                print = print + M[idx1][j];
            }

            System.out.println();
        }
        print.trim();
        myWriter.write(print);
    }
}