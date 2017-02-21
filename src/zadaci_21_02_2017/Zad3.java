package zadaci_21_02_2017;
/*
 * Emirp brojevi (prime unazad) je nepalindromski prosti broj koji
 * je prosti broj i kada ispišemo naopako.
 * Na primjer, broj 17 i broj 71 su prosti brojevi tako da su brojevi i
 * 17 i 71 emirp brojevi.
 * Napisati program koji ispisuje prvih 100 emirp brojeva,
 * 10 brojeva po liniji. 
 * 
 * */
public class Zad3 {
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
	public static boolean isPalindrome(int num) {
		if (reverse(num) == num)
			return true;
		else
			return false;
	}
	//ne smije biti palindrom i mora biti prost i njegov reverse isto prost
	public static boolean isEmirp(int num) {
		if (!isPalindrome(num) && isPrime(num) && isPrime(reverse(num))) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		int counter = 0;
		int i = 2;
		//ispis prvi 100 Emirp brojeva
		while (counter < 100) {
			if (isEmirp(i)) {
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
