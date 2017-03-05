package zadaci_04_03_2017;

import java.math.BigInteger;

/*
 * (Divisible by 5 or 6) Find the first ten numbers greater than Long.MAX_VALUE
 * that are divisible by 5 or 6.
 * */
public class Zad5 {
	
	//ako je djeljiv sa 5 ili sa 6 vrati true
	public static boolean divisibleBy5And6(BigInteger number) {
		BigInteger rem5 = new BigInteger("5");
		BigInteger rem6 = new BigInteger("6");
	
			if (number.remainder(rem5).equals(BigInteger.ZERO) || number.remainder(rem6).equals(BigInteger.ZERO)) {
				return true;
			}
		
		
		return false;
	}

	public static void main(String[] args) {
		
		BigInteger maxLongNumber = new BigInteger(String.valueOf(Long.MAX_VALUE));
		int counter = 0;
		
		while (counter < 10) {
			maxLongNumber = maxLongNumber.add(BigInteger.ONE);
			//ispis prvih 10 djeljivih sa 5 ili sa 6 vecih od Long.MAX_VALUE
			if (divisibleBy5And6((maxLongNumber))) {
				System.out.println(maxLongNumber);
				counter++;
			}
			maxLongNumber = maxLongNumber.add(BigInteger.ONE);
		}

	}

}
