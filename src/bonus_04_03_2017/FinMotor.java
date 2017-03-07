package bonus_04_03_2017;

public class FinMotor implements Komponenta{
	String opis;
	
	FinMotor(String opis){
		this.opis = opis;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Override
	public void pokreni() {
		System.out.println("Startujem motor koji je "+opis);
		
	}
	

}
