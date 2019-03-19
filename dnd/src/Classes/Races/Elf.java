package Classes.Races;

import Classes.Race;

public class Elf extends Race {
    private String feyAncestry; //Cannot be charmed or put to sleep. Advantage on save
    private String darkVision; // has darkvison. can seee up to x feet in dim light.
    private String keenSenses; // has proficiency in keenSenses;
    private String trance;

    public Elf(String racename, int maxAge, String feyAncestry, int raceIncreaseStats, String languages, String darkVision, String keenSenses, String trance, String[] availableStats){
        super(racename,maxAge,raceIncreaseStats,languages,availableStats);
        this.feyAncestry=feyAncestry;
        this.keenSenses=keenSenses;
        this.darkVision=darkVision;
        this.trance=trance;
    }
}
