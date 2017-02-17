package zadaci_17_02_2017;

import java.util.Scanner;

/*
 * Napisati metodu koja vraæa broj dana u godini.
 * Metoda koristi sljedeæi header: public static int numberOfDayInAYear(int year).
 * Napisati program koji pita korisnika da unese poèetnu godinu,
 * krajnju godinu te ispisuje broj dana za svaku godinu u rasponu.
 * 
 * */
public class Zad1 {
	public static boolean isLeap(int godina) {
		if (godina % 400 == 0 || (godina % 4 == 0 && godina % 100 != 0)) {
			return true;
		}
		return false;
	}
    //zavisno od toga je li prestupna ima 366 ili 365 dana
	public static int numberOfDayInAYear(int year) {
		if (isLeap(year)) {
			return 366;
		} else {
			return 365;
		}
	}

	public static boolean isValid(int year) throws Exception {
		if (year < 1800 || year > 3000) {
			throw new Exception("ERR");
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int year1 = 0;
		int year2 = 0;
		while (true) {
			try {
				System.out.println("Unesite pocetnu godinu:");
				year1 = in.nextInt();
				isValid(year1);
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos:");
				in.nextLine();
			}
		}
		while (true) {
			try {
				System.out.println("Unesite krajnju godinu:");
				year2 = in.nextInt();
				isValid(year2);
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos:");
				in.nextLine();
			}
		}
		for (int i = year1; i <= year2; i++) {
			System.out.println("Godina = " + i + ", broj dana = " + numberOfDayInAYear(i));
		}
		in.close();
	}

}
