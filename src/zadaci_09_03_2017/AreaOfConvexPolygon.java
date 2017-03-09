package zadaci_09_03_2017;

import java.util.ArrayList;
import java.util.Scanner;

public class AreaOfConvexPolygon {
	public static double getConvexPolygonArea(ArrayList<MyPoint> points) {

		double sum1 = 0;
		double sum2 = 0;
		for (int i = 0; i < points.size() - 1; i++) {
			MyPoint p1 = points.get(i);
			MyPoint p2 = points.get(i + 1);
			sum1 += (p1.x * p2.y);
			sum2 += (p1.y * p2.x);
		}

		sum1 += points.get(points.size() - 1).x * points.get(0).y;
		sum2 += points.get(points.size() - 1).y * points.get(0).x;

		double area = 0.5 * (sum1 - sum2);
		return Math.abs(area);
	}

	public static double enterPoint(Scanner input) {
		double coordinate = 0;
		while (true) {
			try {
				coordinate = input.nextDouble();
				break;
			} catch (Exception e) {
				System.out.println("Try again.");
				input.nextLine();
			}
		}
		return coordinate;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of the points: ");
		int numOfPoints = 0;
		while (true) {
			try {
				numOfPoints = input.nextInt();
				if (numOfPoints < 0) {
					throw new Exception("negative");
				}
				break;
			} catch (Exception e) {
				System.out.println("Try again.");
				input.nextLine();
			}
		}
		System.out.println("Enter the coordinates of the points: ");
		ArrayList<MyPoint> points = new ArrayList<>();
		for (int i = 0; i < numOfPoints; i++) {
			double x = enterPoint(input);
			double y = enterPoint(input);
			points.add(new MyPoint(x, y));
		}

		System.out.println("The total area is " + getConvexPolygonArea(points));
		input.close();
	}

}
