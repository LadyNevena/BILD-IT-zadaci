package zadaci_21_02_2017;

import java.util.Scanner;

/*
 * Pretpostavimo da kupujemo rižu ili neki drugi proizvod u dva razlièita pakovanja.
 * Želimo napisati program koji uporeðuje cijene ta dva pakovanja.
 * Program pita korisnika da unese težinu i cijenu oba pakovanja
 * te ispisuje koje pakovanje ima bolju cijenu.
 *
 * */
public class Zad5 {
	
	public static boolean isNegative(double n) throws Exception{
		if(n<0){
			throw new Exception("Neagtive number.");
		}
		return true;
	}
	public static double validInput() {
		Scanner in = new Scanner(System.in);
		double w = 0;
		while (true) {
			try {
				System.out.println("Enter: ");
				w = in.nextDouble();
				isNegative(w);
				break;
			} catch (Exception e) {
				System.out.println("Try again.");
				in.nextLine();
			}
		}
		return w;
	}

	public static void main(String[] args) {
		System.out.println("Enter weight for package1.");
		double w1 = validInput();
		System.out.println("Enter price for package1.");
		double p1 = validInput();
		System.out.println("Enter weight for package2.");
		double w2 = validInput();
		System.out.println("Enter price for package2,");
		double p2 = validInput();
		
		double k1 = w1 / p1;
		double k2 = w2 / p2;
		// System.out.println(k1+" "+k2);
		
		if (k1 > k2) {
			System.out.println("Package1 has a better price.");
		} else if (k2 > k1) {
			System.out.println("Package2 has a better price.");
		} else {
			System.out.println("The packages have the same price.");
		}
	}

}
