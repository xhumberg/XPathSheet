package character;

import java.util.ArrayList;
import java.util.List;

public class Health {
	private int hitDice;
	private int lethalDamage;
	private int nonLethalDamage;
	private Stat con;
	private List<Adjust> adjustments;
	
	public Health(Stat con) {
		this.con = con;
		lethalDamage = 0;
		nonLethalDamage = 0;
		hitDice = 0;
		adjustments = new ArrayList<Adjust>();
	}
	
	public void fullHeal() {
		lethalDamage = 0;
		nonLethalDamage = 0;
	}
	
	public void addHitDice(Adjust adjustment) {
		adjustments.add(adjustment);
		hitDice++;
	}
	
	public void addHealthAdjust(Adjust adjustment) {
		adjustments.add(adjustment);
	}
	
	public int getMaxHealth() {
		int result = hitDice * con.getMod();
		for(Adjust adjust : adjustments) {
			result = adjust.applyAdjustment(result);
		}
		return result;
	}
	
	public int getCurrentHealth() {
		int healthLethal = getMaxHealth() - lethalDamage;
		if (healthLethal <= 0)
			return healthLethal;
		return Math.max(0, healthLethal - nonLethalDamage);
	}
	
	public void damageLethal(int damage) {
		lethalDamage += damage;
	}
	
	public void damageNonLethal(int damage) {
		nonLethalDamage += damage;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("HP: ");
		str.append(getCurrentHealth());
		str.append("/");
		str.append(getMaxHealth());
		if (nonLethalDamage != 0) {
			str.append(" (");
			str.append(nonLethalDamage);
			str.append(" nonlethal)");
		}
		str.append(" (");
		str.append(hitDice + " hit dice)");
		return str.toString();
	}
}
