package bonus_04_03_2017;

public class TragicnaAkcija extends NormalnaAkcija {
	
	
	TragicnaAkcija(String opis){
		super(opis);
	}
	@Override
	public void izvrsi() {
		System.out.print("Tragedija se dogodila. ");
		super.izvrsi();
	}
	
}
