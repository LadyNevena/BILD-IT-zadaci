package zadaci_11_02_2017;

public class Zad4 {
	//ja sam shvatila da se trazi ovakav ispis
	//prvo ispisemo random slova po 10 u liniji
	//potom ispisemo random brojeve po 10 u liniji
	public static void printUppercaseNumbers(){
		int brojac=0;
		for (int i = 0; i < 100; i++) {
			// u ascii kodu A-Z izmedju 65-90
			char c= (char)((int)(Math.random()*26+65));
			if(brojac<10){
				System.out.print(c+"\t");
				brojac++;
			}
			if(brojac>=10){
				System.out.println();
				brojac=0;
			}
		}
		for (int i = 0; i < 100; i++) {
			//neki broj, ogranicenje recimo <100
			int b = (int)(Math.random()*100);
			if(brojac<10){
				System.out.print(b+"\t");
				brojac++;
			}
			if(brojac>=10){
				System.out.println();
				brojac=0;
			}
		}
		
	}
	public static void main(String[] args) {
		printUppercaseNumbers();

	}

}
