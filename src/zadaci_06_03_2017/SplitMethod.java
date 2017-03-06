package zadaci_06_03_2017;

public class SplitMethod {

	public static String[] split(String string, String s) {

		java.util.ArrayList<String> result = new java.util.ArrayList<>();
		int k = 0;
		int start = 0;
		if (s.charAt(0) == '[' && s.charAt(s.length() - 1) == ']') {
			s = s.substring(1, s.length());
			
			for (int i = 0; i < string.length(); i++)
				if (s.indexOf(string.charAt(i)) != -1) {
					if (start < i)
						result.add(string.substring(start, i));
					result.add(string.substring(i, i + 1));
					start = i + 1;
				}
			if (start < string.length()){
				result.add(string.substring(start));
			}
		} else {
			start = 0;
			k = 0;
			while (string.indexOf(s) != -1) {
				k = string.indexOf(s);
				result.add(string.substring(start, k));
				result.add(string.substring(k, k + s.length()));
				string = string.substring(k + s.length(), string.length());
				start = 0;
			}
			if (!string.equals(""))
				result.add(string);
		}
		String[] splitted = new String[result.size()];
		for (int i = 0; i < splitted.length; i++) {
			splitted[i] = result.get(i);
		}

		return splitted;
	}

	public static boolean contains(char c, String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("Implementacija metode split.");
		System.out.println("Ispisuje i znakove u odnosu na koje splituje.");
		System.out.println();
		String s = "a?b?#gf?#FE#?##?#";
		System.out.println("String s = \""+s+"\";");
		System.out.println();
		// split metoda i ispisuje one znakove u odnosu na koje splituje
		System.out.println("s.split(\"[?#]\")");
		for (int i = 0; i < split(s, "[?#]").length; i++) {
			System.out.println(split(s, "[?#]")[i]);
		}
		System.out.println();
		System.out.println("s.split(\"?#\")");
		for (int i = 0; i < split(s, "?#").length; i++) {
			System.out.println(split(s, "?#")[i]);
		}

	}

}
