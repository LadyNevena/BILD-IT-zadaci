package zadaci_04_03_2017;

import java.math.BigInteger;

/*
 * (Mersenne prime) A prime number is called a Mersenne prime if it can be written
 * in the form 2p - 1 for some positive integer p. Write a program that finds
 * all Mersenne primes with p … 100 and displays the output as shown below.
 * (Hint: You have to use BigInteger to store the number, because it is too big to
 * be stored in long. Your program may take several hours to run.)
 * 
 * */
public class Zad4 {

	// racuna mersenov broj
	public static BigInteger mersennePrime(int p) {
		BigInteger mersenne = new BigInteger("2");
		mersenne = mersenne.pow(p);
		return mersenne.subtract(BigInteger.ONE);
	}

	// provjera da li je broj prost
	public static boolean prime(BigInteger number) {
		BigInteger i = new BigInteger("2");
		BigInteger halfNum = number.divide(i);
		while (i.compareTo(halfNum) <= 0) {
			if (number.remainder(i).equals(BigInteger.ZERO)) {
				return false;
			}
			i = i.add(BigInteger.ONE);
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("p\tp^2-1");
		System.out.println("---------");
		// traze se za p<=100
		for (int p = 2; p <= 100; p++) {
			// p je prost i ako je mersenov broj prost ispisujemo ga
			if (prime(new BigInteger(p + "")) && prime(mersennePrime(p))) {
				System.out.println(p + "\t" + mersennePrime(p));
			}
		}

	}

}
