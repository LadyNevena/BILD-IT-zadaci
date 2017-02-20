package zadaci_20_02_2017;

/*
 *  Pretpostavimo da se registarska tablica za auto sastoji od tri uppercase karaktera 
 *  i 4 broja u sljedeæem formatu AAA-1234.
 *  Napisati program koji nasumièno generiše tablicu.
 * */
public class Zad1 {
	// generisemo veliko slovo
	public static char velikoSlovo() {
		char c = (char) ((int) (Math.random() * 26 + 65));
		return c;
	}

	// generisemo broj
	public static int broj() {
		int broj = (int) (Math.random() * 10);
		return broj;
	}
	//registarske tablice
	public static String registarskeTablice() {
		String slova = "" + velikoSlovo() + velikoSlovo() + velikoSlovo();
		String brojevi = "" + broj() + broj() + broj() + broj();
		String regOznaka = slova + "-" + brojevi;
		return regOznaka;
	}

	public static void main(String[] args) {
		System.out.println("Registarske tablice:");
		System.out.println(registarskeTablice());
	}

}
