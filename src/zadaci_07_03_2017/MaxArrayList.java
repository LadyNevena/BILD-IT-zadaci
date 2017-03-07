package zadaci_07_03_2017;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxArrayList {
	public static Integer max(ArrayList<Integer> list) {
		if (list == null || list.size() == 0)
			return null;

		int result = list.get(0);
		for (int i = 1; i < list.size(); i++)
			if (result < list.get(i))
				result = list.get(i);

		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();

		System.out.println("Enter integers (input ends with 0): ");
		int value;

		do {
			while (true) {
				try {
					value = in.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Try again.");
					in.nextLine();
				}
			}
			if (value != 0)
				list.add(value);
		} while (value != 0);

		System.out.print("The maximum number is " + max(list));

		in.close();
	}

}
