package zadaci_09_02_2017;

import java.util.Scanner;

public class Zad4 {
	public static void printMatrix(int n) {
		int[][] matrica = new int[n][n];
		// petlja kojom kontolisemo vrstu
		for (int i = 0; i < matrica.length; i++) {
			// petlja za kontrolu kolone
			for (int j = 0; j < matrica[i].length; j++) {
				// presjek i-te vrste i j-te kolone je generisano 0 ili 1
				matrica[i][j] = (int) (Math.random() * 2);
				// ispisujemo generisani element matrice
				System.out.print(matrica[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesite dimenzije matrice (nxn) :");
		int n = in.nextInt();

		printMatrix(n);
		in.close();
	}

}
