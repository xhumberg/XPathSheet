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
	}
	
	public void addAdjustNumSpells(int spellLevel, Adjust adjustment) {
		numSpells[spellLevel].addAdjust(adjustment);
	}
	
	public void addSpellKnown(Spell spell) {
		spellsKnown.add(spell);
	}
	
	private Spell getSpell(String name, List<Spell> spells) {
		for (Spell spell : spells) {
			if (spell.name.toLowerCase().equals(name.toLowerCase()))
				return spell;
		}
		throw new RuntimeException("Spell " + name + " doesn't exist in list you're searching");
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

	public String listPrepared() {
		return list(spellsPrepared);
	}
	
	private String list(List<Spell> spells) {
		StringBuilder str = new StringBuilder();
		for(Spell spell : spells) {
			str.append(spell.name);
			if (!(spell.save.toLowerCase().equals("none") || spell.save.toLowerCase().equals("harmless"))) {
				str.append(getSpellDC(spell.level));
			}
			str.append(", ");
		}
		if (str.length() > 3) {
			return str.substring(0, str.length() - 2);
		}
		return str.toString();
	}

	private String getSpellDC(int level) {
		return " (DC " + (10 + level + casterStat.getMod()) + ")";
	}
}
