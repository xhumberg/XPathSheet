package character;

public class Skills {
	private Stat strength;
	private Stat dexterity;
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
	
	public Skills(Abilities abilities) {
		strength = abilities.get("str");
		dexterity = abilities.get("dex");
		intelligence = abilities.get("int");
		wisdom = abilities.get("wis");
		charisma = abilities.get("cha");
		initialize();
	}
	
	private void initialize() {
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
		case "UMD":
			return useMagicDevice;
		}
		return null;
	}
}
