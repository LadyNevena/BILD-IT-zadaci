package zadaci_13_02_2017;

import java.util.Scanner;

/*
 * Pretpostavimo da uplatimo $100 svaki mjesec na �tedni ra�un
 *  koji ima godi�nju interesnu stopu od 5%. 
 *  Mjese�na interesna stopa je stoga 0.05 / 12 = 0.00417. 
 *  Nakon prvog mjeseca vrijednost na ra�unu postaje 100 * (1 + 0.00417) = 100.417. 
 *  Nakon drugog mjeseca, vrijednost na ra�unu postaje (100 + 100.417) * (1 + 0.00417) = 201.252. 
 *  Nakon tre�eg mjeseca, vrijednost na ra�unu postaje (100 + 201.252) * (1 + 0.00417) = 302.507 i tako dalje.
 *  Napisati program koji pita korisnika da unese mjese�ni iznos �tednje te broj mjeseci
 *  nakon kojeg bi �elio znati stanje ra�una. 

 * */
public class Zad1 {
	//racuna stedju po zadatoj formuli
	public static double stednja(int brojMjeseci, double kStopa) {
		double iznos = 0;
		double iStopa = kStopa / 1200;
		for (int i = 0; i < brojMjeseci; i++) {
			iznos = (100 + iznos) * (1 + iStopa);
		}
		return iznos;
	}

	public static boolean validanMjesec(int broj) throws Exception {
		if (broj < 0) {
			throw new Exception("GRESKA");
		}
		return true;
	}
	public static boolean validnaKamata(double broj) throws Exception {
		if (broj < 0) {
			throw new Exception("GRESKA");
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int brojMjeseci=0;
		double kStopa=0;
		
		while (true) {
			try {
				System.out.println("Unesite broj mjeseci: ");
				brojMjeseci = in.nextInt();
				validanMjesec(brojMjeseci);
				break;
			} catch (Exception e) {
				System.out.println("Unijeli ste nepravilnu vrijednost.");
				in.nextLine();
			}
		}
		while(true){
			try{

				System.out.println("Unesite kamatnu stopu u procentima:");
				kStopa=in.nextDouble();
				validnaKamata(kStopa);
				break;
			}catch(Exception e){
				System.out.println("Unijeli ste nepravilnu vrijednost.");
				in.nextLine();
			}
			
		}
		
		System.out.printf("Stednja nakon %d mjeseca  = %.3f",brojMjeseci,stednja(brojMjeseci,kStopa));
		in.close();
	}

}
