package zadaci_21_02_2017;
/*
 *  Palindrome prime je prosti broj koji je takoðer i palindrom.
 *  Na primjer, 131 je palindrome prime, kao i brojevi 313 i 757.
 *  Napisati program koji ispisuje prvih 100 palindrome prime brojeva,
 *  10 brojeva po liniji. 
 * 
 * */
public class Zad4 {
	//provjeravamo da li je prost
		public static boolean isPrime(int num) {
			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0) {
					return false;
				}
			}
			return true;
		}
		//obrnemo broj
		public static int reverse(int num) {
			int revNum = 0;
			while (num != 0) {
				int digit = num % 10;
				revNum = revNum * 10 + digit;
				num /= 10;
			}
			return revNum;
		}
		//provjera da li je broj palindrom
		public static boolean isPrimePalindrome(int num) {
			if (reverse(num) == num){
				if(isPrime(num)){
					return true;
				}
			}
			return false;
		}
	public static void main(String[] args) {
		int counter = 0;
		int i = 2;
		//ispis prvih 100 prime palindromes
		while (counter < 100) {
			if (isPrimePalindrome(i)) {
				System.out.print(i + " ");
				counter++;

				if (counter % 10 == 0) {
					System.out.println();
				}
			}
			i++;
		}


	}

}
