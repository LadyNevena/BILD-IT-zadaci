package zadaci_24_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji prima karakter te vraæa njegov Unicode.
 * Primjer: ukoliko korisnik unese karakter E program mu vraæa
 * 69 kao unicode za taj karakter.
 * 
 * */
public class Zad2 {
	public static boolean validan(String s) throws Exception {
		if (s.length() > 1) {
			throw new Exception("nije karakter");
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char karakter = 0;
		while (true) {
			try {
				System.out.println("Unesite karakter:");
				String s = in.nextLine();
				validan(s);
				karakter = s.charAt(0);
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos.");
			}
		}
		System.out.println("Unicode: "+(int)(karakter));
		in.close();

	}

}
