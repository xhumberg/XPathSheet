package character;

public class Abilities {
	private Stat strength;
	private Stat dexterity;
	private Stat constitution;
	private Stat intelligence;
	private Stat wisdom;
	private Stat charisma;
	
	public Abilities() {
		this(10, 10, 10, 10, 10, 10);
	}
	
	public Abilities(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
		this.strength = new Stat(strength);
		this.dexterity = new Stat(dexterity);
		this.constitution = new Stat(constitution);
		this.intelligence = new Stat(intelligence);
		this.wisdom = new Stat(wisdom);
		this.charisma = new Stat(charisma);
	}
	
	/**
	 * Fetches the Stat requested by the passed string or throws a runtime exception if the string isn't recognized.
	 * 
	 * @param ability - A string representing the ability score you'd like to retrieve (i.e. "strength" or "str")
	 * @return - The Stat that contains the passed 
	 */
	Stat get(String ability) {
		switch(ability.toLowerCase()) {
		case "strength":
		case "str":
			return strength;
		case "dexterity":
		case "dex":
			return dexterity;
		case "constitution":
		case "con":
			return constitution;
		case "intelligence":
		case "int":
			return intelligence;
		case "wisdom":
		case "wis":
			return wisdom;
		case "charisma":
		case "cha":
			return charisma;
		}
		throw new RuntimeException("Ability \"" + ability + "\" doesn't exist");
	}
	
	void addAdjustment(Adjust adjustment) {
		Stat toChange = get(adjustment.getWhatAdjust());
		toChange.addAdjust(adjustment);
	}
	
	void deactivateAdjustment(int id) {
		strength.removeAdjust(id);
		dexterity.removeAdjust(id);
		constitution.removeAdjust(id);
		intelligence.removeAdjust(id);
		wisdom.removeAdjust(id);
		charisma.removeAdjust(id);
	}

	public void activateAdjustment(Adjustment adjustment) {
		deactivateAdjustment(adjustment.id);
		for (Adjust adjust : adjustment.adjustments) {
			try{
				Stat addition = get(adjust.getWhatAdjust());
				addition.addAdjust(adjust);
			} catch (RuntimeException e) {
				continue;
			}
		}
	}
}
