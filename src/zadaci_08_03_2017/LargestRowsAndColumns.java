package zadaci_08_03_2017;

public class LargestRowsAndColumns {
	public static int sumInColumn(int[][] matrix, int j) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum += matrix[i][j];
		}
		return sum;
	}

	public static java.util.ArrayList<Integer> indexOfLargestColumn(int[][] matrix) {
		int max = sumInColumn(matrix, 0);
		java.util.ArrayList<Integer> indices = new java.util.ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			if (sumInColumn(matrix, i) > max) {
				max = sumInColumn(matrix, i);
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			if (sumInColumn(matrix, i) == max) {
				indices.add(i);
			}
		}
		return indices;
	}

	public static int sumInRow(int[][] matrix, int i) {
		int sum = 0;
		for (int j = 0; j < matrix.length; j++) {
			sum += matrix[i][j];
		}
		return sum;
	}

	public static java.util.ArrayList<Integer> indexOfLargestRow(int[][] matrix) {
		int max = sumInRow(matrix, 0);
		java.util.ArrayList<Integer> indices = new java.util.ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			if (sumInRow(matrix, i) > max) {
				max = sumInRow(matrix, i);
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			if (sumInRow(matrix, i) == max) {
				indices.add(i);
			}
		}
		return indices;
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
		System.out.print("The largest row indices are: ");
		for (int i = 0; i < indexOfLargestRow(matrix).size(); i++) {
			System.out.print(indexOfLargestRow(matrix).get(i)+" ");
		}
		System.out.println();
		System.out.print("The largest column indices are: ");
		for (int i = 0; i < indexOfLargestColumn(matrix).size(); i++) {
			System.out.print(indexOfLargestColumn(matrix).get(i)+" ");
		}

	}

}
