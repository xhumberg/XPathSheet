package character;

import java.util.ArrayList;
import java.util.List;

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
	List<Special> skillSpecials;
	
	public Skills(Abilities abilities) {
		strength = abilities.get("str");
		dexterity = abilities.get("dex");
		intelligence = abilities.get("int");
		wisdom = abilities.get("wis");
		charisma = abilities.get("cha");
		skillSpecials = new ArrayList<Special>();
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
		int i = 0;
		while (i < skillSpecials.size()) {
			if (skillSpecials.get(i).getID() == id) {
				skillSpecials.remove(i);
				continue;
			}
			i++;
		}
	}
	
	public void activateAdjustment(Adjustment adjustment) {
		deactivateAdjustment(adjustment.id);
		for (Adjust adjust : adjustment.adjustments) {
			if (adjust.getWhatAdjust().toLowerCase().equals("skills")) {
				acrobatics.addAdjust(adjust);
				appraise.addAdjust(adjust);
				bluff.addAdjust(adjust);
				climb.addAdjust(adjust);
				crafta.addAdjust(adjust);
				craftb.addAdjust(adjust);
				diplomacy.addAdjust(adjust);
				disableDevice.addAdjust(adjust);
				disguise.addAdjust(adjust);
				escapeArtist.addAdjust(adjust);
				fly.addAdjust(adjust);
				handleAnimal.addAdjust(adjust);
				heal.addAdjust(adjust);
				intimidate.addAdjust(adjust);
				knowledgeArcana.addAdjust(adjust);
				knowledgeDungeoneering.addAdjust(adjust);
				knowledgeEngineering.addAdjust(adjust);
				knowledgeGeography.addAdjust(adjust);
				knowledgeHistory.addAdjust(adjust);
				knowledgeLocal.addAdjust(adjust);
				knowledgeNature.addAdjust(adjust);
				knowledgeNobility.addAdjust(adjust);
				knowledgePlanes.addAdjust(adjust);
				knowledgeReligion.addAdjust(adjust);
				linguistics.addAdjust(adjust);
				perception.addAdjust(adjust);
				performa.addAdjust(adjust);
				performb.addAdjust(adjust);
				professiona.addAdjust(adjust);
				professionb.addAdjust(adjust);
				professionc.addAdjust(adjust);
				ride.addAdjust(adjust);
				senseMotive.addAdjust(adjust);
				sleightOfHand.addAdjust(adjust);
				spellcraft.addAdjust(adjust);
				stealth.addAdjust(adjust);
				survival.addAdjust(adjust);
				swim.addAdjust(adjust);
				useMagicDevice.addAdjust(adjust);
				continue;
			}
			try{
				Skill addition = this.getSkill(adjust.getWhatAdjust());
				addition.addAdjust(adjust);
			} catch (RuntimeException e) {
				continue;
			}
		}
		for (Special special : adjustment.skillSpecials) {
			skillSpecials.add(special);
		}
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(skillString("Acrobatics", acrobatics));
		str.append(skillString("Appraise",appraise));
		str.append(skillString("Bluff",bluff));
		str.append(skillString("Climb",climb));
		str.append(skillString("Craft A",crafta));
		str.append(skillString("Craft B",craftb));
		str.append(skillString("Diplomacy",diplomacy));
		str.append(skillString("Disable Device",disableDevice));
		str.append(skillString("Disguise",disguise));
		str.append(skillString("Escape Artist",escapeArtist));
		str.append(skillString("Fly",fly));
		str.append(skillString("Handle Animal",handleAnimal));
		str.append(skillString("Heal",heal));
		str.append(skillString("Intimidate",intimidate));
		str.append(skillString("Knowledge(Arcana)",knowledgeArcana));
		str.append(skillString("Knowledge(Dungeoneering)",knowledgeDungeoneering));
		str.append(skillString("Knowledge(Engineering)",knowledgeEngineering));
		str.append(skillString("Knowledge(Geography)",knowledgeGeography));
		str.append(skillString("Knowledge(History)",knowledgeHistory));
		str.append(skillString("Knowledge(Local)",knowledgeLocal));
		str.append(skillString("Knowledge(Nature)",knowledgeNature));
		str.append(skillString("Knowledge(Nobility)",knowledgeNobility));
		str.append(skillString("Knowledge(Planes)",knowledgePlanes));
		str.append(skillString("Knowledge(Religion)",knowledgeReligion));
		str.append(skillString("Linguistics",linguistics));
		str.append(skillString("Perception",perception));
		str.append(skillString("Perform A",performa));
		str.append(skillString("Perform B",performb));
		str.append(skillString("Profession A",professiona));
		str.append(skillString("Profession B",professionb));
		str.append(skillString("Profession C",professionc));
		str.append(skillString("Ride",ride));
		str.append(skillString("Sense Motive",senseMotive));
		str.append(skillString("Sleight of Hand",sleightOfHand));
		str.append(skillString("Spellcraft: ", spellcraft));
		str.append(skillString("Stealth: ",stealth));
		str.append(skillString("Survival: ",survival));
		str.append(skillString("Swim: ",swim));
		str.append(skillString("Use Magic Device: ",useMagicDevice));
		str = new StringBuilder(Character.wordWrap(str.toString(), "  ", 80));
		for (Special special : skillSpecials) {
			str.append("\n" + special);
		}
		return str.toString();
	}
	
	private String skillString(String name, Skill skill) {
		if (skill.getBonus() == 0 || skill.getBonus() == -999)
			return "";
		else
			return (name + (skill.isClassSkill() ? "*" : "") + ": " + skill + "  ");
	}

	public void classSkill(String skill) {
		if (skill.toLowerCase().equals("craft")) {
			crafta.makeClassSkill();
			craftb.makeClassSkill();
		} else if (skill.toLowerCase().equals("perform")) {
			performa.makeClassSkill();
			performb.makeClassSkill();
		} else if (skill.toLowerCase().equals("profession")) {
			professiona.makeClassSkill();
			professionb.makeClassSkill();
			professionc.makeClassSkill();
		} else {
			this.getSkill(skill).makeClassSkill();
		}
	}
}
