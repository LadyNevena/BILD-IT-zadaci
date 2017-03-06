package HangmanAndBattleshipGame;

public class TestBattleshipGame {

	public static void main(String[] args) {
		
		/*
		 * Tabla je velicine 10x10
		 * Na tabli su nasumicno rasporedjeni brodovi vertikalno ili horizontalno
		 * Svaki brod ima svoj naziv i duzinu polja koje zauzima
		 * Brodovi ne smiju zauzeti poziciju koju je neki drugi brod vec zauzeo
		 * Najprije je ispisana tabla na kojoj se vidi kako su brodovi rasporedjeni,
		 * kako bi bilo lakse testirati aplikaciju.
		 * Svaki brod je oznacen sa jednim brojem koji se uzastopno ponavlja, onoliko puta
		 * koliko brod zauzima pozicija. Npr. jedan brod je oznacen sa 1 1 1 1 1,
		 * to znaci da je brod zauzeo 4 polja u matrici vertikalno ili horizontalno.
		 * 
		 * Recimo, na 10x10 tabli ja sam unijela 7 brodova koje treba pogoditi
		 * Od kojih je jedan duzine 5, dva broda velicine 4, jedan velicine 3, jedan velicine 2,
		 * te dvije podmornice koje zauzimaju po jedno polje.
		 * 
		 * 
		 * Program je zamisljen da se zaustavi kada igrac pogodi sve brodove.
		 * 
		 * Pri svakom unosu vrste i kolone se prikazuje tabla  i poruka ako je brod pogodjen
		 * te poruka koliko je korisnik brodova unistio.
		 * 
		 * */
		
		
		Ship sh1 = new Ship("Brod5", 5);
		Ship sh2 = new Ship("Brod4", 4);
		Ship sh3 = new Ship("Brod4", 4);
		Ship sh4 = new Ship("Brod3", 3);
		Ship sh5 = new Ship("Brod2", 2);
		Ship sh6 = new Ship("Brod1", 1);
		Ship sh7 = new Ship("Brod1", 1);

		Ship[] ships = { sh1, sh2, sh3, sh4, sh5, sh6, sh7 };

		Board board = new Board(10, 10,ships);
		System.out.println("**Board with ships for testing aplication**");
		board.showBoard();
		System.out.println();
		System.out.println("**START for user**");
		System.out.println();
		board.play();

	}

}
