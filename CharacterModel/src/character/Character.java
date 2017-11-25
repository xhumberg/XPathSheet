package character;

import java.util.ArrayList;
import java.util.List;

public class Character {
	private Abilities abilities;
	private Skills skills;
	private Details character;
	private Offense offense;
	private Defense defense;
	private Equipment equipment;
	private Spellstuffs spells;
	
	/*
	 * Alignment
	 */
	private boolean lawful;
	private boolean chaotic;
	private boolean good;
	private boolean evil;

	public Character() {
		this.initialize(10, 10, 10, 10, 10, 10);
	}
	public Character(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
		this.initialize(strength, dexterity, constitution, intelligence, wisdom, charisma);
	}
	public void initialize(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
		abilities = new Abilities(strength, dexterity, constitution, intelligence, wisdom, charisma);
		skills = new Skills(abilities);
		character = new Details("No Name", 'X', "Medium", "No Favored Class Selected", "No type set");
		offense = new Offense(abilities, character);
		defense = new Defense(abilities, character);
		equipment = new Equipment();		
		lawful = false;
		chaotic = false;
		good = false;
		evil = false;
	}
	
	public String getAlignment() {
		StringBuilder str = new StringBuilder();
		
		if (lawful)
			str.append("L");
		else if (chaotic)
			str.append("C");
		else
			str.append("N");
		
		if (good)
			str.append("G");
		else if (evil)
			str.append("E");
		else {
			if (!str.toString().equals("N"))
				str.append("N");
		}
		
		return str.toString();
	}
	public void setAlignment(boolean lawful, boolean chaotic, boolean good, boolean evil) {
		this.lawful = false;
		this.chaotic = false;
		if (lawful)
			this.lawful = true;
		else if (chaotic)
			this.chaotic = true;
		
		this.good = false;
		this.evil = false;
		if (good)
			this.good = true;
		else if (evil)
			this.evil = true;
	}

	/*
	 * STRING METHODS
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(line() + "\n");
		str.append(character.name + "\n");
		str.append(line() + "\n");
		str.append(race().toString().split(":")[0] + " ");
		str.append(getClassString() + "\n");
		str.append(getAlignment() + " " + getSizeString() + " " + character.type + "\n");
		str.append("Init: " + (offense.initiative.getBonus() < 0 ? "" : "+") + offense.initiative.getBonus() + "; Senses: ");
		str.append(character.getSenses());
		str.append("\nPerception " + (skills.getSkill("perception").getBonus() < 0 ? "" : "+") + skills.getSkill("perception").getBonus() + "\n");
		
		str.append("\n" + line() + "\n");
		str.append("DEFENSE" + "\n");
		str.append(line() + "\n");
		str.append(defense + "\n");
		
		str.append("\n" + line() + "\n");
		str.append("OFFENSE" + "\n");
		str.append(line() + "\n");
		str.append(offense + "\n");
		
//		str.append("Spells:\n");
//		if (spells != null) {
//			str.append(spells.listPrepared());
//		}
		
		
		str.append("\n" + line() + "\n");
		str.append("STATISTICS" + "\n");
		str.append(line() + "\n");
		str.append(abilities + "\n");
		str.append("Feats: ");
		str.append(character.featList() + "\n");
		str.append(skills + "\n");
		return str.toString();
	}
	private String getClassString() {
		return character.getClassesString();
	}
	private String getSizeString() {
		switch (character.size.getBase()) {
		case -1:
			return "Small";
		case -2:
			return "Tiny";
		case -4:
			return "Diminutive";
		case -8:
			return "Fine";
		case 0:
			return "Medium";
		case 1:
			return "Large";
		case 2:
			return "Huge";
		case 4:
			return "Gargantuan";
		case 8:
			return "Colossal";
		default:
			return "INVALID SIZE";
		}
	}
	private String line() {
		return "----------------------------------------";
	}

	public void deactivateAdjustment(int id) {
		// TODO Auto-generated method stub
		
	}

	public void activateAdjustment(Adjustment adjustment) {
		abilities.activateAdjustment(adjustment);
		skills.activateAdjustment(adjustment);
		offense.activateAdjustment(adjustment);
		defense.activateAdjustment(adjustment);
	}
	public void setName(String name) {
		character.name = name;
	}
	public Adjustment race() {
		return character.getRace();
	}
	public Stat ability(String string) {
		return abilities.get(string);
	}
	public void setType(String type) {
		character.type = type;
	}




}
