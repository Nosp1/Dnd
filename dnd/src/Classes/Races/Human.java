package Classes.Races;

import Classes.Race;
import Classes.Statroller;



//increase in stats +1 to all or +1 to 2. and extra skill + extra language.
public class Human extends Race {
    private String extraLanguage;

    public Human(String raceName, int maxAge, int raceIncreaseStats, String languages, String extraLanguage, String[] availableStats) {
        super(raceName, maxAge, raceIncreaseStats, languages,availableStats);
        this.extraLanguage = extraLanguage;




    }
}
