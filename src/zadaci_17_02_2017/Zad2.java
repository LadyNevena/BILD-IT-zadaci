package zadaci_17_02_2017;

/*
 * Twin prime brojevi su par prostih brojeva 
 * koji se razlikuju za 2. 
 * Na primjer, brojevi 3 i 5 su twin primes, 
 * brojevi 5 i 7 i 11 i 13 su takoðer twin primes.
 * Napisati program koji ispisuje sve twin prime brojeve 
 * manje od 10000, 10 parova po liniji
 * 
 * */
public class Zad2 {
	public static boolean prime(int broj) {
		for (int i = 2; i <= broj / 2; i++) {
			if (broj % i == 0) {
				return false;
			}
		}
		return true;
	}
	//ispisujemo i i+2 ako su prosti
	public static void printTwinPrime() {
		int brojac = 0;
		for (int i = 2; i < 10000; i++) {
			if (prime(i) && prime(i + 2)) {
				System.out.print("(" + i + "," + (i + 2) + ")  ");
				brojac++;
				if (brojac == 10) {
					System.out.println();
					brojac = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		printTwinPrime();
	}

}
