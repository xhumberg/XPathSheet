package character;

import java.util.ArrayList;
import java.util.List;

public class Skill {
	private int ranks;
	private int temp;
	private boolean classSkill;
	private List<Adjust> adjustments;
	private int bonus;
	private Stat stat;
	private List<String> specials;
	private boolean trainedOnly;
	
	public Skill(Stat stat, boolean trainedOnly) {
		this.stat = stat;
		ranks = 0;
		temp = 0;
		classSkill = false;
		adjustments = new ArrayList<Adjust>();
		this.trainedOnly = trainedOnly;
		specials = new ArrayList<String>();
	}
	public int getRanks() {
		return ranks;
	}
	public void addRank() {
		ranks++;
	}
	public void addRanks(int i) {
		ranks += i;
	}
	public void setRanks(int ranks) {
		this.ranks = ranks;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public boolean isClassSkill() {
		return classSkill;
	}
	public void makeClassSkill() {
		classSkill = true;
	}
	public int getBonus() {
		recalculate();
		return bonus;
	}
	public void recalculate() {
		if (trainedOnly && ranks < 1) {
			bonus = -999;
			return;
		}
		bonus = ranks + temp + stat.getMod();
		if (classSkill && ranks > 0)
			bonus += 3;
		for (Adjust adjust : adjustments) 
			bonus = adjust.applyAdjustment(bonus);
	}
	public String toString() {
		recalculate();
		return "" + bonus + (specials.size() > 0 ? specials.toString() : "");
	}
	public void addAdjust(Adjust addMe) {
		adjustments.add(addMe);
	}
	public void removeAdjust(int id) {
		int index = 0;
		while (index < adjustments.size()) {
			if (adjustments.get(index).isID(id)) {
				adjustments.remove(index);
				continue;
			}
			index++;
		}
	}
}
