package zadaci_11_02_2017;

import java.util.Scanner;

public class Zad3 {
	//s obzirom da imamo samo 3 broja, sortiranje mozemo obaviti jednostavnim poredjenjem brojeva
	public static void displaySortedNumbers(double x, double y, double z) {
		double temp;
		if (x > y) {
			temp = x;
			x = y;
			y = temp;
		}
		if (y > z) {
			temp = y;
			y = z;
			z = temp;
		}
		if (x > y) {
			temp = x;
			x = y;
			y = temp;
		}
		System.out.println("Sortirani u rastucem nizu: " + x + " " + y + " " + z);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean nastavi = true;
		System.out.println("Unesite 3 broja:");
		//program nastavlja da pita korisnika sve dok ispravno ne unese brojeve
		while (nastavi) {
			try {
				double x = in.nextDouble();
				double y = in.nextDouble();
				double z = in.nextDouble();
				displaySortedNumbers(x, y, z);
				nastavi = false;
			} catch (Exception ex) {
				System.out.println("NEPRAVILAN UNOS! Ponovo unesite 3 broja: ");
				in.nextLine();
			}
		}
		in.close();
	}

}
