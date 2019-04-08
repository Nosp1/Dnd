package Classes.Races;

import Classes.Race;

public class Gnome extends Race {
    private String darkVision, gnomeCunning;

    public String getDarkVision() {
        return darkVision;
    }

    public void setDarkVision(String darkVision) {
        this.darkVision = darkVision;
    }

    public String getGnomeCunning() {
        return gnomeCunning;
    }

    public void setGnomeCunning(String gnomeCunning) {
        this.gnomeCunning = gnomeCunning;
    }

    public Gnome(String raceName, int maxAge, int raceIncreaseStats, String languages, String[] availableStats, String gnomeCunning, String darkVision) {
        super(raceName, maxAge, raceIncreaseStats, languages, availableStats);

    }
}
