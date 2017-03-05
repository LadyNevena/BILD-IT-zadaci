package zadaci_04_03_2017;

import java.math.BigDecimal;

/*
 * Find the first ten numbers with 50 decimal digits that are
 * divisible by 2 or 3.
 * */
public class Zad1 {

	public static void main(String[] args) {
		String number = "1";
		for (int i = 0; i < 49; i++) {
			number += "0";
		}
		//pocetni broj sa 50 cifara
		BigDecimal numbers = new BigDecimal(number);
		int counter = 0;
		
		while (counter < 10) {
			//podjelimo ga sa 2 i sa 3
			BigDecimal rem2 = numbers.remainder(new BigDecimal("2"));
			BigDecimal rem3 = numbers.remainder(new BigDecimal("3"));
			
			//ako je ostatak bio 0 ispisemo broj i povecamo brojac
			if (rem2.equals(BigDecimal.ZERO) || rem3.equals(BigDecimal.ZERO)) {
				System.out.println(numbers);
				counter++;
			}
			//povecamo broj za 1 i ispitamo njega 
			numbers = numbers.add(BigDecimal.ONE);
		}

	}

}
