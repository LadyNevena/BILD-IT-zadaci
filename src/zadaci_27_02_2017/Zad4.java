package zadaci_27_02_2017;

/*
 * (Sort two-dimensional array)
 * 
 * {{4, 2},{1, 7},{4, 5},{1, 2},{1, 1},{4, 1}}
 * 
 * */
public class Zad4 {
	public static void sort(int[][] matrix) {
		// prvo uslov sa redovima
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				if (matrix[i][0] >= matrix[j][0]) {
					int temp1 = matrix[i][0];
					int temp2 = matrix[i][1];
					matrix[i][0] = matrix[j][0];
					matrix[j][0] = temp1;
					matrix[i][1] = matrix[j][1];
					matrix[j][1] = temp2;

				}
			}
		}

		// zadrzati vec sortirane redove i dodati uslov sa kolonama
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				if (matrix[i][0] >= matrix[j][0] && matrix[i][1] >= matrix[j][1]) {
					int temp1 = matrix[i][0];
					int temp2 = matrix[i][1];
					matrix[i][0] = matrix[j][0];
					matrix[j][0] = temp1;
					matrix[i][1] = matrix[j][1];
					matrix[j][1] = temp2;

				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 4, 2 }, { 1, 7 }, { 4, 5 }, { 1, 2 }, { 1, 1 }, { 4, 1 } };
		sort(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
