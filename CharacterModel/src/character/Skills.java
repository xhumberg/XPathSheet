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
		throw new RuntimeException("Cannot find skill " + skill);
	}

	public void deactivateAdjustment(int id) {
		acrobatics.removeAdjust(id);
		appraise.removeAdjust(id);
		bluff.removeAdjust(id);
		climb.removeAdjust(id);
		crafta.removeAdjust(id);
		craftb.removeAdjust(id);
		diplomacy.removeAdjust(id);
		disableDevice.removeAdjust(id);
		disguise.removeAdjust(id);
		escapeArtist.removeAdjust(id);
		fly.removeAdjust(id);
		handleAnimal.removeAdjust(id);
		heal.removeAdjust(id);
		intimidate.removeAdjust(id);
		knowledgeArcana.removeAdjust(id);
		knowledgeDungeoneering.removeAdjust(id);
		knowledgeEngineering.removeAdjust(id);
		knowledgeGeography.removeAdjust(id);
		knowledgeHistory.removeAdjust(id);
		knowledgeLocal.removeAdjust(id);
		knowledgeNature.removeAdjust(id);
		knowledgeNobility.removeAdjust(id);
		knowledgePlanes.removeAdjust(id);
		knowledgeReligion.removeAdjust(id);
		linguistics.removeAdjust(id);
		perception.removeAdjust(id);
		performa.removeAdjust(id);
		performb.removeAdjust(id);
		professiona.removeAdjust(id);
		professionb.removeAdjust(id);
		professionc.removeAdjust(id);
		ride.removeAdjust(id);
		senseMotive.removeAdjust(id);
		sleightOfHand.removeAdjust(id);
		spellcraft.removeAdjust(id);
		stealth.removeAdjust(id);
		survival.removeAdjust(id);
		swim.removeAdjust(id);
		useMagicDevice.removeAdjust(id);
	}
	
	public void activateAdjustment(Adjustment adjustment) {
		deactivateAdjustment(adjustment.id);
		for (Adjust adjust : adjustment.adjustments) {
			try{
				Skill addition = this.getSkill(adjust.getWhatAdjust());
				addition.addAdjust(adjust);
			} catch (RuntimeException e) {
				continue;
			}
		}
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
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
}