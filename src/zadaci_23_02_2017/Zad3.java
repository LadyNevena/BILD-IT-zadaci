package zadaci_23_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji pita korisnika da unese
 * Social Security Number (SSN) u formatu DDD-DD-DDDD
 * gdje D predstavlja broj.
 * Program treba da provjerava da li je broj unesešen u ispravnom formatu.
 * Ukoliko nije, program pita korisnika da pokuša ponovo.
 * Ukoliko jeste unešen u pravom formatu, program završava sa radom.
 * 
 * */
public class Zad3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("Unesite SSN:");
			String ssn = in.nextLine();
			if (ssn.matches("^(\\d{3}-?\\d{2}-?\\d{4})$")) {
				System.out.println("SSN je validan.");
				break;
			} else {
				System.out.println("SSN nije validan.");
			}
		}
		in.close();

	}

}
