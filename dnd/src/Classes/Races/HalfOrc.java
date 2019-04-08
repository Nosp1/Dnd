package Classes.Races;

import Classes.Race;

public class HalfOrc extends Race {
    private  String darkVision, relentlessEndurance, savageAttacks;
    private String menacing; //todo needs a function to get proficiency in a Intimidation.
    public HalfOrc(String raceName, int maxAge, int raceIncreaseStats, String languages, String[] availableStats, String darkVision, String relentlessEndurance, String savageAttacks, String menacing) {
        super(raceName, maxAge, raceIncreaseStats, languages, availableStats);
        this. darkVision = darkVision;
        this.relentlessEndurance = relentlessEndurance;
        this.savageAttacks = savageAttacks;
        this.menacing = menacing;
    }
}
