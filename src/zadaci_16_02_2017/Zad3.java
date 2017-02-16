package zadaci_16_02_2017;
/*
 * Napišite program koji ispisuje sve brojeve,
 * od 100 do 1000, 10 brojeva po liniji, koji su djeljivi i sa 5 i sa 6.
 * Razmak izmeðu brojeva treba biti taèno jedan space. 
 * */
public class Zad3 {
	public static void djeljiviSa5I6(){
		int brojac=0;
		for (int i = 100; i <= 1000; i++) {
			if(i%5==0 && i%6==0){
				System.out.print(i+" ");
				brojac++;
				if(brojac == 10){
					System.out.println();
					brojac = 0;
				}
			}
		}
	}
	public static void main(String[] args) {
		djeljiviSa5I6();
	}

}
