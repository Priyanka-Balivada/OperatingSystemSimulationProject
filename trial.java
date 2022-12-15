public class trial {
    public static void main(String[] args) {
        static char M[][] = new char[100][4];

        try {
            // Open the file for reading
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

            // Read each line of the file
            String line = reader.readLine();
            while (line != null) {
                // Print the first four characters of the line
                String amj = line.substring(0, 4);
                if (amj.equals("$AMJ")) {
                    System.out.println("File is starting the $AMJ");
                }
                System.out.println(amj);

                // Read the next line
                line = reader.readLine();
            }

            // Close the file
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
