package zadaci_08_03_2017;

import java.util.ArrayList;
import java.util.Scanner;

public class UnionArrayLists {
	public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		for (int i = 0; i < list2.size(); i++) {
			list1.add(list2.get(i));
		}
		return list1;
	}

	public static ArrayList<Integer> enterList(Scanner in) {
		ArrayList<Integer> numbers = new java.util.ArrayList<>();
		System.out.println("Enter 5 numbers: ");
		for (int i = 0; i < 5; i++) {
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
		return numbers;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list1 = enterList(in);
		ArrayList<Integer> list2 = enterList(in);
		ArrayList<Integer> union = union(list1,list2);
		System.out.println("Union:");
		for (int i = 0; i < union.size(); i++) {
			System.out.println(union.get(i));
		}

		in.close();

	}

}
