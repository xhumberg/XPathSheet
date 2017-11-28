# XPathSheet
A WIP pathfinder character sheet. This will not natively store ANY data from Paizo, and is therefore fully customizable.

# Code usage
All necessary functions ~are~ (will be) in the character class. The main class for doing anything is called an `Adjustment`. The Adjustment class contains a unique ID and several lists for each type of adjustment that can be made. The primary method wtihin Adjustment is `addAdjust(String whatAdjust, String howAdjust, int valAdjust)`. This method signals the Adjustment to create an Adjust, which will apply to the value specified by the `whatAdjust` field. For example: The race adjustment can be accessed with `character.race()`, and edited as follows:
```java
Character kitsune = new Character...
...
Adjustment race = kitsune.race();
race.addAdjust("Charisma", "add", 2);
race.addAdjust("Dex", "add", 2);
race.addAdjust("Str", "subtract", 2);
```