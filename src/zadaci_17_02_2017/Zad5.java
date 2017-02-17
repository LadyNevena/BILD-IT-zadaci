package zadaci_17_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji pita korisnika 
 * da unese dva stringa te provjerava i ispisuje 
 * da li je drugi string substring prvog stringa. 
 * Na primjer, ukoliko korisnik unese ABCD kao prvi string 
 * a BC kao drugi string program mu ispisuje da je 
 * BC substring ABCD stringa.
 * 
 * */
public class Zad5 {
	//provjera pomocu metode contains
	public static boolean isSubstring(String s1, String s2){
		if(s1.contains(s2)){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesite prvi string:");
		String s1 = in.nextLine();
		System.out.println("Unesite drugi string:");
		String s2 = in.nextLine();
		if(isSubstring(s1, s2)){
			System.out.println(s2+" je podstring od "+s1);
		}
		else{
			System.out.println(s2+" nije podstring od "+s1);
		}
		in.close();
	}

}
