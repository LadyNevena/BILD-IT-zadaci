package bonus_13_02_2017;

import java.util.Scanner;

public class SvjetlosneGodine {
	public static long kilometri(long brojSvjGodina){
		//svjetlost putuje brzinom 299.792.458 m/s
		//sekunde u godini * 299 792 458 m/s je priblizno 9 460 730 472 580 800 m u jednoj svjetlosnoj godini
		return brojSvjGodina*(9460730472800l/1000);
	}
	public static long au(long brojSvjGodina){
		//AU  149.6 miliona km
		//gore sam izracunala da jedna svj. godina ima 9 460 730 580 800 m
		//(9 460 730 580 800 / 1000)/149600 je nekih 63 241 AU
		//tako dobijamo da 1sg=63241au
		return brojSvjGodina*63241;
	}
	public static double parsec(long brojSvjGodina){
		//1ps=3.26sg
		return brojSvjGodina/3.26;
	}
	public static double helios2(long brojSvjGodina){
		//helios2 252 792.537 km/h je otprilike nekih 70.220 km/s
		//kad se brzina svjetlosti 299 792 458 m/s pretvori u km/s dobijemo da
 		//svjetlost putuje brzinom 299 792.458 km/s

		return (brojSvjGodina*299792.458)/70.220;
	}
	public static boolean negative(long n) throws Exception{
		if(n<0){
			throw new Exception("NEGATIVE.");
		}
		return false;
	}
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		long numOfYears=0;
		while(true){
			try{
				System.out.println("Unesite broj svj. godina:");
				numOfYears=in.nextLong();
				negative(numOfYears);
				break;
			}catch(Exception e){
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		System.out.println(numOfYears+" svjetlosnih godinaje priblizno "+kilometri(numOfYears)+" km.");
		System.out.println(numOfYears+" svjetlosnih godina je priblizno "+au(numOfYears)+" au.");
		System.out.println(numOfYears+" svjetlosnih godina je priblizno "+parsec(numOfYears)+" parsec.");
		System.out.println(numOfYears+" svjetlosnih godina je priblizno "+helios2(numOfYears)+" putovanja heliosom2.");
		in.close();
		//btw provjerom na raznim kalkulatorima po netu, rezultati su priblizni
		//LOL

	}

}
