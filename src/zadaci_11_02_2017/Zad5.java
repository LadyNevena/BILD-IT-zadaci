package zadaci_11_02_2017;

import java.util.Scanner;

public class Zad5 {
	// metoda koja stampa ukupno brojeva iznas i ispod srednje vrijednosti
	public static void printBrojeva(java.util.ArrayList<Integer> lista) {
		int iznad = 0;
		int ispod = 0;
		double avg = 0;
		double suma = 0;

		for (int i = 0; i < lista.size(); i++) {
			double broj = (double) (lista.get(i));
			suma += broj;
		}
		// System.out.println("suma="+suma);
		avg = suma / lista.size();
		// System.out.println("avg="+avg);

		for (int i = 0; i < lista.size(); i++) {
			if ((double) (lista.get(i)) >= avg) {
				iznad++;
			} else {
				ispod++;
			}
		}
		System.out.println("Ukupno iznad ili jednakih prosjeku: " + iznad + "\nUkupno ispod prosjeka:" + ispod);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int broj = 0;
		boolean flag = true;
		java.util.ArrayList<Integer> lista = new java.util.ArrayList<>();
		System.out.println("Unosite brojeve:");

		// ukoliko korisnik unese nesto sto nije cio broj
		// program ne prekida sa radom, vec ispisuje poruku da korisnik nastavi
		// sa unosom
		// dok ne unese ispravno
		while (lista.size() != 100) {
			try {
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
		if (flag) {
			printBrojeva(lista);
		}
		in.close();
	}

}
