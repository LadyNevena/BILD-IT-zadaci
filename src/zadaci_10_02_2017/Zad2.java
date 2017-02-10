package zadaci_10_02_2017;

import java.util.Scanner;

public class Zad2 {
	public static double min(double[] array) {
		double min = array[0];// pp da je prvi el. niza minimalan
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];// novi minimalan
			}
		}
		return min;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double[] array = new double[10];
		System.out.println("Unesite 10 brojeva:");
		for (int i = 0; i < array.length; i++) {
			array[i] =in.nextDouble();
		}
		System.out.println("Najmanji element u nizu je: " + min(array));

		in.close();
	}

}
