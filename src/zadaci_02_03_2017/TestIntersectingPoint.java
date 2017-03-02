package zadaci_02_03_2017;

import java.util.Scanner;

class IntersectingPoint {
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	private double x3;
	private double y3;
	private double x4;
	private double y4;

	IntersectingPoint() {
	}

	IntersectingPoint(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.x4 = x4;
		this.y4 = y4;
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	public double getX3() {
		return x3;
	}

	public void setX3(double x3) {
		this.x3 = x3;
	}

	public double getY3() {
		return y3;
	}

	public void setY3(double y3) {
		this.y3 = y3;
	}

	public double getX4() {
		return x4;
	}

	public void setX4(double x4) {
		this.x4 = x4;
	}

	public double getY4() {
		return y4;
	}

	public void setY4(double y4) {
		this.y4 = y4;
	}

	public double getX() {
		double determinantX = -(x1 - x2) * ((y3 - y4) * x3 - (x3 - x4) * y3)
				+ (x3 - x4) * ((y1 - y2) * x1 - (x1 - x2) * y1);
		double determinant = -(y1 - y2) * (x3 - x4) + (x1 - x2) * (y3 - y4);
		double x = determinantX / determinant;
		if (determinant != 0) {
			return x;
		} else {
			System.out.println("Not solvable!");
			return 0;
		}
	}

	public double getY() {
		double determinantY = -(y1 - y2) * ((y3 - y4) * x3 - (x3 - x4) * y3)
				+ (y3 - y4) * ((y1 - y2) * x1 - (x1 - x2) * y1);
		double determinant = -(y1 - y2) * (x3 - x4) + (x1 - x2) * (y3 - y4);
		double y = determinantY / determinant;
		if (determinant != 0) {
			return y;
		} else {
			System.out.println("Not solvable!");
			return 0;
		}
	}

}

public class TestIntersectingPoint {
	public static double enterNumber(Scanner in) {
		double n = 0;
		while (true) {
			try {
				System.out.println("Enter coordinate:");
				n = in.nextDouble();
				break;
			} catch (Exception e) {
				System.out.println("You didn't enter number.");
				in.nextLine();
			}
		}

		return n;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter (x1,y1) (x2,y2) (x3,y3) (x4,y4):");
		double x1 = enterNumber(in);
		double y1 = enterNumber(in);
		double x2 = enterNumber(in);
		double y2 = enterNumber(in);
		double x3 = enterNumber(in);
		double y3 = enterNumber(in);
		double x4 = enterNumber(in);
		double y4 = enterNumber(in);
		// recimo ako se unesu tacke 5 4 3 2 1 6 7 8 dobije se presjecna tacka
		// ako je determinanta manja od 0 nece biti rjesenja tj prave su
		// paralelne
		IntersectingPoint ip1 = new IntersectingPoint(x1, y1, x2, y2, x3, y3, x4, y4);
		if (ip1.getX() == 0 || ip1.getY() == 0) {
			System.out.println("The linear equation has no solutions.");
		} else {
			System.out.printf("Intersecting point : x=%.3f y=%.3f", ip1.getX(), ip1.getY());
		}
		in.close();

	}

}
