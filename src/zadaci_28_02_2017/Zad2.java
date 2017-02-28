package zadaci_28_02_2017;

import java.util.Scanner;

/*
 * (Strictly identical arrays) The two-dimensional arrays m1 and m2 are strictly
 * identical if their corresponding elements are equal.
 * */
public class Zad2 {
	public static boolean strictlyIdentical(int[][] a, int[][] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				if (a[i][j] != b[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] a = new int[3][3];
		int[][] b = new int[3][3];
		System.out.println("Enter matrix:");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				while (true) {
					try {
						a[i][j] = in.nextInt();
						break;
					} catch (Exception e) {
						System.out.println("Enter element again and continue:");
						in.nextLine();
					}
				}
			}
		}
		System.out.println("Enter matrix:");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				while (true) {
					try {
						b[i][j] = in.nextInt();
						break;
					} catch (Exception e) {
						System.out.println("Enter element again and continue:");
						in.nextLine();
					}
				}
			}
		}
		System.out.println("Matrix A:");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Matrix B:");
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		
		if (strictlyIdentical(a, b)) {
			System.out.println("The matrices are strictly identical.");
		} else {
			System.out.println("They are not strictly identical.");
		}

		in.close();
	}

}
