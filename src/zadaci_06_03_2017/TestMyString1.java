package zadaci_06_03_2017;

class MyString1 {
	private char[] chars;

	MyString1(char[] chars) {
		this.chars = new char[chars.length];
		System.arraycopy(chars, 0, this.chars, 0, chars.length);
	}

	MyString1() {
	}

	public char charAt(int index) {
		return chars[index];
	}

	public int length() {
		int counter = 0;
		for (int i = 0; i < chars.length; i++) {
			counter++;
		}
		return counter;
	}

	public MyString1 substring(int begin, int end) {
		char[] newChars = new char[end - begin];
		int k=0;
		for (int i = begin; i < end; i++) {
			newChars[k] = chars[i];
			k++;
		}
		return new MyString1(newChars);
	}

	public MyString1 toLowerCase() {
		char[] newChars = new char[chars.length];
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] >= 'A' && chars[i] <= 'Z') {
				newChars[i] = (char) (chars[i] + 32);
			}
			else{
				newChars[i] = chars[i];
			}
		}
		return new MyString1(newChars);
	}

	public static MyString1 valueOf(int i) {
		char[] temp = new char[50];
		int size = 0;
		while (i != 0) {
			int number = i % 10;
			i = i / 10;
			temp[size] = (char) (number + '0');
			size++;
		}

		char[] temp2 = new char[size];
		for (int k = size - 1; k >= 0; k--) {
			temp2[k] = temp[size - k - 1];
		}
		return new MyString1(temp2);

	}

	public boolean equals(MyString1 s) {
		if (s.length() != chars.length) {
			return false;
		} else {
			for (int i = 0; i < chars.length; i++) {
				if (s.getChars()[i] != chars[i]) {
					return false;
				}
			}
		}
		return true;
	}

	public char[] getChars() {
		return chars;
	}

}

public class TestMyString1 {

	public static void main(String[] args) {

		MyString1 s = new MyString1(new char[] { 'm', 'D', 'K', 'f','f','R','g' });
		System.out.println("Metoda length():");
		System.out.println(s.length());
		System.out.println("Metoda charAt(int index):");
		System.out.println(s.charAt(1));
		System.out.println("Metoda equals(MyString1 s):");
		System.out.println(s.equals(new MyString1(new char[] { 'm', 'd', 'h', 'g' })));
		System.out.println("Metoda toLowerCase():");
		MyString1 s1 = s.toLowerCase();
		for (int i = 0; i <s1.getChars().length; i++) {
			System.out.print(s1.getChars()[i]);
		}
		System.out.println();
		System.out.println("Metoda substring(int begin, int end):");
		for (int i = 0; i <s1.substring(2,4).length(); i++) {
			System.out.print((s1.substring(2,4)).getChars()[i]);
		}
		System.out.println();
		System.out.println("Metoda valueOf(int num):");
		char[] chars = MyString1.valueOf(12345).getChars();
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i]);
		}

	}

}
