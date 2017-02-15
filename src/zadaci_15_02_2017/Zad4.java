package zadaci_15_02_2017;

/*
 * Pozitivni cijeli broj je savr�en broj ukoliko je jednak zbiru 
 * svih svojih pozitivnih djelilaca, isklju�uju�i sebe.
 * Na primjer, 6 je prvi savr�eni broj jer 6 = 3 + 2 + 1. 
 * Sljede�i savr�eni broj je 28 jer 28 = 14 + 7 + 4 + 2 + 1.
 * Samo 4 savr�ena broja postoje u rasponu od 0 do 10.000. 
 * Napi�ite program koji ispisuje sva 4.
 * 
 * */
public class Zad4 {

	public static boolean savrsen(int x) {
		int suma = 0;
		for (int i = 1; i < x; i++) {
			//ako je djelilac
			if (x % i == 0) {
				//dodajemo ga na sumu
				suma += i;
			}
		}
		//provjera da li je suma jednaka broju, i ako se nula unese da ga ne uracunamo kao savrsen 
		if (suma == x && x != 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			if (savrsen(i)) {
				System.out.println(i);
			}
		}
	}

}
