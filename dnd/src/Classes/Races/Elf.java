package Classes.Races;

import Classes.Race;
/*
This is the standard Elf race. Currently has all Standard Elf features added as strings.
Todo need to add printable methods for FeyAncestry, Use same method for Darkvision as Dwarf. Keen Senses, and Trance.
 Todo IF TIME:  Add the standard edition sub races. Wood elf and High elf. Need player input method when player chooses elf.

 */

public class Elf extends Race {
    private String feyAncestry; //Cannot be charmed or put to sleep. Advantage on save
    protected String darkVision; // has darkvison. can seee up to x feet in dim light.
    protected String keenSenses; // has proficiency in keenSenses;
    protected String trance;

    public Elf(String racename, int maxAge, String feyAncestry, int raceIncreaseStats, String languages, String darkVision, String keenSenses, String trance, String[] availableStats){
        super(racename,maxAge,raceIncreaseStats,languages,availableStats);
        this.feyAncestry=feyAncestry;
        this.keenSenses=keenSenses;
        this.darkVision=darkVision;
        this.trance=trance;
    }

    public String getFeyAncestry() {
        return feyAncestry;
    }

    public void setFeyAncestry(String feyAncestry) {
        this.feyAncestry = feyAncestry;
    }

    public String getDarkVision() {
        return darkVision;
    }

    public void setDarkVision(String darkVision) {
        this.darkVision = darkVision;
    }

    public String getKeenSenses() {
        return keenSenses;
    }

    public void setKeenSenses(String keenSenses) {
        this.keenSenses = keenSenses;
    }

    public String getTrance() {
        return trance;
    }

    public void setTrance(String trance) {
        this.trance = trance;
    }
}
