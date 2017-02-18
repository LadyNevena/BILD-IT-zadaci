package zadaci_18_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji uèitava neodreðen broj cijelih brojeva,
 * odreðuje koliko je pozitivnih brojeva korisnik unio,
 * koliko negativnih te izraèunava ukupnu sumu i prosjek svih
 * unesenih brojeva.
 * (Korisnik prekida unos tako što unese nulu).
 * Na primjer, ukoliko korisnik unese 1 2 -1 3 0
 * program treba da ispiše da je broj pozitivnih brojeva 3,
 * negativnih brojeva 1,
 * suma ili zbir su 5.0 a prosjek svih brojeva je 1.25.
 * */
public class Zad5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		java.util.ArrayList<Integer> lista = new java.util.ArrayList<>();
		int broj = -1;
		while (broj != 0) {
			try {
				System.out.println("Unesite broj u listu:");
				broj = in.nextInt();
				if (broj == 0) {
					break;
				} else {
					lista.add(broj);
				}
			} catch (Exception ex) {
				System.out.println("Niste unijeli cijeli broj! Ponovite unos broja: ");
				in.nextLine();
			}
		}
		int negativni = 0;
		int suma = 0;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) < 0) {
				negativni++;
			}
			suma += lista.get(i);
		}
		System.out.println("Pozitivnih ima: " + (lista.size() - negativni));
		System.out.println("Negativnih ima: " + negativni);
		System.out.println("Suma svih unesenih brojeva: " + suma);
		System.out.println("Prosjek unesenih brojeva: " + ((double) suma / lista.size()));
		in.close();
	}

}
