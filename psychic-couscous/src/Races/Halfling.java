package Races;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

/*
The core Halfing Race. Has all properties as strings.
@Author Trym Staurheim
 */
@JsonTypeName("halfling")
public class Halfling extends Race {
    @JsonProperty("@type")
    private final String type = "halfling";

    String lucky;
    String naturallyStealthy;
    String halflingNimbleness;
    String brave;

    public Halfling() { }

    public Halfling(String nameIn, int maxAgeIn, String languagesIn, int raceIncreaseStatsIn, String[] availableStatsIn, String luckyIn, String naturallyStealthyIn, String halflingNimblenessIn, String braveIn) {
        super(nameIn, maxAgeIn, languagesIn, raceIncreaseStatsIn, availableStatsIn);
        setBrave(braveIn);
        setHalflingNimbleness(halflingNimblenessIn);
        setLucky(luckyIn);
        setNaturallyStealthy(naturallyStealthyIn);
    }

    public String getLucky() {
        return lucky;
    }

    private void setLucky(String luckyIn) {
        this.lucky = luckyIn;
    }

    public String getNaturallyStealthy() {
        return naturallyStealthy;
    }

    private void setNaturallyStealthy(String naturallyStealthyIn) {
        this.naturallyStealthy = naturallyStealthyIn;
    }

    public String getHalflingNimbleness() {
        return halflingNimbleness;
    }

    private void setHalflingNimbleness(String halflingNimblenessIn) {
        this.halflingNimbleness = halflingNimblenessIn;
    }

    public String getBrave() {
        return brave;
    }

    private void setBrave(String braveIn) {
        this.brave = braveIn;
    }
}
