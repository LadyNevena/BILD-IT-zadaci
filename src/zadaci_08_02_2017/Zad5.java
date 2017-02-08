package zadaci_08_02_2017;
import java.util.Scanner;

public class Zad5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesite brojeve: ");
		int max = in.nextInt();
		int broj = -1;
		int brojac = 1;
		
		do {
			broj = in.nextInt();
			//trenutni maksimalan i njegov brojac vracamo na 1
			if (broj > max) {
				max = broj;
				brojac=1;
			}//brojimo pojavljivanja potencijalnog maksimalnog broja
			else if(broj==max){
				brojac++;
			}
		} while (broj != 0);
		
		System.out.println("Najveci broj je "+max+".\nPojavio se "+brojac+" puta.");
		
		in.close();
	}
}
