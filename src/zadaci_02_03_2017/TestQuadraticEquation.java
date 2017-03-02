package zadaci_02_03_2017;

class QuadraticEquation {
	private double a;
	private double b;
	private double c;

	QuadraticEquation() {
	}

	QuadraticEquation(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

	public double getDiscriminant() {
		return b * b - 4 * a * c;
	}

	public double getRoot1() {
		double d = b * b - 4 * a * c;
		if (d >= 0) {
			return ((-1) * b + Math.sqrt(d)) / (2 * a);
		} else {
			return 0;
		}
	}

	public double getRoot2() {
		double d = b * b - 4 * a * c;
		if (d >= 0) {
			return ((-1) * b - Math.sqrt(d)) / (2 * a);
		} else {
			return 0;
		}
	}
}

public class TestQuadraticEquation {

	public static void main(String[] args) {
		QuadraticEquation qe1 = new QuadraticEquation(2, 5, 1);
		System.out.println("x1=" + qe1.getRoot1() + " x2=" + qe1.getRoot2());
		
		//if determinant is less than 0 we don't have real solutions
		//only imaginary roots, so we return 0
		QuadraticEquation qe2 = new QuadraticEquation(2, 1, 1);
		System.out.println("x1=" + qe2.getRoot1() + " x2=" + qe2.getRoot2());
	}

}
