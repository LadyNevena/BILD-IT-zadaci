package zadaci_09_03_2017;

import java.util.Scanner;
import java.util.InputMismatchException;

public class TestInputMismatchException {

	public static int readInteger(Scanner in) {
		int num = 0;
		while (true) {
			try {
				num = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Try again.");
				in.nextLine();
			}
		}
		return num;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter first integer:");
		int num1 = readInteger(in);
		System.out.println("Enter second integer:");
		int num2 = readInteger(in);
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		in.close();
	}

}
