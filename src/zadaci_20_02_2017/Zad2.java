package zadaci_20_02_2017;

import java.util.Scanner;

/*
 * Napisati program koji pita korisnika da unese dva cijela,
 * pozitivna broja te ispisuje najveæi i najmanji
 * zajednièki djelilac za ta dva broja.
 * */
public class Zad2 {
	//provejera da li je negativan
	public static boolean pozitivan(int n) throws Exception{
		if(n<0){
			throw new Exception("NEGATIVAN");
		}
		return true;
	}
	public static int nzd(int a, int b) {
		int nzd = 1;//1 je nzd svih brojeva
		int k=1;
		//u slucaju da su brojevi medjusobno djeljivi, nzd je manji od tih brojeva
		// i to je krajnji slucaj koji moze da se desi
		while (k<=a && k<=b) {
			//zajednicki=djelitelj oba broja
			if(a % k == 0 && b % k == 0){
				nzd=k;
			}
			k++;
		}
		return nzd;
	}
	
	public static int najmanjiZajDjelitelj(int a, int b){
		int k=2;// jer 1 ignorisemo :D
		while (k<=a && k<=b) {
			if(a % k == 0 && b % k == 0){
				return k;
			}
			k++;
		}
		return 1;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a=0,b=0;
		while(true){
			try{
				System.out.println("Unesite pozitivan broj:");
				a = in.nextInt();
				pozitivan(a);
				break;
			}catch(Exception e){
				System.out.println("Ponovite unos!");
				in.nextLine();
			}
		}
		while(true){
			try{
				System.out.println("Unesite pozitivan broj:");
				b = in.nextInt();
				pozitivan(b);
				break;
			}catch(Exception e){
				System.out.println("Ponovite unos!");
				in.nextLine();
			}
		}
		System.out.println("NZD = "+nzd(a,b));
		System.out.println("Najmanji zaj. djelitelj = "+najmanjiZajDjelitelj(a, b));
		in.close();
	}

}
