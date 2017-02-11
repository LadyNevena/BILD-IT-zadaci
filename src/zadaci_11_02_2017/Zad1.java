package zadaci_11_02_2017;

import java.util.Scanner;

public class Zad1 {
	public static boolean pozitivan(int n) throws Exception{
		if(n>=0){
			return true;
		}
		else{
			throw new Exception("NEGATIVAN BROJ");
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesi broj: ");
		boolean nastavi = true;
		while (nastavi) {
			//ako korisnik pokusa da unese nesto sto nije broj
			try {
				int n = in.nextInt();
				//ako je unesen broj
				try{
					//ako broj  jeste pozitivan ispisuju se faktori
					pozitivan(n); 
					nastavi = false;
					System.out.println("Prosti faktori: ");
					for (int i = 2; i <= n; i++) {
						// sve dok je broj djeljiv sa faktorom nastavi da djelis
						while (n % i == 0) {
							n = n / i;
							System.out.print(i + " ");
						}
					}//ako broj nije pozitivan pitaj korisnika ponovo da unese broj
				}catch(Exception ex){
					System.out.println("Molimo unesite pozitivan broj: ");	
				}
			} catch (Exception ex) {
				System.out.println("GRESKA. Nastavite unos:");
				in.nextLine();
			}
		}
		in.close();
	}

}
