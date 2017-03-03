package zadaci_03_03_2017;


class MyInteger {
	int value;

	MyInteger(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isEven() {
		if (value % 2 == 0) {
			return true;
		}
		return false;
	}

	public boolean isOdd() {
		if (value % 2 != 0) {
			return true;
		}
		return false;
	}

	public boolean isPrime() {
		for (int i = 2; i <= value / 2; i++) {
			if (value % i != 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEven(int value) {
		if (value % 2 == 0) {
			return true;
		}
		return false;
	}

	public static boolean isOdd(int value) {
		if (value % 2 != 0) {
			return true;
		}
		return false;
	}

	public static boolean isPrime(int value) {
		for (int i = 2; i <= value / 2; i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEven(MyInteger mi) {
		if (mi.getValue() % 2 == 0) {
			return true;
		}
		return false;
	}

	public static boolean isOdd(MyInteger mi) {
		if (mi.getValue() % 2 != 0) {
			return true;
		}
		return false;
	}

	public static boolean isPrime(MyInteger mi) {
		for (int i = 2; i <= mi.getValue() / 2; i++) {
			if (mi.getValue() % i == 0) {
				return false;
			}
		}
		return true;
	}

	public boolean equals(MyInteger mi) {
		if (mi.getValue() == this.value) {
			return true;
		}
		return false;
	}

	public boolean equals(int value) {
		if (this.value == value) {
			return true;
		}
		return false;
	}

	public int parseInt(char[] c) {
		String s = "";
		for (int i = 0; i < c.length; i++) {
			s += "" + c[i];
		}
		return Integer.parseInt(s);
	}

	public int parseInt(String s) {
		return Integer.parseInt(s);
	}
	
}

public class TestMyInteger {

	public static void main(String[] args) {
		MyInteger mi1 = new MyInteger(10);
		MyInteger mi2 = new MyInteger(15);
		System.out.println("Test class for number "+mi1.getValue());
		System.out.println("Even:" + mi1.isEven());
		System.out.println("Odd:" + mi1.isOdd());
		System.out.println("Prime:" + mi1.isPrime());
		System.out.println();
		System.out.println("Test class for number "+5);
		System.out.println("Even:" + MyInteger.isEven(5));
		System.out.println("Odd:" + MyInteger.isOdd(5));
		System.out.println("Prime:" + MyInteger.isPrime(5));
		System.out.println();
		System.out.println("Test class for number "+mi2.getValue());
		System.out.println("Even:" + MyInteger.isEven(mi2));
		System.out.println("Odd:" + MyInteger.isOdd(mi2));
		System.out.println("Prime:" + MyInteger.isPrime(mi2));
		System.out.println();
		System.out.println(""+mi1.getValue()+".equals(10):"+mi1.equals(10));
		System.out.println(""+mi1.getValue()+".equals("+mi2.getValue()+"): "+mi1.equals(mi2));
		System.out.println();
		char[] c = { '1', '2', '3' };
		String s = "12345";
		//int value
		System.out.println("char[] to int value: "+mi1.parseInt(c));
		//int value 
		System.out.println("String to int value: "+mi1.parseInt(s));

	}

}
