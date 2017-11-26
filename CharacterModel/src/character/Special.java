package character;

public class Special {
	String name;
	String description;
	private int id;
	
	public Special(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getID() {
		return id;
	}
	
	public String toString() {
		return id + " - " + name + ": " + description;
	}
}
