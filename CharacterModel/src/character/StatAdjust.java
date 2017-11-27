package character;

public class StatAdjust extends Adjust {
	double multiplier;
	Stat stat;
	String partOfStat;
	int min;
	
	StatAdjust(String whatAdjust, int parentID, int adjustmentType, int adjustValue) {
		super(whatAdjust, parentID, adjustmentType, adjustValue);
		throw new RuntimeException("This constructor is invalid");
	}
	
	StatAdjust(String whatAdjust, int parentID, int adjustmentType, Stat stat, String partOfStat, double multiplier, int min) {
		super(whatAdjust, parentID, adjustmentType, (int)(stat.getMod()*multiplier));
		this.stat = stat;
		this.multiplier = multiplier;
		this.partOfStat = partOfStat;
		this.min = min;
	}
	
	@Override
	public int applyAdjustment(int value) {		
		int val = 0;
		if (partOfStat.toLowerCase().equals("mod"))
			val = stat.getMod();
		else if (partOfStat.toLowerCase().equals("base"))
			val = stat.getBase();
		
		val = Math.max(min, (int)(val*multiplier));
		
		if (super.getAdjustmentType() == 0)
			return val;
		else if (super.getAdjustmentType() == 1)
			return value + val;
		else if (super.getAdjustmentType() == 2)
			return value - val;
		else return value;
	}
	
	@Override
	public String toString() {
		return super.getWhatAdjust() + ": adjusted by stat";
	}
	
}
