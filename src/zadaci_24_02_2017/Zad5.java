package zadaci_24_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji uèitava 10 brojeva te ispisuje koilko je
 * jedinstvenih brojeva unijeto te sve jedinstvene brojeve koji
 * su unijeti, razmaknute jednim spaceom.
 * Ukoliko se neki broj pojavljuje više puta,
 * broj treba ispisati samo jednom.
 * 
 * */
public class Zad5 {
	//samo provjerava da li je element pripada nizu
	public static boolean inArray(int[] array, int n) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == n) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] array = new int[10];
		int k = 0;
		int x = 0;
		//odmah brojimo jedinstvene u toku unosa, i samo njih smjestamo u niz
		for (int i = 0; i < 10; i++) {
			while (true) {
				try {
					System.out.println("Enter integer number:");
					x = in.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Try again.");
					in.nextLine();
				}
			}
			//ako se uneseni broj vec nalazi u nizu onda ga preskocimo
			if (inArray(array, x)) {
				continue;
			} else {
				array[k] = x;
				k++;
			}
		}
		System.out.println("The number of distict numbers is: " + k);
		System.out.println("The distinct numbers are:");
		for (int i = 0; i < k; i++) {
			System.out.print(array[i] + " ");
		}

		in.close();

	}

}
