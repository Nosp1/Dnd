package Classes.Races;

import Classes.Race;

public class Dragonborn extends Race {
    private String draconicAncestry;
    private String breathWeapon;


    public Dragonborn(String racename, int maxAge, int raceIncreaseStats, String languages, String[] availableStats, String draconicAncestry, String breathWeapon){
        super (racename,maxAge,raceIncreaseStats, languages, availableStats );
        this.draconicAncestry = draconicAncestry;
        this.breathWeapon = breathWeapon;
    }
}
