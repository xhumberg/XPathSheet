package character;

import java.util.ArrayList;
import java.util.List;

public class Adjustment {
	int id;
	String name;
	String description;
	boolean active;
	List<Adjust> adjustments;
	
	public Adjustment(int id) {
		this.id = id;
		active = true;
		name = "No Name";
		description = "";
		adjustments = new ArrayList<Adjust>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addAdjustStat(String stat, String type, int value, Character character) {
		int action;
		switch (type.toLowerCase()) {
		case "set":
			action = 0;
			break;
		case "add":
			action = 1;
			break;
		case "subtract":
			action = 2;
			break;
		default:
			action = 1;
			break;
		}
		
		Adjust newAdjustment = new Adjust(stat, id, action, value);
		
		character.addAbilityScoreAdjust(stat, newAdjustment);
		adjustments.add(newAdjustment);
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(name);
		str.append(": ");
		str.append(description);
		for (Adjust adjust : adjustments) {
			str.append("\n" + adjust);
		}
		return str.toString();
	}
}
