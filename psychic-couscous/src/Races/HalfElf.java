package Races;
/*
The  core Half elf race. Has all properties as strings.
@Author Trym Staurheim
 */

import handlers.Stat;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
@JsonTypeName("halfelf")
public class HalfElf extends Race {
    @JsonProperty("@type")
    private final String type = "halfelf";
    private String feyAncestry;
    private String darkVision;
    private String skillVersatility;

    public HalfElf() { }

    public HalfElf(String nameIn, int maxAgeIn, String languagesIn, int raceIncreaseStatsIn, String[] availableStatsIn, String darkVisionIn, String feyAncestryIn,
                   String skillVersatilityIn ) {
        super(nameIn, maxAgeIn, languagesIn, raceIncreaseStatsIn, availableStatsIn);
        setDarkVision(darkVisionIn);
        setFeyAncestry(feyAncestryIn);
        setSkillVersatility(skillVersatilityIn);
    }

    @Override
    public String toString() {
        return super.toString()
                + ",\n  fey ancestry="
                + feyAncestry
                + ",\n  darkvision="
                + darkVision
                + ",\n  skill versatility="
                + skillVersatility
                + ",\n }";
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
