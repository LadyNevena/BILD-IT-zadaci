package zadaci_08_03_2017;

import java.util.ArrayList;
import java.util.Scanner;

public class SumArrayList {
	public static double sum(ArrayList<Double> list){
		double sum=0;
		for (int i = 0; i < list.size(); i++) {
			sum+=list.get(i);
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 5 numbers:");
		java.util.ArrayList<Double> list = new java.util.ArrayList<>();

		for (int i = 0; i < 5; i++) {
			while (true) {
				try {
					list.add(in.nextDouble());
					break;
				} catch (Exception e) {
					System.out.println("Enter again.");
					in.nextLine();
				}
			}
		}
		System.out.println("Sum of elements: "+sum(list));
		
		in.close();
		

	}

}
