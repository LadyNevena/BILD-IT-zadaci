package zadaci_08_02_2017;

public class Zad4 {
	public static void main(String[] args) {
		
		int[] niz = new int[10];
		
		//generisemo brojeve od 0 do 9 koji su zapravo indeksi niza
		//niz[i]=j ekvivalentno sa "broj i se pojavio j puta"
		for (int i = 0; i < 100; i++) {
			int broj = (int) (Math.random()*10) ;
			niz[broj]++;
		}

		for (int i = 0; i < niz.length; i++) {
			System.out.println(i + " je generisan " + niz[i] + " puta.");
		}
	}
}
