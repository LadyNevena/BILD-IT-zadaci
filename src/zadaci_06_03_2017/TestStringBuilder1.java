package zadaci_06_03_2017;

class MyStringBuilder1 {
	String string;

	MyStringBuilder1(String string) {
		this.string = string;
	}

	public MyStringBuilder1 append(MyStringBuilder1 s) {
		return new MyStringBuilder1(string + "" + s.toString());
	}

	public MyStringBuilder1 append(int i) {
		return new MyStringBuilder1(string + "" + i);
	}

	public int length() {
		return string.length();
	}

	public char charAt(int i) {
		return string.charAt(i);
	}

	public String toString() {
		return string;
	}

	public MyStringBuilder1 toLowerCase() {
		MyStringBuilder1 temp = new MyStringBuilder1("");
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
				temp.string += "" + (char) (string.charAt(i) + 32);
			} else {
				temp.string += "" + string.charAt(i);
			}
		}
		return temp;
	}

	public MyStringBuilder1 substring(int begin, int end) {
		MyStringBuilder1 temp = new MyStringBuilder1("");
		for (int i = begin; i < end; i++) {
			temp.string += string.charAt(i);
		}
		return temp;
	}
	

}

public class TestStringBuilder1 {

	public static void main(String[] args) {
		MyStringBuilder1 string =new MyStringBuilder1("JAVA");
		MyStringBuilder1 string1 = new MyStringBuilder1("programiranje");
		System.out.println("string = \""+string.toString()+"\";");
		System.out.println("string1 = \""+string1.toString()+"\";");
		System.out.println();
		System.out.println("string.toString() = "+string.toString());
		System.out.println("string.append(string1) = "+string.append(string1));
		System.out.println("string.append(\"123\") = "+string.append(123));
		System.out.println("string.length() = "+string.length());
		System.out.println("string.charAt(2) = '"+string.charAt(2)+"'");
		System.out.println("string.toLowerCase() = "+string.toLowerCase().toString());
		System.out.println("string1.substring(2,7) = "+string1.substring(2, 7).toString());
		
	}

}
