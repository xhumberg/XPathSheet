package character;

import java.util.ArrayList;
import java.util.List;

public class Armor {
	private Adjust armorBonus;
	private Adjust shieldBonus;
	private Stat dexterity;
	private Adjust enhancementBonus;
	private Adjust deflectionBonus;
	private Adjust naturalArmor;
	private List<Adjust> dodgeBonuses;
	private Stat size;
	private Adjust maxDexterityBonus;
	//TODO: Need to add Armor Check Penalty
	//TODO: Arcane Spell Failure Chance
	//Speed is done by the item's adjustment
	//Weight is done in the item
	//Value is done in the item
	
	public Armor (Stat size, Stat dexterity) {
		this.size = size;
		this.dexterity = dexterity;
		armorBonus = null;
		shieldBonus = null;
		enhancementBonus = null;
		deflectionBonus = null;
		naturalArmor = null;
		dodgeBonuses = new ArrayList<Adjust>();
	}
	
	public void addAdjustArmor(Adjust adjustment) {
		if (armorBonus == null) {
			armorBonus = adjustment;
			return;
		}
		if (adjustment.applyAdjustment(0) > armorBonus.applyAdjustment(0))
			armorBonus = adjustment;
	}
	public void addAdjustShield(Adjust adjustment) {
		if (shieldBonus == null) {
			shieldBonus = adjustment;
			return;
		}
		if (adjustment.applyAdjustment(0) > shieldBonus.applyAdjustment(0))
			shieldBonus = adjustment;
	}
	public void addAdjustEnhancement(Adjust adjustment) {
		if (enhancementBonus == null) {
			enhancementBonus = adjustment;
			return;
		}
		if (adjustment.applyAdjustment(0) > enhancementBonus.applyAdjustment(0))
			enhancementBonus = adjustment;
	}
	public void addAdjustDeflection(Adjust adjustment) {
		if (deflectionBonus == null) {
			deflectionBonus = adjustment;
			return;
		}
		if (adjustment.applyAdjustment(0) > deflectionBonus.applyAdjustment(0))
			deflectionBonus = adjustment;
	}
	public void addAdjustNaturalArmor(Adjust adjustment) {
		if (naturalArmor == null) {
			naturalArmor = adjustment;
			return;
		}
		if (adjustment.applyAdjustment(0) > naturalArmor.applyAdjustment(0))
			naturalArmor = adjustment;
	}
	public void addAdjustDodge(Adjust adjustment) {
		dodgeBonuses.add(adjustment);
	}
	public void addMaxDexBonus(Adjust adjustment) {
		if (maxDexterityBonus == null) {
			maxDexterityBonus = adjustment;
			return;
		}
		if (adjustment.applyAdjustment(0) < maxDexterityBonus.applyAdjustment(0))
			maxDexterityBonus = adjustment;
	}
	
	public int getArmor() {
		if (armorBonus == null)
			return 0;
		return armorBonus.applyAdjustment(0);
	}
	public int getShield() {
		if (shieldBonus == null)
			return 0;
		return shieldBonus.applyAdjustment(0);
	}
	public int getEnhancement() {
		if (enhancementBonus == null)
			return 0;
		return enhancementBonus.applyAdjustment(0);
	}
	public int getDeflection() {
		if (deflectionBonus == null)
			return 0;
		return deflectionBonus.applyAdjustment(0);
	}
	public int getNaturalArmor() {
		if (naturalArmor == null)
			return 0;
		return naturalArmor.applyAdjustment(0);
	}
	public int getDodge() {
		int total = 0;
		for(Adjust adjust : dodgeBonuses)
			total += adjust.applyAdjustment(0);
		return total;
	}
	
	public int getDexterityBonus() {
		if (dexterity.getMod() <= 0)
			return dexterity.getMod();
		if (maxDexterityBonus == null)
			return dexterity.getMod();
		return (dexterity.getMod() > maxDexterityBonus.applyAdjustment(0) ? 
				maxDexterityBonus.applyAdjustment(0) : dexterity.getMod());
	}

	public int getAC() {
		return 10 + getArmor() + getShield() + getDexterityBonus()				
				+ getEnhancement() + getDeflection() +
				getNaturalArmor() + getDodge() - size.getScore();
	}
	public int getTouch() {
		return 10 + getDexterityBonus() + getDeflection() + getDodge()
				- size.getScore();
	}
	public int getFlatFooted() {
		return 10 + getArmor() + getShield() + getEnhancement() + getDeflection() + getNaturalArmor() - size.getScore() 
				+ (getDexterityBonus() < 0 ? getDexterityBonus() : 0);
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("AC: " + getAC());
		str.append(", Touch: " + getTouch());
		str.append(", Flat-footed: " + getFlatFooted());
		str.append("  (");
		if (getArmor() != 0)
			str.append("Armor: " + getArmor() + "  ");
		if (getShield() != 0)
			str.append("Shield: " + getShield() + "  ");
		if (getDexterityBonus() != 0)
			str.append("Dex: " + getDexterityBonus() + "  ");
		if (getEnhancement() != 0)
			str.append("Enhancement: " + getShield() + "  ");
		if (getDeflection() != 0)
			str.append("Deflection: " + getDeflection() + "  ");
		if (getNaturalArmor() != 0)
			str.append("Natural Armor: " + getNaturalArmor() + "  ");
		if (getDodge() != 0)
			str.append("Dodge: " + getDodge() + "  ");
		if (size.getScore() != 0)
			str.append("Size: " + (-size.getScore()));
		str.append(")");
		return str.toString();
	}
}
