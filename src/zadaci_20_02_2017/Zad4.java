package zadaci_20_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji pita korisnika da unese 3 cijela broja
 * te mu ispi�e ta ista tri broja u rastu�em redosljedu.
 * Bonus: Napisati metodu koja prima tri cijela broja kao
 * argumente te vra�a brojeve u rastu�em redosljedu. 
 * 
 * */
public class Zad4 {
	// s obzirom da imamo samo 3 broja, sortiranje mozemo obaviti jednostavnim
	// poredjenjem brojeva
	public static int[] displaySortedNumbers(int x, int y, int z) {
		int[] rastuci = new int[3];
		int temp;
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
		rastuci[0] = x;
		rastuci[1] = y;
		rastuci[2] = z;

		return rastuci;
	}

	public static int unos() {
		Scanner in = new Scanner(System.in);
		int broj = 0;
		while (true) {
			try {
				System.out.println("Unesite cijeli broj:");
				broj = in.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Molimo, ponovite unos.");
				in.nextLine();
			}
		}
		return broj;
	}

	public static void main(String[] args) {
		int x = unos();
		int y = unos();
		int z = unos();
		System.out.println("Sortirani u rastucem nizu:");
		for (int i = 0; i < 3; i++) {
			System.out.print(displaySortedNumbers(x, y, z)[i]+" ");
		}

	}

}
