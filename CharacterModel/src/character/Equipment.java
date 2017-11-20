package character;

import java.util.ArrayList;
import java.util.List;

public class Equipment {
	/*
	 * An item has an adjustment, a weight, and a value.
	 */
	private List<Item> equipment;
	
	public Equipment() {
		equipment = new ArrayList<Item>();
	}

	public void add(String name, int value, int weight, Adjustment adjustment) {
		equipment.add(new Item(name, value, weight, adjustment));
	}
}
