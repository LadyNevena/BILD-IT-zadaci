package zadaci_24_02_2017;

import java.util.Scanner;

/*
 * Napisati metodu sa sljedeæim headerom:
 * public static String format(int number, int width)
 * koja vraæa string broja sa prefiksom od jedne ili više nula.
 * Velièina stringa je width argument.
 * Na primjer, ukoliko pozovemo metodu format(34, 4) metoda vraæa 0034,
 * ukoliko pozovemo format(34, 5) metoda vraæa 00034.
 * Ukoliko je uneseni broj veæi nego width argument,
 * metoda vraæa samo string broja.
 * Npr. ukoliko pozovemo format(34, 1) metoda vraæa 34.
 * 
 * */
public class Zad4 {
	public static String format(int number, int width) {
		String s = Integer.toString(Math.abs(number));
		int j = s.length();
		if (s.length() < width && width > 0) {
			for (int i = j; i < width; i++) {
				s = "0" + s;
			}
		}else if(s.length() < Math.abs(width) && width < 0){
			for (int i = j; i < Math.abs(width); i++) {
				s += "0";
			}
		}
		else {
			s = Integer.toString(Math.abs(number));
		}
		if (number < 0) {
			s = "-" + s;
		}
		return s;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number = 0;
		int width = 0;

		while (true) {
			try {
				System.out.println("Unesite cijeli broj:");
				number = in.nextInt();
				break;
			} catch (Exception e) {
				in.nextLine();
			}
		}
		while (true) {
			try {
				System.out.println("Unesite sirinu formata:");
				width = in.nextInt();
				break;
			} catch (Exception e) {
				in.nextLine();
			}
		}
		System.out.println(format(number, width));
		in.close();

	}

}
