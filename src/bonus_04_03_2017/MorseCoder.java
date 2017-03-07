package bonus_04_03_2017;

public class MorseCoder implements Coder {
	private String[] morse = { "._", "_...", "_._.", "_..", ".", ".._.", "__.", "....", "..", ".___", "_._", "._..",
			"__", "_.", "___", ".__.", "__._", "._.", "...", "_", ".._", "..._", ".__", "_.._", "_..__", "__..",
			".____", "..___", "...__", "...._", ".....", "_....", "__...", "___..", "____.", "_____" };
	private String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
			"r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };

	@Override
	public String encode(String code) {
		String encoded = "";
		for (int i = 0; i < code.length(); i++) {
			for (int j = 0; j < alphabet.length; j++) {
				if (("" + code.charAt(i)).equals(alphabet[j])) {
					encoded += morse[j] + " ";
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
			for (int j = 0; j < morse.length; j++) {
				if (words[i].equals(morse[j])) {
					decoded += alphabet[j];
				}
			}
		}
		return decoded;
	}

}
