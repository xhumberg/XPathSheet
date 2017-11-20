package character;

public class Item {
	String name;
	int value;
	int weight;
	Adjustment itemAdjust;

	public Item(String name, int value, int weight, Adjustment adjustment) {
		this.name = name;
		this.value = value;
		this.weight = weight;
		this.itemAdjust = adjustment;
	}
}
