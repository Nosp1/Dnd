package Races;

import handlers.SettingsReader;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
        @Type(value = Dragonborn.class, name = "dragonborn"),
        @Type(value = Dwarf.class, name = "dwarf"),
        @Type(value = Elf.class, name = "elf"),
        @Type(value = Gnome.class, name = "gnome"),
        @Type(value = HalfElf.class, name = "halfelf"),
        @Type(value = Halfling.class, name = "halfling"),
        @Type(value = HalfOrc.class, name = "halforc"),
        @Type(value = Human.class, name = "human"),
        @Type(value = Tiefling.class, name = "tiefling")
})
public abstract class Race {

    private String name;
    private int maxAge;
    private String languages;
    private int raceIncreaseStats;
    private ArrayList<String> availableStats;

    private ResourceBundle text = SettingsReader.getResourceBundle("Race");

    public Race() { }

    public Race(String nameIn, int maxAgeIn, String languagesIn, int raceIncreaseStatsIn, String[] availableStatsIn) {

        setName(nameIn);
        setMaxAge(maxAgeIn);
        setLanguages(languagesIn);
        setRaceIncrasestats(raceIncreaseStatsIn);
        setAvailablestats(availableStatsIn);

    }

    private void setAvailablestats(String[] availableStatsIn) {
        availableStats = new ArrayList<>(Arrays.asList(availableStatsIn));
    }

    public String[] getAvailableStats() {
        return (String[]) availableStats.toArray();
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

    public static void printProperties(String[] temp, int counter) {
        for (String s : temp) {
            System.out.println(" # " + (counter + 1) + " " + s);
            counter++;
        }
    }

    @Override
    public String toString() {
        return "{"
                + "\n  race name="
                + name
                + ",\n  max age="
                + maxAge
                + ",\n  languages="
                + languages
                + ",\n  raceIncreaseStats="
                + raceIncreaseStats
                + ",\n  availableStats="
                + availableStats;
    }

}
