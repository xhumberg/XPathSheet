# XPathSheet
A WIP pathfinder character sheet. This will not natively store ANY data from Paizo, and is therefore fully customizable.

# Code usage
All necessary functions to retrieve and set data ~are~ (will be) in the character class. 

##Adjustments
The main class for doing anything is called an `Adjustment`. The Adjustment class contains a unique ID and several lists for each type of adjustment that can be made. The primary method wtihin Adjustment is `addAdjust(String whatAdjust, String howAdjust, int valAdjust)`. This method signals the Adjustment to create an Adjust, which will apply to the value specified by the `whatAdjust` field. For example: The race adjustment can be accessed with `character.race()`, and edited as follows:
```java
Character kitsune = new Character...
...
Adjustment race = kitsune.race();
race.addAdjust("Charisma", "add", 2);
race.addAdjust("Dex", "add", 2);
race.addAdjust("Str", "subtract", 2);
```

Current allowed values are:

| Abilities | Offense | Defense | Skills | Spellstuff | Other  |
| --------- | ------- | --------| ------ | ---------- | ------ |
| test1     | test2   | test3   | test4  | test5      | test6  |

Adjustments also have the ability to add special, non-adjusting values to offense, defense, skill, and general values. These functions are `adjustment.addOffenseSpecial(String name, String description`, `adjustment.addDefenseSpecial(String name, String description`, `adjustment.addSkillSpecial(String name, String description`, and `adjustment.addSpecial(String name, String description`. A great example is what happens when a kitsune turns human. 

```java
becomeHuman.addSkillSpecial("Change Shape", "+10 to disguise to appear human");
```

Adjustments also have the ability to add attacks