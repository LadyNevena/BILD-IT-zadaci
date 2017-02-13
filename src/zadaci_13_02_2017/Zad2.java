package zadaci_13_02_2017;

/*
 * Napisati program koji simulira nasumièno izvlaèenje karte iz špila od 52 karte.
 * Program treba ispisati koja karta je izvuèena (A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q ili K) 
 * te znak u kojem je data karta (Srce, Pik, Djetelina, Kocka). 
 * Primjer: Karta koju ste izvukli je 10 u znaku kocke.
 * */
public class Zad2 {

	public static int[] shuffleDeck(int[] deck) {
		for (int i = 0; i < deck.length; i++) {
			int index = (int) (Math.random() * deck.length);
			int temp = i;
			deck[i] = deck[index];
			deck[index] = deck[temp];
		}
		return deck;
	}

	public static void main(String[] args) {
		int[] deck = new int[52];
		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
		String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
		// initialize the cards
		for (int i = 0; i < deck.length; i++) {
			deck[i] = i;
		}
		// promijesamo spil karata
		shuffleDeck(deck);
		// odaberemo neki indeks od [0,51]
		int i = (int) (Math.random() * 52);
		// izbor znaka [0,3]
		String suit = suits[deck[i] / 13];
		// izbor slike [0,12]
		String rank = ranks[deck[i] % 13];
		System.out.println(rank + " of " + suit);
	}

}
