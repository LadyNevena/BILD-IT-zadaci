package zadaci_03_03_2017;

class PrimeNumbers {

	private int[] primes;
	private int size = 5;
	private int length;
	private int number;

	PrimeNumbers(int number) {
		this.number = number;
		primes = new int[this.size];
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public void push(int value) {
		if (length >= primes.length) {
			int[] temp = new int[primes.length * 2];
			System.arraycopy(primes, 0, temp, 0, primes.length);
			primes = temp;
		}
		primes[length++] = value;
	}

	public int pop() {
		return primes[--length];
	}

	public int peek() {
		return primes[length - 1];
	}

	public boolean empty() {
		return length == 0;
	}

	public int[] getPrimes() {
		for (int i = 2; i < number; i++) {
			if (isPrime(i)) {
				push(i);
			}
		}
		/*
		 * for (int i = 0; i < primes.length; i++) { for (int j = 0; j <
		 * primes.length; j++) { if (primes[i] >= primes[j]) { int temp =
		 * primes[i]; primes[i] = primes[j]; primes[j] = temp; } } }
		 */
		return primes;
	}

}

public class TestPrimeNumbers {

	public static void main(String[] args) {
		int number = 120;
		PrimeNumbers pn = new PrimeNumbers(number);

		/*
		 * int[] primes = pn.getPrimes(); for (int i = 0; i < primes.length;
		 * i++) { if (primes[i] != 0) { System.out.println(primes[i]); } else{
		 * break; } }
		 */
		System.out.println("Prime numbers less than 120 in decreasing order:");
		pn.getPrimes();
		while (!pn.empty()) {
			System.out.println(pn.pop());
		}

	}

}
