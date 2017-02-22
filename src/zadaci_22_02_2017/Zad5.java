package zadaci_22_02_2017;

import java.util.Scanner;

/*
 * Napisati metodu koja ispisuje n x n matricu koristeæi se
 * sljedeæim headerom: public static void printMatrix(int n).
 * Svaki element u matrici je ili 0 ili 1, nasumièno generisana.
 * Napisati test program koji pita korisnika da unese broj n te mu
 * ispiše n x n matricu u konzoli.
 * 
 * */
public class Zad5 {
	public static void printMatrix(int n){
		int[][] matrix = new int[n][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int)(Math.random()*2);
			}
		}
		System.out.println("Generisana matrica...");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean negativan(int n) throws Exception{
		if(n<0){
			throw new Exception("Negativan.");
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=0;
		while(true){
			try{
				System.out.println("Unesite dimenzije matrice nxn:");
				n = in.nextInt();
				negativan(n);
				break;
			}catch(Exception e){
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		printMatrix(n);
		in.close();
	}

}
