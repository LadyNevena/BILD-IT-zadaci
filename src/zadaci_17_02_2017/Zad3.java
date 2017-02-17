package zadaci_17_02_2017;
/*
 * Napisati program koji ispisuje sve mogu�e 
 * kombinacije za biranje dva broja u rasponu od 1 do 7. 
 * Tako�er, program ispisuje broj svih mogu�ih kombinacija.  
 * Dakle, program treba da ispi�e sve mogu�e parove brojeva u datom rasponu, 
 * krenuv�i sa 1 2, 1 3, 1 4, itd. Broj mogu�ih kombinacija je 21. 
 * */
public class Zad3 {
	//kombinacije bez ponavljanja
	//ukupno ih je 21 , a to znaci da se par brojeva iz skupa od 7 elemenata
	//moze odabrati da 21 nacin
	public static void main(String[] args) {
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				if(i<j){
					System.out.print("("+i+","+j+")  ");
									}
				else{
					continue;
				}
			}
			System.out.println();
		}

	}

}
