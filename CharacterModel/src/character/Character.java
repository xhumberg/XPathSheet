package character;

import java.util.ArrayList;
import java.util.List;

public class Character {
	private String name;
	private boolean lawful;
	private boolean chaotic;
	private boolean good;
	private boolean evil;
	private Stat strength;
	private Stat dexterity;
	private Stat constitution;
	private Stat intelligence;
	private Stat wisdom;
	private Stat charisma;
	private List<Adjustment> adjustments;
	private int newAdjustmentIndex;
	
	public Character() {
		name = "No Name";
		lawful = false;
		chaotic = false;
		good = false;
		evil = false;
		strength = new Stat();
		dexterity = new Stat();
		constitution = new Stat();
		intelligence = new Stat();
		wisdom = new Stat();
		charisma = new Stat();
		adjustments = new ArrayList<Adjustment>();
		newAdjustmentIndex = 0;
	}
	
	public int getAbilityScore(String ability) {
		switch(ability.toLowerCase()) {
		case "strength":
			return strength.getScore();
		case "dexterity":
			return dexterity.getScore();
		case "constitution":
			return constitution.getScore();
		case "intelligence":
			return intelligence.getScore();
		case "wisdom":
			return wisdom.getScore();
		case "charisma":
			return charisma.getScore();
		}
		return -404;
	}
	
	public void setAbilityScoreBase(String ability, int newBase) {
		switch(ability.toLowerCase()) {
		case "strength":
			strength.setBase(newBase);
			return;
		case "dexterity":
			dexterity.setBase(newBase);
			return;
		case "constitution":
			constitution.setBase(newBase);
			return;
		case "intelligence":
			intelligence.setBase(newBase);
			return;
		case "wisdom":
			wisdom.setBase(newBase);
			return;
		case "charisma":
			charisma.setBase(newBase);
			return;
		}
	}	
	
	public void setAbilityScoreTemp(String ability, int newTemp) {
		switch(ability.toLowerCase()) {
		case "strength":
			strength.setTemp(newTemp);
			return;
		case "dexterity":
			dexterity.setTemp(newTemp);
			return;
		case "constitution":
			constitution.setTemp(newTemp);
			return;
		case "intelligence":
			intelligence.setTemp(newTemp);
			return;
		case "wisdom":
			wisdom.setTemp(newTemp);
			return;
		case "charisma":
			charisma.setTemp(newTemp);
			return;
		}
	}

	public void addAbilityScoreAdjust(String ability, Adjust adjustment) {
		switch(ability.toLowerCase()) {
		case "strength":
			strength.addAdjust(adjustment);
			return;
		case "dexterity":
			dexterity.addAdjust(adjustment);
			return;
		case "constitution":
			constitution.addAdjust(adjustment);
			return;
		case "intelligence":
			intelligence.addAdjust(adjustment);
			return;
		case "wisdom":
			wisdom.addAdjust(adjustment);
			return;
		case "charisma":
			charisma.addAdjust(adjustment);
			return;
		}
	}
	
	public String getAlignment() {
		StringBuilder str = new StringBuilder();
		
		if (lawful)
			str.append("Lawful ");
		else if (chaotic)
			str.append("Chaotic ");
		else
			str.append("Neutral ");
		
		if (good)
			str.append("Good");
		else if (evil)
			str.append("Evil");
		else {
			if (str.toString().equals("Neutral ")) {
				str.delete(0, str.length());
				str.append("True Neutral");
			}
			else
				str.append("Neutral");
		}
		
		return str.toString();
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(name + "\n");
		str.append(getAlignment() + "\n");
		str.append("STR: " + strength + "\n");
		str.append("DEX: " + dexterity + "\n");
		str.append("CON: " + constitution + "\n");
		str.append("INT: " + intelligence + "\n");
		str.append("WIS: " + wisdom + "\n");
		str.append("CHA: " + charisma + "\n");
		for (Adjustment adjustment : adjustments) {
			str.append(adjustment + "\n");
		}
		return str.toString();
	}


	public void setName(String name) {
		this.name = name;
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

	Adjustment createAdjustment() {
		Adjustment newAdj = new Adjustment(newAdjustmentIndex);
		newAdjustmentIndex++;
		adjustments.add(newAdj);
		return newAdj;
	}
}
