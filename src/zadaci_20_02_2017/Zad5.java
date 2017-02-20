package zadaci_20_02_2017;

import java.util.Scanner;

/*
 *  Napisati program koji uèitava cijele brojeve u rasponu od 1 do 100
 *  te broji i ispisuje koliko je koji broj puta unijet.
 *  Pretpostavimo da nula prekida unos brojeva.
 *  Ukoliko unesemo sljedeæi niz brojeva 2 5 6 23 42 58 2 6 0
 *  program nam ispisuje da se broj 2 ponavlja 2 puta,
 *  broj 5 jednom, broj 6 2 puta, broj 23 jednom, itd.
 *  
 * */
public class Zad5 {
	public static boolean validanUnos(int n) throws Exception {
		if (n < 0 || n > 100) {
			throw new Exception("ERR");
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//indeksi ovog niza su brojevi koje unosimo
		//na svako pojavljivanje broja , uvecavamo odg. index za 1
		int[] brojevi = new int[101];
		int broj = 0;
		while (true) {
			try {
				System.out.println("Unesite cijeli broj izmedju [1,100]:");
				broj = in.nextInt();
				validanUnos(broj);
				if (broj == 0) {
					break;
				}
				// kada unese broj , odg. index u nizu uvecamo za 1
				brojevi[broj]++;

			} catch (Exception e) {
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		for (int i = 0; i < brojevi.length; i++) {
			if (brojevi[i] != 0) {
				System.out.println("Broj " + i + " se pojavio " + brojevi[i] + " puta.");
			}
		}
		in.close();

	}

}
