package zadaci_09_02_2017;

public class Zad5 {

	public static void pismoGlava(int n){
		int pismo=0;
		int glava=0;
		for (int i = 0; i < n; i++) {
			if((int)(Math.random()*2) == 0){
				pismo++;
			}
			else{
				glava++;
			}
		}
		System.out.println("PISMO: "+pismo+"\nGLAVA: "+glava);
	}
	
	public static void main(String[] args) {
		int brojBacanja=5;
		
		//testiranje metode za eksperiment bacanja novcica 5 puta
		pismoGlava(brojBacanja);
	}
}
