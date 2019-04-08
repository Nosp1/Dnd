package Classes.Races;

import Classes.Race;
/*
The half elf race.
@Author Trym Staurheim
 */

public class HalfElf extends Race {
    private String feyAncestry, darkVision, skillVersatility;
    public HalfElf(String raceName, int maxAge, int raceIncreaseStats, String languages, String[] availableStats, String feyAncestry, String darkVision, String skillVersatility) {
        super(raceName, maxAge, raceIncreaseStats, languages, availableStats);
        this.feyAncestry = feyAncestry;
        this.darkVision = darkVision;
        this.skillVersatility = skillVersatility;
    }

    public String getFeyAncestry() {
        return feyAncestry;
    }

    public void setFeyAncestry(String feyAncestry) {
        this.feyAncestry = feyAncestry;
    }

    public String getDarkVision() {
        return darkVision;
    }

    public void setDarkVision(String darkVision) {
        this.darkVision = darkVision;
    }

    public String getSkillVersatility() {
        return skillVersatility;
    }

    public void setSkillVersatility(String skillVersatility) {
        this.skillVersatility = skillVersatility;
    }
}
