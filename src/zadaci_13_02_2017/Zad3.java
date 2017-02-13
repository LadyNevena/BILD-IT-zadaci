package zadaci_13_02_2017;

import java.util.Scanner;

/* Napisati program koji pita korisnika da unese 2 stringa te ispisuje najveæi zajednièki prefix za ta dva stringa, ukoliko isti postoji. 
 * Na primjer, ukoliko korisnik unese sljedeæa dva stringa 
 * "Dobrodošli u Dubai" i "Dobrodošli u Vankuver"
 * program treba da ispiše: Najveæi zajednièki prefix za dva stringa je "Dobrodošli u"
 * */
public class Zad3 {
	public static String prefiks(String s1, String s2) {
		int kraj = 0;
		String prefiks = "";
		//petlja se vrti do kraceg stringa
		if (s1.length() < s2.length()) {
			kraj = s1.length();
		} else {
			kraj = s2.length();
		}
		
		for (int i = 0; i < kraj; i++) {
			//kad naidje na prvo razlicito slovo, petlja prekida sa radom
			if (s1.charAt(i) != s2.charAt(i)) {
				break;
			} else {
				prefiks += s1.charAt(i);
			}
		}
		return prefiks;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesite prvi string:");
		String s1 = in.nextLine();
		System.out.println("Unesite drugi string:");
		String s2 = in.nextLine();
		System.out.println("Najveci prefiks stringova: " + prefiks(s1, s2));
		in.close();
	}
}
