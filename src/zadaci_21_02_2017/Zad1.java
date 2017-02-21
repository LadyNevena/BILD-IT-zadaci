package zadaci_21_02_2017;

import java.util.Scanner;

/*
 *  (Izraèunavanje napojnice) Napisati program koji uèitava ukupan iznos raèuna koji treba uplatiti kao
 *  i procenat tog raèuna kojeg želimo platiti kao napojnicu te izraèunava ukupan raèun i napojnicu.
 *  Na primjer, ukoliko korisnik unese 10 kao raèun i 15 % kao procenat za napojnicu program treba da
 *  ispiše da je ukupan raèun za uplatiti 11.5 a napojnica 1.5. 
 * 
 * */
public class Zad1 {
	public static double napojnica(double cijena, double procenat){
		// vrijednost napojnice
		double napojnica = cijena * procenat / 100.;
		return napojnica;
	}
	public static double racun(double cijena, double procenat) {
		// nova cijena koju treba da plati je tekuci racun + naponica
		double novaCijena = cijena + napojnica(cijena,procenat);

		return novaCijena;
	}

	public static boolean unosProcenta(double p) throws Exception {
		// ne zelimo da procenat bude negativan, i napojnica ne bi trebala da
		// bude veca od 100% izdatog racuna
		if (p < 0 || p > 100) {
			throw new Exception("Procenat negativan, ili prelazi 100%");
		}
		return true;
	}

	public static boolean negativan(double racun) throws Exception {
		if (racun < 0) {
			throw new Exception("Racun negativan");
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double cijena = 0;
		double procenat = 0;
		while (true) {
			try{
				System.out.println("Unesite iznos racuna:");
				cijena = in.nextDouble();
				negativan(cijena);
				break;
			}catch(Exception e){
				System.out.println("Ponovite unos.");
				in.nextLine();
			}

		}
		while (true) {
			try{
				System.out.println("Unesite iznos napojnice u procentima (0%-100%):");
				procenat = in.nextDouble();
				unosProcenta(procenat);
				break;
			}catch(Exception e){
				System.out.println("Ponovite unos.");
				in.nextLine();
			}

		}
		System.out.println("Vas racun iznosi: "+racun(cijena, procenat)+"KM.\nA napojnica koju dajete iznosi: "+napojnica(cijena, procenat)+"KM");

	}

}
