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
		base = 10;
		temp = 0;
		adjustments = new ArrayList<Adjust>();
		score = 10;
		mod = 0;
	}
	
	int getScore() {
		return score;
	}
	
	int getMod() {
		return mod;
	}
	
	void setBase(int base) {
		this.base = base;
		recalculate();
	}
	
	int getBase() {
		return base;
	}
	
	void setTemp(int temp) {
		this.temp = temp;
		recalculate();
	}
	
	int getTemp() {
		return temp;
	}
	
	void addAdjust(Adjust addMe){
		adjustments.add(addMe);
		recalculate();
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
