package zadaci_06_03_2017;

class MyCharacter {
	private char value;

	public MyCharacter(char value) {
		this.value = value;
	}

	public char charValue() {
		return value;
	}

	public int compareTo(MyCharacter anotherCharacter) {
		return value - anotherCharacter.value;
	}

	public boolean equals(MyCharacter anotherCharacter) {
		return value == anotherCharacter.value;
	}

	public boolean isDigit() {
		return isDigit(value);
	}

	public static boolean isDigit(char ch) {
		return ch <= '9' && ch >= '0';
	}

	public static boolean isLetter(char ch) {
		return (ch <= 'z' && ch >= 'a') || (ch <= 'Z' && ch >= 'A');
	}

	public static boolean isLetterOrDigit(char ch) {
		return isLetter(ch) || isDigit(ch);
	}

	public static boolean isLowerCase(char ch) {
		return (ch <= 'z' && ch >= 'a');
	}

	public static boolean isUpperCase(char ch) {
		return (ch <= 'Z' && ch >= 'A');
	}

	public static char toUpperCase(char ch) {
		if (isLowerCase(ch))
			return (char) (ch - 'a' + 'A');
		else
			return ch;
	}

	public static char toLowerCase(char ch) {
		if (isUpperCase(ch))
			return (char) (ch - 'A' + 'a');
		else
			return ch;
	}
}

public class TestMyCharacter {
	public static void main(String[] args) {
		MyCharacter c = new MyCharacter('A');
		MyCharacter b = new MyCharacter('c');
		System.out.println("Da li je cifra?");
		System.out.println(c.isDigit());
		System.out.println("Da li je broj ili cifra?");
		System.out.println(MyCharacter.isLetterOrDigit('G'));
		System.out.println("U malo slovo:");
		System.out.println(MyCharacter.toLowerCase('C'));
		System.out.println("U veliko slovo:");
		System.out.println(MyCharacter.toUpperCase('b'));
		System.out.println("Jednaki karakteri? ");
		System.out.println(c.equals(c));
		System.out.println("compareTo() metod:");
		System.out.println(c.compareTo(b));
	}
}
