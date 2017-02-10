package zadaci_10_02_2017;

import java.util.Scanner;

public class Zad3 {
	//vraca true ako su nizovi striktno identicni
	public static boolean equals(int[] niz1, int[] niz2) {
		for (int i = 0; i < niz2.length; i++) {
			if (niz1[i] != niz2[i]) {
				return false;// prekini petlju ako se odg el. ne poklapaju
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesite duzinu nizova:");
		int n = in.nextInt();
		int[] niz1 = new int[n];
		int[] niz2 = new int[n];
		System.out.println("Unesite prvi niz:");
		for (int i = 0; i < niz1.length; i++) {
			niz1[i] = in.nextInt();
		}
		System.out.println("Unesite drugi niz:");
		for (int i = 0; i < niz2.length; i++) {
			niz2[i] = in.nextInt();
		}
		System.out.println("Da li su striktno identicni? " + equals(niz1, niz2));
		in.close();
	}

}
