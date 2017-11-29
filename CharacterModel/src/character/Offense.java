package character;

import java.util.ArrayList;
import java.util.List;

public class Offense {
	private Stat strength;
	private Stat size;
	Skill initiative;
	Stat BAB;
	Stat attackBonus;
	Stat damageBonus;
	List<Attack> attacks;
	Stat landSpeed;
	Stat swimSpeed;
	Stat flySpeed;
	Stat climbSpeed;
	Stat burrowSpeed;
	List<Special> specialAttacks;
	
	public Offense(Abilities abilities, Details character) {
		size = character.size;
		strength = abilities.get("Strength");
		attacks = new ArrayList<Attack>();
		specialAttacks = new ArrayList<Special>();
		initiative = new Skill(abilities.get("Dexterity"), false);
		BAB = new Stat(0);
		landSpeed = new Stat(30);
		swimSpeed = new Stat(0);
		flySpeed = new Stat(0);
		climbSpeed = new Stat(0);
		burrowSpeed = new Stat(0);
		attackBonus = new Stat(0);
		damageBonus = new Stat(0);
	}
	
	public int CMB() {
		return strength.getMod() + BAB.getScore() + size.getScore();
	}
	
	private void removeAttacks(int id) {
		int i = 0;
		while (i < attacks.size()) {
			if (attacks.get(i).id == id) {
				attacks.remove(i);
				continue;
			}
			i++;
		}
	}
	
	public void deactivateAdjustment(int id) {
		removeAttacks(id);
		removeSpecials(id);
		BAB.removeAdjust(id);
		initiative.removeAdjust(id);
		landSpeed.removeAdjust(id);
		swimSpeed.removeAdjust(id);
		flySpeed.removeAdjust(id);
		climbSpeed.removeAdjust(id);
		burrowSpeed.removeAdjust(id);
		attackBonus.removeAdjust(id);
		damageBonus.removeAdjust(id);
	}

	private void removeSpecials(int id) {
		int i = 0;
		while (i < specialAttacks.size()) {
			if (specialAttacks.get(i).getID() == id) {
				specialAttacks.remove(i);
				continue;
			}
			i++;
		}
	}
	
	public void activateAdjustment(Adjustment adjustment) {
		deactivateAdjustment(adjustment.id);
		for (Adjust adjust : adjustment.adjustments) {
			switch(adjust.getWhatAdjust().toLowerCase()) {
			case "attack":
				attackBonus.addAdjust(adjust);
				continue;
			case "damage":
				damageBonus.addAdjust(adjust);
				continue;
			case "initiative":
				initiative.addAdjust(adjust);
				continue;
			case "bab":
				BAB.addAdjust(adjust);
				continue;
			case "land speed":
			case "speed":
				landSpeed.addAdjust(adjust);
				continue;
			case "climb speed":
				climbSpeed.addAdjust(adjust);
				continue;
			case "fly speed":
				flySpeed.addAdjust(adjust);
				continue;
			case "swim speed":
				swimSpeed.addAdjust(adjust);
				return;
			case "burrow speed":
				burrowSpeed.addAdjust(adjust);
				continue;
			}
		}
		for (Attack attack : adjustment.attacks) {
			attacks.add(attack);
		}
		for (Special specialAttack : adjustment.specialAttacks) {
			specialAttacks.add(specialAttack);
		}
		propogateBonuses();
	}

	
	private void propogateBonuses() {
		for (Attack attack : attacks) {
			attack.attackBonus = attackBonus;
			attack.damageBonus = damageBonus;
		}
	}

	public int getInitiative() {
		return initiative.getBonus();
	}
	
	public int speed() {
		return landSpeed.getScore();
	}

	public Object getAttack(String contains) {
		StringBuilder str = new StringBuilder();
		for (Attack attack : attacks) {
			if (attack.name.contains(contains))
				str.append(attack + "\n");
		}
		if (str.length() > 1)
			return str.substring(0, str.length()-1);
		return str.toString();
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Speed: " + speed() + " ft.\n");
		boolean isMelee = false;
		for (Attack attack : attacks)
			if (attack.isMelee()) {
				isMelee = true;
				break;
			}
		if (isMelee)
			str.append("Melee: \n");
		
		for (Attack attack : attacks) {
			if (attack.isMelee())
				str.append(attack + "\n");
		}
		boolean isRanged = false;
		for (Attack attack : attacks)
			if (!attack.isMelee()) {
				isRanged = true;
				break;
			}
		if (isRanged)
			str.append("Ranged: \n");
		for (Attack attack : attacks) {
			if (!attack.isMelee())
				str.append(attack + "\n");
		}
		
		for (Special specialAttack : specialAttacks) {
			str.append(Character.wordWrap(specialAttack.toString(), " ", 180) + "\n");
		}
		return str.toString();
	}
}
