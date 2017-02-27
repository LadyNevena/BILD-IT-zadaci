package zadaci_27_02_2017;

import java.util.Scanner;

/*
 * (Algebra: multiply two matrices)
 * */
public class Zad2 {
	public static double[][] multiplyMatrix(double[][] matrix1,
			double[][] matrix2) {
		double[][] product = new double[matrix1.length][matrix2[0].length];
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix2[0].length; j++) {
				for (int k = 0; k < matrix2.length; k++) {
					product[i][j] += matrix1[i][k] * matrix2[k][j];
				}
			}

		}
		return product;
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
		int p = 0;

		while (true) {
			try {
				System.out.println("Enter n:");
				n = in.nextInt();
				negative(n);
				break;
			} catch (Exception e) {
				System.out.println("Try again.");
				in.nextLine();
			}
		}
		while (true) {
			try {
				System.out.println("Enter m:");
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
				System.out.println("Enter p:");
				p = in.nextInt();
				negative(p);
				break;
			} catch (Exception e) {
				System.out.println("Try again.");
				in.nextLine();
			}
		}
		
		double[][] matrix1 = new double[n][m];
		double[][] matrix2 = new double[m][p];
		double[][] product = new double[n][p];
		
		System.out.println("Enter first matrix :");
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[0].length; j++) {
				while (true) {
					try {
						System.out.println("Enter element:");
						matrix1[i][j] = in.nextDouble();
						break;
					} catch (Exception e) {
						System.out.println("Try again:");
						in.nextLine();
					}
				}
		
			}
		}
		System.out.println("Enter second matrix :");
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2[0].length; j++) {
				while (true) {
					try {
						System.out.println("Enter element:");
						matrix2[i][j] = in.nextDouble();
						break;
					} catch (Exception e) {
						System.out.println("Try again:");
						in.nextLine();
					}
				}
			}
		}
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[0].length; j++) {
				System.out.print(matrix1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2[0].length; j++) {
				System.out.print(matrix2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		product = multiplyMatrix(matrix1, matrix2);
		System.out.println("Product of two matrices:");
		for (int i = 0; i < product.length; i++) {
			for (int j = 0; j < product[0].length; j++) {
				System.out.print(product[i][j] + " ");
			}
			System.out.println();
		}
		in.close();
	}

}
