package Roles;

import java.util.ArrayList;
/*
The Druid Role/class
@Author Trym Staurheim
 */

public class Druid extends Role {
    public Druid(String roleNameIn, int baseHpIn, ArrayList<String> availableRoleSkillsIn, int amountOfSkillsIn, ArrayList<String> chosenRoleSkillsIn) {
        super(roleNameIn, baseHpIn, availableRoleSkillsIn, amountOfSkillsIn, chosenRoleSkillsIn);
    }
}
