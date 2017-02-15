package zadaci_15_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji pita korisnika da unese mjesec i 
 * godinu te mu ispiše broj dana u datom mjesecu. 
 * Na primjer, ukoliko korisnik unese kao godinu 2012 a kao mjesec 2, 
 * program treba ispisati da je Februar 2012 imao 29 dana.
 * Ukoliko korisnik unese kao godinu 2015 a kao mjesec 3, 
 * program treba ispisati da je Mart 2015 imao 31 dan. 
 * 
 * */
public class Zad2 {
	//da li je prestupna
	public static boolean prestupna(int godina) {
		if (godina % 400 == 0 || (godina % 4 == 0 && godina % 100 != 0)) {
			return true;
		}
		return false;
	}
	//ispis odg poruke u zavisnosti od mjeseca
	public static void printDaniUMjesecu(int godina, int mjesec) {
		switch (mjesec) {
		case 1:
			System.out.println("Januar " + godina + " ima 31 dan.");
			break;

		case 2: {
			if (prestupna(godina)) {
				System.out.println("Februar " + godina + " ima 29 dana.");
			} else {
				System.out.println("Februar " + godina + " ima 28 dana.");
			}
		}
			break;
		case 3:
			System.out.println("Mart " + godina + " ima 31 dan.");
			break;
		case 4:
			System.out.println("April " + godina + " ima 30 dan.");
			break;
		case 5:
			System.out.println("Maj " + godina + " ima 31 dan.");
			break;
		case 6:
			System.out.println("Jun " + godina + " ima 30 dan.");
			break;
		case 7:
			System.out.println("Juli " + godina + " ima 31 dan.");
			break;
		case 8:
			System.out.println("Avgust " + godina + " ima 31 dan.");
			break;
		case 9:
			System.out.println("Septembar " + godina + " ima 30 dan.");
			break;
		case 10:
			System.out.println("Oktobar " + godina + " ima 31 dan.");
			break;
		case 11:
			System.out.println("Novembar " + godina + " ima 30 dan.");
			break;
		case 12:
			System.out.println("Decembar " + godina + " ima 31 dan.");
			break;
		}
	}
	//za manje godine ne ispisuje rezultat
	public static boolean validnaGodina(int godina) throws Exception {
		if (godina < 1900) {
			throw new Exception("GRESKA");
		}
		return true;
	}
	//mjeseci su validni ako su izmedju1 i 12
	public static boolean validanMjesec(int mjesec) throws Exception {
		if (mjesec < 1 || mjesec > 12) {
			throw new Exception("GRESKA");
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int mjesec = 0;
		int godina = 0;
		while (true) {
			try {
				System.out.println("Unesite godinu:");
				godina = in.nextInt();
				validnaGodina(godina);
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		while (true) {
			try {
				System.out.println("Unesite mjesec:");
				mjesec = in.nextInt();
				validanMjesec(mjesec);
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		printDaniUMjesecu(godina, mjesec);
		in.close();
	}

}
