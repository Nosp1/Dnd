package Races;

import org.codehaus.jackson.annotate.JsonTypeName;

/*
The Core Gnome Race. Has all Gnome features added.
@Author Trym Staurheim
 */
@JsonTypeName("gnome")
public class Gnome extends Race {
    private String darkVision;
    private String gnomeCunning;

    public Gnome(String nameIn, int maxAgeIn, String languagesIn, int raceIncreaseStatsIn, String[] availableStatsIn, String darkVisionIn, String gnomeCunningIn) {
        super(nameIn, maxAgeIn, languagesIn, raceIncreaseStatsIn, availableStatsIn);
    }

    public String getDarkVision() {
        return darkVision;
    }

    public void setDarkVision(String darkVisionIn) {
        this.darkVision = darkVisionIn;
    }

    public String getGnomeCunning() {
        return gnomeCunning;
    }

    public void setGnomeCunning(String gnomeCunningIn) {
        this.gnomeCunning = gnomeCunningIn;
    }
}
