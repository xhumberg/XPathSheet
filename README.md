# XPathSheet
A WIP pathfinder character sheet. This will not natively store ANY data from Paizo, and is therefore fully customizable.

# Code usage
All necessary functions ~are~ (will be) in the character class. The main class for doing anything is called an `Adjustment`. The Adjustment class contains a unique ID and several lists for each type of adjustment that can be made.

The race adjustment can be accessed with `character.race()`, and edited as follows:
```Java
	kitsune.setType("Humanoid (Shapechanger and Kitsune)");
	kitsune.setSize("Medium");
	kitsune.setSpeed(30);
	kitsune.addLanguage("Common");
	kitsune.addLanguage("Sylvan");
	Adjustment race = kitsune.race();
	race.name = "Kitsune";
	race.addAdjust("Charisma", "add", 2);
	race.addAdjust("Dex", "add", 2);
	race.addAdjust("Str", "subtract", 2);
	race.addAdjust("Acrobatics", "add", 2);
	race.addAttack(kitsune.ability("str"), kitsune.ability("str"), kitsune.BAB(), "1d4", "PSB", "Bite");

	race.addSense("Low-Light Vision");
	race.activate(kitsune);
	Adjustment becomeHuman = kitsune.newEffect("Change Shape");
	becomeHuman.addSpecial("Change Shape", "Transform into a specific human (only one per lifetime) and get +10 to disguise to appear human. Changing shape is a standard action");
	becomeHuman.addSkillSpecial("Change Shape", "+10 to disguise to appear human");
	becomeHuman.description = "Appear human";
	Adjustment foxShape = kitsune.newEffect("Fox Shape");
	foxShape.addSpecial("Fox Shape", "Transform into a specific fox (only one per lifetime) and get +10 to disguise to appear as a fox. Changing shape is a standard action");		
	foxShape.addSkillSpecial("Fox Shape", "+10 to disguise to appear as a fox");
	foxShape.description = "Appear as a fox";
```