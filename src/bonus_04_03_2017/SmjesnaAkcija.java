package bonus_04_03_2017;

public class SmjesnaAkcija extends NormalnaAkcija{
	
	
	public SmjesnaAkcija(String akcija){
		super(akcija);
	}
	
	@Override
	public void izvrsi() {
		System.out.print("Smijesna situacija. :) ");
		super.izvrsi();
	}
	

}
