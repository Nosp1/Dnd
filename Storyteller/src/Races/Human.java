package Races;
/*
the Core Human race. All properties as strings.
@Author Trym Staurheim
  todo, need to be able to pick extra language.
  */

public class Human extends Race {
    private String extraLanguage;


    public Human(String nameIn, int maxAgeIn, String languagesIn, int raceIncreaseStatsIn, String[] availableStatsIn, String extraLanguageIn) {
        super(nameIn, maxAgeIn, languagesIn, raceIncreaseStatsIn, availableStatsIn);
        setExtraLanguage(languagesIn);
    }

    public String getExtraLanguage() {
        return extraLanguage;
    }

    private void setExtraLanguage(String extraLanguageIn) {
        this.extraLanguage = extraLanguageIn;
    }
}
