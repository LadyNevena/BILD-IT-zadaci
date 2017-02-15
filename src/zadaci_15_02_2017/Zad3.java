package zadaci_15_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji pita korisnika da unese godinu i 
 * prva tri slova imena mjeseca (prvo slovo uppercase) 
 * te mu ispiše broj dana u tom mjesecu. 
 * Na primjer, ukoliko korisnik kao godinu unese 2001 
 * a kao mjesec Jan program mu ispisuje da Jan 2011 ima 31 dan.*/
public class Zad3 {
	public static boolean prestupna(int godina) {
		if (godina % 400 == 0 || (godina % 4 == 0 && godina % 100 != 0)) {
			return true;
		}
		return false;
	}
	//u zavisnosti od mjeseca ispisujemo odg poruku
	public static void printDaniUMjesecu(int godina, String mjesec) {
		if (mjesec.equals("Jan")) {
			System.out.println(mjesec + " " + godina + " ima 31 dan.");
		} else if (mjesec.equals("Feb")) {
			if (prestupna(godina)) {
				System.out.println(mjesec + " " + godina + " ima 29 dana.");
			} else {
				System.out.println(mjesec + " " + godina + " ima 28 dana.");
			}
		} else if (mjesec.equals("Mar")) {
			System.out.println(mjesec + " " + godina + " ima 31 dan.");
		} else if (mjesec.equals("Apr")) {
			System.out.println(mjesec + " " + godina + " ima 30 dan.");
		} else if (mjesec.equals("Maj")) {
			System.out.println(mjesec + " " + godina + " ima 31 dan.");
		} else if (mjesec.equals("Jun")) {
			System.out.println(mjesec + " " + godina + " ima 30 dan.");
		} else if (mjesec.equals("Jul")) {
			System.out.println(mjesec + " " + godina + " ima 31 dan.");
		} else if (mjesec.equals("Avg")) {
			System.out.println(mjesec + " " + godina + " ima 31 dan.");
		} else if (mjesec.equals("Sep")) {
			System.out.println(mjesec + " " + godina + " ima 30 dan.");
		} else if (mjesec.equals("Okt")) {
			System.out.println(mjesec + " " + godina + " ima 31 dan.");
		} else if (mjesec.equals("Nov")) {
			System.out.println(mjesec + " " + godina + " ima 30 dan.");
		} else if (mjesec.equals("Dec")) {
			System.out.println(mjesec + " " + godina + " ima 31 dan.");
		}

	}

	public static boolean validnaGodina(int godina) throws Exception {
		if (godina < 1900) {
			throw new Exception("GRESKA");
		}
		return true;
	}
	//sve dok se ne unese mjesec u trazenom formatu ispisuje se poruka da ponovo unese
	public static boolean validanMjesec(String mjesec) throws Exception {
		if (!mjesec.equals("Jan") && !mjesec.equals("Feb") && !mjesec.equals("Mar") && !mjesec.equals("Apr")
				&& !mjesec.equals("Jun") && !mjesec.equals("Jul") && !mjesec.equals("Avg") && !mjesec.equals("Sep")
				&& !mjesec.equals("Okt") && !mjesec.equals("Nov") && !mjesec.equals("Dec")&&!mjesec.equals("Maj")) {
			throw new Exception("GRESKA");

		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int godina = 0;
		String mjesec = "";
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
		in.nextLine();
		while (true) {
			try {
				System.out.println("Unesite mjesec:");
				mjesec = in.nextLine();
				validanMjesec(mjesec);
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos.");
			}
		}
		printDaniUMjesecu(godina, mjesec);
		in.close();
	}

}
