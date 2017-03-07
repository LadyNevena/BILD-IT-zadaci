package bonus_04_03_2017;

public class Lenovo implements Phone {
	private boolean possessingFrontCamera;
	private double numberofCPUCores;
	private double dispaySize;
	private double androidVersion;
	Lenovo(boolean possessingFrontCamera,double numberOfCPUCores, double displaySize, double androidVersion){
		this.possessingFrontCamera = possessingFrontCamera;
		this.numberofCPUCores = numberOfCPUCores;
		this.dispaySize = displaySize;
		this.androidVersion = androidVersion;
		
	}
	@Override
	public void printInfo() {
		String info = "Phone type: Lenovo\nSuports front camera: " + possessingFrontCamera + "\nNumber of cores: " + numberofCPUCores
				+ "\nDisplay size: " + dispaySize + "\nAndroid version: " + androidVersion+"\n";
		System.out.println(info);
	}

}
