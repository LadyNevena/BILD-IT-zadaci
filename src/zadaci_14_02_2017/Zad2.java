package zadaci_14_02_2017;

import java.util.Scanner;

/*
 * Metoda koja ispisuje sve prestupne godine, 10 po liniji
 * */
public class Zad2 {
	public static boolean prestupna(int godina) {
		if (godina % 400 == 0 || (godina % 4 == 0 && godina % 100 != 0)) {
			return true;
		}
		return false;
	}

	public static boolean negativan(double n) throws Exception {
		if (n < 0) {
			throw new Exception("NEGATIVAN BROJ");
		}
		return true;
	}

	public static boolean manjaVeca(int a, int b) throws Exception {
		if (a < b) {
			return true;
		}
		throw new Exception("POCETNA VECA OD KRAJNJE.");
	}
	//metoda za ispis prestupnih godina, 10 po liniji
	public static void printPrestupne(int a, int b) {
		int brojac = 0;
		for (int i = a; i <= b; i++) {
			if (prestupna(i)) {
				System.out.print(i + " ");
				brojac++;
				if (brojac % 10 == 0) {
					System.out.println();
					brojac = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = 0;
		int b = 0;
		//kontrolisemo unos pocetne i krajnje godine
		//u slucaju da je prvo unio krajnju godinu pa onda pocetnu 
		//nudi mu se mogucnost da ponovi unos
		while (true) {
			try{
				//unosi godine, bitno je da nije negativna i da nije neki karakter
			while (true) {
				try {
					System.out.println("Unesite pocetnu godinu:");
					a = in.nextInt();
					negativan(a);
					break;
				} catch (Exception e) {
					System.out.println("Ponovite unos:");
					in.nextLine();
				}
			}
			//unos krajnje godine, bitno je da nije negativna i da nije karakter
			while (true) {
				try {
					System.out.println("Unesite krajnju godinu:");
					b = in.nextInt();
					negativan(b);
					break;
				} catch (Exception e) {
					System.out.println("Ponovite unos:");
					in.nextLine();
				}
			}
			manjaVeca(a,b);
			break;
			}catch(Exception e){
				System.out.println("Pocetna godina je veca od krajnje. Ponovite unos.");
			}
		}
		//ako je sve proslo kako treba ispisujemo godine, 10 po liniji
		printPrestupne(a, b);
		in.close();
	}
}
