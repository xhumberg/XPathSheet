package character;

public class Dice {
	String dice;
	String description;
	
	public Dice(String dice, String description) {
		this.dice = dice;
		this.description = description;
	}
	
	public String toString() {
		return dice + " " + description;
	}
	
	//TODO: Resize logic happens in here.
}
