package Classes;
/*
This is the Race class. It serves as a skeleton for inheritance for all Races.
@Author Trym Staurheim
 */
public abstract class Race {
    private String raceName;
    private int maxAge;
    private int raceIncreaseStats;
    private String languages;
    private String[] availableStats;

    public Race(String raceName, int maxAge, int raceIncreaseStats, String languages, String[] availableStats){
        this.raceName = raceName;
        this.maxAge = maxAge;
        this.raceIncreaseStats = raceIncreaseStats;
        this.languages = languages;
        this.availableStats = availableStats;


    }

    public String[] getAvailableStats() {
        return availableStats;
    }

    public void setAvailableStats(String[] availableStats) {
        this.availableStats = availableStats;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getRaceInrease() {
        return raceIncreaseStats;
    }

    public void setRaceInrease(int raceIncreaseStats) {
        this.raceIncreaseStats = raceIncreaseStats;
    }

    public int getRaceIncreaseStats() {
        return raceIncreaseStats;
    }

    public void setRaceIncreaseStats(int raceIncreaseStats) {
        this.raceIncreaseStats = raceIncreaseStats;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
}
