package kalendarMini1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Reminder {
	private int day;
	private int month;
	private int year;
	private String title;
	private String note;

	Reminder() {
	}

	Reminder(int day, int month, int year, String title, String note) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.title = title;
		this.note = note;
	}
	//ispis sadrzaja podsjetnika
	public String getNote() {
		return "Date crated:\t" + day + "/" + month + "/" + year + "\n" + "Title:\t" + title + "\n" + "Note:\t" + note
				+ "\n-----";
	}
	//metoda koja dodaje podsjetnik u fajl
	public void addReminder(int day, int month, int year, String title, String note, String filename)
			throws Exception {

		Path path = Paths.get(filename);
		String newState = "";

		try {
			BufferedReader reader = Files.newBufferedReader(path);
			newState = "";
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					newState += line + "\n";
				}
			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		newState += day + " " + month + " " + year + " " + title + " " + note + "\n";
		BufferedWriter writer = Files.newBufferedWriter(path);
		String[] tempLine = newState.split("\n");
		for (int j = 0; j < tempLine.length; j++) {
			writer.write(tempLine[j]);
			writer.newLine();
		}
		writer.close();
	}
	
	//ispis podsjetnika
	public static void printReminder(String filename) {
		Path path = Paths.get(filename);
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					String[] readUser = line.split(" ");
					Reminder rem = new Reminder(Integer.parseInt(readUser[0]), Integer.parseInt(readUser[1]),
							Integer.parseInt(readUser[2]), readUser[3], readUser[4]);
					System.out.println(rem.getNote());
				}
			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
