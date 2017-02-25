package zadaci_25_02_2017;

import java.util.Scanner;

/*
 *add two matrices 
 * */
public class Zad5 {
	//add two matrices
	public static int[][] addMatrix(int matrix1[][], int matrix2[][]) {
		int sum[][] = new int[matrix1.length][matrix1[0].length];
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[0].length; j++) {
				sum[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		return sum;
	}
	//is negative number
	public static boolean negative(int n) throws Exception {
		if (n < 0) {
			throw new Exception("negative");
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//n for rows and m for columns
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

		int[][] matrix1 = new int[n][m];
		int[][] matrix2 = new int[n][m];
		int[][] sum = new int[n][m];
		//enter first matrix
		System.out.println("Enter first matrix :");
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[0].length; j++) {
				while (true) {
					try {
						matrix1[i][j] = in.nextInt();
						break;
					} catch (Exception e) {
						System.out.println("Enter number again.");
						in.nextLine();
					}
				}
			}
		}
		//enter for second matrix
		System.out.println("Enter second matrix :");
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2[0].length; j++) {
				while (true) {
					try {
						matrix2[i][j] = in.nextInt();
						break;
					} catch (Exception e) {
						System.out.println("Enter number again.");
						in.nextLine();
					}
				}
			}
		}
		//print
		System.out.println("Matrix A:");
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[0].length; j++) {
				System.out.print(matrix1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Matrix B:");
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2[0].length; j++) {
				System.out.print(matrix2[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		//call addmatrix() function
		sum = addMatrix(matrix1, matrix2);
		System.out.println("Matrix C = A+B :");
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum[0].length; j++) {
				System.out.print(sum[i][j] + " ");
			}
			System.out.println();
		}
		in.close();

	}

}
