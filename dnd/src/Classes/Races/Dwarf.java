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
    private String dwarvenResilience;
    private String toolProficiceny;

    public Dwarf(String raceName, int maxAge, int raceIncreaseStats, String languages, String[] availableStats, String darkVision, String dwarwenCombatTraining, String stoneCunning, String dwarvenResilience, String toolProficiceny) {
        super(raceName, maxAge, raceIncreaseStats, languages, availableStats);
        this.darkVision = darkVision;
        this.dwarwenCombatTraining = dwarwenCombatTraining;
        this.stoneCunning = stoneCunning;
        this.dwarvenResilience = dwarvenResilience;
        this.toolProficiceny = toolProficiceny;
    }

    public String getDarkVision() {
        return darkVision;
    }

    public void setDarkVision(String darkVision) {
        this.darkVision = darkVision;
    }

    public String getDwarwenCombatTraining() {
        return dwarwenCombatTraining;
    }

    public void setDwarwenCombatTraining(String dwarwenCombatTraining) {
        this.dwarwenCombatTraining = dwarwenCombatTraining;
    }

    public String getStoneCunning() {
        return stoneCunning;
    }

    public void setStoneCunning(String stoneCunning) {
        this.stoneCunning = stoneCunning;
    }

    public String getDwarvenResilience() {
        return dwarvenResilience;
    }

    public void setDwarvenResilience(String dwarvenResilience) {
        this.dwarvenResilience = dwarvenResilience;
    }

    public String getToolProficiceny() {
        return toolProficiceny;
    }

    public void setToolProficiceny(String toolProficiceny) {
        this.toolProficiceny = toolProficiceny;
    }
}
