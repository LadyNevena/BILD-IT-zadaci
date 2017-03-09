package zadaci_09_03_2017;


import java.util.Scanner;


public class TestOutOfBounds {
	public static int readInteger(Scanner in, int size) {
		int num = 0;
		while (true) {
			try {
				num = in.nextInt();
				if(num<0 || num>=size){
					throw new ArrayIndexOutOfBoundsException("out of bounds");
				}
				break;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Try again.");
				in.nextLine();
			}catch(Exception e){
				System.out.println("Try again.");
				in.nextLine();
			}
		}
		return num;
	}
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int[] array = new int[100];
		for (int i = 0; i < array.length; i++) {
			array[i]  = (int)(Math.random()*10);
		}
		System.out.println("Enter index:");
		int index = readInteger(in,array.length);
		System.out.println("array["+index+"] = "+array[index]);
		in.close();

	}

}
