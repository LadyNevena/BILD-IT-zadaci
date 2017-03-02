package zadaci_02_03_2017;

class Fan {

	private final int SLOW = 1;
	private final int MEDIUM = 2;
	private final int FAST = 3;
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	private String color = "blue";

	Fan() {
	}

	public void setSpeed(int speed) {
		if (this.on == true && this.speed == SLOW || this.speed == MEDIUM ||this.speed == FAST) {
			this.speed = speed;
		} else {
			System.out.println("Fan is off or invalid speed.");
		}
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public boolean getOn() {
		return this.on;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return this.radius;
	}

	public String toString() {
		if (this.on == true) {
			return "Color: " + this.getColor() + "\n" + "Radius: "
					+ this.getRadius() + "\n" + "Speed:" + this.getSpeed();
		}
		return "Fan is off.\nColor: " + this.getColor() + "\n" + "Radius: "
				+ this.getRadius();

	}

}

public class TestFan {

	public static void main(String[] args) {
		Fan f1 = new Fan();
		System.out.println("Fan1:");
		f1.setOn(true);
		f1.setRadius(10);
		f1.setColor("yellow");
		f1.setSpeed(3);
		System.out.println(f1.toString());
		
		System.out.println("Fan2:");
		Fan f2 = new Fan();
		f2.setOn(false);
		f2.setRadius(5);
		f2.setColor("blue");
		f2.setSpeed(2);
		System.out.println(f2.toString());
	}

}
