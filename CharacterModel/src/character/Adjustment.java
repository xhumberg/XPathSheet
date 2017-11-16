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
			return;
		}
		
		Adjust newAdjustment = new Adjust(stat, id, action, value);
		
		character.addAbilityScoreAdjust(stat, newAdjustment);
		adjustments.add(newAdjustment);
	}

	public void addAdjustSkill(String skill, String type, int value, Character character) {
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
		case "class skill":
			action = 3;
			character.addClassSkill(skill);
		default:
			return;
		}
		
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

	public void changeType(String newType, Character gnome) {
		Adjust newAdjustment = new Adjust("type", id, newType);
		
		gnome.setType(newType);
		adjustments.add(newAdjustment);
	}
}
