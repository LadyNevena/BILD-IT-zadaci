package bonus_04_03_2017;

public class NormalnaAkcija implements Akcija {
	String akcija;

	public NormalnaAkcija(){
	}
	
	public NormalnaAkcija(String akcija){
		this.akcija = akcija;
	}


	@Override
	public void izvrsi() {
		System.out.println(akcija);
	}
	
	
}
