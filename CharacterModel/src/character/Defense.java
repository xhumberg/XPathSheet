package character;

public class Defense {
	Armor AC;
	Health HP;
	Skill fortSave;
	Skill refSave;
	Skill willSave;
	
	public Defense(Abilities abilities, Details details) {
		AC = new Armor(details.size, abilities.get("dex"), abilities.get("str"));
		HP = new Health(abilities.get("con"));
		fortSave = new Skill(abilities.get("con"), false);
		refSave = new Skill(abilities.get("dex"), false);
		willSave = new Skill(abilities.get("wis"), false);
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
			}
		}
	}
	
	public void deactivateAdjustment(int id) {
		AC.deactivateAdjustment(id);
		HP.removeAdjust(id);
		fortSave.removeAdjust(id);
		refSave.removeAdjust(id);
		willSave.removeAdjust(id);
		
	}
}
