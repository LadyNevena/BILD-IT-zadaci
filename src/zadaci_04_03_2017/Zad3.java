package zadaci_04_03_2017;

import java.math.BigInteger;

/*
 * (Large prime numbers) Write a program that finds five prime numbers larger
 * than Long.MAX_VALUE.
 * 
 * */
public class Zad3 {
	
	//provjera da li je prost
	public static boolean prime(BigInteger number) {
		BigInteger i = new BigInteger("2");
		BigInteger halfNum = number.divide(i);
		while (i.compareTo(halfNum) <= 0) {
			if (number.remainder(i).equals(BigInteger.ZERO)) {
				return false;
			}
			i = i.add(BigInteger.ONE);
			System.out.println("vrti se");
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		//krecemo od Long.MAX_VALUE
		BigInteger maxLongNumber = new BigInteger(String.valueOf(Long.MAX_VALUE));
		int counter = 0;
		
		while (counter < 5) {
			//posto se trazi strogo veci, krecemo od prvog veceg od Long.MAX_VALUE
			maxLongNumber = maxLongNumber.add(BigInteger.ONE);
			
			if (prime(maxLongNumber)) {
				System.out.println(maxLongNumber);
				counter++;
			
			}

		}

	}

}
