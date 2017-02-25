package zadaci_25_02_2017;

import java.util.Scanner;

/*
 * Write a test program that prompts the user to enter a series
 * of integers and displays
 * if the series contains four consecutive numbers with the same value.
 * 
 * */
public class Zad3 {
	public static boolean consecutiveEqual(int[] array, int a, int b) {
		for (int i = a; i < b - 1; i++) {
			if (array[i] != array[i + 1]) {
				return false;
			}
		}
		return true;
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
		while (true) {
			try {
				System.out.println("Enter length of an array:");
				n = in.nextInt();
				negative(n);
				break;
			} catch (Exception e) {
				System.out.println("Enter again.");
				in.nextLine();
			}
		}

		int[] a = new int[n];

		System.out.println("Enter elements of an array:");
		for (int i = 0; i < n; i++) {
			while (true) {
				try {
					a[i] = in.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Enter number again.");
					in.nextLine();
				}
			}
		}
		
		boolean consecutive = false;
		
		for (int i = 0; i <= a.length - 4; i++) {
			consecutive = false;
			if (consecutiveEqual(a, i, i + 4)) {
				consecutive = true;
				break;
			}
		}
		
		if (!consecutive) {
			System.out.println("The list has no consecutive four.");
		} else {
			System.out.println("The list has consecutive four.");
		}

		in.close();

	}

}
