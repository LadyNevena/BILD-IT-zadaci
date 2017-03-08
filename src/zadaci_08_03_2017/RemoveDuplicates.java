package zadaci_08_03_2017;

import java.util.Scanner;

public class RemoveDuplicates {
	public static void removeDuplicates(java.util.ArrayList<Integer> numbers) {
		for (int k = 0; k < numbers.size() - 1; k++) {
			for (int i = k + 1; i < numbers.size(); i++) {
				if (numbers.get(k).equals(numbers.get(i))) {
					numbers.remove(i);
					i--;
				}
			}
		}

		for (int i = 0; i < numbers.size(); i++) {
			System.out.print(numbers.get(i) + " ");
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		java.util.ArrayList<Integer> numbers = new java.util.ArrayList<>();
		System.out.println("Enter 10 numbers: ");
		for (int i = 0; i < 10; i++) {
			while (true) {
				try {
					numbers.add(in.nextInt());
					break;
				} catch (Exception e) {
					System.out.println("Enter again.");
					in.nextLine();
				}
			}
		}
		removeDuplicates(numbers);
		in.close();
	}

}
