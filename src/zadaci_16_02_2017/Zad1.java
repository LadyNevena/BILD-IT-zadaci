package zadaci_16_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji pita korisnika da unese cijeli broj za današnji dan 
 * u sedmici (0 za ponedjeljak, 1 za utorak...) i da unese broj dana nakon 
 * današnjeg dana te mu ispiše koji je to dan u buduænosti.
 * (Primjer: ako korisnik unese 1 kao današnji dan a 3 kao dan u buduænosti 
 * program mu ispisuje da je danas utorak a dan u buduænosti je petak.) 
 *
 * */
public class Zad1 {

	public static int danUBuducnosti(int x, int y) {
		return (x + y) % 7;
	}

	public static void printDan(int x, int y) {
		String[] dani = { "ponedjeljak", "utorak", "srijeda", "cetvrtak", " petak", "subota", "nedjelja" };
		System.out.println("Danas je " + dani[x] + " ,a za " + y + " dan/a ce biti " + dani[danUBuducnosti(x, y)]+".");
	}

	public static boolean negativan(int n) throws Exception {
		if (n < 0) {
			throw new Exception("NEGATIVAN");
		}
		return true;
	}

	public static boolean validanDan(int dan) throws Exception {
		if (dan < 0 || dan > 6) {
			throw new Exception("ERR");
		}
		return true;
	}

	public static void printDan() {

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int dan = 0;
		int brojDana=0;
		while (true) {
			try {
				System.out.println("Unesite danasnji dan:");
				dan = in.nextInt();
				validanDan(dan);
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos. Dani u sedmici(0-6).");
				in.nextLine();
			}
		}
		while (true) {
			try {
				System.out.println("Unesite broj dana nakon danasnjeg dana:");
				brojDana = in.nextInt();
				negativan(brojDana);
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		printDan(dan,brojDana);
		in.close();

	}

}
