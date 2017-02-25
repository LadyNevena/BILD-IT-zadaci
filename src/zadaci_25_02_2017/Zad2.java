package zadaci_25_02_2017;

/*
 * Write a method that returns a random number between
 * 1 and 54, excluding the numbers passed in the argument. 
 * */
public class Zad2 {
	public static int genNum() {
		return (int) (Math.random() * 54 + 1);
	}

	public static int getRandom(int... numbers) {
		int number = 0;
		boolean flag = true;
		while (true) {
			flag = true;
			number = genNum();
			for (int i = 0; i < numbers.length; i++) {
				if (number == numbers[i]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return number;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(getRandom(1,2,5,7,12,34,51));		
	}

}
