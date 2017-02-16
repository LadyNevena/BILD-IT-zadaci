package zadaci_16_02_2017;

import java.util.Scanner;

/*
 * Napišite program koji uèitava neodreðen broj cijelih brojeva (unos prekida nula),
 * pronalazi najveæi od unijetih brojeva te ispisuje koliko se najveæi broj puta 
 * ponovio. 
 * Na primjer, ukoliko unesemo 3 5 2 5 5 5 0 
 * program ispisuje da je najveæi broj 5 te ispisuje da se isti ponavlja 4 puta. 
 *
 * */
public class Zad4 {
	public static int brojPonavljanja(java.util.ArrayList<Integer> brojevi, int x) {
		int brojac = 0;
		for (int i = 0; i < brojevi.size(); i++) {
			if (brojevi.get(i).equals(x)) {
				brojac++;
			}
		}
		return brojac;
	}

	public static int max(java.util.ArrayList<Integer> brojevi) {
		int max = (int) brojevi.get(0);
		for (int i = 1; i < brojevi.size(); i++) {
			if ((int) brojevi.get(i) > max) {
				max = (int) brojevi.get(i);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		java.util.ArrayList<Integer> brojevi = new java.util.ArrayList<>();
		int unos = -1;
		while (unos != 0) {
			while (true) {
				try {
					System.out.println("Unesite broj: ");
					unos = in.nextInt();
					break;

				} catch (Exception e) {
					System.out.println("Ponovite unos.");
					in.nextLine();
				}
			}
			if (unos == 0) {
				break;
			} else {
				brojevi.add(unos);

			}
		}

		System.out.println("Najveci broj je " + max(brojevi) + ".\nPojavio se " + brojPonavljanja(brojevi, max(brojevi))
				+ " puta.");
		in.close();
	}

}
