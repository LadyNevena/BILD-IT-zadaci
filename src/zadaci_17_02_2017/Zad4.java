package zadaci_17_02_2017;

import java.util.Scanner;

/*
 * Napisati metodu koja pronalazi broj ponavljanja 
 * odreðenog karaktera u stringu. 
 * Metoda treba da koristi sljedeæi header:
 * public static int count(String str, char a). 
 * Na primjer, ukoliko pozovemo metodu na sljedeæi naèin:
 * count("Welcome", e) metoda treba da vrati 2. 
 * Napisati program koji pita korisnika da unese string i koji karakter 
 * želi da prebroji u datom stringu te mu ispiše koliko se puta odreðeni 
 * karakter ponovio u zadatom stringu.
 * 
 * */
public class Zad4 {
	//brojanje karaktera
	public static int count(String str, char a) {
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == a) {
				counter++;
			}
		}
		return counter;
	}
	//ako unese string a ne karakter , unosi ponovo dok ne unese karakter
	public static boolean length(String s) throws Exception {
		if (s.length() > 1) {
			throw new Exception("ERR");
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesite string:");
		String str = in.nextLine();
		String s = "";
		char c=0;
		while (true) {
			try {
				System.out.println("Unesite karakter:");
				s = in.nextLine();
				length(s);
				c = s.charAt(0);
				break;

			} catch (Exception e) {
				System.out.println("Niste unijeli jedan karakter.");
			}
		}
		System.out.println("Karakter "+c+" se pojavio "+count(str, c)+" puta.");
		in.close();
	}

}
