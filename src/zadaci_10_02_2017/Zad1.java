package zadaci_10_02_2017;


public class Zad1 {
	// metoda vraca true ako je broj prost
	public static boolean jeProst(int broj) {
		/*
		 * svaki broj se moze napisati kao proizvod svojih prostih faktora ako
		 * je broj prost njegovi jedini faktori su 1 i on sam prvi prost broj je
		 * 2 pa potragu za faktorima zapocinjemo od 2 petlja moze da stane kada
		 * dodjemo do polovine broja, jer bismo u protivnom bespotrebno vrtili
		 * petlju, npr ako je neki broj djeljiv sa 6 on je djeljiv i sa 2 sto
		 * smo vec ranije provjerili cim naidjemo na prost faktor prekidamo
		 * petlju jer je to dovoljno da zakljucimo da broj nije prost
		 * 
		 */
		for (int i = 2; i <= broj / 2; i++) {
			if (broj % i == 0) {
				return false;
			}
		}
		return true;
	}
	//ispis svih prostih iz [a,b] ,njih n u liniji
	public static void printProst(int a, int b, int n) {
		int brojac = 0;
		for (int i = a; i <= b; i++) {
			if (jeProst(i)) {
				System.out.print(i + " ");
				brojac++;
				if (brojac % n == 0) {
					System.out.println();
					brojac = 0;//posto se koristi moduo ,cak ne treba ni vracati brojac na 0
					//mada je bolja varijanta u slucaju da je n ogroman
				}
			}

		}

	}

	public static void main(String[] args) {
		//testiranje metode i ispis prostih brojeva iz segmenta [100,1000]
		//po 10 u liniji
		printProst(100,1000,10);
	}

}
