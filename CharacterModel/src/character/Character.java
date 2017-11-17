package character;

import java.util.ArrayList;
import java.util.List;

public class Character {
	private String name;
	private Adjustment race;
	private String type;
	private List<Adjustment> classes;
	private List<Adjustment> feats;
	private int level;
	private Stat speed;
	private Stat size;
	private Skill initiative;
	
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
	private Stat strength;
	private Stat dexterity;
	private Stat constitution;
	private Stat intelligence;
	private Stat wisdom;
	private Stat charisma;
	
	/*
	 * SKILLS
	 */
	private Skill acrobatics;
	private Skill appraise;
	private Skill bluff;
	private Skill climb;
	private Skill crafta;
	private Skill craftb;
	private Skill diplomacy;
	private Skill disableDevice;
	private Skill disguise;
	private Skill escapeArtist;
	private Skill fly;
	private Skill handleAnimal;
	private Skill heal;
	private Skill intimidate;
	private Skill knowledgeArcana;
	private Skill knowledgeDungeoneering;
	private Skill knowledgeEngineering;
	private Skill knowledgeGeography;
	private Skill knowledgeHistory;
	private Skill knowledgeLocal;
	private Skill knowledgeNature;
	private Skill knowledgeNobility;
	private Skill knowledgePlanes;
	private Skill knowledgeReligion;
	private Skill linguistics;
	private Skill perception;
	private Skill performa;
	private Skill performb;
	private Skill professiona;
	private Skill professionb;
	private Skill professionc;
	private Skill ride;
	private Skill senseMotive;
	private Skill sleightOfHand;
	private Skill spellcraft;
	private Skill stealth;
	private Skill survival;
	private Skill swim;
	private Skill useMagicDevice;
	
	private int newAdjustmentIndex;
	
	public Character() {
		name = "No Name";
		race = new Adjustment(0);
		classes = new ArrayList<Adjustment>();
		feats = new ArrayList<Adjustment>();
		speed = new Stat();
		speed.setBase(30);
		level = 0;
		size = new Stat();
		size.setBase(0);
		lawful = false;
		chaotic = false;
		good = false;
		evil = false;
		
		strength = new Stat();
		dexterity = new Stat();
		constitution = new Stat();
		intelligence = new Stat();
		wisdom = new Stat();
		charisma = new Stat();
		
		initiative = new Skill(dexterity, false);
		
		acrobatics = new Skill(dexterity, false);
		appraise = new Skill(intelligence, false);
		bluff = new Skill(charisma, false);
		climb = new Skill(strength, false);
		crafta = new Skill(intelligence, false);
		craftb = new Skill(intelligence, false);
		diplomacy = new Skill(charisma, false);
		disableDevice = new Skill(dexterity, true);
		disguise = new Skill(charisma, false);
		escapeArtist = new Skill(dexterity, false);
		fly = new Skill(dexterity, false);
		handleAnimal = new Skill(charisma, true);
		heal = new Skill(wisdom, false);
		intimidate = new Skill(charisma, false);
		knowledgeArcana = new Skill(intelligence, true);
		knowledgeDungeoneering = new Skill(intelligence, true);
		knowledgeEngineering = new Skill(intelligence, true);
		knowledgeGeography = new Skill(intelligence, true);
		knowledgeHistory = new Skill(intelligence, true);
		knowledgeLocal = new Skill(intelligence, true);
		knowledgeNature = new Skill(intelligence, true);
		knowledgeNobility = new Skill(intelligence, true);
		knowledgePlanes = new Skill(intelligence, true);
		knowledgeReligion = new Skill(intelligence, true);
		linguistics = new Skill(intelligence, true);
		perception = new Skill(wisdom, false);
		performa = new Skill(charisma, false);
		performb = new Skill(charisma, false);
		professiona = new Skill(wisdom, true);
		professionb = new Skill(wisdom, true);
		professionc = new Skill(wisdom, true);
		ride = new Skill(dexterity, false);
		senseMotive = new Skill(wisdom, false);
		sleightOfHand = new Skill(dexterity, true);
		spellcraft = new Skill(intelligence, true);
		stealth = new Skill(dexterity, false);
		survival = new Skill(wisdom, false);
		swim = new Skill(strength, false);
		useMagicDevice = new Skill(charisma, true);
		
		newAdjustmentIndex = 21;
	}
	
