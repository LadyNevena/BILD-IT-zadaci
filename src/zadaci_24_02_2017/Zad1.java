package zadaci_24_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji prima ASCII kod (cijeli broj izmeðu 0 i 127)
 * te ispisuje koji je to karakter.
 * Na primjer, ukoliko korisnik unese 69 kao ASCII kod,
 * program mu ispisuje da je karakter sa tim brojem karakter E.
 * 
 * */
public class Zad1 {
	public static boolean validan(int n) throws Exception {
		if (n < 0 || n > 127) {
			throw new Exception("n<0 || n>127");
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int broj = 0;
		while (true) {
			try {
				System.out.println("Unesite cijeli broj (0 i 127):");
				broj = in.nextInt();
				validan(broj);
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		System.out.println("ASCII karakter: "+(char) (broj));
		in.close();
	}

}
