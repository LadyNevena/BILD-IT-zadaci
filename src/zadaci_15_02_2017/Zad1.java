package zadaci_15_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji ispisuje tri nasumièna cijela broja 
 * te pita korisnika da unese njihov zbir.
 * Ukoliko korisnik pogriješi,
 * program ispisuje pitanje ponovo sve sa porukom da pokuša ponovo. 
 * Ukoliko korisnik unese taèan odgovor, 
 * program mu èestita i završava sa radom. 
 * 
 * */
public class Zad1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = (int) (Math.random() * 50);
		int b = (int) (Math.random() * 50);
		int c = (int) (Math.random() * 50);
		int odgovor = a + b + c;
		int unos = 0;
		do {
			while (true) {
				try {
					System.out.println("Koliko je " + a + "+" + b + "+" + c + "?");
					unos = in.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Pogresan unos.");
					in.nextLine();

				}
			}

		} while (unos != odgovor);
		System.out.println("Cestitamo, tacan odgovor!");
		in.close();

	}
}
