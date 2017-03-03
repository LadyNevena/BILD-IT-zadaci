package zadaci_03_03_2017;

class MyPoint {
	double x;
	double y;

	MyPoint(double x, double y) {
		setX(x);
		setY(y);
	}

	MyPoint() {
		this(0, 0);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double distance(double x1, double y1) {
		return Math.sqrt(Math.pow(this.x - x1, 2) + Math.pow(this.y - y1, 2));
	}

	public double distance(MyPoint mp) {
		return Math.sqrt(Math.pow(this.x - mp.getX(), 2)
				+ Math.pow(this.y - mp.getY(), 2));
	}

}

public class TestMyPoint {

	public static void main(String[] args) {
		MyPoint mp1 = new MyPoint(0, 0);
		MyPoint mp2 = new MyPoint(10, 30.5);
	//	System.out.println(mp1.distance(2, 5));
		System.out.println("distance( ("+mp1.getX()+","+mp1.getY()+") , ("+mp2.getX()+","+mp2.getY()+") ) = "+mp1.distance(mp2));
	}

}
