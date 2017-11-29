# XPathSheet
A WIP pathfinder character sheet. This will not natively store ANY data from Paizo, and is therefore fully customizable.

# Code usage
All necessary functions to retrieve and set data ~are~ (will be) in the character class. 

## Adjustments
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
| Strength (STR) | Attack | HP | Skills | Cantrips | None yet |
| Dexterity (DEX) | Damage | Fort save (Fort) | [Any skill that isn't knowledge, craft, perform, or profession] | L[1-9] SPD | |
| Constitution (CON)| Initiative | Fortitude Save (Fortitude)| Craft [A, B] | [0th-9th] Level spells per day | |
| Intelligence (INT) | BAB | Ref save (Ref) | Perform [A, B] | Level [0-9] spells per day | |
| Wisdom (WIS) | Land speed (Speed) | Reflex save (Reflex) | Profession [A, B, C] | | |
| Charisma (CHA)| Climb speed | Will save (Will) | Knowledge [type without any parenthesis] | | |
| | Fly speed | Saving throw (Saves) | | | |
| | Swim speed | Armor | | | |
| | Burrow speed | Shield | | | |
| | | AC Enhancement | | | |
| | | Deflection | | | |
| | | Natural Armor (NA) | | | |
| | | Dodge | | | |
| | | Max dex [bonus] (max dexterity bonus)| | | |
| | | Armor check [penalty] | | | |
| | | Arcane Spell Failure | | | |

Adjustments also have the ability to add special, non-adjusting values to offense, defense, skill, and general values. These functions are `addOffenseSpecial`, `addDefenseSpecial`, `addSkillSpecial`, and `addSpecial`. A great example is what happens when a kitsune turns human. 

```java
becomeHuman.addSkillSpecial("Change Shape", "+10 to disguise to appear human");
```

Adjustments also have the ability to add attacks