package zadaci_10_03_2017;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class ProcessScores {

	public static double[] totalNumbersPerLine(String line) {
		String number = "";
		double total = 0;
		int numbersPerLine = 0;
		double[] array = new double[2];
		for (int i = 0; i < line.length(); i++) {
			if (Character.isDigit(line.charAt(i))) {
				number += line.charAt(i);
			} else if (number != "") {
				total += Double.parseDouble(number);
				numbersPerLine++;
				number = "";
			} else {
				continue;
			}
		}
		array[0] = Double.parseDouble(number) + total;
		array[1] = 1 + numbersPerLine;
		return array;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double total = 0;
		double numbersPerLine = 0;
		System.out.println("Enter filename:");
		String filename="";
		while(true){
			try{
				filename=in.nextLine();
				if(!filename.endsWith(".txt")){
					throw new Exception("file not ends with .txt");
				}
				break;
			}catch(Exception e){
				System.out.println("Enter filename that ends with .txt :");
			}
		}
		Path path = Paths.get(filename);
		try {
			
			BufferedReader reader = Files.newBufferedReader(path);
			try {
				String line;
				while ((line = reader.readLine()) != null) {
					double[] array = totalNumbersPerLine(line);
					total += array[0];
					numbersPerLine += array[1];
				}
			} finally {
				System.out.println("Total: " + total + "\nAverage: " + total
						/ numbersPerLine);
				reader.close();
				in.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		in.close();
	}
}
