package zadaci_07_03_2017;

import java.util.Scanner;

class Triangle extends GeometricObject {

	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;

	Triangle(double side1, double side2, double side3) {
		setSide1(side1);
		setSide2(side2);
		setSide3(side3);
	}

	Triangle() {
	}

	public double getPerimeter() {
		return side1 + side2 + side3;
	}

	public double getArea() {
		double s = getPerimeter() / 2.0;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}

	public String toString() {
		return "Side1: " + getSide1() + " Side2: " + getSide2() + " Side3: " + getSide3();
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}

}

public class TestTriangle {
	public static double enterDouble(Scanner in) {
		double side = 0;
		while (true) {
			try {
				System.out.println("Enter side:");
				side = in.nextDouble();
				if (side < 0) {
					throw new Exception("negative");
				}
				break;
			} catch (Exception e) {
				System.out.println("Try again.");
				in.nextLine();
			}
		}
		return side;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double side1 = enterDouble(in);
		double side2 = enterDouble(in);
		double side3 = enterDouble(in);
		Triangle t = new Triangle(side1, side2, side3);
		in.nextLine();
		System.out.println("Enter color:");
		String color = in.nextLine();
		System.out.println("Enter boolean value to indicate  whether the triangle is filled:");
		boolean filled = false;
		while (true) {
			try {
				filled = in.nextBoolean();
				break;
			} catch (Exception e) {
				System.out.println("Try again.");
				in.nextLine();
			}
		}
		t.setFilled(filled);
		t.setColor(color);
		System.out.println(t.toString());
		System.out.println("Perimeter:" + t.getPerimeter());
		System.out.println("Area:" + t.getArea());
		System.out.println("isFilled? " + t.getFilled());
		System.out.println("Color: " + t.getColor());
	}

}
