package zadaci_23_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji pita korisnika da unese cijeli
 * trocifreni broj te provjerava da li je unijeti broj palindrom.
 * Broj je palindrom ukoliko se èita isto
 * i sa lijeva na desno i sa desna na lijevo npr. 121, 131, itd.

 * */
public class Zad1 {
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

	public static boolean isThreeDigit(int number) throws Exception {
		if (!(Integer.toString(Math.abs(number)).length() == 3)) {
			throw new Exception("num!=3");
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number = 0;
		while (true) {
			try {
				System.out.println("Unesite broj: ");
				number = in.nextInt();
				isThreeDigit(number);
				break;
			} catch (Exception e) {
				System.out.println("Molimo unesite  trocifren cio broj!");
				in.nextLine();
			}
		}
		System.out.println("PALINDROM = " + isPalindrome(number));
		in.close();

	}

}
