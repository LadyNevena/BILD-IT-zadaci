package bonus_04_03_2017;

public class BrailleCoder implements Coder {
	private String[] braille = { "1", "13", "12", "124", "14", "123", "1234", "134", "23", "234", "15", "135", "125",
			"1245", "145", "1235", "12345", "1345", "235", "2345", "156", "1356", "2346", "1256", "12456", "1456"};
	private String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
			"r", "s", "t", "u", "v", "w", "x", "y", "z"};

	@Override
	public String encode(String code) {
		String encoded = "";
		for (int i = 0; i < code.length(); i++) {
			for (int j = 0; j < alphabet.length; j++) {
				if (("" + code.charAt(i)).equals(alphabet[j])) {
					encoded += braille[j] + " ";
				}
			}
		}
		return encoded;
	}

	@Override
	public String decode(String code) {
		String[] words = code.split(" ");
		String decoded = "";
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < braille.length; j++) {
				if (words[i].equals(braille[j])) {
					decoded += alphabet[j];
				}
			}
		}

		return decoded;
	}

}
