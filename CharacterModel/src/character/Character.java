package character;

import java.util.ArrayList;
import java.util.List;

public class Character {
	private String name;
	private Adjustment race;
	private List<Adjustment> classes;
	int level;
	private boolean lawful;
	private boolean chaotic;
	private boolean good;
	private boolean evil;
	private Stat strength;
	private Stat dexterity;
	private Stat constitution;
	private Stat intelligence;
	private Stat wisdom;
	private Stat charisma;
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
	
	
	//TODO: Remove this
	private List<Adjustment> adjustments;
	
	private int newAdjustmentIndex;
	
	public Character() {
		name = "No Name";
		race = new Adjustment(0);
		classes = new ArrayList<Adjustment>();
		level = 0;
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
		
		//TODO: Remove this
		adjustments = new ArrayList<Adjustment>();
		
		newAdjustmentIndex = 1;
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
	public void setAbilityScoreBase(String ability, int newBase) {
		getAbility(ability).setBase(newBase);
	}	
	public void setAbilityScoreTemp(String ability, int newTemp) {
		getAbility(ability).setTemp(newTemp);
	}
	public void addAbilityScoreAdjust(String ability, Adjust adjustment) {
		getAbility(ability).addAdjust(adjustment);
	}

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
	public void addSkillRank(String skill) {
		getSkill(skill).addRank();
	}
	public void addClassSkill(String skill) {
		getSkill(skill).makeClassSkill();
	}
	public void addAdjustSkill(String skill, Adjust adjustment) {
		getSkill(skill).addAdjust(adjustment);
	}
	
	public String getAlignment() {
		StringBuilder str = new StringBuilder();
		
		if (lawful)
			str.append("Lawful ");
		else if (chaotic)
			str.append("Chaotic ");
		else
			str.append("Neutral ");
		
		if (good)
			str.append("Good");
		else if (evil)
			str.append("Evil");
		else {
			if (str.toString().equals("Neutral ")) {
				str.delete(0, str.length());
				str.append("True Neutral");
			}
			else
				str.append("Neutral");
		}
		
		return str.toString();
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(name + "\n");
		str.append(race.toString().split(":")[0] + " ");
		str.append(getClassString() + "\n");
		str.append(getAlignment() + "\n");
		str.append("STR: " + strength + "\n");
		str.append("DEX: " + dexterity + "\n");
		str.append("CON: " + constitution + "\n");
		str.append("INT: " + intelligence + "\n");
		str.append("WIS: " + wisdom + "\n");
		str.append("CHA: " + charisma + "\n");
		for (Adjustment adjustment : adjustments) {
			str.append(adjustment + "\n");
		}
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

	Adjustment createAdjustment() {
		Adjustment newAdj = new Adjustment(newAdjustmentIndex);
		newAdjustmentIndex++;
		adjustments.add(newAdj);
		return newAdj;
	}

	Adjustment getRace() {
		return race;
	}
	
	Adjustment getAdjustment(int id) {
		return adjustments.get(id);
	}

	Adjustment addLevel() {
		Adjustment newLevel = new Adjustment(++level);
		classes.add(newLevel);
		return newLevel;
	}
	
	Adjustment getLevel(int level) {
		return classes.get(level-1);
	}

}
