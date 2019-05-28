package Roles;

import java.util.ArrayList;
/*
The Fighter Role/class
@Author Trym Staurheim
 */

public class Fighter extends Role {
    private String secondWind;
    private String fightingStyle;

    public Fighter(String roleNameIn, int baseHpIn, ArrayList<String> availableRoleSkillsIn, int amountOfSkillsIn, ArrayList<String> chosenRoleSkillsIn, String fightingStyleIn, String secondWindIn) {
        super(roleNameIn, baseHpIn, availableRoleSkillsIn, amountOfSkillsIn, chosenRoleSkillsIn);
        setFightingStyle(fightingStyleIn);
        setSecondWind(secondWindIn);
    }

    public String getSecondWind() {
        return secondWind;
    }

    private void setSecondWind(String secondWindIn) {
        this.secondWind = secondWindIn;
    }

    public String getFightingStyle() {
        return fightingStyle;
    }

    private void setFightingStyle(String fightingStyleIn) {
        this.fightingStyle = fightingStyleIn;
    }
}
