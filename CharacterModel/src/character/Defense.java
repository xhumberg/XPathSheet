package character;

import java.util.ArrayList;
import java.util.List;

public class Defense {
	Armor AC;
	Health HP;
	Skill fortSave;
	Skill refSave;
	Skill willSave;
	List<Special> defenseSpecials;
	
	public Defense(Abilities abilities, Details details) {
		AC = new Armor(details.size, abilities.get("dex"), abilities.get("str"));
		HP = new Health(abilities.get("con"));
		fortSave = new Skill(abilities.get("con"), false);
		refSave = new Skill(abilities.get("dex"), false);
		willSave = new Skill(abilities.get("wis"), false);
		defenseSpecials = new ArrayList<Special>();
	}
	
	public void activateAdjustment(Adjustment adjustment) {
		AC.activateAdjustment(adjustment);
		for (Adjust adjust : adjustment.adjustments) {
			switch (adjust.getWhatAdjust().toLowerCase()) {
			case "hp":
				HP.addAdjust(adjust);
				continue;
			case "fort":
			case "fort save":
			case "fortitude":
			case "fortitude save":
				fortSave.addAdjust(adjust);
				continue;
			case "ref":
			case "ref save":
			case "reflex":
			case "reflex save":
				refSave.addAdjust(adjust);
				continue;
			case "will":
			case "will save":
				willSave.addAdjust(adjust);
				continue;
			case "saving throws":
			case "saves":
				fortSave.addAdjust(adjust);
				willSave.addAdjust(adjust);
				refSave.addAdjust(adjust);
				continue;
			}
		}
		for (Special special : adjustment.defenseSpecials) {
			defenseSpecials.add(special);
		}
	}
	
	public void deactivateAdjustment(int id) {
		AC.deactivateAdjustment(id);
		HP.removeAdjust(id);
		fortSave.removeAdjust(id);
		refSave.removeAdjust(id);
		willSave.removeAdjust(id);
		int i = 0;
		while (i < defenseSpecials.size()) {
			if (defenseSpecials.get(i).getID() == id) {
				defenseSpecials.remove(i);
				continue;
			}
			i++;
		}
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(AC + "\n");
		str.append(HP + "\n");
		str.append("Fort: ");
		str.append(fortSave.getBonus());
		str.append(", Ref: ");
		str.append(refSave.getBonus());
		str.append(", Will: ");
		str.append(willSave.getBonus());
		str.append("\n");
		for (Special special : defenseSpecials) {
			str.append(Character.wordWrap(special.toString(), " ", 180) + "\n");
		}
		return str.toString();
	}
}
