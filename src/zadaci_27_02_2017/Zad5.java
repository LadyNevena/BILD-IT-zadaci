package zadaci_27_02_2017;
/*
 * (Even number of 1s) Write a program that generates a 6-by-6 two-dimensional
 * matrix filled with 0s and 1s, displays the matrix, and checks if every row and
 * every column have an even number of 1s.
 * */
public class Zad5 {
	public static boolean isEven(int n) {
		if (n % 2 == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEvenNumberOf1sInRow(int matrix[][]) {
		int sum1 = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum1 = 0;
			for (int j = 0; j < matrix[0].length; j++) {
				sum1 += matrix[i][j];
			}
			if (!isEven(sum1)) {
				return false;
			}
		}
		int sum2 = 0;
		for (int j = 0; j < matrix[0].length; j++) {
			sum2 = 0;
			for (int i = 0; i < matrix.length; i++) {
				sum2 += matrix[i][j];
			}
			if (!isEven(sum2)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[6][6];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = (int) (Math.random() * 2);
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		if (isEvenNumberOf1sInRow(matrix)) {
			System.out.println("True.");
		} else {
			System.out.println("False.");
		}

	}

}
