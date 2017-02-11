package zadaci_11_02_2017;

import java.util.Scanner;

public class Zad2 {
	// niz cifara isbn-a
	public static int[] cifreISBN(String isbn) {
		int[] cifre = new int[9];
		for (int i = 0; i < isbn.length(); i++) {
			cifre[i] = Integer.parseInt(isbn.charAt(i) + "");
		}
		return cifre;
	}

	// vraca d10 prema formuli,a cifre broja su u nizu
	public static int checkSum(String isbn) {
		int cifre[] = cifreISBN(isbn);
		int d10 = 0;
		for (int i = 0; i < cifre.length; i++) {
			d10 += cifre[i] * (i + 1);
		}
		return d10 % 11;
	}

	// pomocna metoda za provjeru da li string sadrzi samo brojeve
	public static boolean samoBrojevi(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}

	// ako je negativan, duzi od 9 ili kraci, ako se ne sastoji samo od brojeva
	public static boolean validanISBN(String isbn) throws Exception {
		if (isbn.length() == 9 && Integer.parseInt(isbn) > 0 && samoBrojevi(isbn)) {
			return true;
		} else {
			throw new Exception("ISBN je 9-cifreni pozitivan cijeli broj. ");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesite prvih 9 cifara ISBN :");
		boolean nastavi = true;
		while (nastavi) {
			try {
				String isbn = in.nextLine();
				validanISBN(isbn);
				nastavi = false;
				String newISBN = "";
				if (checkSum(isbn) == 10) {
					newISBN = isbn + "X";
					System.out.println("ISBN = " + newISBN);
				} else {
					newISBN = isbn + "1";
					System.out.println("ISBN = " + newISBN);
				}
			} catch (Exception ex) {
				System.out.println(ex + "\n");
				System.out.println("Unesite ponovo:");
			}
		}
		in.close();
	}

}
