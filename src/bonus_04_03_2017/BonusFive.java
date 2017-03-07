package bonus_04_03_2017;
public class BonusFive {
	public static void main(String[] args) {
		Komponenta finMotor = new FinMotor("fin");
		Komponenta motorAlZaribao = new LosMotor("zaribao");
		
		Akcija klucUBravu = new NormalnaAkcija("Ubacim kljuc i okrenem.");
		Akcija paljenjeIzPrve = new SmjesnaAkcija("Palim i upali iz prve");
		Akcija gasDoDaske = new SmjesnaAkcija("Dodam gas i ne pustam.");
		Akcija naKamenSeSkrsim = new TragicnaAkcija("Naletim na kamen i skrsim se.");
		Akcija pricljiviPolicajac = new TragicnaAkcija("Spazi me policajac i pozove me da mi nesto kaze.");


		Motor maliSkuter = new Skuter();
		maliSkuter.dodajKomponentu(finMotor);
		maliSkuter.dodajAkciju(klucUBravu);
		maliSkuter.dodajAkciju(paljenjeIzPrve);
		maliSkuter.dodajAkciju(gasDoDaske);
		maliSkuter.dodajAkciju(pricljiviPolicajac);

		maliSkuter.vozi();


		System.out.println();


		Motor velikiSkuter = new Skuter();
		velikiSkuter.dodajKomponentu(motorAlZaribao);
		velikiSkuter.dodajAkciju(paljenjeIzPrve);
		velikiSkuter.dodajAkciju(gasDoDaske);
		velikiSkuter.dodajAkciju(naKamenSeSkrsim);

		velikiSkuter.vozi();
	}
}