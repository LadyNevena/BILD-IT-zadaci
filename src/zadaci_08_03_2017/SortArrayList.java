package zadaci_08_03_2017;

import java.util.Scanner;

public class SortArrayList {
	public static void sort(java.util.ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 1; j < list.size() - i; j++) {
				if (list.get(j) < list.get(j - 1)) {
					int temp = list.get(j);
					list.set(j, list.get(j - 1));
					list.set(j - 1, temp);
				}
			}
		}
	}

	public static void main(String[] Args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 5 numbers:");
		java.util.ArrayList<Integer> list = new java.util.ArrayList<>();

		for (int i = 0; i < 5; i++) {
			while (true) {
				try {
					list.add(in.nextInt());
					break;
				} catch (Exception e) {
					System.out.println("Enter again.");
					in.nextLine();
				}
			}
		}
		sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		in.close();
	}
}
