package zadaci_08_02_2017;

import java.util.Scanner;

public class Zad2 {
	//fja vraca true ako karakter pripada zadatom nizu karaktera
	public static boolean pripada(char c, char[] niz) {
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] == c) {
				return true;
			}
		}
		return false;
	}

	public static int[] prebrojSamSug(String s) {
	
		//na indeksu 0 cuvamo broj samoglasnika, a na indeksu 1 broj suglasnika
		int[] niz = new int[2];
		
		char[] slova = { 'A', 'O', 'E', 'U', 'I', 'a', 'o', 'e', 'i', 'u' };
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				if (pripada(s.charAt(i), slova)) {
					niz[0]++;
				} else {
					niz[1]++;
				}
			}
		}
		return niz;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesite string:");
		String s = in.nextLine();
		System.out.println("Broj samoglasnika: " + prebrojSamSug(s)[0] + "\nBroj suglasnika: " + prebrojSamSug(s)[1]);
		
		in.close();
	}

}

