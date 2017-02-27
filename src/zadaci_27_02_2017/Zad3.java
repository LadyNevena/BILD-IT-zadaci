package zadaci_27_02_2017;
/*
 * (Largest row and column) Write a program that randomly fills in 0s and 1s into
 * a 4-by-4 matrix, prints the matrix, and finds the first row and column with the
 * most 1s.
 * 
 * */
public class Zad3 {
	public static int sumInColumn(int[][] matrix, int j) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum += matrix[i][j];
		}
		return sum;
	}

	public static int indexOfLargestColumn(int[][] matrix) {
		int max = sumInColumn(matrix, 0);
		int index = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (sumInColumn(matrix, i) > max) {
				max = sumInColumn(matrix, i);
				index = i;
			}
		}
		return index;
	}

	public static int sumInRow(int[][] matrix, int i) {
		int sum = 0;
		for (int j = 0; j < matrix.length; j++) {
			sum += matrix[i][j];
		}
		return sum;
	}

	public static int indexOfLargestRow(int[][] matrix) {
		int max = sumInRow(matrix, 0);
		int index = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (sumInRow(matrix, i) > max) {
				max = sumInRow(matrix, i);
				index = i;
			}
		}
		return index;
	}
	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
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
		System.out.println("The largest row index is: "
				+ indexOfLargestRow(matrix));
		System.out.println("The largest column index is: "
				+ indexOfLargestColumn(matrix));
	}

}
