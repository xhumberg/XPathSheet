package character;

import java.util.ArrayList;
import java.util.List;

class Stat {
	private int base;
	private int temp;
	private List<Adjust> adjustments;
	private int score;
	private int mod;
	
	Stat() {
		this(10);
	}
	
	Stat(int base) {
		this.base = base;
		temp = 0;
		adjustments = new ArrayList<Adjust>();
		score = 10;
		mod = 0;
	}
	
	int getScore() {
		recalculate();
		return score;
	}
	
	int getMod() {
		recalculate();
		return mod;
	}
	
	void setBase(int base) {
		this.base = base;
	}
	
	int getBase() {
		recalculate();
		return base;
	}
	
	void setTemp(int temp) {
		this.temp = temp;
	}
	
	int getTemp() {
		recalculate();
		return temp;
	}
	
	void addAdjust(Adjust addMe){
		adjustments.add(addMe);
	}
	
	void removeAdjust(int id) {
		int index = 0;
		while (index < adjustments.size()) {
			if (adjustments.get(index).isID(id)) {
				adjustments.remove(index);
				continue;
			}
			index++;
		}
	}
	
	private void recalculate() {
		score = base + temp;
		for (Adjust adj : adjustments) {
			score = adj.applyAdjustment(score);
		}
		mod = (int)Math.floor((score - 10.0) / 2.0);
	}
	
	public String toString() {
		recalculate();
		return score + " (" + mod + ")";
		
	}
}
