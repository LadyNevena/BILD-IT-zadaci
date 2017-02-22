package zadaci_22_02_2017;
/*
 * Napisati program koji sabira sljedeæu seriju
 * 1/3 + 3/5 + 5/7 + 7/9 + 9/11 + 11/13 ..... + 95/97 + 97/99
 * 
 * */
public class Zad3 {
	public static void main(String[] args){
		double suma=0;
		String s="";
		for(int i=1;i<99;i+=2){
			suma=suma+i/(i+2.0);
			s+=i+"/"+(i+2)+"+";
			//System.out.print(i+"/"+(i+2)+"+");
		}
		//s = s.substring(0,s.length()-1);
		System.out.println("1/3 + 3/5 +...+ 95/97 + 97/99  = "+suma);
	}
}
