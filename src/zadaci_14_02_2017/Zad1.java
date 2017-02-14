package zadaci_14_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji uèitava iznos investicije, godišnju interesnu stopu i 
 * broj godina te vraæa buduæu vrijednost investicije koristeæi se 
 * sljedeæom formulom: buducaVrijednostInvesticije = iznosInvesticije * (1 + mjesecnaInteresnaStopa)^brojGodina*12.
 *  Na primjer, ukoliko uneste kao iznos investicije 1000, 3.25 kao godišnju interesnu stopu i 1 kao broj godina 
 *  program vam vraæa 1032.98 kao buducu vrijednost investicije.
 * 
 * */
public class Zad1 {
	public static boolean negativan(double n) throws Exception{
		if(n<0){
			throw new Exception("NEGATIVAN BROJ");
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		double iznosInvesticije = 0;
		double godisnjaStopa = 0;
		double brojGodina = 0;
		while(true){
			try{
				//unos iznosa
				System.out.println("Unesite iznos investicije:");
				iznosInvesticije=in.nextDouble();
				negativan(iznosInvesticije);
				break;
			}catch(Exception e){
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
			
		}
		while(true){
			try{
				//unos godisnje stope
				System.out.println("Unesite godisnju stopu:");
				godisnjaStopa = in.nextDouble();
				negativan(godisnjaStopa);
				break;
			}catch(Exception e){
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
			
		}
		while(true){
			try{
				//unos godina
				System.out.println("Unesite broj godina:");
				brojGodina = in.nextDouble();
				negativan(brojGodina);
				break;
			}catch(Exception e){
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
			
		}
		double buducaInvesticija = iznosInvesticije*(Math.pow((1+godisnjaStopa/1200),brojGodina*12));
		System.out.printf("Buduca vrijednost investicije: %.3f",buducaInvesticija);
		in.close();
	}
}
