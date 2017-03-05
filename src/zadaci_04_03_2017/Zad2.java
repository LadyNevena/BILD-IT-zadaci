package zadaci_04_03_2017;

import java.math.BigInteger;

/*
 * (Square numbers) Find the first ten square numbers that are greater than
 * Long.MAX_VALUE. A square number is a number in the form of n^2. For example,
 * 4, 9, and 16 are square numbers. Find an efficient approach to run your
 * program fast.
 * 
 * */
public class Zad2 {
	
	/*
	 * eto proradilo nakon duze mukotrpne borbe
	 * 
	 * */
	public static void main(String[] args) {
		
		BigInteger maxLongNumber = new BigInteger(String.valueOf(Long.MAX_VALUE));
		
		//korijen od Long.MAX_VALUE zaokruzim na gornji cio dio
		long sqrt = (long) Math.ceil(Math.sqrt(Long.MAX_VALUE));
		
		//znaci imam cio ogroman broj
		BigInteger squared = new BigInteger(sqrt + "");

		int counter = 0;
		while (counter < 10) {
			
			//ispisem 10 kvadrata tih brojeva
			if (squared.multiply(squared).compareTo(maxLongNumber) > 0) {
				System.out.println(squared.multiply(squared));
				counter++;
			}
			//svaki sljedeci je veci za 1
			squared = squared.add(BigInteger.ONE);
		}

	}

}
