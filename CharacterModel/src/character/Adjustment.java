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
		int action = decodeType(type);
		
		Adjust newAdjustment = new Adjust(stat, id, action, value);
		
		character.addAbilityScoreAdjust(stat, newAdjustment);
		adjustments.add(newAdjustment);
	}

	private int decodeType(String type) {
		switch (type.toLowerCase()) {
		case "set":
			return 0;
		case "add":
			return 1;
		case "subtract":
			return 2;
		case "class skill":
			return 3;
		default:
			return - 1;
		}
	}
	
	public void addAdjustSkill(String skill, String type, int value, Character character) {
		int action = decodeType(type);
		if (action == 3)
			character.addClassSkill(skill);
		
		Adjust newAdjustment = new Adjust(skill, id, action, value);
		
		character.addAdjustSkill(skill, newAdjustment);
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

	public void changeType(String newType, Character character) {
		Adjust newAdjustment = new Adjust("type", id, newType);
		
		character.setType(newType);
		adjustments.add(newAdjustment);
	}

	public void setSize(int size, Character character) {
		Adjust newAdjustment = new Adjust("size", id, 0, size);
		
		character.setSize(size);
		adjustments.add(newAdjustment);
	}

	public void addAdjustSpeed(String type, int value, Character character) {
		int action = decodeType(type);
		
		Adjust newAdjustment = new Adjust("speed", id, action, value);
		
		character.addAdjustSpeed(newAdjustment);
		adjustments.add(newAdjustment);
	}

	public void addAdjustInitiative(String type, int value, Character character) {
		int action = decodeType(type);
		
		Adjust newAdjustment = new Adjust("Initiative", id, action, value);
		
		character.addAdjustInitiative(newAdjustment);
		adjustments.add(newAdjustment);
	}

	public void addSenses(String type, String description, Character character) {
		Adjust newAdjustment = new Adjust(type, id, description);
		
		character.addSense(newAdjustment);
		adjustments.add(newAdjustment);
		
	}
}
