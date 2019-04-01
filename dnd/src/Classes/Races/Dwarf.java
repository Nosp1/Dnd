package Classes.Races;

import Classes.Race;
/*
This is the Core Dwarf. Currently has String properties for all dwarf features.
Todo needs method to get intrinsic property information. E.G. darkvision
todo need to add DwarvenCombatTraining choice. and print command for what the feature adds
 */

public class Dwarf extends Race {
    private String darkVision;
    private String dwarwenCombatTraining;
    private String stoneCunning;

    public Dwarf(String raceName, int maxAge, int raceIncreaseStats, String languages, String[] availableStats, String darkVision, String dwarwenCombatTraining, String stoneCunning) {
        super(raceName, maxAge, raceIncreaseStats, languages, availableStats);
        this.darkVision = darkVision;
        this.dwarwenCombatTraining = dwarwenCombatTraining;
        this.stoneCunning = stoneCunning;
    }

}
