package HangmanAndBattleshipGame;

import java.util.Scanner;

public class Board {
	private int row;
	private int column;
	private Object[][] board;
	private Ship[] ships;
	private int[][][] shipPositions;

	Board() {

	}

	Board(int row, int column, Ship[] ships) {
		this.row = row;
		this.column = column;
		this.ships = ships;
		this.board = new Object[row][column];
		shipPositions = addShip();
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public Ship[] getShips() {
		return ships;
	}

	public void setShips(Ship[] ships) {
		this.ships = ships;
	}

	public void showBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	// if we hit than lock the place on the board with X token
	public void replace(int row, int column) {
		board[row][column] = "X";
	}

	// is hitted if the place on the board is already locked
	public boolean isHitted(int row, int column) {
		if (board[row][column].equals("X")) {
			return true;
		}
		return false;
	}

	// print coordinates for each ship
	public static void show3D(int[][][] positions) {

		for (int i = 0; i < positions.length; i++) {
			for (int j = 0; j < positions[i].length; j++) {
				for (int k = 0; k < positions[i][j].length; k++) {
					System.out.print(positions[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public void initBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = (Object) (new String("O"));
			}
		}
	}

	// each matrix in 3D array is one ship represented with coordinates
	public int[][][] addShip() {
		int[][][] positions = new int[ships.length][][];
		int pos = 1;
		int shipIndex = 0;
		int[] shipLengths = new int[ships.length];
		for (int i = 0; i < ships.length; i++) {
			shipLengths[i] = ships[i].getLength();
			positions[i] = new int[2][ships[i].getLength()];
		}

		initBoard();

		for (int ship : shipLengths) {
			boolean added = false;
			while (!added) {
				int x = (int) (row * Math.random());
				int y = (int) (column * Math.random());
				boolean horizontal = ((int) (10 * Math.random())) % 2 == 0;
				if (horizontal) {
					// Check for vertical space
					boolean hasSpace = true;
					for (int i = 0; i < ship; i++) {
						if (y + i >= column) {
							hasSpace = false;
							break;
						}
						if (!board[x][y + i].equals("O")) {
							hasSpace = false;
							break;
						}
					}
					if (!hasSpace) {
						// check again
						continue;
					}
					for (int i = 0; i < ship; i++) {
						board[x][y + i] = (Object) (new String("" + pos));
						positions[shipIndex][0][i] = x;
						positions[shipIndex][1][i] = y + i;
					}
					added = true;
					shipIndex++;
					pos++;
				} else {
					// Check for horizontal space
					boolean hasSpace = true;
					for (int i = 0; i < ship; i++) {
						if (x + i >= board.length) {
							hasSpace = false;
							break;
						}
						if (!board[x + i][y].equals("O")) {
							hasSpace = false;
							break;
						}
					}
					if (!hasSpace) {
						// check again
						continue;
					}
					for (int i = 0; i < ship; i++) {
						board[x + i][y] = (Object) (new String("" + pos));
						positions[shipIndex][0][i] = x + i;
						positions[shipIndex][1][i] = y;

					}
					added = true;
					shipIndex++;
					pos++;
				}
			}
		}

		return positions;

	}

	public static boolean negative(int n) throws Exception {
		if (n < 0) {
			throw new Exception("Negative.");
		}
		return true;
	}

	public static int validInput(Scanner in, int row, int column) {
		int number = 0;
		while (true) {
			try {
				number = in.nextInt();
				negative(number);
				if (number >= row || number >= column) {
					throw new Exception("Out of bounds.");
				}
				break;
			} catch (Exception e) {
				System.out.println("Invalid input.");
				in.nextLine();
			}
		}
		return number;
	}

	// indices of destroyed ships
	public static int[] hitShip(int[][][] shipPositions) {
		boolean destroyed = false;
		int[] ships = new int[shipPositions.length];
		for (int i = 0; i < ships.length; i++) {
			ships[i] = -1;
		}
		for (int i = 0; i < shipPositions.length; i++) {
			destroyed = true;
			for (int j = 0; j < shipPositions[i].length; j++) {
				for (int k = 0; k < shipPositions[i][j].length; k++) {
					if (shipPositions[i][j][k] != -1) {
						destroyed = false;
					}

				}
			}
			if (destroyed) {
				ships[i] = i;
			}

		}
		return ships;
	}

	public void play() {
		Scanner in = new Scanner(System.in);

		// board with covered ships
		Board board = new Board(getRow(), getColumn(), ships);
		board.initBoard();
		board.showBoard();

		// show3D(shipPositions);

		int column = 0;
		int row = 0;

		boolean hitted = false;

		int countHitted = 0;

		while (countHitted < shipPositions.length) {

			
			countHitted = 0;

			System.out.println("Enter row:");
			row = validInput(in, getRow(), getColumn());
			System.out.println("Enter column:");
			column = validInput(in, getRow(), getColumn());

			hitted = false;

			// if we already have replaced position with X on the board
			if (board.isHitted(row, column)) {
				System.out.println("You've already entered this position .");
				continue;
			}

			// if user hit the ship, then replace ship position with -1
			for (int i = 0; i < shipPositions.length; i++) {
				for (int j = 0; j < shipPositions[i].length / 2; j++) {
					for (int k = 0; k < shipPositions[i][j].length; k++) {
						if (shipPositions[i][0][k] == row && shipPositions[i][1][k] == column) {
							shipPositions[i][0][k] = -1;
							shipPositions[i][1][k] = -1;
							hitted = true;
							break;
						}

					}
				}

			}
			// if ship is hitted with all -1's then user have destroyed that
			// ship
			if (hitted) {
				board.replace(row, column);
				System.out.println("You hitted the ship!");
			}
			int[] destroyed = hitShip(shipPositions);
			for (int i = 0; i < destroyed.length; i++) {
				if (destroyed[i] != -1) {
					countHitted++;
				}
			}
			System.out.println("You've destroyed " + countHitted + " ships.");

			// print board
			board.showBoard();

		}
		System.out.println("You destroyed the last ship. You win!");

	}

}
