package zadaci_15_02_2017;

import java.util.Scanner;

/*
 *  Neke web stranice forsiraju odreðena pravila za passworde.
 *  Napisati metodu koja provjerava da li je unijeti string validan 
 *  password. Pravila da bi password bio validan su sljedeæa:
 *   1. Password mora biti saèinjen od najmanje 8 karaktera. 
 *   2. Password smije da se sastoji samo od slova i brojeva. 
 *   3. Password mora sadržati najmanje 2 broja. 
 *  Napisati program koji pita korisnika da unese password
 *  te mu ispisuje "password je validan" 
 *  ukoliko su sva pravila ispoštovana ili 
 *  "password nije validan" ukoliko pravila nisu ispoštovana.
 * 
 * */
public class Zad5 {
	public static boolean slovaBrojevi(String password) {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLetterOrDigit(password.charAt(i))) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static int brojevi(String password) {
		int brojac = 0;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				brojac++;
			}
		}
		return brojac;
	}

	public static boolean validanPassword(String password) {
		if (password.length() >= 8 && slovaBrojevi(password) && brojevi(password) >= 2)
			return true;

		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesite password:");
		String password = in.nextLine();
		System.out.println("VALIDAN = " + validanPassword(password));
		in.close();
	}

}
