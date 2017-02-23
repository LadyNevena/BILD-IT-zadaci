package zadaci_23_02_2017;

import java.util.Scanner;

/*
 *  Napisati program koji pita korisnika da unese neki string
 *  te mu ispisuje dužinu tog stringa kao i prvo slovo stringa. 
 *
 * */
public class Zad2 {
	public static char prvoSlovo(String recenica){
		for (int i = 0; i < recenica.length(); i++) {
			if(Character.isLetter(recenica.charAt(i))){
				return recenica.charAt(i);
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesite string:");
		String recenica = in.nextLine();
		System.out.println("Duzina stringa: "+recenica.length()+"\nPrvo slovo : "+prvoSlovo(recenica));		
		in.close();
	}

}
