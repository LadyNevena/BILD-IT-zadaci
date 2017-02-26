package GameConnect4AndTicTacToeMini3;


import java.util.Scanner;

/*
 * 
 * Connect four is a two-player board game in which the
 * players alternately drop colored disks into a seven-column, six-row vertically suspended grid.
 * The objective of the game is to connect four same-colored disks in a row, a column,
 * or a diagonal before your opponent can do likewise. 
 * The program prompts two players to drop a red or yellow disk alternately.
 * Whenever a disk is dropped, the program redisplays the board on the console and determines the
 * status of the game (win, draw, or continue).
 *
 *
 * */

public class GameConnectFour {

	public static String[][] setMatrix(String[][] matrix, int input, String letter) {

		for (int i = matrix.length - 1; i >= 0; i--) {
			if (!matrix[i][input].equals(" ")) {
				continue;
			} else {
				matrix[i][input] = matrix[i][input].replace(" ", letter);
				break;
			}
		}
		return matrix;
	}

	/*
	 * The method that return true if the row has consecutive n numbers from a
	 * to b
	 */
	public static boolean isConsecutive4Row(String[][] matrix, int i, int a, int b) {
		for (int j = a; j < b - 1; j++) {
			if (!matrix[i][j].equals(matrix[i][j + 1]) || matrix[i][j].equals(" ")) {
				return false;
			}
		}
		return true;
	}

	/*
	 * The method that return true if the column has consecutive n numbers from
	 * a to b
	 */
	public static boolean isConsecutive4Column(String[][] matrix, int j, int a, int b) {
		for (int i = a; i < b - 1; i++) {
			if (!matrix[i][j].equals(matrix[i + 1][j]) || matrix[i][j].equals(" ")) {
				return false;
			}
		}
		return true;
	}

	public static boolean isConsecutiveFour(String[][] matrix) {
		/*
		 * ckeck if the row has consecutive4
		 */
		boolean consecutive = false;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j <= matrix[0].length - 4; j++) {
				if (isConsecutive4Row(matrix, i, j, j + 4)) {
					consecutive = true;
					// System.out.println("Row --");
					break;
				}
			}

