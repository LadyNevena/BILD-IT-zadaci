package zadaci_21_02_2017;

import java.util.Scanner;

/*
 *  Napišite metodu sa sljedeæim headerom koja vraæa naopako ispisan
 *  broj koji joj je proslijeðen kao argument:
 *  public static void reverse(int number).
 *  Na primjer, reverse(3456) treba da vrati 6543.
 *  Napisati program koji pita korisnika da unese neki cijeli broj te mu
 *  vrati isti ispisan naopako. 
 * 
 * */
public class Zad2 {
	public static void reverse(int number) {
		int digit = 0;
		int num = number;
		System.out.println("Obrnuti broj:");
		while (number != 0) {
			digit = number % 10;
			if (numOfDigits(number) == numOfDigits(num)) {
				if (number<0 && digit == 0) {
					System.out.print("-"+digit);
				} else {
					System.out.print(digit);
				}
			} else {
				System.out.print(Math.abs(digit));
			}
			number /= 10;
		}
	}

	public static int numOfDigits(int number) {
		return Integer.toString(Math.abs(number)).length();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number = 0;
		while (true) {
			try {
				System.out.println("Unesite cijeli broj:");
				number = in.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		reverse(number);
		in.close();
	}

}
