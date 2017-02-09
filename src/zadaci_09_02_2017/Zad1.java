package zadaci_09_02_2017;

public class Zad1 {
	//prestupna => djeljiva sa 400 ili ako je djeljiva sa 4, a nije sa 100
	public static boolean prestupna(int godina) {
		if (godina % 400 == 0 || (godina % 4 == 0 && godina % 100 != 0)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int godinaULiniji = 0;
		for (int i = 101; i < 2100; i++) {
			//prestupne godine ispisujemo u jednoj liniji
			if (prestupna(i)) {
				System.out.print(i + " ");
				godinaULiniji++;
				//uslov koji nam omogucava da se u svakoj liniji ispise 10 godina
				if (godinaULiniji % 10 == 0) {
					System.out.println();
				}
			}
		}
		
		System.out.println("\nUkupno prestupnih godina: "+godinaULiniji);
	}

}
