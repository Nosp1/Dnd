package Classes.Races;

import Classes.Race;
/*
The Race of Dragon Born. Currently has two intrinsic properties.
Todo need to add color choice for your dragon -> ref: dragon breath.
Todo needs to add a print for dragon breath properties.
 */

public class Dragonborn extends Race {
    private String draconicAncestry;
    private String breathWeapon;


    public Dragonborn(String racename, int maxAge, int raceIncreaseStats, String languages, String[] availableStats, String draconicAncestry, String breathWeapon){
        super (racename,maxAge,raceIncreaseStats, languages, availableStats );
        this.draconicAncestry = draconicAncestry;
        this.breathWeapon = breathWeapon;
    }
}
