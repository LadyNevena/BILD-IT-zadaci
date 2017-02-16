package zadaci_16_02_2017;

import java.util.Scanner;

/*
 * Great circle distance predstavlja udaljenost izmeðu dvije taèke na površine sfere.
 * Neka nam (x1, y1) i (x2, y2) predstavljaju geografsku širinu i dužinu dvije taèke.
 * Great circle distance izmeðu ove dvije taèke može biti izraèunata koristeæi se sljedeæom formulom:
 * d = radius * arccos (sin(x1) X sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2)). 
 * Napisati program koij pita korisnika da unese geografsku širinu i dužinu u stepenima
 * dvije taèke na površini zemlje te mu ispisuje great circle distance.
 * Prosjeèni radius zemlje je 6.371.01 km.
 * Stepene koje korisnik unese trebamo promijeniti u radianse koristeæi 
 * se Math.toRadians metodom jer Java trigonometrijske metode koriste radianse. 
 * Širina i dužina u ovoj formuli se odnose na zapad i sjever. 
 * Koristimo negativne vrijednosti da oznaèimo istok i jug. 
 * 
 * */
public class Zad2 {
	public static double udaljenost(double x, double y, double z, double t) {
		//stepene u radijane
		double x1 = Math.toRadians(x), y1 = Math.toRadians(y);
		double x2 = Math.toRadians(z), y2 = Math.toRadians(t);
		//rastojanje izmedju tacaka
		double d = 6371.01 * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
		return d;
	}
	
	//metoda za unos
	public static double validanUnos(){
		Scanner in = new Scanner(System.in);
		double unos = 0;
		while (true) {
			try {
				System.out.println("Unesite koordinatu:");
				unos = in.nextDouble();
				break;
			} catch (Exception e) {
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		return unos;
	}

	public static void main(String[] args) {
		double x1 = 0, y1 = 0;
		double x2 = 0, y2 = 0;
		x1=validanUnos();
		y1=validanUnos();
		x2=validanUnos();
		y2=validanUnos();
		System.out.printf("Udaljenost izmedju tacaka iznosi: %.3f", udaljenost(x1, y1, x2, y2));
	
	}

}
