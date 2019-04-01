package Classes.Races;

import Classes.Race;



/*
Human in dnd: has only one intrinsic property.
Todo need to add a method for  extra language choice.
 */
public class Human extends Race {
    private String extraLanguage;

    public Human(String raceName, int maxAge, int raceIncreaseStats, String languages, String extraLanguage, String[] availableStats) {
        super(raceName, maxAge, raceIncreaseStats, languages,availableStats);
        this.extraLanguage = extraLanguage;




    }
}
