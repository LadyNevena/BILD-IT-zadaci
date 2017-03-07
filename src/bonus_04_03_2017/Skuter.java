package bonus_04_03_2017;

public class Skuter implements Motor {
	java.util.ArrayList<Komponenta> komponente =new java.util.ArrayList<>(); 
	java.util.ArrayList<Akcija> akcije =new java.util.ArrayList<>(); 
	
	@Override
	public void dodajKomponentu(Komponenta komponenta) {
		komponente.add(komponenta);
	}

	@Override
	public void dodajAkciju(Akcija akcija) {
		akcije.add(akcija);
	}

	@Override
	public void vozi() {
		for (int i = 0; i < komponente.size(); i++) {
			komponente.get(i).pokreni();
		}
		for (int i = 0; i < akcije.size(); i++) {
			akcije.get(i).izvrsi();
		}
	}

}
