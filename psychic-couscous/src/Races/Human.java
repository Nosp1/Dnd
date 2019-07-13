package Races;
/*
the Core Human race. All properties as strings.
@Author Trym Staurheim
  todo, need to be able to pick extra language.
  */

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

@JsonTypeName("human")
public class Human extends Race {
    @JsonProperty("@type")
    private final String type = "human";

    private String extraLanguage;

    public Human() { }

    public Human(String nameIn, int maxAgeIn, String languagesIn, int raceIncreaseStatsIn, String[] availableStatsIn, String extraLanguageIn) {
        super(nameIn, maxAgeIn, languagesIn, raceIncreaseStatsIn, availableStatsIn);
        setExtraLanguage(languagesIn);
    }

    @Override
    public String toString() {
        return super.toString()
                + ",\n extra language="
                + extraLanguage
                + ",\n }";
    }

    public String getExtraLanguage() {
        return extraLanguage;
    }

    private void setExtraLanguage(String extraLanguageIn) {
        this.extraLanguage = extraLanguageIn;
    }
}
