package bonus_04_03_2017;

public class BonusFour {
	public static void main(String[] args) {
		Phone nokia3310 = new Nokia3310("Generic",240,320,2);
		Phone lumia638 = new Lumia638("Microsoft Windows Phone 8.1", 480,854,5);
		Phone lenovoK50t5 = new LenovoK50t5(true,8,5.5,5.1);
		Phone lenovoK6Power = new Lenovo6Power(true,8,5,6);
		
		
		nokia3310.printInfo();
		lumia638.printInfo();
		lenovoK50t5.printInfo();
		lenovoK6Power.printInfo();
	}
}

