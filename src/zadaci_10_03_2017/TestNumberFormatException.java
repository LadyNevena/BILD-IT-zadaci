package zadaci_10_03_2017;

public class TestNumberFormatException {
	public static int bin2Dec(String binary) throws NumberFormatException {

		if (!isBinary(binary)) {
			throw new NumberFormatException(binary + " is not a binary number.");
		}
		int power = 0;
		int decimal = 0;
		for (int i = binary.length() - 1; i >= 0; i--) {

			if (binary.charAt(i) == '1') {
				decimal += Math.pow(2, power);
			}
			power++;
		}
		return decimal;
	}

	public static boolean isBinary(String binary) {

		for (char ch : binary.toCharArray()) {
			if (ch != '1' && ch != '0')
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int dec1=0;
		int dec2=0;
		try {
			dec1 = bin2Dec("1000111");
			System.out.println(dec1);
		} catch (NumberFormatException e) {
			e.getMessage();
		}
		
		try {
			dec2 = bin2Dec("1111b010101");
			System.out.println(dec2);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	
	}

}
