package zadaci_08_02_2017;


public class Zad1 {
	public static Integer max(java.util.ArrayList<Integer> list) {
		Integer max = null;
		if (list.size() != 0) {
			max = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i) > max) {
					max = list.get(i);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		java.util.ArrayList<Integer> list1 = new java.util.ArrayList<>();
		java.util.ArrayList<Integer> list2 = new java.util.ArrayList<>();
		list1.add(5);
		list1.add(23);
		list1.add(1);
		list1.add(5);
		list1.add(19);
		//testiranje funkcije max na listama list1 i list2
		System.out.println(max(list1));
		System.out.println(max(list2));
		

	}

}