	/*
	 * GETTERS
	 */
	public Skill getSkill(String skill) {
		switch(skill.toLowerCase()) {
		case "acrobatics":
			return acrobatics;
		case "appraise":
			return appraise;
		case "bluff":
			return bluff;
		case "climb":
			return climb;
		case "craft a":
			return crafta;
		case "craft b":
			return craftb;
		case "diplomacy":
			return diplomacy;
		case "disable device":
			return disableDevice;
		case "disguise":
			return disguise;
		case "escape artist":
			return escapeArtist;
		case "fly":
			return fly;
		case "handle animal":
			return handleAnimal;
		case "heal":
			return heal;
		case "intimidate":
			return intimidate;
		case "knowledge arcana":
			return knowledgeArcana;
		case "knowledge dungeoneering":
			return knowledgeDungeoneering;
		case "knowledge engineering":
			return knowledgeEngineering;
		case "knowledge geography":
			return knowledgeGeography;
		case "knowledge history":
			return knowledgeHistory;
		case "knowledge local":
			return knowledgeLocal;
		case "knowledge nature":
			return knowledgeNature;
		case "knowledge nobility":
			return knowledgeNobility;
		case "knowledge planes":
			return knowledgePlanes;
		case "knowledge religion":
			return knowledgeReligion;
		case "linguistics":
			return linguistics;
		case "perception":
			return perception;
		case "perform a":
			return performa;
		case "perform b":
			return performb;
		case "profession a":
			return professiona;
		case "profession b":
			return professionb;
		case "profession c":
			return professionc;
		case "ride":
			return ride;
		case "sense motive":
			return senseMotive;
		case "sleight of hand":
			return sleightOfHand;
		case "spellcraft":
			return spellcraft;
		case "stealth":
			return stealth;
		case "survival":
			return survival;
		case "swim":
			return swim;
		case "use magic device":
			return useMagicDevice;
		}
		return null;
	}
	public int getSkillBonus(String skill) {
		return getSkill(skill).getBonus();
	}
	public int getSkillTemp(String skill) {
		return getSkill(skill).getTemp();
	}
	public int getSkillRanks(String skill) {
		return getSkill(skill).getRanks();
	}
	private Stat getAbility(String ability) {
		switch(ability.toLowerCase()) {
		case "strength":
			return strength;
		case "dexterity":
			return dexterity;
		case "constitution":
			return constitution;
		case "intelligence":
			return intelligence;
		case "wisdom":
			return wisdom;
		case "charisma":
			return charisma;
		}
		return null;
	}
	public int getAbilityScore(String ability) {
		return getAbility(ability).getScore();
	}
	public int getAbilityMod(String ability) {
		return getAbility(ability).getMod();
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

	/*
	 * SETTERS
	 */
	public void setAbilityScoreBase(String ability, int newBase) {
		getAbility(ability).setBase(newBase);
	}	
	public void setAbilityScoreTemp(String ability, int newTemp) {
		getAbility(ability).setTemp(newTemp);
	}
	public void addSkillRank(String skill) {
		getSkill(skill).addRank();
	}
	public void addClassSkill(String skill) {
		getSkill(skill).makeClassSkill();
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
	
	/*
	 * ADJUSTERS
	 */
	public void addAbilityScoreAdjust(String ability, Adjust adjustment) {
		getAbility(ability).addAdjust(adjustment);
	}
	public void addAdjustSkill(String skill, Adjust adjustment) {
		getSkill(skill).addAdjust(adjustment);
	}
	public void addAdjustSpeed(Adjust adjustment) {
		speed.addAdjust(adjustment);
	}
	public void addAdjustInitiative(Adjust adjustment) {
		initiative.addAdjust(adjustment);
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
		str.append("Initiative: " + initiative.getBonus() + "\n");
		
		str.append("\n" + line() + "\n");
		str.append("DEFENSE" + "\n");
		str.append(line() + "\n");
		
		str.append("\n" + line() + "\n");
		str.append("OFFENSE" + "\n");
		str.append(line() + "\n");
		str.append("Speed: " + getSpeed() + " ft.\n");
		
		str.append("\n" + line() + "\n");
		str.append("STATISTICS" + "\n");
		str.append(line() + "\n");
		str.append("STR: " + strength  + ", ");
		str.append("DEX: " + dexterity + ", ");
		str.append("CON: " + constitution + ", ");
		str.append("INT: " + intelligence + ", ");
		str.append("WIS: " + wisdom + ", ");
		str.append("CHA: " + charisma + "\n");
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
}
