package zadaci_07_03_2017;

public class Circle{
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return radius * radius * Math.PI;
	}
	

	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}
	@Override
	public String toString(){
		return "Circle object with radius = "+radius;
	}
}