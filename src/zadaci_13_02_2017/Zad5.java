package zadaci_13_02_2017;

import java.util.Scanner;

/*
 * Napisati metodu koja broji slova u stringu. 
 * Metoda treba koristiti sljedeæi header: public static int countLetters(String s). 
 * Napisati program koji pita korisnika da unese neki string te mu 
 * vrati koliko taj string ima slova.
*/
public class Zad5 {
	public static int brojacSlova(String s){
		int brojacSlova=0;
		for (int i = 0; i < s.length(); i++) {
			if((s.charAt(i)>='a'&& s.charAt(i)<='z') || (s.charAt(i)>='A'&& s.charAt(i)<='Z')){
				brojacSlova++;
			}
		}
		return brojacSlova;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesite string: ");
		String s = in.nextLine();
		System.out.println("Ukupno slova: "+brojacSlova(s));
		
		in.close();
	}

}
