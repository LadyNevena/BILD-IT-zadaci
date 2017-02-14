package bonus_13_02_2017;

import java.util.Scanner;

public class Kalkulator {

	Kalkulator() {

	}

	public static double sabiranje(java.util.ArrayList<Double> brojevi) {
		int suma = 0;
		for (int i = 0; i < brojevi.size(); i++) {
			suma += brojevi.get(i);
		}
		return suma;
	}

	public static double oduzimanje(java.util.ArrayList<Double> brojevi) {
		int rez = 0;
		for (int i = 0; i < brojevi.size(); i++) {
			rez -= brojevi.get(i);
		}
		return rez;
	}

	public static double mnozenje(java.util.ArrayList<Double> brojevi) {
		int rez = 1;
		for (int i = 0; i < brojevi.size(); i++) {
			rez *= brojevi.get(i);
		}
		return rez;
	}

	public static double dijeljenje(java.util.ArrayList<Double> brojevi) {
		double rez = brojevi.get(0);
		for (int i = 1; i < brojevi.size(); i++) {
			rez /= brojevi.get(i);
		}
		return rez;
	}

	public static double korijen(double broj) {
		return Math.sqrt(broj);
	}

	public static double stepen(double broj, double n) {
		return Math.pow(broj, n);
	}

	public static boolean validnaOperacija(int n) throws Exception {
		if (n < 0 || n > 6) {
			throw new Exception("GRESKA");
		}
		return true;
	}

	public static java.util.ArrayList<Double> validanUnos() {
		Scanner in = new Scanner(System.in);
		java.util.ArrayList<Double> lista = new java.util.ArrayList<>();
		double n = -1;
		//0 prekida unos brojeva u listu
		while (n != 0) {
			while (true) {
				try {
					System.out.println("Unesite broj:");
					n = in.nextDouble();
					if (n == 0) {
						break;
					}
					lista.add(n);
					break;
				} catch (Exception e) {
					System.out.println("Ponovite unos.");
					in.nextLine();
				}
			}
		}
		in.close();
		return lista;
	}

	
	public void menu() {
		Scanner in = new Scanner(System.in);
		System.out.println("  Kalkulator");
		System.out.println("--------------");
		System.out.println("1.+\t2.-\n3.*\t4./\n5.sqrt\t6.pow");
		System.out.println("--------------");
		int operacija = 0;
		while (true) {
			try {
				operacija = in.nextInt();
				validnaOperacija(operacija);
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos:");
				in.nextLine();
			}
		}
		switch (operacija) {
		case 1: {
			System.out.println("Rezultat sabiranja: " + sabiranje(validanUnos()));

		}
			break;
		case 2: {
			System.out.println("Rezultat oduzimanja: " + oduzimanje(validanUnos()));

		}
			break;
		case 3: {
			System.out.println("Rezultat mnozenja: " + mnozenje(validanUnos()));

		}
			break;
		case 4: {
			System.out.println("Rezultat djeljenja: " + dijeljenje(validanUnos()));

		}
			break;
		case 5: {
			double broj=0;
			while(true){
				try{
					System.out.println("Unesite broj: ");
					broj=in.nextDouble();
					break;
				}catch(Exception e){
					System.out.println("Ponovite unos:");
					in.nextLine();
				}
			}
			System.out.println("sqrt(" + broj + ") = " + korijen(broj));

		}
			break;
		case 6: {
			double broj=0;
			while(true){
				try{
					System.out.println("Unesite broj: ");
					broj=in.nextDouble();
					break;
				}catch(Exception e){
					System.out.println("Ponovite unos:");
					in.nextLine();
				}
			}
			double n=0;
			while(true){
				try{
					System.out.println("Unesite stepen: ");
					n=in.nextDouble();
					break;
				}catch(Exception e){
					System.out.println("Ponovite unos:");
					in.nextLine();
				}
			}
			System.out.println(broj + "^" + n + " = " + stepen(broj, n));
		}   
		    break;

		}
		in.close();

	}

}
