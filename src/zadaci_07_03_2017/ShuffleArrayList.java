package zadaci_07_03_2017;

import java.util.ArrayList;

public class ShuffleArrayList {
	public static void shuffle(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			int index1 = (int) (Math.random() * list.size());
			int index2 = (int) (Math.random() * list.size());
			int temp = list.get(index1);
			list.set(index1, list.get(index2));
			list.set(index2, temp);
		}

	}

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		shuffle(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
