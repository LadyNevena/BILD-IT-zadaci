package zadaci_02_03_2017;



class LinearEquations {

	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;

	LinearEquations() {
	}

	LinearEquations(double a, double b, double c, double d, double e, double f) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = d;
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

	public double getD() {
		return d;
	}

	public double getE() {
		return e;
	}

	public double getF() {
		return f;
	}

	public boolean isSolvable() {
		if (a * d - b * c != 0) {
			return true;
		}
		return false;
	}

	public double getX() {

		return (e * d - b * f) / (a * d - b * c);
	}

	public double getY() {

		return (a * f - e * c) / (a * d - b * c);
	}

}

public class TestLinearEquation {

	public static void main(String[] args) {
		LinearEquations le1 = new LinearEquations(1, 2, 3, 4, 5, 6);
		if (le1.isSolvable()) {
			System.out.println("x=" + le1.getX() + " y=" + le1.getY());
		} else {
			System.out.println("The equation has no solution.");

		}

	}

}
