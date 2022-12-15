import java.io.*;
import java.util.*;

public class ReadFile {
	char IR[] = new char[4];
	static char M[][] = new char[100][4];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("D:/VIT/BE SYS3/OS/OS Project/job.txt"));
		String line = null;
		String str = "0002";
		int c = 0;
		line = br.readLine();

		while (true) {
			if (line == null)
				break;
			if (!line.trim().equals("")) {
				if (line.indexOf(str) != -1) {
					System.out.println("$AMJ is present in the line.");
					break;
				}
			}

		}

	}
}