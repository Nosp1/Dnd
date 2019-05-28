package Classes.Roles;

import Classes.Role;
/*
The Cleric Role/Class.
@Author Trym Staurheim
Todo: Add spell choice.
 */

public class Cleric extends Role {

    public Cleric(String rollerName, int baseHp, String[] availableSkills, int amountOfskills) {
        super(rollerName, baseHp, availableSkills,amountOfskills );
    }
}
