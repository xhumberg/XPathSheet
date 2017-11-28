package character;

import java.util.ArrayList;
import java.util.List;

public class Attack {
	int id;
	boolean melee;
	String name;
	List<Dice> damageDice;
	Stat attack;
	Stat damage;
	int critLow;
	int critMultiplier;
	Stat BAB;
	Stat attackBonus;
	Stat damageBonus;
	
	public Attack(int id, String type, Stat attack, int critLow, int critMultiplier, Stat BAB, String dice, String damageType, String name) {
		this(id, type, attack, null, critLow, critMultiplier, BAB, dice, damageType, name);
	}
	
	public Attack(int id, String type, Stat attack, Stat damage, int critLow, int critMultiplier, Stat BAB, String dice, String damageType, String name) {
		if (type.toLowerCase().equals("melee"))
			melee = true;
		else
			melee = false;
		this.id = id;
		this.critMultiplier = critMultiplier;
		this.name = name;
		this.attack = attack;
		this.damage = damage;
		this.critLow = critLow;
		this.BAB = BAB;
		damageDice = new ArrayList<Dice>();
		attackBonus = new Stat(0);
		damageBonus = new Stat(0);
		damageDice.add(new Dice(dice, damageType));
	}
	
	public boolean isMelee() {
		return melee;
	}
	
	public String getAttack() {
		int atk = attack.getMod();
		atk += attackBonus.getScore();
		String result = "";
		int bab = BAB.getScore();
		do {
			if (bab + atk >= 0)
				result+="+";
			result+=(bab+atk) + "";
			if (bab > 5)
				result+="/";
			bab -= 5;
		} while (bab > 0);
		return result;
	}
	
	public void addDice(String dice, String damageType) {
		damageDice.add(new Dice(dice, damageType));
	}
	
	public String getDamage() {
		String result = "";
		for(Dice dice : damageDice) {
			result += dice + " + ";
		}
		int dam = damage.getMod();
		dam += damageBonus.getScore();
		if (dam == 0) {
			result = result.substring(0, result.length() - 3);
		} else if (dam < 0) {
			result = result.substring(0, result.length() - 2);
			result += "- " + (-dam);
		} else
			result += dam + "";
		return result;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(name);
		str.append(" ");
		str.append(getAttack());
		str.append(" (");
		str.append(getDamage());
		str.append(" | ");
		if (critLow < 20)
			str.append(critLow + "-");
		str.append("20");
		str.append("x" + critMultiplier);
		str.append(")");
		return str.toString();
	}
}
