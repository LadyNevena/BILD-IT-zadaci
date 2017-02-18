package zadaci_18_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji pita korisnika da unese imena 
 * tri grada te ih ispiše u abecednom redu.
 * Na primjer, ukoliko korisnik unese Chicago, Los Angeles i Atlanta 
 * kao gradove, program vraæa Atlanta, Chicago, Los Angeles.
 * 
 * */
public class Zad1 {
	public static void sort(String[] niz){
		for (int i = 0; i < niz.length; i++) {
			for (int j = 0; j < niz.length-1; j++) {
				if(niz[j].compareTo(niz[j+1])>0){
					String temp = niz[j];
					niz[j] = niz[j+1];
					niz[j+1] = temp;
				}
				
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] gradovi = new String[3];
		for (int i = 0; i < gradovi.length; i++) {
			System.out.println("Unesite "+(i+1)+". grad:");
			gradovi[i]=in.nextLine();
		}
		sort(gradovi);
		System.out.println("Sortirani gradovi:");
		for (int i = 0; i < gradovi.length; i++) {
			System.out.println(gradovi[i]);
		}
		in.close();
	}

}
