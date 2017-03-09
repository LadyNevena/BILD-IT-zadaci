package zadaci_09_03_2017;

import java.util.Scanner;

public class TheSmallestPerfectSquare {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter an integer:");
		int m = 0;
		while (true) {
			try {
				m = in.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Try again.");
				in.nextLine();
			}
		}
		boolean negative = false;
		if (m < 0) {
			negative = true;
		}
		for (int n = 1;; n++) {
			double sqrt = Math.sqrt(Math.abs(m) * n);
			int sqrt1 = (int)Math.sqrt(Math.abs(m) * n);
			if ( Math.pow(sqrt, 2)== Math.pow(sqrt1, 2)) {
				if(negative){
					System.out.println("The smallest number n such that m*n is a perfect square is "+(-1*n));
				}
				else{
					System.out.println("The smallest number n such that m*n is a perfect square is "+n);
				}
				break;
			}
		}
		in.close();
	}

}
