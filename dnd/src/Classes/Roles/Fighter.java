package Classes.Roles;

import Classes.Role;
/*
The Fighter Role/class
@Author Trym Staurheim
 */

public class Fighter extends Role {

    private String secondWind, fighingSTyle;
    private String fightingStyle;
    public Fighter(String rollerName, int baseHp, String[] availableSkills, String fightingStyle, String secondWind, int amountOfSkills) {
        super(rollerName, baseHp, availableSkills,amountOfSkills);
        this.fightingStyle= fightingStyle;
        this.secondWind = secondWind;
    }
}
