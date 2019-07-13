package Races;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

/*
The core race of Tiefling. All properties are strings.

 */
@JsonTypeName("tiefling")
public class Tiefling extends Race {
    @JsonProperty("@type")
    private final String type = "tiefling";

    private String darkVision;
    private String hellishRebuke; //restistance to fire damage?
    private String infernalLegacy; //can speak infernal

    public Tiefling() { }

    public Tiefling(String nameIn, int maxAgeIn, String languagesIn, int raceIncreaseStatsIn, String[] availableStatsIn, String darkVisionIn, String hellishRebukeIn, String infernalLegacyIn) {
        super(nameIn, maxAgeIn, languagesIn, raceIncreaseStatsIn, availableStatsIn);
        setDarkVision(darkVisionIn);
        setHellishRebuke(hellishRebukeIn);
        setInfernalLegacy(infernalLegacyIn);
    }

    @Override
    public String toString() {
        return super.toString()
                + ",\n  dark vision"
                + darkVision
                + ",\n  hellish rebuke="
                + hellishRebuke
                + ",\n  infernal legacy="
                + infernalLegacy
                + "\n }";
    }

    public String getDarkVision() {
        return darkVision;
    }

    public void setDarkVision(String darkVisionIn) {
        this.darkVision = darkVisionIn;
    }

    public String getHellishRebuke() {
        return hellishRebuke;
    }

    public void setHellishRebuke(String hellishRebukeIn) {
        this.hellishRebuke = hellishRebukeIn;
    }

    public String getInfernalLegacy() {
        return infernalLegacy;
    }

    public void setInfernalLegacy(String infernalLegacyIn) {
        this.infernalLegacy = infernalLegacyIn;
    }
}