			if (consecutive) {
				break;
			}

		}
		/*
		 * check if the column has consecutive4
		 */
		for (int j = 0; j < matrix[0].length; j++) {
			for (int i = 0; i <= matrix.length - 4; i++) {
				if (isConsecutive4Column(matrix, j, i, i + 4)) {
					consecutive = true;
					// System.out.println("Column |");
					break;
				}

				if (consecutive) {
					break;
				}
			}
		}
		/*
		 * check for diagonals under and upper of major diagonal
		 */
		int count = 1;
		for (int i = 0; i < matrix.length - 1; i++) {
			int k = i;
			count = 1;
			for (int j = 0; j < matrix[0].length - 1 && k < matrix.length - 1; j++) {
				if (!matrix[k][j].equals(matrix[k + 1][j + 1]) || matrix[k][j].equals(" ")
						|| matrix[k + 1][j + 1].equals(" ")) {
					count = 1;
				} else {
					count++;
				}
				k++;
				if (count == 4) {
					consecutive = true;
					// System.out.println("diagonal \\");
				}

			}
		}
		for (int i = 0; i < matrix[0].length - 1; i++) {
			int k = i;
			count = 1;
			for (int j = 0; j < matrix.length - 1 && k < matrix[0].length - 1; j++) {
				if (!matrix[j][k].equals(matrix[j + 1][k + 1]) || matrix[j][k].equals(" ")
						|| matrix[j + 1][k + 1].equals(" ")) {
					count = 1;
				} else {
					count++;
				}
				k++;
				if (count == 4) {
					consecutive = true;
					// System.out.println("diagonal \\");
				}
			}
		}
		/*
		 * check for sub-diagonals
		 */
		for (int j = 0; j < matrix[0].length - 1; j++) {
			int k = j;
			count = 1;
			for (int i = matrix.length - 1; i > 0 && k < matrix[0].length - 1; i--) {
				if (!matrix[i][k].equals(matrix[i - 1][k + 1]) || matrix[i][k].equals(" ")
						|| matrix[i - 1][k + 1].equals(" ")) {
					count = 1;
				} else {
					count++;
				}
				k++;
				if (count == 4) {
					consecutive = true;
					// System.out.println("diagonal /");
				}
			}
		}
		for (int i = 0; i < matrix.length - 1; i++) {
			count = 1;
			int k = i;
			for (int j = 0; j < matrix[0].length - 1 && k > 0; j++) {
				if (!matrix[k][j].equals(matrix[k - 1][j + 1]) || matrix[k][j].equals(" ")
						|| matrix[k - 1][j + 1].equals(" ")) {
					count = 1;
				} else {
					count++;
				}
				k--;
				if (count == 4) {
					consecutive = true;
					// System.out.println("diagonal /");
				}
			}

		}
		return consecutive;
	}

	/*
	 * print matrix
	 */
	public static void printMatrix(String[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (j < matrix[0].length - 1) {
					System.out.print("|" + matrix[i][j]);
				} else {
					System.out.print("|" + matrix[i][j] + "|");
				}
			}
			System.out.println("");
		}
		System.out.println("---------------");
	}
	/*
	 * count numbers in column at index colIndex
	 * */
	public static int columnSize(int colIndex, String[][] matrix) {
		int size = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (!matrix[i][colIndex].equals(" ")) {
				size++;
			}
		}
		return size;
	}

	/*
	 * check if the colIndex is >6 or <0 -> return exception
	 * if user try to put disk in already filled column -> exception
	 **/
	public static boolean validInput(int input, String[][] matrix) throws Exception {
		if (input < 0 || input > 6) {
			throw new Exception("Choose column (0-6)!");
		} else if (columnSize(input, matrix) == 6) {
			throw new Exception("Column contains 6 disks!");
		}
		return true;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int column;
		int input = 0;
		int ROWS = 6;
		int COLUMNS = 7;
		String[][] matrix = new String[ROWS][COLUMNS];
		/*
		 * initialize
		 */
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = " ";
			}
		}
		/*
		 * continue to play if we have less than ROWS*COLUMNS disk in matrix
		 * */
		while (input < ROWS * COLUMNS) {

			while (true) {
				try {
					System.out.println("Drop a yellow disk at column (0-6):");
					column = in.nextInt();
					validInput(column, matrix);
					break;
				} catch (Exception e) {
					System.out.println("Please, enter again.");
					in.nextLine();
				}
			}
			/*
			 * if the input is valid set Y disk at the right place (at column index)
			 * 
			 * */
			matrix = setMatrix(matrix, column, "Y");
			printMatrix(matrix);
			/*
			 * check if we connect 4 yellow disks
			 * */
			if (isConsecutiveFour(matrix)) {
				System.out.println("The yellow player won!");
				break;
			}

			while (true) {
				try {
					System.out.println("Drop a red disk at column (0-6):");
					column = in.nextInt();
					validInput(column, matrix);
					break;
				} catch (Exception e) {
					System.out.println("Please, enter again.");
					in.nextLine();
				}
			}
			/*
			 * if the input is valid set R disk at the right place (at column index)
			 * 
			 * */
			matrix = setMatrix(matrix, column, "R");
			printMatrix(matrix);
			/*
			 * check if we connect 4 red disks
			 * */
			if (isConsecutiveFour(matrix)) {
				System.out.println("The red player won!");
				break;
			}
			
			//we add R and Y disk in matrix
			input += 2;
		}
		/*
		 * if matrix cintains all ROWS*COLUMNS disks -> stop playing it's drawn
		 * */
		if (input == ROWS * COLUMNS) {
			System.out.println("Draw!");
		}
		in.close();

	}

}
