package zadaci_14_02_2017;

import java.util.Scanner;

/*
 * Ako imamo ubrzanje aviona a te brzinu pri kojoj avion uzlijeće v, 
 * možemo izračunati minimalnu dužinu piste potrebne da avion uzleti 
 * koristeći se sljedećom formulom: dužina = v * v / 2a.
 * Napisati program koji pita korisnika da unese v u m/s i a u m/s² te ispisuje
 * korisniku minimalnu dužinu piste.
 *(Primjer: ukoliko unesemo 60 za brzinu i 3.5 za ubrzanje dužina piste je 514.286)
 * 
 * */
public class Zad5 {
	public static boolean negativan(double n) throws Exception {
		if (n < 0) {
			throw new Exception("NEGATIVAN BROJ");
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double a = 0;
		double v = 0;
		while (true) {
			try {
				System.out.println("Unesite brzinu uzlijetanja aviona u m/s:");
				v = in.nextDouble();
				negativan(v);
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		while (true) {
			try {
				System.out.println("Unesite ubrzanje aviona u m/s²:");
				a = in.nextDouble();
				negativan(a);
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		double duzina = Math.pow(v, 2) / (2 * a);
		System.out.printf("Minimalna duzina piste: %.3f", duzina);
		in.close();
	}

}
