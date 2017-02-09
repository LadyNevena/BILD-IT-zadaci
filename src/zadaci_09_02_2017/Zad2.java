package zadaci_09_02_2017;

import java.util.Scanner;

public class Zad2 {
	//metoda generise broj od 0 do 9
	public static int generisiBroj() {
		return (int) (Math.random() * 10);
	}

	public static void testOduzimanja(int broj) {
		Scanner in = new Scanner(System.in);
		int unos = -1;
		int tacan = 0;
		int netacan = 0;
		int brojacOdgovora = 0;
		//uslov ove petlje kontrolise broj pitanja postavljenih korisniku
		while (brojacOdgovora < broj) {
			int x = generisiBroj();
			int y = generisiBroj();
			//postavljamo korisniku jednostavno pitanje
			System.out.println(x + "-" + y + "?");
			unos = in.nextInt();
			//ako je unio tacan odgovor brojimo tacne odgovore, u suprotnom netacne
			if ((x - y) == unos) {
				tacan++;
			} else {
				netacan++;
			}
			brojacOdgovora++;
		}
		//ispis rezultata kviza
		System.out.println(
				"Broj tacnih odgovora: " + tacan + "\nBroj netacnih odgovora: " + netacan);
		in.close();

	}

	public static void main(String[] args) {
		//ja sam uzela slobodu da zadam broj pitanja:) cisto da se fja testira 
		int brojPitanja = 5;
		
		testOduzimanja(brojPitanja);
		
		
	}

}
