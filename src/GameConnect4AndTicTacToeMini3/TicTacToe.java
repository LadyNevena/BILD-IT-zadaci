package GameConnect4AndTicTacToeMini3;

import java.util.Scanner;

public class TicTacToe {
	
	//check rows, check colums, check diagonals => win if one of them return true
	public static boolean checkWinner(String[][] matrix) {
		if (checkRow(matrix) || checkColumn(matrix) || mainDiagonal(matrix) || subDiagonal(matrix)) {
			return true;
		}
		return false;
	}
	
	//check if one row in matrix has all elements equals
	public static boolean checkRow(String[][] matrix) {
		boolean flag = true;
		for (int i = 0; i < matrix.length; i++) {
			flag = true;
			for (int j = 0; j < matrix.length - 1; j++) {
				if (matrix[i][j].equals(" ")) {
					flag = false;
				} else if (!matrix[i][j].equals(matrix[i][j + 1])) {
					flag = false;
				}
			}
			if (flag) {
				return true;
			}
		}

		return flag;
	}
	
	//check if column has all elements equals
	public static boolean checkColumn(String[][] matrix) {
		boolean flag = true;
		for (int i = 0; i < matrix.length; i++) {
			flag = true;
			for (int j = 0; j < matrix.length - 1; j++) {
				if (matrix[j][i].equals(" ")) {
					flag = false;
				} else if (!matrix[j][i].equals(matrix[j + 1][i])) {
					flag = false;
				}
			}
			if (flag) {
				return true;
			}
		}

		return flag;
	}
	
	//check main diagonal 
	public static boolean mainDiagonal(String[][] matrix) {
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				if (matrix[j][j].equals(" ")) {
					return false;
				} else if (!matrix[i][i].equals(matrix[j][j]))
					return false;
			}
		}
		return true;
	}
	
	//check sub diagonal
	public static boolean subDiagonal(String[][] matrix) {
		int k = 1;
		for (int i = 0; i < matrix.length - 1; i++) {
			if (matrix[k][i + 1].equals(" ")) {
				return false;
			} else if (!matrix[matrix.length - 1][0].equals(matrix[k][i + 1])) {
				return false;
			}
			k--;
		}
		return true;
	}
	
	//replace blank space in matrix with X or O
	public static String[][] setMatrix(String[][] matrix, int column, int row, String letter) {
		if (matrix[row][column].equals(" ")) {
			matrix[row][column] = matrix[row][column].replace(" ", letter);
		}
		return matrix;
	}
	
	//user can not put X or O if the place is already taken
	public static boolean validInput2(int row, int column, String[][] matrix) throws Exception {
		if (!matrix[row][column].equals(" ")) {
			throw new Exception("invalid");
		}
		return true;
	}
	
	//user only can enter 0,1,2 as indices
	public static boolean validInput1(int input, String[][] matrix) throws Exception {
		if (input < 0 || input > 2) {
			throw new Exception("invalid");
		}
		return true;
	}
	
	//print matrix where blank space replaced with entered token
	public static void printMatrix(String[][] matrix) {
		System.out.println("-------");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (j < matrix[0].length - 1) {
					System.out.print("|" + matrix[i][j]);
				} else {
					System.out.print("|" + matrix[i][j] + "|");
				}
			}
			System.out.println();
			System.out.println("-------");
			// System.out.println("");
		}
		// System.out.println("---------------");
	}
	
	//test TicTacToe
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int column = 0;
		int row = 0;
		int input = 0;
		int ROWS = 3;
		int COLUMNS = 3;
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
		 * continue to play if we have less than ROWS*COLUMNS tokens in matrix
		 */
		while (input < ROWS * COLUMNS) {

			while (true) {

				try {
					while (true) {
						try {
							System.out.println("Enter a row (0,1,2) for player X:");
							row = in.nextInt();
							validInput1(row, matrix);
							break;
						} catch (Exception e) {
							System.out.println("Please, enter again.");
							in.nextLine();
						}
					}
					while (true) {
						try {
							System.out.println("Enter a column (0,1,2) for player X:");
							column = in.nextInt();
							validInput1(column, matrix);
							break;
						} catch (Exception e) {
							System.out.println("Please, enter again.");
							in.nextLine();
						}
					}
					validInput2(row, column, matrix);
					break;
				} catch (Exception e) {
					System.out.println("This place is already taken.");
				}
			}
			input++;
			matrix = setMatrix(matrix, column, row, "X");
			printMatrix(matrix);

			if (checkWinner(matrix)) {
				System.out.println("The X player won!");
				break;
			}
			if(input==ROWS*COLUMNS){
				break;
			}

			while (true) {

				try {
					while (true) {
						try {
							System.out.println("Enter a row (0,1,2) for player O:");
							row = in.nextInt();
							validInput1(row, matrix);
							break;
						} catch (Exception e) {
							System.out.println("Please, enter again.");
							in.nextLine();
						}
					}
					while (true) {
						try {
							System.out.println("Enter a column (0,1,2) for player O:");
							column = in.nextInt();
							validInput1(column, matrix);
							break;
						} catch (Exception e) {
							System.out.println("Please, enter again.");
							in.nextLine();
						}
					}
					validInput2(row, column, matrix);
					break;
				} catch (Exception e) {
					System.out.println("This place is already taken.");
				}
			}
			matrix = setMatrix(matrix, column, row, "O");
			printMatrix(matrix);

			if (checkWinner(matrix)) {
				System.out.println("The O player won!");
				break;
			}

			input++;
			if(input==ROWS*COLUMNS){
				break;
			}
		}
		/*
		 * if we replaced all blank spaces in matrix and no one win then print draw!
		 * */
		if (input == ROWS * COLUMNS) {
			System.out.println("Draw!");
		}
		in.close();
	}

}
