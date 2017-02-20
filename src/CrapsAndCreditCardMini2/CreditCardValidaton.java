package CrapsAndCreditCardMini2;

import java.util.Scanner;

public class CreditCardValidaton {
	/** Return true if the card number is valid */
	
	 public static boolean isValid(long number) {
		 if( prefixMatched(number) && (sumOfDoubleEvenPlace(number)+sumOfOddPlace(number))%10==0){
			 return true;
		 }
		 return false;
	 }
	

	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		int sum = 0;
		int even = 1;
		while (number != 0) {
			int digit = (int) (number % 10);
			if (even % 2 == 0) {
				digit *= 2;
				sum += getDigit(digit);
			}
			number /= 10;
			even++;
		}
		return sum;
	}

	/**
	 * Return this number if it is a single digit, otherwise, return the sum of
	 * the two digits
	 */
	public static int getDigit(int number) {
		int sum = 0;
		while (number != 0) {
			int digit = number % 10;
			sum += digit;
			number /= 10;
		}
		return sum;
	}

	/** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(long number) {
		int sum = 0;
		int odd = 1;
		while (number != 0) {
			int digit = (int) (number % 10);
			if (odd % 2 != 0) {
				sum += digit;
			}
			number /= 10;
			odd++;
		}
		return sum;
	}

	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number) {
		if(getPrefix(number,1)==4 ||getPrefix(number,1)==5 ||getPrefix(number,1)==6 || getPrefix(number,2)==37  ){
			return true;
		}
		return false;
	}


	/**
	 * Return the first k number of digits from number. If the number of digits
	 * in number is less than k, return number.
	 *
	 */
	public static long getPrefix(long number, int k) {
		long newNumber = 0;
		if (numOfDigits(number) < k) {
			return number;
		} else {
			while (number != 0) {
				if (numOfDigits(number) == k) {
					newNumber = number;
					break;
				}
				number /= 10;
			}
		}
		return newNumber;
	}
	/*number of digits*/
	public static int numOfDigits(long number) {
		int digits = 0;
		while (number != 0) {
			digits++;
			number /= 10;
		}
		return digits;
	}
	/*valid input*/
	public static boolean validInput(long number) throws Exception{
		if(number<0 || (numOfDigits(number)<13 || numOfDigits(number)>16)){
			throw new Exception("ERR");
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long number = 0;
		while(true){
			try{
				System.out.println("Enter a credit card number as long integer:");
				number = in.nextLong();
				validInput(number);
				break;
			}catch(Exception e){
				System.out.println("Credit card number must have between 13 and 16 digits.\nAnd must be non-negative.");
				in.nextLine();
			}
		}
		if (isValid(number)) {
			System.out.println(number+" is valid.");
			
		}else{
			System.out.println(number+" is invalid.");
		}
		in.close();
	}
}
