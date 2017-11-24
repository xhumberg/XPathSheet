package character;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Details {
	public String name;
	public char gender;
	private Adjustment race;
	private Adjustment[] classes;
	private int size;
	public String favoredClass;
	private int[] favoredClassBonuses;
	private int level;
	public String type;
	private List<Adjustment> feats;
	private int currentFeat;
	private List<Adjustment> effects;
	private int currentEffect;
	private List<String> senses;
	
	public Details(String name, char gender, String size, String favoredClass, String type) {
		this.name = name;
		this.gender = gender;
		this.size = decodeSize(size);
		this.favoredClass = favoredClass;
		this.favoredClassBonuses = new int[20];
		this.classes = new Adjustment[20];
		level = 0;
		race = new Adjustment(0);
		this.type = type;
		feats = new ArrayList<Adjustment>();
		effects = new ArrayList<Adjustment>();
		currentFeat = 21;
		currentEffect = 121;
		senses = new ArrayList<String>();
	}

	private int decodeSize(String size) {
		switch (size.toLowerCase()) {
		case "fine":
			return -8;
		case "diminutive":
			return -4;
		case "tiny":
			return -2;
		case "small":
			return -1;
		case "medium":
			return 0;
		case "large":
			return 1;
		case "huge":
			return 2;
		case "gargantuan":
			return 4;
		case "colossal":
			return 8;
		}
		throw new RuntimeException("Size " + size + " is invalid");
	}
	
	public Adjustment getRace() {
		return race;
	}
	
	public Adjustment getClasses(int i) {
		return classes[i];
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(String newSize) {
		this.size = decodeSize(newSize);
	}
	
	public Adjustment addLevel(boolean favoredClass, int bonus) {
		classes[level] = new Adjustment(level+1);
		if (favoredClass) {
			favoredClassBonuses[level] = bonus;
		}
		return classes[level++];
	}

	public Adjustment getFeat(String name) {
		for(Adjustment adjust : feats) {
			if (name.toLowerCase().equals(adjust.name.toLowerCase()))
				return adjust;
		}
		//Didn't find it
		return null;
	}
	
	public Adjustment addFeat() {
		if (currentFeat > 120)
			throw new RuntimeException("Too many feats (you have 100). Unable to add more");
		Adjustment newAdjustment = new Adjustment(currentFeat++);
		feats.add(newAdjustment);
		return newAdjustment;
	}

	public Adjustment getEffect(String name) {
		for (Adjustment adjust : effects) {
			if (name.toLowerCase().equals(adjust.name.toLowerCase()))
				return adjust;
		}
		//Didn't find it
		return null;
	}
	
	public Adjustment addEffect() {
		if (currentFeat > 1999)
			throw new RuntimeException("Too many effects (you have over 1750). Unable to add more");
		Adjustment newAdjustment = new Adjustment(currentEffect++);
		effects.add(newAdjustment);
		return newAdjustment;		
	}
	
	public void addSense(String sense) {
		senses.add(sense);
	}
	
	public String getSenses() {
		StringBuilder str = new StringBuilder();
		for (String sense : senses) {
			str.append(sense + ", ");
		}
		if (str.length() > 2)
			return str.substring(0, str.length()-2);
		return str.toString();
	}

	public int getLevel() {
		return level;
	}
	
	public String getClassesString() {
		Set<String> classNames = new HashSet<String>();
		for(Adjustment level : classes) {
			if (level != null)
				classNames.add(level.name);
		}
		StringBuilder str = new StringBuilder();
		for(String className : classNames) {
			int specificLevel = 0;
			for(Adjustment level : classes) {
				if (level != null)
					if (level.name.equals(className))
						specificLevel++;
			}
			str.append(className + " " + specificLevel + " \\ ");
		}
		if (str.length()-3 >= 0)
			return str.substring(0, str.length()-3);
		return str.toString();
	}

	public Object featList() {
		StringBuilder str = new StringBuilder();
		for (Adjustment feat : feats) {
			str.append(feat.name + ", ");
		}
		if (str.length() > 2)
			return str.substring(0, str.length()-2);
		return str.toString();
	}

	public int getHPBonus() {
		return getClassBonus(0);
	}
	
	private int getClassBonus(int bonus) {
		int result = 0;
		for (int i = 0; i < 20; i++) {
			if (classes[i] != null)
				if (classes[i].name.equals(favoredClass))
					if(this.favoredClassBonuses[i] == bonus)
						result++;
		}
		return result;
	}

	public int getSkillBonus() {
		return getClassBonus(1);
	}
	
	public int getRacialBonus() {
		return getClassBonus(2);
	}
}
