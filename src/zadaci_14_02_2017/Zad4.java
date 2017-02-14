package zadaci_14_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji pita korisnika da unese neki string 
 * te mu ispisuje sve karaktere koji se nalaze na neparnim pozicijama.
 * Na primjer, ako korisnik unese string Beijing Chicago, 
 * program vraæa BiigCiao.
 * 
 * */
public class Zad4 {
	public static String karakteriNeparnePozicije(String s) {
		String novi = "";
		for (int i = 0; i < s.length(); i += 2) {
			novi += s.charAt(i);
		}
		return novi;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesite string:");
		String s = in.nextLine();
		System.out.println("Ispis: " + karakteriNeparnePozicije(s));
		in.close();
	}

}
