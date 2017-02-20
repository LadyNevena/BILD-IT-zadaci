package CrapsAndCreditCardMini2;

public class Craps {
	public static int rollTheDice() {
		return (int) (Math.random() * 6 + 1);
	}

	public static void playCraps() {
		int num1 = rollTheDice();
		int num2 = rollTheDice();
		int sum = num1 + num2;
		int sum2 = 0;
		if (sum == 7 || sum == 11) {
			System.out.println("You rolled " + num1 + "+" + num2 + "=" + sum);
			System.out.println("You win!");
		} else if (sum == 2 || sum == 3 || sum == 12) {
			System.out.println("You rolled " + num1 + "+" + num2 + "=" + sum);
			System.out.println("You lose!");
		} else {
			System.out.println("You rolled " + num1 + "+" + num2 + "=" + sum);
			System.out.println("Point is " + sum);
			while (sum != sum2 && sum2 != 7) {
				num1 = rollTheDice();
				num2 = rollTheDice();
				sum2 = num1 + num2;
				if (sum2 == 7) {
					System.out.println("You rolled " + num1 + "+" + num2 + "=" + sum2);
					System.out.println("You lose!");
					break;
				}
				if (sum == sum2) {
					System.out.println("You rolled " + num1 + "+" + num2 + "=" + sum2);
					System.out.println("You win!");
					break;
				}
				System.out.println("You rolled " + num1 + "+" + num2 + "=" + sum2);

			}
		}

	}

	public static void main(String[] args) {
		playCraps();
	}

}
