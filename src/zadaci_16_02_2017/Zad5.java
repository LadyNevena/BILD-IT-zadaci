package zadaci_16_02_2017;

import java.util.Scanner;

/*
 * Napisati metodu koja pretavara milisekunde u sate, minute i sekunde.
 * Metoda treba da koristi sljedeæi header: 
 * public static String convertMillis(long millis).
 * Metoda treba da vraæa vrijeme kao string u formatu sati:minute:sekunde.
 * Na primjer convertMillis(100000) treba da vrati 0:1:40.
 * 
 * */
public class Zad5 {
	public static String convertMillis(long millis) {
		//milisekunde u sekunde
		long sec = millis / 1000;
		long currentSec = sec % 60;
		long min = sec / 60;
		long currentMin = min % 60;
		long hour = min / 60;
		long currentHour = hour % 24;
		return currentHour+":"+currentMin+":"+currentSec;

	}
	public static boolean negativan(long n) throws Exception {
		if (n < 0) {
			throw new Exception("NEGATIVAN");
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long millis=0;
		while (true) {
			try {
				System.out.println("Unesite broj milisekundi:");
				millis=in.nextLong();
				negativan(millis);
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		System.out.println(convertMillis(millis));
		in.close();
	}

}
