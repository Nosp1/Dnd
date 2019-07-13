package Races;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

/*
This is the Core Elf race. Currently has all standard elf features added as strings.
@Author Trym Staurheim
 */
@JsonTypeName("elf")
public class Elf extends Race {
    @JsonProperty("@type")
    private final String type = "elf";

    private String darkVision;
    private String feyAncestry;
    private String keenSenses;
    private String trance;

    public Elf() { }

    public Elf(String nameIn, int maxAgeIn, String languagesIn, int raceIncreaseStatsIn, String[] availableStatsIn, String darkVisionIn, String feyAncestryIn, String keenSensesIn, String tranceIn) {
        super(nameIn, maxAgeIn, languagesIn, raceIncreaseStatsIn, availableStatsIn);
        setDarkVision(darkVisionIn);
        setFeyAncestry(feyAncestryIn);
        setKeenSenses(feyAncestryIn);
        setTrance(tranceIn);
    }

    //TODO: Hver sub-klasse må override sin egen toString, og kalle på super.toString() først
    @Override
    public String toString() {
        return super.toString()
                + ",\n  darkvision="
                + darkVision
                +",\n  feyAncestry="
                + feyAncestry
                +",\n  keenSenses="
                + keenSenses
                +",\n  trance="
                + trance
                + "\n }";
    }

    public String getDarkVision() {
        return darkVision;
    }

    public void setDarkVision(String darkVisionIn) {
        this.darkVision = darkVisionIn;
    }

    public String getFeyAncestry() {
        return feyAncestry;
    }

    public void setFeyAncestry(String feyAncestryIn) {
        this.feyAncestry = feyAncestryIn;
    }

    public String getKeenSenses() {
        return keenSenses;
    }

    public void setKeenSenses(String keenSensesIn) {
        this.keenSenses = keenSensesIn;
    }

    public String getTrance() {
        return trance;
    }

    public void setTrance(String tranceIn) {
        this.trance = tranceIn;
    }


}
