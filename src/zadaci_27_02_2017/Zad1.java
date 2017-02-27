package zadaci_27_02_2017;

import java.util.Scanner;

/*
 * (Compute the weekly hours for each employee) Suppose the weekly hours for all
 * employees are stored in a two-dimensional array. Each row records an employee’s
 * seven-day work hours with seven columns. For example, the following
 * array stores the work hours for eight employees. Write a program that displays
 * employees and their total hours in decreasing order of the total hours.
 * 
 * */
public class Zad1 {
	/*
	 * izracuna ukupno sati za datu vrstu, odnosno, za datog radnika
	 */
	public static int sumHours(int[][] matrix, int row) {
		int sum = 0;
		for (int i = 0; i < matrix[0].length; i++) {
			sum += matrix[row][i];
		}
		return sum;
	}

	public static int[] totalHoursForEmployees(int[][] matrix) {
		// u hours[] smjestamo ukupno sati za svakog radnika
		int[] hours = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			hours[i] = sumHours(matrix, i);
		}
		return hours;
	}

	public static int[][] sort(int[] array) {
		// u matrix[][] smjestamo u prvu kolonu indekse radnika, a u drugu
		// kolonu ukupne sate za svakog radnika
		int[][] matrix = new int[array.length][2];
		// u prvoj koloni matrice su indeksi radnika
		for (int i = 0; i < array.length; i++) {
			matrix[i][0] = i;
		}
		// sortiramo niz sa ukupnim satima, i u isto vrijeme pamtimo indekse i
		// njih sortiramo u prvoj koloni matrice
		for (int i = 0; i < array.length; i++) {
			for (int j = array.length - 1; j > 0; j--) {
				if (array[j - 1] < array[j]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
					int temp1 = matrix[j - 1][0];
					matrix[j - 1][0] = matrix[j][0];
					matrix[j][0] = temp1;
				}
			}
		}
		// u prvoj koloni su sortirani indeksi, i jos u drugu kolonu ubacimo
		// sortiran niz sa ukupnim brojem sati
		// sto znaci da se na matrix[0][0] nalazi indeks radnika sa najvecim
		// brojem sati, a na matrix[0][1] se nalazi ukupan broj sati za tog
		// radnika
		for (int i = 0; i < array.length; i++) {
			matrix[i][1] = array[i];
		}
		return matrix;
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
				System.out.println("Enter the number of employees:");
				n = in.nextInt();
				negative(n);
				break;
			} catch (Exception e) {
				System.out.println("Try again.");
				in.nextLine();
			}
		}
		int[][] matrix = new int[n][7];// 7 dana u sedmici
		System.out.println("Enter matrix:");

		for (int i = 0; i < matrix.length; i++) {
			System.out.println("Enter hours:");
			for (int j = 0; j < matrix[i].length; j++) {
				while (true) {
					try {
						matrix[i][j] = in.nextInt();
						negative(matrix[i][j]);
						break;
					} catch (Exception e) {
						System.out.println("Try again:");
						in.nextLine();
					}
				}
			}
		}
		System.out.println("\t\tSu\tM\tT\tW\tTh\tF\tSa");
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("Employee " + i + ":\t");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		int[] array = new int[matrix.length];
		array = totalHoursForEmployees(matrix);
		int[][] printHours = new int[array.length][2];
		printHours = sort(array);
		System.out.println();
		for (int j = 0; j < printHours.length; j++) {
			System.out.println("Employee " + printHours[j][0] + ": " + printHours[j][1] + " total hours");
		}
		
		in.close();
	}

}
