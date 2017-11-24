package character;

import java.util.ArrayList;
import java.util.List;

public class Character {
	private Abilities abilities;
	private Skills skills;
	private Details character;
	
	private Skill initiative;
	private Armor AC;
	private Health HP;
	private Skill fortSave;
	private Skill refSave;
	private Skill willSave;
	Stat BAB;
	private Equipment equipment;
	private List<Attack> attacks;
	private Spellstuffs spells;
	
	/*
	 * Alignment
	 */
	private boolean lawful;
	private boolean chaotic;
	private boolean good;
	private boolean evil;
	
	/*
	 * STATS
	 */

	
	/*
	 * SKILLS
	 */

	
	private int newAdjustmentIndex;
	
	public Character() {
		this.initialize(10, 10, 10, 10, 10, 10);
	}
	
	public Character(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
		this.initialize(strength, dexterity, constitution, intelligence, wisdom, charisma);
	}
	
	public void initialize(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
		abilities = new Abilities(strength, dexterity, constitution, intelligence, wisdom, charisma);
		skills = new Skills(abilities);
		character = new Details("No Name", 'X', "Medium", "No Favored Class Selected");
		name = "No Name";
		race = new Adjustment(0);
		classes = new ArrayList<Adjustment>();
		feats = new ArrayList<Adjustment>();
		senses = new ArrayList<Adjust>();
		newAdjustmentIndex = 22;
		speed = new Stat();
		speed.setBase(30);
		level = 0;
		size = new Stat();
		size.setBase(0);
		lawful = false;
		chaotic = false;
		good = false;
		evil = false;
		
		HP = new Health(constitution);
		initiative = new Skill(dexterity, false);
		AC = new Armor(size, dexterity);
		fortSave = new Skill(constitution, false);
		refSave = new Skill(dexterity, false);
		willSave = new Skill(wisdom, false);
		BAB = new Stat();
		BAB.setBase(0);
		attacks = new ArrayList<Attack>();
		equipment = new Equipment();		
	}
	
