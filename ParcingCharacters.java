import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParcingCharacters {
    static char R[] = new char[4];
    static char IR[] = new char[4];
    static char M[][] = new char[100][4];
    // [G][D][2][0]
    static int IC;
    static boolean C;

    public static void main(String[] args) throws IOException {
        FileInputStream input = new FileInputStream("input.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        List<String> strings = new ArrayList<String>();
        int index = 0;
        String line = reader.readLine();
        line = reader.readLine();

        while (index < line.length()) {
            // if (line.equals("$DTA")) {
            // break;
            // }

            if (line.substring(index, Math.min(index + 1, line.length())).equals("H")) {
                strings.add("0H00");
                index++;
            } else {
                strings.add(line.substring(index, Math.min(index + 4, line.length())));
                index += 4;
            }
        }
        System.out.println(strings);

        String[] array = strings.toArray(new String[0]);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 4 && j < array[i].length(); j++) {
                M[i][j] = array[i].charAt(j);
                // System.out.println(array[i].charAt(j));
            }
        }

        int cnt = array.length;
        System.out.println("COUNT OF INSTRUCTION: " + cnt);

        // for (int i = 0; i < M.length; i++) {
        // for (int j = 0; j < 4; j++) {
        // System.out.print(" " + i + "." + j + " " + M[i][j]);
        // }
        // System.out.println();
        // }

        reader.close();
    }
}