package character;

public class Adjust {
	private int parentID;
	private int adjustmentType;
	private int adjustValue;
	private String whatAdjust;   //Value adjust should be something like "Strength" or "Stealth"
	
	public int getParentID() {
		return parentID;
	}

	public int getAdjustmentType() {
		return adjustmentType;
	}

	public int getAdjustValue() {
		return adjustValue;
	}

	/***
	 * Creates an adjustment.
	 * 
	 * @param parentID - The ID of the adjustment that created this adjust
	 * @param adjustmentType - The type of adjustment. (0 for set, 1 for add, 2 for subtract)
	 * @param adjustValue - The value to adjust by.
	 */
	Adjust(String whatAdjust, int parentID, int adjustmentType, int adjustValue) {
		this.whatAdjust = whatAdjust;
		this.parentID = parentID;
		this.adjustmentType = adjustmentType;
		this.adjustValue = adjustValue;
	}
	
	int applyAdjustment(int prior) {
		if (adjustmentType == 0)
			return adjustValue;
		if (adjustmentType == 1)
			return prior+adjustValue;
		if (adjustmentType == 2)
			return prior-adjustValue;
		return prior;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder(" - ");
		str.append(whatAdjust + ": ");
		if (adjustmentType == 0)
			str.append("Set to ");
		else if (adjustmentType == 1)
			str.append("Add ");
		else if (adjustmentType == 2)
			str.append("Subtract ");
		str.append(adjustValue);
		return str.toString();
	}
}
