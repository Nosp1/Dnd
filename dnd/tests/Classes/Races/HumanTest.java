package Classes.Races;

import org.junit.Before;
/*
The test for asserting human as a race.
@Author Trym Staurheim
 */
public class HumanTest {

    private String raceName;
    private int maxAge;
    private int raceIncreaseStats;
    private String languages;
    private String extraLanguage;
    private String[] availableStats;

    private Human humanUnderTest;

    @Before
    public void setUp() {
        raceName = "raceName";
        maxAge = 0;
        raceIncreaseStats = 0;
        languages = "languages";
        extraLanguage = "extraLanguage";
        availableStats = new String[]{};
        humanUnderTest = new Human(raceName, maxAge, raceIncreaseStats, languages, extraLanguage, availableStats);
    }

}
