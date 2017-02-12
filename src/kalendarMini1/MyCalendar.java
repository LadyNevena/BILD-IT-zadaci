package kalendarMini1;


import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MyCalendar {

	private int year;
	private int month;

	// no args konstruktor inicijalizuje polja year i month tekucom godinom
	// odnosno mjesecom
	MyCalendar() {
		GregorianCalendar cal = new GregorianCalendar();
		this.year = cal.get(Calendar.YEAR);
		this.month = cal.get(Calendar.MONTH) + 1;
	}

	// ako korisnik unese godinu i mjesec kao argument
	MyCalendar(int year, int month) {
		this.year = year;
		this.month = month;
	}

	// metoda vraca prvi dan kojim pocinje mjesec
	public static int firstDay(int y, int m, int d) {
		int h, day = -1;
		// ove formule djeluju konfuzno, ali u sustini ovako racunamo prvi dan u
		// prvoj sedmici mjeseca
		// ova formula je koriscena u jednom od zadataka iz knjige koju smo
		// korisnici na osnovama
		if (m == 1)
			h = (d + 26 * (13 + 1) / 10 + (y - 1) % 100 + ((y - 1) % 100) / 4 + (y - 1) / 400 + 5 * (y - 1) / 100) % 7;
		else if (m == 2)
			h = (d + 26 * (14 + 1) / 10 + (y - 1) % 100 + ((y - 1) % 100) / 4 + (y - 1) / 400 + 5 * (y - 1) / 100) % 7;
		else
			h = (d + 26 * (m + 1) / 10 + y % 100 + (y % 100) / 4 + y / 400 + 5 * y / 100) % 7;

		switch (h) {
		case 0:
			day = 7;
			break;
		case 1:
			day = 1;
			break;
		case 2:
			day = 2;
			break;
		case 3:
			day = 3;
			break;
		case 4:
			day = 4;
			break;
		case 5:
			day = 5;
			break;
		case 6:
			day = 6;
			break;
		default:
			System.out.println("Invalid number!");
			break;
		}
		return day;
	}

	// provjerava da li je godina prestupna
	public static boolean isLeap(int g) {
		if (g % 400 == 0 || (g % 4 == 0 && g % 100 != 0)) {
			return true;
		}
		return false;

	}

	// ova metoda nije nista specijalno, ako kreiramo instancu klase npr pomocu
	// no args konstruktora
	// pozivom ove metode ce se prikazati kalendar za tekuci mjesec i godinu
	public void displayCalendar() {
		displayMonth(year, month);
	}

	// ovo je metoda koja ispisuje naziv mjeseca, godinu i dane u sedmici
	public static void printHeader(int year, int month) {
		String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		System.out.println("\t\t" + monthNames[month - 1] + " " + year + "\t\t\t");
		System.out.println("___________________________________________________");
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
	}

	// ispisuje kalendar za dati mjesec i godinu
	public static void displayMonth(int year, int month) {

		int b = 0;// cuva zadnji dan u mjesecu
		int a = 0;// cuva dan kojim pocinje mjesec
		int numPerLine = 0;// omogucava kontrolu ispisa dana po sedmicama

		switch (month) {
		case 1: {
			printHeader(year, 1);// ispisemo odgovarajuce zaglavlje 1. mjeseca
			b = 31;// 1. mjesec ima 31 dan
			a = firstDay(year, 1, 1);// nalazimo prvi dan kojim pocinje Januar
		}
			break;
		case 2: {
			printHeader(year, 2);
			if (isLeap(year) == true) {
				b = 29;
			} else {
				b = 28;
			}
			a = firstDay(year, 2, 1);
		}
			break;
		case 3: {
			printHeader(year, 3);
			b = 31;
			a = firstDay(year, 3, 1);
		}
			break;
		case 4: {
			printHeader(year, 4);
			b = 30;
			a = firstDay(year, 4, 1);
		}
			break;
		case 5: {
			printHeader(year, 5);
			b = 31;
			a = firstDay(year, 5, 1);
		}
			break;
		case 6: {
			printHeader(year, 6);
			b = 30;
			a = firstDay(year, 6, 1);
		}
			break;
		case 7: {
			printHeader(year, 7);
			b = 31;
			a = firstDay(year, 7, 1);
		}
			break;
		case 8: {
			printHeader(year, 8);
			b = 31;
			a = firstDay(year, 8, 1);
		}
			break;
		case 9: {
			printHeader(year, 9);
			b = 30;
			a = firstDay(year, 9, 1);
		}
			break;
		case 10: {
			printHeader(year, 10);
			b = 31;
			a = firstDay(year, 10, 1);
		}
			break;
		case 11: {
			printHeader(year, 11);
			b = 30;
			a = firstDay(year, 11, 1);
		}
			break;
		case 12: {
			printHeader(year, 12);
			b = 31;
			a = firstDay(year, 12, 1);
		}
			break;
		default:
			System.out.println("Invalid month.");
			break;
		}

		int k = 1;
		for (int i = 1; i <= a + b; i++) {
			// ispis datuma pocinje od a=prvog dana u sedmici
			if (numPerLine >= a) {
				System.out.print(k + "\t");
				k++;
				// ostavljamo praznine dok ne naidjemo na prvi dan u sedmici
				// kojim pocinje mjesec
			} else if (numPerLine < a) {
				System.out.print("\t");
			}
			// svakih 7 dana ispis nastavljamo u novom redu
			if (numPerLine % 7 == 0) {
				System.out.println();
			}
			numPerLine++;
		}

	}

	// ovdje sam napisala metodu za ispis podsjetnika da se ne bih zajebavala sa
	// listama
	// mada je logicno da ova metoda bued u klasi Podsjetnik
	public static void printRemainder(String filename) {
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

	public static boolean isNegative(int num) throws Exception {
		if (num < 0) {
			throw new Exception("NEGATIVE NUMBER!");
		}
		return false;
	}

	public static boolean greater3(int num) throws Exception {
		if (num > 3) {
			throw new Exception("NEGATIVE NUMBER!");
		}
		return false;
	}

	public static boolean validMonth(int num) throws Exception {
		if (num < 0 || num > 12) {
			throw new Exception("NEGATIVE NUMBER!");
		}
		return false;
	}

	public static boolean isValidYear(int year) throws Exception {
		if (year < 1970) {
			throw new Exception("YEAR<1970");
		}
		return true;
	}
	
	public static boolean numberOfDays(int day,int month,int year) throws Exception{
		if(isLeap(year)){
			int[] days={31,29,31,30,31,30,31,31,30,31,30,31};
			if(days[month-1]<day){
				throw new Exception("INCCORECT NUMBER OF DAYS IN MONTH!");
			}
		}
		else{
			int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
			if(days[month-1]<day){
				throw new Exception("INCCORECT NUMBER OD DAYS IN MONTH!");
			}
		}
		return true;
	}

	public void menu() {
		Scanner in = new Scanner(System.in);
		// korisnik ima mogucnost da odabere 1. za ispis svih podsjetnika koje
		// je napravio
		// ili opciju 2. za prikaz kalendara
		String note = "";
		int addOption = 0;
		int menuOption = 0;
		boolean flag = true;
		while (true) {

			System.out.println("1.ckeck reminder\t2.print calendar\t3.exit");
			// provjera za unos menija
			while(true){
				try {
					menuOption = in.nextInt();
					isNegative(menuOption);
					greater3(menuOption);
					break;
				} catch (Exception e) {
					System.out.println("Please, enter again:");
					in.nextLine();
				}
			}
			// ako je odabir 1 izlistavamo podsjetnike iz fajla
			if (menuOption == 1) {
				printRemainder("remFile.txt");

				// ako je odabir 2, korisniku se pruza mogucnost prikaza
				// kalendara
				// za unijetu godinu i mjesec
			} else if (menuOption == 2) {
				int year = 0;
				int month = 0;
				// unos godine
				System.out.println("Enter a year:");
				while (true) {
					try {
						year = in.nextInt();
						isNegative(year);
						isValidYear(year);
						break;
					} catch (Exception e) {
						System.out.println("Please, enter again:");
						in.nextLine();
					}
				}
				// unos mjeseca
				System.out.println("Enter a month:");
				while (true) {
					try {
						month = in.nextInt();
						validMonth(month);
						break;
					} catch (Exception e) {
						System.out.println("Please, enter again:");
						in.nextLine();
					}
				}

				MyCalendar cal = new MyCalendar(year, month);
				cal.displayCalendar();

				System.out.println();
				System.out.println();
				// poslije prikaza kalendara ostavljamo mogucnosti 1. za
				// unos
				// novog
				// podsjetnika ili 2. za ponovno citanje kalendara i 3. za izlaz
				while (true) {
					System.out.println("1.Add note\t2.print calendar\t3.exit");
					// unos izbora
					while (true) {
						try {
							addOption = in.nextInt();
							isNegative(addOption);
							greater3(addOption);
							break;
						} catch (Exception e) {
							System.out.println("Please, enter again:");
							in.nextLine();
						}
					}
					// uzimamo informacije od korisnika kako bismo napravili
					// podsjetnik
					if (addOption == 1) {
						System.out.println("Enter a day:");
						int day = 0;
						while (true) {
							try {
								day = in.nextInt();
								isNegative(day);
								numberOfDays(day, month, year);
								break;
							} catch (Exception e) {
								System.out.println("Please, enter again:");
								in.nextLine();
							}
						}
						in.nextLine();
						System.out.println("Title:");
						String title = in.nextLine();
						System.out.println("Note:");
						note = in.nextLine();
						// ovo je novi podsjetnik kojeg dodajemo u fajl
						Reminder newRem = new Reminder(day, month, year, title, note);
						try {
							newRem.addReminder(day, month, year, title, note, "remFile.txt");
						} catch (Exception e) {
							e.printStackTrace();
						}
						// ponovo prikazujemo kalendar
					} else if (addOption == 2) {
						int year1 = 0;
						int month1 = 0;

						System.out.println("Enter a year:");
						while (true) {
							try {
								year1 = in.nextInt();
								isNegative(year1);
								isValidYear(year1);
								break;
							} catch (Exception e) {
								System.out.println("Please, enter again:");
								in.nextLine();
							}
						}

						System.out.println("Enter a month:");
						while (true) {
							try {
								month1 = in.nextInt();
								validMonth(month1);
								break;
							} catch (Exception e) {
								System.out.println("Please, enter again:");
								in.nextLine();
							}
						}

						MyCalendar cal1 = new MyCalendar(year1, month1);
						cal1.displayCalendar();

						System.out.println();
						System.out.println();

					} else if (addOption == 3) {
						System.exit(0);
					}
				}
			} else if (menuOption == 3) {
				System.exit(0);
			}
		}
	}
}
