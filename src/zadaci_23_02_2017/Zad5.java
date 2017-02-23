package zadaci_23_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji pita korisnika da unese cijeli 
 * broj te ispisuje piramidu svih brojeva do tog broja.
 * (Na primjer, ukoliko korisnik unese 7 vrh piramide je broj 1,
 * red ispod vrha piramide je 2 1 2, red ispod je 3 2 1 2 3,
 * red ispod 4 3 2 1 2 3 4 itd.)
 * 
 * */
public class Zad5 {
	public static boolean negativan(int n) throws Exception {
		if (n < 0) {
			throw new Exception("n<0");
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;
		while (true) {
			try {
				System.out.println("Unesite cijeli broj:");
				n = in.nextInt();
				negativan(n);
				break;

			} catch (Exception e) {
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		//ispis piramide sa tabovima, jer nekako tako najpravilnije izgleda
		for (int i = 1; i <= n; i++) {
			for (int j = n; j >i; j--) {
				System.out.print("\t");
			}
			for (int j = i; j > 1; j--) {
				System.out.print(j+"\t");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(j+"\t");
			}
			
			System.out.println();
		}
		in.close();
		
	}

}
