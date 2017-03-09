package zadaci_09_03_2017;

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
