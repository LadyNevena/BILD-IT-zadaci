package kalendarMini1;


/*
 * Program radi sa fajlovima. Prilikom pokretanja programa korisnik moze da
 * 1. procita podsjetnike iz fajla
 * 2. pogleda kalendar
 * 3. prekine program 
 * 
 * Ako je opcija 1., nakon prikaza podsjetnika , ponovo ima mogucnost da izlista podsjetnike,
 * pogleda kalendar, ili da izadje 
 * 
 * Ako je opcija 2., unosi godinu, mjesec i prikazuje mu se kalendar
 * onda mu se ponudi mogucnost da za taj mjesec i godinu (dakle kada je otvorio kalendar)
 * napravi podsjetnik. Ako ne zeli, moze da odabere neki drugi kalendar i ponovi radnju 
 * ili da izadje iz programa
 * 
 * */
public class TestMyCalendar {

	public static void main(String[] args) {
		
		MyCalendar cal = new MyCalendar();
		cal.menu();
		
		
		

	}

}
