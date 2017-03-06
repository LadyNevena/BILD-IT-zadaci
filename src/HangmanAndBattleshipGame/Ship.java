package HangmanAndBattleshipGame;

public class Ship {
	private String name;
	private int length;

	Ship() {
	}

	Ship(String name, int lenght) {
		this.name = name;
		this.length = lenght;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
}
