package zadaci_06_03_2017;


class MyString2 {
	private String string;

	MyString2(String string) {
		this.string = string;
	}


	public int compare(String s) {
		String temp;
		if (string.length() < s.length()) {
			temp = string;
		} else {
			temp = s;
		}
		for (int i = 0; i < temp.length(); i++) {
			if (string.charAt(i) < s.charAt(i)) {
				return -1;
			}
			if (string.charAt(i) > s.charAt(i)) {
				return 1;
			}
		}
		return 0;
	}

	public MyString2 substring(int begin) {
		MyString2 temp = new MyString2("");
		for (int i = begin; i < string.length(); i++) {
			temp.string += string.charAt(i);
		}
		return temp;
	}

	public MyString2 toUpperCase() {
		MyString2 temp = new MyString2("");
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
				temp.string += (char) (string.charAt(i) - 32);
			} else {
				temp.string += string.charAt(i);
			}
		}
		return temp;
	}

	public char[] toChars() {
		char[] c = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			c[i] = string.charAt(i);
		}
		return c;
	}

	public  static MyString2 valueOf(boolean b) {
		if (b == true) {
			return new MyString2("true");
		} else {
			return new MyString2("false");
		}
	}

	public String getString() {
		return string;
	}

}

public class TestMyString2 {

	public static void main(String[] args) {
		MyString2 s = new MyString2("Java");
		System.out.println(s.getString()+".compareTo("+"Jbva"+") = "+s.compare("Jbva"));
		System.out.println(s.getString()+".substring(1) = "+s.substring(1).getString());
		System.out.println(s.getString()+".toUpperCase() = "+s.toUpperCase().getString());
		System.out.print("[");
		for (int i = 0; i < (s.toChars()).length; i++) {
			if (i == (s.toChars()).length - 1) {
				System.out.print("'" + s.toChars()[i] + "'");
				break;
			}
			System.out.print("'" + s.toChars()[i] + "'" + ",");
		}
		System.out.println("]");
		System.out.println(s.getString()+".valueOf(true) = "+MyString2.valueOf(true).getString());
		
	}

}