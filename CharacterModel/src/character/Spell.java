package character;

public class Spell {
	String name;
	int level;
	String school;
	String duration;
	String castTime;
	int range;
	String simpleDescription;
	String save;
	boolean spellResist;
	String fullDescription;
	
	public Spell(String name, int level, String school, String duration, String castTime, int range, String simpleDescription, String save, boolean spellResist, String fullDescription) {
		this.name = name;
		this.level = level;
		this.school = school;
		this.duration = duration;
		this.castTime = castTime;
		this.range = range;
		this.simpleDescription = simpleDescription;
		this.save = save;
		this.spellResist = spellResist;
		this.fullDescription = fullDescription;
	}
	
	public String toString() {
		return name + ": " + simpleDescription;
	}
}