	public String getAlignment() {
		StringBuilder str = new StringBuilder();
		
		if (lawful)
			str.append("L");
		else if (chaotic)
			str.append("C");
		else
			str.append("N");
		
		if (good)
			str.append("G");
		else if (evil)
			str.append("E");
		else {
			if (!str.toString().equals("N"))
				str.append("N");
		}
		
		return str.toString();
	}
	public String getType() {
		return type;
	}
	public int getSize() {
		return size.getScore();
	}
	public int getSpeed() {
		return speed.getScore();
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
	public void setType(String newType) {
		type = newType;
	}
	public void setSize(int size) {
		this.size.setBase(size);
	}
	public void setSpeed(int speed) {
		this.speed.setBase(speed);
	}
	public void setTempInitiative(int temp) {
		initiative.setTemp(temp);
	}
	public void addSpellKnown(Spell spell) {
		if (spells == null)
			throw new RuntimeException("Spells not enabled for character");
		spells.addSpellKnown(spell);
	}
	public void prepareSpell(String string) {
		if (spells == null)
			throw new RuntimeException("Spells not enabled for character");
		spells.prepareSpell(string);
		
	}
	
	public void enableSpellcasting(String casterStat, boolean spontaneous) {
		Stat cast = getAbility(casterStat);
		spells = new Spellstuffs(cast, spontaneous);
	}
	public void addAdjustSpeed(Adjust adjustment) {
		speed.addAdjust(adjustment);
	}
	public void addAdjustInitiative(Adjust adjustment) {
		initiative.addAdjust(adjustment);
	}
	public void addSense(Adjust adjustment) {
		senses.add(adjustment);
	}
	public void addHitDice(Adjust adjustment) {
		HP.addHitDice(adjustment);
	}
	public void addAdjustSave(String save, Adjust adjustment) {
		switch (save.toLowerCase()) {
		case("will"):
			willSave.addAdjust(adjustment);
			return;
		case ("fort"):
		case ("fortitude"):
			fortSave.addAdjust(adjustment);
			return;
		case ("ref"):
		case ("reflex"):
			refSave.addAdjust(adjustment);
			return;
		}
	}
	public void addAdjustBAB(Adjust adjustment) {
		BAB.addAdjust(adjustment);
	}
	public void addAttack(Attack attack) {
		attacks.add(attack);
	}
	public void addAdjustSpellsPerDay(int level, Adjust adjustment) {
		if (spells == null)
			throw new RuntimeException("Spells not enabled for character");
		spells.addAdjustNumSpells(level, adjustment);
	}
	
	/*
	 * STRING METHODS
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(line() + "\n");
		str.append(name + "\n");
		str.append(line() + "\n");
		str.append(race.toString().split(":")[0] + " ");
		str.append(getClassString() + "\n");
		str.append(getAlignment() + " " + getSizeString() + " " + type + "\n");
		str.append("Init: " + (initiative.getBonus() < 0 ? "" : "+") + initiative.getBonus() + "; Senses: ");
		for(Adjust adjust : senses) {
			str.append(adjust + "  ");
		}
		str.append("\nPerception " + (perception.getBonus() < 0 ? "" : "+") + perception.getBonus() + "\n");
		
		str.append("\n" + line() + "\n");
		str.append("DEFENSE" + "\n");
		str.append(line() + "\n");
		str.append(AC + "\n");
		str.append(HP + "\n");
		str.append("Fort: ");
		str.append(fortSave.getBonus());
		str.append(", Ref: ");
		str.append(refSave.getBonus());
		str.append(", Will: ");
		str.append(willSave.getBonus());
		str.append("\n");
		
		str.append("\n" + line() + "\n");
		str.append("OFFENSE" + "\n");
		str.append(line() + "\n");
		str.append("Speed: " + getSpeed() + " ft.\n");
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
		str.append("Spells:\n");
		if (spells != null) {
			str.append(spells.listPrepared());
		}
		
		
		str.append("\n" + line() + "\n");
		str.append("STATISTICS" + "\n");
		str.append(line() + "\n");
		str.append("STR: " + strength  + ", ");
		str.append("DEX: " + dexterity + ", ");
		str.append("CON: " + constitution + ", ");
		str.append("INT: " + intelligence + ", ");
		str.append("WIS: " + wisdom + ", ");
		str.append("CHA: " + charisma + "\n");
		str.append("Feats: ");
		for(Adjustment adjustment : feats) {
			str.append(adjustment.getName() + "  ");
		}
		str.append("\n");
		str.append("Acrobatics: " + acrobatics + "  ");
		str.append("Appraise: " + appraise + "  ");
		str.append("Bluff: " + bluff + "  ");
		str.append("Climb: " + climb + "  ");
		str.append("Craft A: " + crafta + "  \n");
		str.append("Craft B: " + craftb + "  ");
		str.append("Diplomacy: " + diplomacy + "  ");
		str.append("Disable Device: " + (disableDevice.getBonus() == -999 ? "No" : disableDevice) + "  ");
		str.append("Disguise: " + disguise + "  \n");
		str.append("Escape Artist: " + escapeArtist + "  ");
		str.append("Fly: " + fly + "  ");
		str.append("Handle Animal: " + (handleAnimal.getBonus() == -999 ? "No" : handleAnimal) + "  ");
		str.append("Heal: " + heal + "  \n");
		str.append("Intimidate: " + intimidate + "  ");
		str.append("Knowledge(Arcana): " + (knowledgeArcana.getBonus() == -999 ? "No" : knowledgeArcana) + "  ");
		str.append("Knowledge(Dungeoneering): " + (knowledgeDungeoneering.getBonus() == -999 ? "No" : knowledgeDungeoneering) + "  \n");
		str.append("Knowledge(Engineering): " + (knowledgeEngineering.getBonus() == -999 ? "No" : knowledgeEngineering) + "  ");
		str.append("Knowledge(Geography): " + (knowledgeGeography.getBonus() == -999 ? "No" : knowledgeGeography) + "  ");
		str.append("Knowledge(History): " + (knowledgeHistory.getBonus() == -999 ? "No" : knowledgeHistory) + "  \n");
		str.append("Knowledge(Local): " + (knowledgeLocal.getBonus() == -999 ? "No" : knowledgeLocal) + "  ");
		str.append("Knowledge(Nature): " + (knowledgeNature.getBonus() == -999 ? "No" : knowledgeNature) + "  ");
		str.append("Knowledge(Nobility): " + (knowledgeNobility.getBonus() == -999 ? "No" : knowledgeNobility) + "  \n");
		str.append("Knowledge(Planes): " + (knowledgePlanes.getBonus() == -999 ? "No" : knowledgePlanes) + "  ");
		str.append("Knowledge(Religion): " + (knowledgeReligion.getBonus() == -999 ? "No" : knowledgeReligion) + "  ");
		str.append("Linguistics: " + (linguistics.getBonus() == -999 ? "No" : linguistics) + "  \n");
		str.append("Perception: " + perception + "  ");
		str.append("Perform A: " + performa + "  ");
		str.append("Perform B: " + performb + "  ");
		str.append("Profession A: " + (professiona.getBonus() == -999 ? "No" : professiona) + "  ");
		str.append("Profession B: " + (professionb.getBonus() == -999 ? "No" : professionb) + "  \n");
		str.append("Profession C: " + (professionc.getBonus() == -999 ? "No" : professionc) + "  ");
		str.append("Ride: " + ride + "  ");
		str.append("Sense Motive: " + senseMotive + "  ");
		str.append("Sleight of Hand: " + (sleightOfHand.getBonus() == -999 ? "No" : sleightOfHand) + "  ");
		str.append("Spellcraft: " + (spellcraft.getBonus() == -999 ? "No" : spellcraft) + "  \n");
		str.append("Stealth: " + stealth + "  ");
		str.append("Survival: " + survival + "  ");
		str.append("Swim: " + swim + "  ");
		str.append("Use Magic Device: " + (useMagicDevice.getBonus() == -999 ? "No" : useMagicDevice) + "  ");
		return str.toString();
	}
	private String getClassString() {
		StringBuilder str = new StringBuilder();
		
		if (classes.size() == 0)
			return "Commoner";
		str.append(classes.get(0).getName());
		str.append(" ");
		str.append(classes.size());
		return str.toString();
		//TODO: Support multiclassing
	}
	private String getSizeString() {
		switch (size.getBase()) {
		case -1:
			return "Small";
		case -2:
			return "Tiny";
		case -4:
			return "Diminutive";
		case -8:
			return "Fine";
		case 0:
			return "Medium";
		case 1:
			return "Large";
		case 2:
			return "Huge";
		case 4:
			return "Gargantuan";
		case 8:
			return "Colossal";
		default:
			return "INVALID SIZE";
		}
	}
	private String line() {
		return "----------------------------------------";
	}
	
	/*
	 * ADJUSTMENT CREATION METHODS
	 */
	Adjustment getRace() {
		return race;
	}
	Adjustment addLevel() {
		Adjustment newLevel = new Adjustment(++level);
		classes.add(newLevel);
		return newLevel;
	}
	Adjustment getLevel(int level) {
		return classes.get(level-1);
	}
	Adjustment addFeat() {
		Adjustment newFeat = new Adjustment(newAdjustmentIndex++);
		feats.add(newFeat);
		return newFeat;
	}
	Adjustment addItem(String name, int value, int weight) {
		Adjustment newItem = new Adjustment(newAdjustmentIndex++);
		equipment.add(name, value, weight, newItem);
		return newItem;
	}




}
