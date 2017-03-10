package zadaci_10_03_2017;

import java.util.*;
import java.io.*;

public class RemoveName {
	public static void main(String[] args) {
		Scanner input=null;
		if (args.length != 2) {
			System.out.println("Invalid arguments.");
			System.exit(1);
		}

		
		File filename = new File(args[1]);
		if (!filename.exists()) {
			System.out.println(args[1] + " does not exist.");
			System.out.println(2);
		}

		String s = "";
		try {
			input = new Scanner(filename);
			while (input.hasNext()) {
				s += input.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		s = s.replaceAll(args[0], "");
		try {
			PrintWriter output = new PrintWriter(filename);
			System.out.println(s);
			output.write(s);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		input.close();
	}
}