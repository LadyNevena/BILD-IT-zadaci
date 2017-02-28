package zadaci_28_02_2017;

import java.util.Scanner;

/*
 * (Row sorting)
 * */
public class Zad1 {
	public static void sort(double[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int k = 0; k < matrix.length; k++) {
				for (int j = 0; j < matrix[0].length - 1; j++) {
					if (matrix[i][j] > matrix[i][j + 1]) {
						double temp = matrix[i][j];
						matrix[i][j] = matrix[i][j + 1];
						matrix[i][j + 1] = temp;
					}
				}
			}
		}
	}

	public static boolean negative(int n) throws Exception {
		if (n < 0) {
			throw new Exception("negative");
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = 0;
		int n = 0;
		while (true) {
			try {
				System.out.println("Enter the of rows:");
				m = in.nextInt();
				negative(m);
				break;
			} catch (Exception e) {
				System.out.println("Try again.");
				in.nextLine();
			}
		}
		while (true) {
			try {
				System.out.println("Enter the number of columns:");
				n = in.nextInt();
				negative(n);
				break;
			} catch (Exception e) {
				System.out.println("Try again.");
				in.nextLine();
			}
		}
		double[][] a = new double[m][n];

		System.out.println("Enter matrix with "+m+" rows and "+n+" columns.");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				while (true) {
					try {
						a[i][j] = in.nextDouble();
						break;
					} catch (Exception e) {
						System.out.println("Try again.");
						in.nextLine();
					}
				}
			}
		}
		System.out.println("Matrix:");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

		sort(a);
		System.out.println();
		System.out.println("Sorted:");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		in.close();

	}

}
