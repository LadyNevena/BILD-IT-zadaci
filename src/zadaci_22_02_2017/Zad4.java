package zadaci_22_02_2017;

import java.util.Scanner;

/*
 * Napisati metodu koja izraèunava zbir svih brojeva u cijelom broju.
 * Koristite sljedeæi header: public static int sumDigits(long n).
 * Na primjer, ako pozovemo metodu i proslijedimo joj broj 234
 * (sumDigits(234)) metoda treba da vrati 9. (2 + 3 + 4 = 9)
 * */
public class Zad4 {
	public static int sumDigits(long n){
		int sum = 0;
		while(n!=0){
			int digit = (int)(n%10);
			sum+=digit;
			n/=10;
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = 0;
		while(true){
			try{
				System.out.println("Unesite broj:");
				n = in.nextLong();
				break;
			}catch(Exception e){
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		System.out.println("Suma cifara: "+sumDigits(n));

	}

}
