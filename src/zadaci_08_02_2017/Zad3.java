package zadaci_08_02_2017;


import java.util.Scanner;

public class Zad3 {
	public static int nzd(int a, int b) {
		int nzd = 1;//1 je nzd svih brojeva
		int k=1;
		//u slucaju da su brojevi medjusobno djeljivi, nzd je manji od tih brojeva
		// i to je krajnji slucaj koji moze da se desi
		while (k<a || k<b) {
			//zajednicki=dijelitelj oba broja
			if(a % k == 0 && b % k == 0){
				nzd=k;
			}
			k++;
		}
		return nzd;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesite prvi broj:");
		int a = in.nextInt();
		System.out.println("Unesite drugi broj:");
		int b = in.nextInt();
		System.out.println("NZD: " + nzd(a, b));
		
		in.close();

	}

}