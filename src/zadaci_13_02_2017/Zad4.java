package zadaci_13_02_2017;

import java.util.Scanner;

public class Zad4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unos niza: ");
		int[] niz = new int[10];
		//unos niza, s tim sto ako unese  neki karakter, ne ide se ispocetka, vec
		//unosi ponovo taj broj
		for (int i = 0; i < niz.length; i++) {
			while (true) {
				try {
					niz[i] = in.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Ponovite unos:");
					in.nextLine();
				}
			}
		}
		System.out.println("Ispis brojeva u obrnutom redoslijedu:");
		for (int i = niz.length - 1; i >= 0; i--) {
			System.out.println(niz[i]);
		}
		in.close();

	}

}
