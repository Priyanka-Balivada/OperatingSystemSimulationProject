import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class first4 {
    public static void main(String[] args) {
        char M[][] = new char[100][4];

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            // Open the file for reading

            // Read each line of the file
            String line = reader.readLine();
            System.out.println(line);

            String first4Char = line.substring(0, 4);
            if (first4Char.equals("$AMJ")) {

                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                    // String secondLine = line.substring(0, 4);
                    System.out.println(line);

                }
                for (int index = 0; index < 3; index++) {
                    line = reader.readLine();

                    String secondLine = line.substring(0, 4);

                }
            } else {
                System.out.println("Input doesn't start with $AMJ");
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
