import java.io.*;
import java.util.*;

public class Read {
    static char IR[] = new char[4];
    static char M[][] = new char[100][4];

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line = null;
        br.readLine(); // $DTA

        line = br.readLine();// VIT
        int idx1 = Integer.parseInt("" + IR[2] + "0");
        int idx2 = 0;

        for (int i = 0; i < line.length(); i++) { // VIT is not same
            if (idx2 == 4) {
                idx2 = 0; // 10 0 1 2 3
                idx1++; // 11
            }
            M[idx1][idx2] = line.charAt(i);
            idx2++;
        }

        idx1 = Integer.parseInt("" + IR[2] + "0");
        for (int i = idx1; i < idx1 + 10; i++) {
            for (int j = 0; j < 4 && j < 4; j++) {
                System.out.print(M[i][j]);
            }
            System.out.println();
        }
    }

}
