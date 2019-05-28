package Races;
/*
The  core Half elf race. Has all properties as strings.
@Author Trym Staurheim
 */

import handlers.Stat;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HalfElf extends Race {
    private String feyAncestry;
    private String darkVision;
    private String skillVersatility;



    public HalfElf(String nameIn, int maxAgeIn, String languagesIn, int raceIncreaseStatsIn, String[] availableStatsIn, String darkVisionIn, String feyAncestryIn,
                   String skillVersatilityIn ) {
        super(nameIn, maxAgeIn, languagesIn, raceIncreaseStatsIn, availableStatsIn);
        setDarkVision(darkVisionIn);
        setFeyAncestry(feyAncestryIn);
        setSkillVersatility(skillVersatilityIn);


    }



    public String getFeyAncestry() {
        return feyAncestry;
    }

    public void setFeyAncestry(String feyAncestryIn) {
        this.feyAncestry = feyAncestryIn;
    }

    public String getDarkVision() {
        return darkVision;
    }

    public void setDarkVision(String darkVisionIn) {
        darkVision = darkVisionIn;
    }

    public String getSkillVersatility() {
        return skillVersatility;
    }

    public void setSkillVersatility(String skillVersatilityIn) {
        this.skillVersatility = skillVersatilityIn;
    }
}
