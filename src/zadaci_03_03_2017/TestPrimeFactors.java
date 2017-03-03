package zadaci_03_03_2017;

class PrimeFactors {

	private int[] factors;
	private int size = 5;
	private int length;
	private int number;

	PrimeFactors(int value) {
		setNumber(value);
		factors = new int[size];
	}

	public void setNumber(int value) {
		this.number = value;
	}

	public void setLenght(int value) {
		this.length = value;
	}

	public int getLenght() {
		return length;
	}

	public int getNumber() {
		return this.number;
	}

	public void push(int value) {
		if (length >= factors.length) {
			int[] temp = new int[factors.length * 2];
			System.arraycopy(factors, 0, temp, 0, factors.length);
			factors = temp;
		}

		factors[length++] = value;
	}

	public int pop() {
		return factors[--length];
	}

	public int peek() {
		return factors[length - 1];
	}

	public boolean empty() {
		return length == 0;
	}

	public int[] getFactors() {
		for (int i = 2; i <= this.number; i++) {
			while (this.number % i == 0) {
				setNumber(this.number / i);
				push(i);
			}
		}
		/*
		 * for (int i = 0; i < factors.length; i++) { for (int j = 0; j <
		 * factors.length; j++) { if (factors[i] > factors[j]) { int temp =
		 * factors[i]; factors[i] = factors[j]; factors[j] = temp; } } }
		 */
		return factors;
	}

}

public class TestPrimeFactors {

	public static void main(String[] args) {

		PrimeFactors pf = new PrimeFactors(120);

		pf.getFactors();

		/*
		 * int[] factors = pf.getFactors(); for (int i = 0; i < factors.length;
		 * i++) { System.out.println(factors[i]); }
		 */
		System.out.println("Prime factors of 120 in decreasing order:");
		while (!pf.empty()) {
			System.out.println(pf.pop());
		}

	}

}
