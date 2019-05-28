package Roles;

import java.util.ArrayList;
/*
The Cleric Role/class
@Author Trym Staurheim
 */

public class Cleric  extends Role{

    public Cleric(String roleNameIn, int baseHpIn, ArrayList<String> availableRoleSkillsIn, int amountOfSkillsIn, ArrayList<String> chosenRoleSkillsIn) {
        super(roleNameIn, baseHpIn, availableRoleSkillsIn, amountOfSkillsIn, chosenRoleSkillsIn);
    }
}
