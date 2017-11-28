package character;

import java.util.ArrayList;
import java.util.List;

public class Adjustment {
	int id;
	String name;
	String description;
	List<Adjust> adjustments;
	boolean active;
	List<Attack> attacks;
	List<Special> specialAttacks;
	List<Special> senses;
	List<Special> specials;
	List<Special> skillSpecials;
	List<Special> defenseSpecials;
	
	public Adjustment(int id) {
		this.id = id;
		name = "No Name";
		description = "";
		adjustments = new ArrayList<Adjust>();
		active = true;
		attacks = new ArrayList<Attack>();
		specialAttacks = new ArrayList<Special>();
		senses = new ArrayList<Special>();
		specials = new ArrayList<Special>();
		skillSpecials = new ArrayList<Special>();
		defenseSpecials = new ArrayList<Special>();
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
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(name);
		str.append(": ");
		str.append(description);
		for (Adjust adjust : adjustments) {
			str.append("\n" + adjust);
		}
		if (attacks.size() > 0) {
			str.append("\nAttacks:");
			for (Attack attack : attacks)
				str.append("\n" + attack.toString());
		}
		if (specialAttacks.size() > 0) {
			str.append("\nSpecial Attacks:");
			for (Special special : specialAttacks) {
				str.append("\n" + special.name);
			}
		}
		return str.toString();
	}
	
	/**
	 * This DOES NOT activate the adjustment automatically.
	 * 
	 * @param whatAdjust
	 * @param howAdjust
	 * @param adjustTo
	 */
	public void addAdjust(String whatAdjust, String howAdjust, int adjustTo) {
		adjustments.add(new Adjust(whatAdjust, id, decodeType(howAdjust), adjustTo));
	}
	
	public void deactivate(Character character) {
		active = false;
		if (character != null)
			character.deactivateAdjustment(id);
	}
	
	public void activate(Character character) {
		active = true;
		if (character != null)
			character.activateAdjustment(this);
	}

	public void addAttack(Stat attack, Stat damage, Stat BAB, String damageDice, String damageType, String name) {
		addAttack("Melee", attack, damage, 20, 2, BAB, damageDice, damageType, name);
	}
	
	public void addAttack(String type, Stat attack, Stat damage, int critLow, int critMult, Stat BAB, String damageDice,
			String damageType, String name) {
		Attack newAttack = new Attack(id, type, attack, damage, critLow, critMult, BAB, damageDice, damageType, name);
		attacks.add(newAttack);
	}

	public void addSense(String sense) {
		Special newSense = new Special(id, sense, "");
		senses.add(newSense);
	}

	public void addSpecial(String name, String description) {
		Special newSpecial = new Special(id, name, description);
		specials.add(newSpecial);
	}

	public void addSkillSpecial(String name, String description) {
		Special newSpecial = new Special(id, name, description);
		skillSpecials.add(newSpecial);
	}

	public void addAdjust(String whatAdjust, String howAdjust, Stat ability, String partOfStat, double d, int min) {
		adjustments.add(new StatAdjust(whatAdjust, id, decodeType(howAdjust), ability, partOfStat, d, min));
	}

	public void addDefenseSpecial(String name, String description) {
		Special newSpecial = new Special(id, name, description);
		defenseSpecials.add(newSpecial);
	}

	public String simpleString() {
		return name + ": " + description;
	}
}
