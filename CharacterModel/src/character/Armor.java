package character;

public class Armor {
	private Stat armorBonus;
	private Stat shieldBonus;
	private Stat dexterity;
	private Stat strength;
	private Stat enhancementBonus;
	private Stat deflectionBonus;
	private Stat naturalArmor;
	private Stat dodgeBonus;
	private Stat armorCheckPenalty;
	private Stat arcaneSpellFailure;
	private Stat maxDexterityBonus;
	
	private Stat size;
	
	public Armor (Stat size, Stat dexterity, Stat strength) {
		this.strength = strength;
		this.size = size;
		this.dexterity = dexterity;
		armorBonus = new Stat(0);
		shieldBonus = new Stat(0);
		enhancementBonus = new Stat(0);
		deflectionBonus = new Stat(0);
		naturalArmor = new Stat(0);
		dodgeBonus = new Stat(0);
		armorCheckPenalty = new Stat(0);
		arcaneSpellFailure = new Stat(0);
		maxDexterityBonus = new Stat(99);
	}
	
	public void activateAdjustment(Adjustment adjustment) {
		for(Adjust adjust : adjustment.adjustments) {
			switch (adjust.getWhatAdjust().toLowerCase()) {
			case "armor":
				armorBonus.addAdjust(adjust);
				continue;
			case "shield":
				shieldBonus.addAdjust(adjust);
				continue;
			case "ac enhancement":
				enhancementBonus.addAdjust(adjust);
				continue;
			case "deflection":
				deflectionBonus.addAdjust(adjust);
				continue;
			case "natural armor":
				naturalArmor.addAdjust(adjust);
				continue;
			case "dodge":
				dodgeBonus.addAdjust(adjust);
				continue;
			case "max dex bonus":
			case "max dexterity bonus":
			case "max dex":
				maxDexterityBonus.addAdjust(adjust);
				continue;
			case "armor check penalty":
			case "armor check":
				armorCheckPenalty.addAdjust(adjust);
				continue;
			case "arcane spell failure":
				arcaneSpellFailure.addAdjust(adjust);
				continue;
			}
		}
	}
	public void deactivateAdjustment(int id) {
		armorBonus.removeAdjust(id);
		shieldBonus.removeAdjust(id);
		enhancementBonus.removeAdjust(id);
		deflectionBonus.removeAdjust(id);
		naturalArmor.removeAdjust(id);
		dodgeBonus.removeAdjust(id);
		armorCheckPenalty.removeAdjust(id);
		arcaneSpellFailure.removeAdjust(id);
		maxDexterityBonus.removeAdjust(id);
	}
	
	public int getArmor() {
		return armorBonus.getScore();
	}
	public int getShield() {
		return shieldBonus.getScore();
	}
	public int getEnhancement() {
		return enhancementBonus.getScore();
	}
	public int getDeflection() {
		return deflectionBonus.getScore();
	}
	public int getNaturalArmor() {
		return naturalArmor.getScore();
	}
	public int getDodge() {
		return dodgeBonus.getScore();
	}
	
	public int getDexterityBonus() {
		return Math.min(this.maxDexterityBonus.getScore(), this.dexterity.getMod());
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

	public int getCMD() {
		return getAC() + 2*size.getScore() + strength.getMod();
	}
	public int getTouchCMD() {
		return getTouch() + 2*size.getScore() + strength.getMod();
	}
	public int getFlatFootedCMD() {
		return getFlatFooted() + 2*size.getScore() + strength.getMod();
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
		if (str.charAt(str.length()-1) == ' ')
			return str.substring(0, str.length()-2) + ")";
		str.append(")");
		return str.toString();
	}
}
