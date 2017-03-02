package zadaci_02_03_2017;


class RegularPolygon {
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;

	RegularPolygon() {
	}

	RegularPolygon(int n, double side) {
		this.n = n;
		this.side = side;
		this.x = 0;
		this.y = 0;
	}

	RegularPolygon(int n, double side, double x, double y) {
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}

	public void setN(int n) {
		this.n = n;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getN() {
		return n;
	}

	public double getSide() {
		return side;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getPerimeter() {
		double perimeter = 0;
		for (int i = 0; i < n; i++) {
			perimeter += side;
		}
		return perimeter;
	}

	public double getArea() {
		return (n * side * side) / (4 * Math.tan(Math.PI / n));
	}

}

public class TestRegularPoligon {

	public static void main(String[] args) {
		RegularPolygon rp1 = new RegularPolygon();
		RegularPolygon rp2 = new RegularPolygon(6, 4);
		RegularPolygon rp3 = new RegularPolygon(10, 4, 5.6, 7.8);
		System.out.println("Perimeter:\tArea:");
		System.out.println(rp1.getPerimeter() + "\t\t" + rp1.getArea());
		System.out.println(rp2.getPerimeter() + "\t\t" + rp2.getArea());
		System.out.println(rp3.getPerimeter() + "\t\t" + rp3.getArea());

	}

}
