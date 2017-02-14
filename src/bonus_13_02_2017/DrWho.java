package bonus_13_02_2017;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
 * Napisati aplikaciju koja prima od korisnika unos (broj godina koji korisnik želi da se vrati u prošlost) te ispisuje korisniku broj:

	1. Sekundi, minuta i sati koliko bi trebalo putovati da se vrati do navedene godine u prošlosti.
	2. BONUS: Dana, mjeseci, godina koliko bi trebalo putovati da se vrati do navedene godine u prošlosti.
	3. BONUS: Decenija, stoljeæa, milenija koliko bi trebalo putovati da se vrati do navedene godine u prošlosti.

    Drugi naèin da dobijemo osjeæaj za duboko vrijeme je da zamislimo da nas jedan korak (~75 cm) vraæa 1 godinu u prošlost. Naša aplikacija treba da ispisuje i sljedeæe (za isti unos kao i gore):

	1. Broj centimetara, metara i kilometara koje bi trebalo prohodati da se vrati do navedene godine u prošlosti.
	2. Broj puta koliko bi prehodali prosjeèni fudbalski stadion (105 m)
	3. Broj puta koliko bi prehodali obim zemlje (obim zemlje: 40.075 km)
 * 
 * */

//Ovako, s obzirom da se trazi unos koliko se godina vracamo unazad, 
//cini mi se da je samim tim program mnogo pojednostavljen, jer ako se npr vratimo 
//3 godine, mi smo se zapravo vratili za jedan cijeli period od trenutka u sadasnjosti
//do trenutka u proslosti, pa bi 3g = 36 mjeseci = 1096 dana u zavisnosti da li je godina
//prestupna ili ne. Prica bi bila drugacija da se unosi godina 
//u koju se vracamo, onda bi imali ispis oblika godina, pa mjeseci pa dani koliko je ostalo, 
//jer od trenutka u sadasnjosti ne bi moralo znaciti da se vracamo u isti trenutak u proslosti ,vec
//je bitno samo da se pojavimo u godini u proslosti, valjda :)
//ovo sto se trazi u zadatku vise odgovara unosu godine u koju zelimo da se vratimo,
//nego koliko se godina vracamo u proslost
//pa mi je to stvorilo blagu konfuziju.
//Uglavnom, zadatak je uradjen sa unosom koliko se godina zelimo vratiti u proslost


//klasa je simbolicno nazvana Dr Who
public class DrWho {

	// pjeske racunanje trenutne godine, mjeseca i dana
	// na osnovu broja milisekundi proteklih od 1970 do danas
	public static int currentYear() {
		// koliko je milisekundi proslo od 1970.
		long millisec = System.currentTimeMillis();
		// milisekunde pretvorimo u sekunde
		long sec = millisec / 1000;
		// dan ima 86400 sekundi pa nadjemo koliko je dana proslo od 1970.
		long numOfDays = sec / 86400;
		int year = 1970;

		while (numOfDays > 0) {
			if (isLeapYear(year)) {
				numOfDays -= 366;
			} else {
				numOfDays -= 365;
			}
			if (numOfDays > 0) {
				year++;
			}
		}
		return year;
	}

