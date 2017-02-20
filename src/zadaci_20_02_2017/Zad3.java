package zadaci_20_02_2017;

/*
 * Napisati metodu sa sljedeæim headerom: 
 * public static int isPrime(int n) koja provjerava da li je broj prost/prime.
 * Napisati test program koji poziva ovu metodu i ispisuje sve proste brojeve
 * u rasponu od 0 do 100000.
 * 
 * */
public class Zad3 {
	public static boolean isPrime(int n) {
		if (n == 0 || n == 1) {
			return false;
		}
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100000; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			} else {
				continue;
			}
		}

	}

}
