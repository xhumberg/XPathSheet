package character;

import java.util.ArrayList;
import java.util.List;

public class Spellstuffs {
	List<Spell> spellsKnown;
	List<Spell> spellsPrepared;
	boolean isPreparedCaster;
	Stat[] numSpells;
	int[] numUsedSpells;
	Stat casterStat;
	
	public Spellstuffs(Stat casterStat, boolean spontaneous) {
		spellsKnown = new ArrayList<Spell>();
		if (!spontaneous)
			spellsPrepared = new ArrayList<Spell>();
		isPreparedCaster = !spontaneous;
		numSpells = new Stat[10];
		numUsedSpells = new int[10];
		for (int i = 0; i < 10; i++) {
			numSpells[i] = new Stat();
			numUsedSpells[i] = 0;
		}
		for (Stat spellNumber : numSpells) {
			spellNumber.setBase(0);
		}
		this.casterStat = casterStat;
		recalculate();
	}
	
	private void recalculate() {
		for (int spellLevel = 1; spellLevel < 10; spellLevel++) {
			int baseCalc = 0;
			if (numSpells[spellLevel].getScore() <= 0)
				continue;
			for (int i = spellLevel; i <= casterStat.getMod(); i+=4)
				baseCalc++;
			numSpells[spellLevel].setBase(baseCalc);
		}
	}

	public void addSpellKnown(Spell spell) {
		spellsKnown.add(spell);
	}
	
	private Spell getSpell(String name, List<Spell> spells) {
		for (Spell spell : spells) {
			if (spell.name.toLowerCase().equals(name.toLowerCase()))
				return spell;
		}
		throw new RuntimeException("Spell " + name + " doesn't exist in spels known");
	}
	
	public void prepareSpell(String spellName) {
		if (!this.isPreparedCaster)
			throw new RuntimeException("Unable to prepare spells for a spontaneous caster");
		Spell prep = getSpell(spellName, spellsKnown);
		if (prep != null) {
			if (numUsedSpells[prep.level] >= numSpells[prep.level].getScore()) 
				throw new RuntimeException("Cannot prepare another spell of level " + prep.level);
			spellsPrepared.add(prep);
			numUsedSpells[prep.level]++;
		}
	}
	public void castSpell(String spellName) {
		if (this.isPreparedCaster) {
			Spell used = getSpell(spellName, spellsPrepared);
			spellsPrepared.remove(used);
		} else {
			Spell cast = getSpell(spellName, spellsKnown);
			if (numUsedSpells[cast.level] >= numSpells[cast.level].getScore())
				throw new RuntimeException("Cannot cast spell of level " + cast.level);
			numUsedSpells[cast.level]++;
		}
	}

	public void activateAdjustment(Adjustment adjustment) {
		for (Adjust adjust : adjustment.adjustments) {
			switch (adjust.getWhatAdjust().toLowerCase()) {
			case "0th level spells per day":
			case "l0 spd":
			case "level 0 spells per day":
			case "cantrips":
				numSpells[0].addAdjust(adjust);
				continue;
			case "1st level spells per day":
			case "l1 spd":
			case "level 1 spells per day":
				numSpells[1].addAdjust(adjust);
				continue;
			case "2st level spells per day":
			case "l2 spd":
			case "level 2 spells per day":
				numSpells[2].addAdjust(adjust);
				continue;
			case "3st level spells per day":
			case "l3 spd":
			case "level 3 spells per day":
				numSpells[3].addAdjust(adjust);
				continue;
			case "4th level spells per day":
			case "l4 spd":
			case "level 4 spells per day":
				numSpells[4].addAdjust(adjust);
				continue;
			case "5th level spells per day":
			case "51 spd":
			case "level 5 spells per day":
				numSpells[5].addAdjust(adjust);
				continue;
			case "6th level spells per day":
			case "l6 spd":
			case "level 6 spells per day":
				numSpells[6].addAdjust(adjust);
				continue;
			case "7th level spells per day":
			case "l7 spd":
			case "level 7 spells per day":
				numSpells[7].addAdjust(adjust);
				continue;
			case "8th level spells per day":
			case "l8 spd":
			case "level 8 spells per day":
				numSpells[8].addAdjust(adjust);
				continue;
			case "9th level spells per day":
			case "l9 spd":
			case "level 9 spells per day":
				numSpells[9].addAdjust(adjust);
				continue;
			}
		}
		recalculate();
	}
	
	public void deactivateAdjustment(int id) {
		for (Stat spellsPerDay : numSpells)
			spellsPerDay.removeAdjust(id);
	}
	
	public String toString() {
		if (this.isPreparedCaster)
			return list(spellsPrepared);
		else {
			return list(spellsKnown);
		}
	}
	private String list(List<Spell> spells) {
		//Seperate Spells into correct Levels
		ArrayList<ArrayList<Spell>> spellLevels = new ArrayList<ArrayList<Spell>>();
		for (int i = 0; i < 10; i++)
			spellLevels.add(new ArrayList<Spell>());
		for (Spell spell : spells) {
			spellLevels.get(spell.level).add(spell);
		}
		
		//Now make the string
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			if (spellLevels.get(i).isEmpty())
				break;
			str.append("Level " + i + ":\n");
			for (Spell spell : spellLevels.get(i)) {
				str.append(spell.name);
				if (!(spell.save.toLowerCase().equals("harmless") || spell.save.toLowerCase().equals("no")))
					str.append(getSpellDC(i));
				str.append(", ");
			}
			str = str.replace(str.length()-2, str.length(), "\n");
		}
		return str.toString();
	}
	//TODO: Adjustable. DCs can go up and down pretty easily
	private String getSpellDC(int level) {
		return " (DC " + (10 + level + casterStat.getMod()) + ")";
	}
}