	// provjera za prestupne godine
	public static boolean isLeapYear(int year) {
		if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public static int currentMonth() {
		// koliko je milisekundi proslo od 1970.
		long millisec = System.currentTimeMillis();
		// milisekunde pretvorimo u sekunde
		long sec = millisec / 1000;
		// dan ima 86400 sekundi pa nadjemo koliko je dana proslo od 1970.
		long numOfDays = sec / 86400;
		int month = 1;
		int year = currentYear();

		for (int i = 1970; i <= year; i++) {
			while (numOfDays > 0) {
				for (int j = 1; j <= 12; j++) {
					switch (j) {
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12: {
						numOfDays -= 31;
						month = j;
					}
						break;

					case 2: {
						if (isLeapYear(i)) {
							numOfDays -= 29;

						} else {
							numOfDays -= 28;
						}
						month = j;
					}
						break;

					case 4:
					case 6:
					case 9:
					case 11: {
						numOfDays -= 30;
						month = j;
					}
						break;

					default:
						System.out.println("Invalid month.");
						break;
					}
					if (numOfDays < 0) {
						break;
					}
				}
			}
		}
		return month;
	}

	public static int getTotalDays(int year, int month) {
		int days = 0;
		// koliko je dana proslo od 1970 do prvog mjeseca u trenutnoj godini
		for (int i = 1970; i < year; i++) {
			if (isLeapYear(i)) {
				days += 366;
			} else {
				days += 365;
			}
		}
		// dodajemo jos dane iz trenutnog mjeseca u godini
		for (int i = 1; i < month; i++) {
			days += getNumberOfDaysInMonth(year, i);
		}
		return days;
	}

	public static int getNumberOfDaysInMonth(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			return 31;

		if (month == 4 || month == 6 || month == 9 || month == 11)
			return 30;

		if (month == 2)
			return isLeapYear(year) ? 29 : 28;
		return 0;
	}

	public static int currentDay() {
		long millisec = System.currentTimeMillis();
		long sec = millisec / 1000;
		/*
		 * koliko je ukupno proslo dana od 1.1.1970 do danas
		 */
		long numOfDays = sec / 86400;
		/*
		 * od tog ukupnog broja dana do trenutnog dana u godini oduzmemo ukupan
		 * broj dana do tog mjeseca u godini
		 */
		int day = 1 + (int) (numOfDays) - getTotalDays(currentYear(), currentMonth());
		return day;
	}

	// dani koji su protekli izmedju tekuce i godine u koju se vracamo
	public static long days(long numOfYears) {
		//ukupno dana u tekucoj godini
		long daysInCurrentYear=0;
		for (int i = 1; i < currentMonth(); i++) {
			daysInCurrentYear+=getNumberOfDaysInMonth(currentYear(), i);
		}
		daysInCurrentYear+=currentDay();

		long res=daysInCurrentYear;
		int i=0;
		for (i = currentYear() - 1; i > (currentYear() - numOfYears); i--) {
			if (isLeapYear(i)) {
				res += 366;
			} else {
				res += 365;
			}
		}
		//provjera za godinu iz proslosti 
		if (isLeapYear(i)) {
			res += 366-daysInCurrentYear;
		} else {
			res += 365-daysInCurrentYear;
		}
		// i moramo oduzeti dane iz tekuce godine
		return res;
	}

	// mjeseci koji su protekli od tekuce do navedene godine
	public static long months(long numOfYears) {
		return numOfYears*12;
	}

	// godina u koju se vracamo
	public static long year(long numOfYears) {
		return currentYear() - numOfYears;
	}

	public static long seconds(long numOfYears) {
		// ukupno dana koliko je proslo dana 
		return days(numOfYears)*24*60*60;
	}
	//ukupno minuta
	public static long minutes(long numOfYears) {

		return days(numOfYears) *24*60;
	}
	//ukupno sati
	public static long hours(long numOfYears) {
		return days(numOfYears)*24;
	}
	//dekade
	public static long decade(long numOfYears){
		return numOfYears/10;
	}
	//stoljece
	public static long century(long numOfYears){
		return numOfYears/100;
	}
	//milenijum
	public static long millenium(long numOfYears){
		return numOfYears/1000000;
	}
	//centimetri
	public static long centimeters(long numOfYears){
		//75 cm nas vraca godinu u proslost
		return 75*numOfYears;
	}
	//metri
	public static double meters(long numOfYears){
		//75 cm nas vraca godinu u proslost
		//75 cm = 0.75 m
		return 0.75*numOfYears;
	}
	//kilometri
	public static double kilometers(long numOfYears){
		//75 cm nas vraca godinu u proslost
		//75 cm = 0.75m = 0.00075
		return 0.00075*numOfYears;
	}
	//teren fudbalski
	public static double field(long numOfYears){
		//stadion 105m = 105*100 = 10500cm 
		//10500/75 = 140 godina
		//105m bismo presli za 140 godina;
		//dijelimo godine sa 140, jer na svakih 140 godina mi predjemo stadion
		return numOfYears/140;
	}
	//obim zemlje
	public static double volumeEarth(long numOfYears){
		//40075km = 40075000m = 4007500000cm
		//4007500000/75 je priblizno 53433333 godina
		//obim zemlje bismo prehodali za otprilike 53433333 godina
		//dijelimo godine sa 53433333, jer na svakih 53433333 mi obidjemo zemlju
		return numOfYears/53433333;
	}
	public static boolean negative(long n) throws Exception{
		if(n<0){
			throw new Exception("NEGATIVE.");
		}
		return false;
	}
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		long numOfYears=0;
		while(true){
			try{
				System.out.println("Unesite broj svj. godina:");
				numOfYears=in.nextLong();
				negative(numOfYears);
				break;
			}catch(Exception e){
				System.out.println("Ponovite unos.");
				in.nextLine();
			}
		}
		System.out.println("Vracamo se unazad "+numOfYears+" godina/e "+", to je "+months(numOfYears)+" mjeseci, odnosno "+days(numOfYears)+" dana.");
		System.out.println("Od trenutka u proslosti smo udaljeni : "+ hours(numOfYears)+" sati , odnosno "+minutes(numOfYears)+" minuta, odnosno "+seconds(numOfYears)+" sekundi");
		System.out.println("Unazad se vracamo "+millenium(numOfYears)+" milenijuma ,odnosno "+century(numOfYears)+" stoljeca ,odnosno "+decade(numOfYears)+" decenija");
		System.out.println("75 cm nas vraca jednu godinu. "+numOfYears+" godina je "+kilometers(numOfYears)+" kilometara, odnosno "+meters(numOfYears)+" metara, odnosno "+centimeters(numOfYears)+" centimetara");
		System.out.println("Koliko puta prehodamo stadion od 105 m ? "+field(numOfYears));
		System.out.println("Koliko puta bi prehodali obim zemlje? "+volumeEarth(numOfYears));
		in.close();
	}
}
