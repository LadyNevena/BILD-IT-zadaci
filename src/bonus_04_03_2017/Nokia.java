package bonus_04_03_2017;

public class Nokia implements Phone {
	private String operatingSystem;
	private int verticalPixels;
	private int horisontalPixels;
	private double cameraMegaPixels;

	Nokia(String operatingSystem, int verticalPixels, int horisontalPixels, double cameraMegaPixels) {
		this.operatingSystem = operatingSystem;
		this.verticalPixels = verticalPixels;
		this.horisontalPixels = horisontalPixels;
		this.cameraMegaPixels = cameraMegaPixels;
	}

	@Override
	public void printInfo() {
		String info = "PhoneType: Nokia\nOperating system : " + operatingSystem + "\nResolution: " + verticalPixels + "x"
				+ horisontalPixels + "\nCamera resolution: " + cameraMegaPixels + "MP\n";
		System.out.println(info);
	}

}
