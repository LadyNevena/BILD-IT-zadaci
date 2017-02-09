package zadaci_09_02_2017;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Zad3 {
	// jednostavna metoda koja prima za argument liniju tj String i vraca broj
	// karaktera u tom stringu
	public static int prebrojKaraktere(String linija) {
		int c = 0;
		for (int i = 0; i < linija.length(); i++) {
			if (linija.charAt(i) != ' ') {
				c++;
			}
		}
		return c;
	}

	// metoda vraca broj rijeci odvojenih razmakom
	public static int prebrojRijeci(String linija) {
		int brojRijeci = 0;
		String[] rijeci = linija.split(" ");

		return rijeci.length;
	}

	public static void main(String[] args) {
		String imeFajla = args[0];
		int brojLinija = 0;
		int brojKaraktera = 0;
		int brojRijeci = 0;
		//za citanje sadrzaja iz fajla koristim klasu BufferedReader
		try {
			System.out.println("Unesite ime fajla:");
			Path path = Paths.get(imeFajla);
			BufferedReader reader = Files.newBufferedReader(path);		
			try {
				String linija = null;
				//sve dok ne dodjemo do kraja fajla
				while ((linija = reader.readLine()) != null) {
					//brojimo linije
					brojLinija++;
					//u svakoj liniji pobrojimo karaktere
					brojKaraktera += prebrojKaraktere(linija);
					//u svakoj liniji pobrojimo rijeci
					brojRijeci += prebrojRijeci(linija);
				}
			} finally {
				System.out.println("Ukupno linija:" + brojLinija + "\nUkupno karaktera:" + brojKaraktera
						+ "\nUkupno rijeci:" + brojRijeci);
				//zatvaramo resusrse koje smo koristili
				reader.close();
			
			}//u ovom "spoljasnjem" catch-u cemo uhvatiti greske
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
