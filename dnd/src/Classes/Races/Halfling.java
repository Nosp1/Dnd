package Classes.Races;

import Classes.Race;

public class Halfling extends Race {
    private String lucky, naturallyStealthy, halflingNimbleness;
    private String brave;

    public Halfling(String raceName, int maxAge, int raceIncreaseStats, String languages, String[] availableStats,String lucky, String brave, String naturallyStealthy, String halflingNimbleness) {
        super(raceName, maxAge, raceIncreaseStats, languages, availableStats);
        this.lucky = lucky;
        this.brave = brave;
        this.naturallyStealthy = naturallyStealthy;
        this.halflingNimbleness = halflingNimbleness;
    }

    public String getLucky() {
        return lucky;
    }

    public void setLucky(String lucky) {
        this.lucky = lucky;
    }

    public String getNaturallyStealthy() {
        return naturallyStealthy;
    }

    public void setNaturallyStealthy(String naturallyStealthy) {
        this.naturallyStealthy = naturallyStealthy;
    }

    public String getHalflingNimbleness() {
        return halflingNimbleness;
    }

    public void setHalflingNimbleness(String halflingNimbleness) {
        this.halflingNimbleness = halflingNimbleness;
    }

    public String getBrave() {
        return brave;
    }

    public void setBrave(String brave) {
        this.brave = brave;
    }
}
