package Races;
/*
The Core Gnome Race. Has all Gnome features added.
@Author Trym Staurheim
todo needs informaton on properties.
 */

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
