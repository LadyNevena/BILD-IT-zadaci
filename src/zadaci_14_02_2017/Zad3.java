package zadaci_14_02_2017;

import java.util.Scanner;

/*
 * Napisati metode sa sljedeæim headerima: 
 * public static int reverse(int number) i 
 * public static boolean isPalindrome(int number).
 * Prva metoda prima cijeli broj kao argument i vraæa isti ispisan naopako.
 * (npr. reverse(456) vraæa 654.) 
 * Druga metoda vraæa true ukoliko je broj palindrom a false ukoliko nije.
 * Koristite reverse metodu da implementirate isPalindrome metodu. 
 * Napišite program koji pita korisnika da unese broj
 * te mu vrati da li je broj palindrome ili ne. 
 * 
 * */
public class Zad3 {
	public static int reverse(int number) {
		int revNum = 0;
		// sve dok ne dodjemo do 0
		while (number != 0) {
			// otkinemo zadnju cifru
			int digit = number % 10;
			// pomnozimo prethodno sa 10 i dodamo cifru da napravimo broj
			revNum = revNum * 10 + digit;
			// podijelimo sa 10 da bi mogli izracunati sljedecu cifru
			number /= 10;
		}
		return revNum;
	}

	public static boolean isPalindrome(int number) {
		// ako je broj sa okrenutim ciframa jednak sebi on je palindrom
		if (number < 0)
			return false;
		else if (reverse(number) == number)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number = 0;
		while (true) {
			try {
				System.out.println("Unesite broj: ");
				number = in.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Niste unijeli broj!");
				in.nextLine();
			}
		}
		System.out.println("PALINDROM = " + isPalindrome(number));
		in.close();
	}

}
