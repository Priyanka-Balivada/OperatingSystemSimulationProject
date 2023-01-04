import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
// import java.util.*;

public class MainProgram {
    static char R[] = new char[4];
    static char IR[] = new char[4];
    static char M[][] = new char[100][4];
    static boolean C = false;
    static int SI = 0;
    // [G][D][2][0]
    static int IC = 0;
    static int cnt = 0;

    static FileInputStream input;
    static BufferedReader reader;
    static FileWriter myWriter;

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Welcome to Alpha OS!");
        // System.out.println("\nFor now you can perfomr follwoing tasks: \n 1. Read \n
        // 2. Write \n 3. Terminate");
        // System.out.print("\nEnter the task number you want to perform: ");
        // SI = sc.nextInt();
        load();
        // MOS(SI);

        sc.close();
    }

    // ParsingChar code
    public static void load() throws IOException {

        List<String> strings = new ArrayList<String>();
        input = new FileInputStream("input2.txt");
        reader = new BufferedReader(new InputStreamReader(input));
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
        // System.out.println(strings);

        String[] array = strings.toArray(new String[0]);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 4 && j < array[i].length(); j++) {
                M[i][j] = array[i].charAt(j);
                // System.out.println(array[i].charAt(j));
            }
        }

        // for (int i = 0; i < array.length; i++) {
        // for (int j = 0; j < 4 && j < array[i].length(); j++) {
        // System.out.print(M[i][j]);
        // }
        // System.out.println();
        // }

        cnt = array.length;
        // System.out.println("\n\nCOUNT OF INSTRUCTION: " + cnt);
        reader.readLine(); // $DTA
        ExecuteUserProgram();

        for (int i = 30; i < 40; i++) {
            for (int j = 0; j < 4 && j < M[i].length; j++) {
                System.out.println(M[i][j]);
            }
        }

        reader.close();
    }

    public static void MOS(int SI) throws IOException {
        switch (SI) {

            case 1:
                // System.out.println(" Read");
                read();
                break;

            case 2:
                // System.out.println(" Write");
                write();
                break;

            case 3:
                // System.out.println(" Terminate");
                System.exit(0);
                break;

            default:
                // System.out.println(" Invalid Choice!");
                break;
        }
    }

    public static void read() throws IOException {
        String line = null;

        line = reader.readLine();
        // System.out.println("Line " + line);// VIT
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

    public static void write() throws IOException {
        myWriter = new FileWriter("output.txt", true);
        String print = "";

        int idx1 = Integer.parseInt("" + IR[2] + "0");
        for (int i = idx1; i < idx1 + 10; i++) {
            for (int j = 0; j < 4; j++) {
                print = print + M[i][j];
            }

            System.out.println();
        }
        print.trim();
        myWriter.write(print);
        myWriter.close();

    }

    public static void loadReg() {
        int idx1 = Integer.parseInt("" + IR[2] + "" + IR[3]);
        // int idx1 = IR[2] - '0';
        // int idx2 = IR[3] - '0';
        for (int i = 0; i < R.length; i++) {
            R[i] = M[idx1][i];
        }

        // System.out.println("\nLoad Register");
        // for (int i = 0; i < R.length; i++) {
        // System.out.println(R[i]);
        // }
    }

    public static void storeReg() {
        int idx1 = Integer.parseInt("" + IR[2] + "" + IR[3]);
        // int idx1 = IR[2] - '0';
        // int idx2 = IR[3] - '0';
        for (int i = 0; i < R.length; i++) {
            M[idx1][i] = R[i];
        }

        // System.out.println("\n Store Register");
        // for (int i = 0; i < M.length; i++) {
        // for (int j = 0; j < 4 && j < M[i].length; j++) {
        // System.out.println(M[i][j]);
        // }
        // }

    }

    public static boolean compareRegAndMem() {
        boolean countCmp = true;
        int idx1 = Integer.parseInt("" + IR[2] + "" + IR[3]);
        // int idx1 = IR[2] - '0';
        // int idx2 = IR[3] - '0';
        // System.out.println(idx1 + " " + idx2);
        for (int i = 0; i < R.length; i++) {
            if (R[i] != M[idx1][i]) {
                countCmp = false;
            }
        }
        // System.out.println("\n Compare Register");
        return countCmp;
    }

    // Execution Code
    public static void ExecuteUserProgram() throws IOException {
        int counter = 0;
        // int a1;
        // int a2;
        while (counter < cnt) {
            // while(IC<no. of instructions)
            for (int i = 0; i < 4; i++) {
                IR[i] = M[IC][i]; // iC=0 M[0][]
                System.out.print(IR[i]);
            }
            // IR = M [IC];
            IC = IC + 1; // ic=1;
            // int idx1 = IR[2] - '0';
            // int idx2 = IR[3] - '0';
            // LR10 SR CR BT GD PD H
            if (IR[0] == 'L' && IR[1] == 'R')
                loadReg();
            else if (IR[0] == 'S' && IR[1] == 'R')
                storeReg();
            else if (IR[0] == 'C' && IR[1] == 'R')
                if (compareRegAndMem())
                    C = true;
                else
                    C = false;
            else if (IR[0] == 'B' && IR[1] == 'T') {
                if (C == true) {
                    // ic=01
                    // BT40
                    IC = Integer.parseInt("" + IR[2] + "" + IR[3]); // IR[3]=9 IR[4]=2 int IC=92
                }
            }
            // a1 = IR[2] - '0';
            // a2 = IR[3] - '0';
            else if (IR[0] == 'G' && IR[1] == 'D') {
                SI = 1;
                MOS(SI);
            } else if (IR[0] == 'P' && IR[1] == 'D') {
                SI = 2;
                MOS(SI);
            } else if (IR[1] == 'H') {
                SI = 3;
                MOS(SI);
            }

            counter++;
        }
    }

}
