package zadaci_25_02_2017;

import java.util.Scanner;

/*
 * Write a method that returns the sum of all the
 * elements in a specified column in a matrix.
 * */
public class Zad4 {
	public static double sumMatrixColumn(double[][] matrix, int column) {
		double sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum += matrix[i][column];
		}
		return sum;
	}

	public static boolean negative(int n) throws Exception {
		if (n < 0) {
			throw new Exception("negative");
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;
		int m = 0;
		while (true) {
			try {
				System.out.println("Enter number of rows:");
				n = in.nextInt();
				negative(n);
				break;
			} catch (Exception e) {
				System.out.println("Enter again.");
				in.nextLine();
			}
		}
		while (true) {
			try {
				System.out.println("Enter number of columns:");
				m = in.nextInt();
				negative(m);
				break;
			} catch (Exception e) {
				System.out.println("Enter again.");
				in.nextLine();
			}
		}
		double[][] matrix = new double[n][m];
		System.out.println("Enter matrix (row by row):");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				while (true) {
					try {
						matrix[i][j] = in.nextDouble();
						break;
					} catch (Exception e) {
						System.out.println("Enter number again.");
						in.nextLine();
					}
				}

			}
		}
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < matrix[0].length; i++) {
			System.out.println("Sum of elements in " + i + " column is: " + sumMatrixColumn(matrix, i));
		}
		in.close();
	}

}
