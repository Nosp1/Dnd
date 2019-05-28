package Classes.Races;

import Classes.Race;

/*
The Tiefling race.
@Author Trym Staurheim
 */

public class Tiefling extends Race {
    private String darkVision, hellishRebuke, infernalLegacy;
    public Tiefling(String raceName, int maxAge, int raceIncreaseStats, String languages, String[] availableStats, String darkVision, String hellishRebuke, String infernalLegacy) {
        super(raceName, maxAge, raceIncreaseStats, languages, availableStats);
        this.darkVision = darkVision;
        this.hellishRebuke = hellishRebuke;
        infernalLegacy = infernalLegacy;
    }
}
