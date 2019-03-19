package Classes.Races;

import Classes.Race;

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
