package zadaci_24_02_2017;

import java.util.Scanner;

/*
 * U javi, short vrijednost se sprema u samo 16 bita.
 * Napisati program koji pita korisnika da unese short broj te mu
 * ispiše svih 16 bita za dati cijeli broj.
 * Na primjer, ukoliko korisnik unese
 * broj 5 - program mu ispisuje 0000000000000101
 * 
 * */
public class Zad3 {

	public static String add0(String s) {
		int j = s.length();
		for (int i = j; i < 16; i++) {
			s = "0" + s;
		}
		return s;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// -32768 do 32767 
		short x = 0;
		
		while (true) {
			try {
				System.out.println("Unesite short broj:");
				x = in.nextShort();
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos.");
				in.nextLine();
			}

		}
		String s = Integer.toBinaryString(x);
		if (x > 0) {
			System.out.println(add0(s));
		} else {
			String binaryShort = s.substring(s.length() - 16, s.length());
			System.out.println(binaryShort);
		}
		in.close();
	}

}
