package HangmanAndBattleshipGame;

import java.util.Scanner;

public class Hangman {
	// replace all chars in secret word with *
	public static String secretWord(String s) {
		for (int i = 0; i < s.length(); i++) {
			s = s.replace(s.charAt(i), '*');
		}
		return s;
	}

	// check if the character is in the word
	public static boolean inWord(String s, char c) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == Character.toLowerCase(c)) {
				return true;
			}
		}
		return false;
	}

	// return win if the answer is equal to the word
	public static boolean checkAnswer(String word, String answer) {
		return word.equals(answer.toLowerCase());
	}

	// return true if user input character
	public static boolean isCharacter(String word) {
		return word.length() == 1;
	}

	// replace all chars in word with user's input
	public static String replace(String s, int x, char c) {
		String replaced = "";
		for (int i = 0; i < s.length(); i++) {
			if (i != x) {
				replaced += s.charAt(i);
			} else {
				replaced += Character.toLowerCase(c);
			}
		}
		return replaced;
	}

	// if user input number return message to try again
	public static boolean containToken(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (!Character.isLetter(word.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	// continue game if user enter y for yes or break for n as no
	public static char continueGame(Scanner in) {
		String answer = "";
		while (true) {
			try {
				answer = in.nextLine();
				if (answer.length() != 1 || (answer.charAt(0) != 'y' && answer.charAt(0) != 'n')) {
					throw new Exception("incorrect input");
				}
				break;
			} catch (Exception e) {
				System.out.println("Please, enter y to continue, or n to stop game.");
			}
		}
		return answer.charAt(0);
	}

	// print hangman
	public static void printHangman(int missed) {

		String[] message = { "head", "body", "left arm", "right arm", "left leg", "right leg" };

		System.out.println("I'm drawing " + message[missed]+"...");

	}

	// valid input if user enter word or char
	public static String validInput(Scanner in) {
		String answer = "";
		while (true) {
			try {
				answer = in.nextLine();
				if (containToken(answer)) {
					throw new Exception("incorrect input");
				}
				break;
			} catch (Exception e) {
				System.out.println("Please, enter one letter or one word.");
			}
		}
		return answer;
	}

	// main function
	public static void main(String[] args) {
		/*
		 * Igrac pogadja rijec.
		 * Dozvoljeno je unijeti rijec, ako je pogodjena program objavljuje pobjedu.
		 * Dozvoljeno je unijeti slovo, pri cemu program ispisuje pogodak ili mu "crta" dio hangmana
		 * Ako korisnik unese nesto cudnovato, program ga zamoli da ponovi unos.
		 * Takodje ako je zamisljena rijec npr java, a korisnik je unio Java ili recimo JAVA,
		 * program mu priznaje pogodak
		 * 
		 *Korisnik nakon kraja igre moze unijeti y i n da nastavi odnosno prekine dalje igranje.
		 *
		 * */
		Scanner in = new Scanner(System.in);
		String[] words = { "write", "that", "program", "beer", "java", "chocolate" };
		int missed = 0;
		char answer = 'y';
		String guess = "";
		do {
			// generate index of secret word
			int index = (int) (Math.random() * words.length);
			String s = words[index];
			// replace chars with *
			String s1 = secretWord(s);

			while (!s1.equals(s) && missed < 6) {
				System.out.println("Enter a letter in word or guess the word: " + s1);
				guess = validInput(in);

				if (!isCharacter(guess)) {
					// if user enter the word
					if (checkAnswer(s, guess)) {
						System.out.println("You won.");
						break;
					} else {
						System.out.println("You missed!");
						printHangman(missed);
						missed++;
					}

				} else {
					// char as an input
					if (inWord(s, guess.charAt(0))) {
						for (int i = 0; i < s.length(); i++) {
							if (s.charAt(i) == Character.toLowerCase(guess.charAt(0)) && s1.charAt(i) == '*') {
								s1 = replace(s1, i, guess.charAt(0));
							} else if (s.charAt(i) == Character.toLowerCase(guess.charAt(0))
									&& s1.charAt(i) == Character.toLowerCase(guess.charAt(0))) {
								System.out.println(guess + " is already in the word.");
							}
						}
					} else {
						System.out.println(guess + " is not in the word.");
						printHangman(missed);
						missed++;
					}

				}
			}
			System.out.println();
			System.out.println("The word is " + s);
			if (missed == 1) {
				System.out.println("You missed " + missed + " time.");
			} else {
				System.out.println("You missed " + missed + " times.");
			}
			System.out.println();
			System.out.println("Do you want to guess another word? y or n?");
			answer = continueGame(in);
			missed=0;
		} while (answer == 'y');

		in.close();
	}
}
