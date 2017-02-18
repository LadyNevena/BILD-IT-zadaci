package zadaci_18_02_2017;

/*
 *  Napisati program koji ispisuje sve proste brojeve
 *  od 2 do 1000, ukljuæujuæi i 2 i 1000.
 *  Program treba da ispiše 8 brojeva po liniji te razmak 
 *  izmeðu brojeva treba da bude jedan space.
 * 
 * */
public class Zad2 {
	public static boolean prost(int broj) {
		for (int i = 2; i <= broj / 2; i++) {
			if (broj % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int brojac = 0;
		for (int i = 2; i <= 1000; i++) {
			if (prost(i)) {
				System.out.print(i + " ");
				brojac++;
				if (brojac == 8) {
					System.out.println();
					brojac = 0;
				}
			}
		}

	}

}
