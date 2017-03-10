package zadaci_10_03_2017;

import java.io.*;

import java.util.*;

public class CountCharsWordsLines {


	public static int prebrojRijeci(String linija) {
		int brojRijeci = 0;
		String[] rijeci = linija.split(" ");
		for (int i = 0; i < rijeci.length; i++) {
			System.out.println(rijeci[i]);
			if (rijeci[i].isEmpty()) {
				continue;
			}
			brojRijeci++;
		}
		return brojRijeci;
	}

	public static void main(String[] args) {
		Scanner input = null;
		
		if (args.length != 1) {
			System.out.println("Invalid arguments.");
			System.exit(1);
		}
		
		File filename = new File(args[0]);
		if (!filename.exists()) {
			System.out.println(filename + " does not exist.");
			System.exit(2);
		}

		int brojLinija = 0;
		int brojKaraktera = 0;
		int brojRijeci = 0;

		try {
			input = new Scanner(filename);
			while (input.hasNext()) {
				String s = input.nextLine();
				brojLinija++;
				brojKaraktera += s.length();
				brojRijeci += prebrojRijeci(s);
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		System.out.println("Broj linija: " + brojLinija);
		System.out.println("Broj rijeci: " + brojRijeci);
		System.out.println("Broj karaktera: " + brojKaraktera);
		input.close();
	}
}
