package zadaci_10_02_2017;

import java.util.Scanner;

public class Zad5 {
	public static void sortRedova(int[][] mat ){
		//kontrola redova
		for (int i = 0; i < mat.length; i++) {
			//sortiranje datog reda algoritmom bubble sort
			//vrsi se poredenje svih elemenata i zamjena po kriterijumu iz if-a
			for (int j = 0; j < mat[i].length; j++) {
				for (int k = 0; k < mat[i].length-1; k++) {
					if(mat[j][k]>mat[j][k+1]){
						int temp = mat[j][k];
						mat[j][k] = mat[j][k+1];
						mat[j][k+1] = temp;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Unesite dimenzije 2D niza nxn: ");
		int n = in.nextInt();
		int[][] mat = new int[n][n];
		System.out.println("Unesite elemente matrice:");
		// unos matrice
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = in.nextInt();
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
		sortRedova(mat);
		System.out.println("Matrica sa sortiranim redovima:");
		// ispis elemenata nakon poziva fje sortRedova(mat);
				for (int i = 0; i < mat.length; i++) {
					for (int j = 0; j < mat[i].length; j++) {
						System.out.print(mat[i][j] + " ");
					}
					System.out.println();
				}
				in.close();
	}


}
