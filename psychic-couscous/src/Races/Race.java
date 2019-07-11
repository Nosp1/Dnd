package Races;

import handlers.SettingsReader;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.util.ResourceBundle;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dragonborn.class, name = "Dragonborn"),
        @JsonSubTypes.Type(value = Dwarf.class, name = "Dwarf"),
        @JsonSubTypes.Type(value = Elf.class, name = "Elf"),
        @JsonSubTypes.Type(value = Gnome.class, name = "Gnome"),
        @JsonSubTypes.Type(value = HalfElf.class, name = "Halfelf"),
        @JsonSubTypes.Type(value = Halfling.class, name = "Halfling"),
        @JsonSubTypes.Type(value = HalfOrc.class, name = "HalfOrc"),
        @JsonSubTypes.Type(value = Human.class, name = "Human"),
        @JsonSubTypes.Type(value = Tiefling.class, name = "Tiefling")
})
public abstract class Race {

    private String name;
    private int maxAge;
    private String languages;
    private int raceIncreaseStats;
    private String[] availableStats;

    private ResourceBundle text = SettingsReader.getResourceBundle("Race");

    public Race() {}

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

    public static void printProperties(String[] temp, int counter) {
        for (String s : temp) {
            System.out.println(" # " + (counter + 1) + " " + s);
            counter++;
        }
    }

}
