package zadaci_10_02_2017;

import java.util.Scanner;

public class Zad4 {
	public static int[] locateLargest(double[][] a) {
		double max = a[0][0];// pp da je prvi el najveci
		int[] indeksi = new int[2];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i][j] > max) {
					max = a[i][j];
					indeksi[0] = i;// indeks vrste trenutnog najveceg
					indeksi[1] = j;// indeks kolone trenutnog najveceg
				}

			}
		}
		return indeksi;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Unesite dimenzije 2D niza nxn: ");
		int n = in.nextInt();
		double[][] mat = new double[n][n];
		System.out.println("Unesite elemente matrice:");
		// unos matrice
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = in.nextDouble();
			}
		}
		System.out.println("Ispis matrice:");
		System.out.println();
		// ispis elemenata
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Najveci element date matrice se nalazi na poziciji (" + locateLargest(mat)[0] + ","
				+ locateLargest(mat)[1] + ")");
		in.close();

	}

}
