package zadaci_28_02_2017;
/*
 * Design a class named Location for locating a maximal
 * value and its location in a two-dimensional array. The class contains public data
 * fields row, column, and maxValue that store the maximal value and its indices
 * in a two-dimensional array with row and column as int types and maxValue as a double type.
 * Write the following method that returns the location of the largest element in a
 * two-dimensional array:
 *                        public static Location locateLargest(double[][] a)
 *                        
 * The return value is an instance of Location. Write a test program that prompts
 * the user to enter a two-dimensional array and displays the location of the largest
 * element in the array.
 * 
 */

import java.util.Scanner;

class Location {
	private int row;
	private int column;
	private double maxValue;
	private double[][] matrix;

	Location() {
	}

	Location(int row, int column) {
		this.row = row;
		this.column = column;
		this.matrix = new double[row][column];

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

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	public double[][] getMatrix() {
		return matrix;
	}
	public static void printMatrix(double[][] matrix){
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println();
		}
	}

	public void setMatrix() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the array:");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (in.hasNext()) {
					while (true) {
						try {
							matrix[i][j] = in.nextDouble();
							break;
						} catch (Exception e) {
							System.out.println("Try again.");
							in.nextLine();
						}
					}
				}
			}
		}
		in.close();
	}

	// na poziciju (i,j) u matrici smjesta vrijednost promj. value
	public void setLocation(int i, int j, double value) {
		this.matrix[i][j] = value;
	}

	public Location locateLargest(double[][] a) {
		Location loc = new Location(1, 3);
		loc.setMaxValue(a[0][0]);
		int inx1 = 0;
		int inx2 = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] > loc.getMaxValue()) {
					loc.setMaxValue(a[i][j]);
					inx1 = i;
					inx2 = j;
				}
			}
		}
		loc.setLocation(0, 0, loc.getMaxValue());// na poz (0,0) smjesti max
													// element
		loc.setLocation(0, 1, (double) inx1);// na poz (0,1) smjesti indeks
												// vrste
		loc.setLocation(0, 2, (double) inx2);// na poz (0,2) smjesti indeks
												// kolone

		return loc;
	}
}



public class TestLocation {
	
	public static boolean negative(int n) throws Exception {
		if (n < 0) {
			throw new Exception("negative");
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of rows and columns. ");
		int row = 0;
		int column = 0;
		while (true) {
			try {
				System.out.println("Enter the number of rows:");
				row = in.nextInt();
				negative(row);
				break;
			} catch (Exception e) {
				System.out.println("Try again.");
				in.nextLine();
			}
		}
		while (true) {
			try {
				System.out.println("Enter the number of columns:");
				column = in.nextInt();
				negative(column);
				break;
			} catch (Exception e) {
				System.out.println("Try again.");
				in.nextLine();
			}
		}
		Location loc = new Location(row, column);// pozivamo konstruktor matrice
		loc.setMatrix();// korisnik popunjava matricu
		Location.printMatrix(loc.getMatrix());
		// pozivamo staticku metodu locateLargest(double[][]a) koja vraca
		// referencu na novokreirani objekat
		Location loc1 = loc.locateLargest(loc.getMatrix());
		System.out.println("The location of the largest is " + loc1.getMatrix()[0][0] + " at " + "("
				+ (int) loc1.getMatrix()[0][1] + "," + (int) loc1.getMatrix()[0][2] + ").");
		in.close();
	}

}
