package zadaci_23_02_2017;

import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 *  Napisati metodu koja vraæa datum i trenutaèno vrijeme.
 * */
public class Zad4 {
	//racuna vrijeme za bilo koju zonu, mi smo u zoni 1
		public static String showCurrentTimeZone(int zone) {
			long millisec = System.currentTimeMillis();
			/*
			 * Npr zona je 5 to znaci da na UTC sate dodajemo jos 5 sati tj. nadjemo
			 * ukupno sekundi pa na to dodamo 5 sati pretvoreno u sekunde sto iznosi
			 * 5*60*60
			 */
			long sec = millisec / 1000 + zone * 60 * 60;
			long currentSec = sec % 60;
			long min = sec / 60;
			long currentMin = min % 60;
			long hour = min / 60;
			long currentHour = hour % 24;
			String time = Long.toString(currentHour) + ":" + Long.toString(currentMin) + ":" + Long.toString(currentSec);
			return time;
		}
	public static void printDateTime() {
		long millisec = System.currentTimeMillis();
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeInMillis(millisec);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;// jer ovdje mjeseci idu od 0
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		String[] mjeseci = { "januar", "februar", "mart", "april", "maj", "jun", "juli", "avgust", "septembar",
				"oktobar", "novembar", "decembar" };
		System.out.println(day + ". " + mjeseci[month - 1] + ", " + year + " " + showCurrentTimeZone(1));
	}
	public static void main(String[] args) {
	
		printDateTime();

	}

}
