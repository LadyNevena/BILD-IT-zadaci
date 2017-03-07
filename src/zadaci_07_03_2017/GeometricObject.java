package zadaci_07_03_2017;

public class GeometricObject {
	private String color = " white";
	private boolean filled = false;
	private java.util.Date dateCreated;

	public GeometricObject() {
		dateCreated = new java.util.Date();
	}

	public GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;

	}

	public boolean getFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;

	}

	public java.util.Date getDate() {
		return dateCreated;
	}
}
