package zadaci_22_02_2017;

import java.util.Scanner;

/*
 *  Napisati program koji igra sa protivnikom rock-paper-scissors.
 *  (papir-bunar-makaze ili tako nekako po naški) Program nasumièno generiše brojeve
 *  0, 1 i 2 koji predstavljaju papir, bunar i makaze.
 *  Program pita korisnika da unese 0, 1 ili 2 te mu ispisuje poruku da li je korisnik pobijedio,
 *  da li je raèunar pobijedio ili je bilo neriješeno. 
 * 
 * */
public class Zad2 {
	public static int genNum() {
		return (int) (Math.random() * 2 + 1);
	}

	public static boolean isValid(int x) throws Exception {
		if (x < 0 || x > 2) {
			throw new Exception("x<0||x>2");
		}
		return true;
	}

	public static int input() {
		Scanner in = new Scanner(System.in);
		int x = 0;
		while (true) {
			try {
				System.out.println("Scissor(0) Rock(1) paper(2) :");
				x = in.nextInt();
				isValid(x);
				break;
			} catch (Exception e) {
				System.out.println("Enter again.");
				in.nextLine();
			}
		}
		return x;

	}

	public static void main(String[] args) {
		int y = genNum();
		// System.out.println("genNum "+y);
		int x = input();
		if (y == 0 && x == 1)
			System.out.println("The computer is scissor. You are rock.You won!");
		else if (y == 0 && x == 2)
			System.out.println("The computer is scissor.You are paper.Computer won!");
		else if (y == 1 && x == 2)
			System.out.println("The computer is rock.You are paper.You won!");
		else if (y == 1 && x == 0)
			System.out.println("The computer is rock.You are scissor.Computer won!");
		else if (y == 2 && x == 0)
			System.out.println("The computer is paper.You are scissor.You won!");
		else if (y == 2 && x == 1)
			System.out.println("The computer is paper.You are rock.Computer won!");
		else if (x == y) {
			switch (x) {
			case 0:
				System.out.println("The computer is scissor.You are scissor.");
				break;
			case 1:
				System.out.println("The computer is rock.You are rock.");
				break;
			case 2:
				System.out.println("The computer is paper.You are paper.");
				break;
			default:
				System.out.println("Invalid number!");
				break;
			}
		}

	}

}
