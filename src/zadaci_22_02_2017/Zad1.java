package zadaci_22_02_2017;

/*
 * Napisati program koji nasumièno generiše cijeli broj izmeðu 1 i 12
 * te ispisuje ime mjeseca za taj broj. (Januar za 1, Ferbruar za 2....)
 * 
 * */
public class Zad1 {
	public static int generisi() {
		return (int) (Math.random() * 12+1);
	}

	public static String mjesec() {
		String[] mjeseci = { "januar", "februar", "mart", "april", "maj", "jun", "juli", "avgust", "septembar",
				"oktobar", "novembar", "decembar" };
		return mjeseci[generisi()-1];
	}

	public static void main(String[] args) {
		System.out.println("Random mjesec: " + mjesec());

	}

}
