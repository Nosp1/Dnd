package Races;

import handlers.SettingsReader;

import java.util.ResourceBundle;

public abstract class Race {

    private String name;
    private int maxAge;
    private String languages;
    private int raceIncreaseStats;
    private String[] availableStats;

    private ResourceBundle text = SettingsReader.getResourceBundle("Race");


    public Race(String nameIn, int maxAgeIn, String languagesIn, int raceIncreaseStatsIn, String[] availableStatsIn) {

        setName(nameIn);
        setMaxAge(maxAgeIn);
        setLanguages(languagesIn);
        setRaceIncrasestats(raceIncreaseStatsIn);
        setAvailablestats(availableStatsIn);

    }

    private void setAvailablestats(String[] availableStatsIn) {
        availableStats = availableStatsIn;
    }

    public String[] getAvailableStats() {
        return availableStats;
    }

    private void setRaceIncrasestats(int raceIncreaseStatsIn) {
        raceIncreaseStats = raceIncreaseStatsIn;
    }

    public int getRaceIncreaseStats() {
        return raceIncreaseStats;
    }

    private void setName(String nameIn) {

        name = nameIn;

    }

    private void setMaxAge(int maxAgeIn) {

        maxAge = maxAgeIn;

    }

    private void setLanguages(String languagesIn) {

        languages = languagesIn;

    }


    public String getName() {

        return name;

    }

    public int getMaxAge() {

        return maxAge;

    }

    public String getLanguages() {

        return languages;

    }

    protected static void printProperties(String[] temp, int counter) {
        for (String s : temp) {
            System.out.println(" # " + (counter + 1) + " " + s);
            counter++;
        }
    }

}
