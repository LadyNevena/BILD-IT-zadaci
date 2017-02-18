package zadaci_18_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji pita korisnika da unese broj minuta
 * (npr. 1 milijardu) te ispiše korisniku koliko je to u 
 * godinama i danima.
 * Zbog jednostavnosti, pretpostavimo da godina ima 365 dana.
 *  
 * */
public class Zad4 {
	public static boolean negativan(long n) throws Exception {
		if (n < 0) {
			throw new Exception("negativan");
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long minute = 0;
		while (true) {
			try {
				System.out.println("Unesite minute:");
				minute = in.nextLong();
				negativan(minute);
				break;

			} catch (Exception e) {
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		// dan ima 1440 minuta
		// posto je pretpostavka da godina ima 365 dana
		// godina = 365*1440 = 525600 minuta
		int godina = (int) (minute / 525600);
		System.out.println(minute + " minuta je " + godina + " godine/a.");
		int dani = (int) (minute / 1440);
		System.out.println(minute + " minuta je " + dani + " dana.");
		in.close();
	}

}
