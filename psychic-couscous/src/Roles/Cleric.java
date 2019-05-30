package Roles;



import handlers.Skill;

import java.util.ArrayList;

import static handlers.Utilities.getSkills;
/*
The Cleric Role/class
@Author Trym Staurheim
todo add domain choice
 */

public class Cleric  extends Role{

    public Cleric(String roleNameIn, int baseHpIn, int amountOfSkillsIn, ArrayList<Skill> chosenRoleSkillsIn, int valueIn) {
        super(roleNameIn, baseHpIn, amountOfSkillsIn, chosenRoleSkillsIn, valueIn);
    }

    @Override
    public ArrayList<String> availableRoleSkills(){
        ArrayList<String> availableRoleSkills = new ArrayList<>();
        availableRoleSkills.add(getSkills().getString("history"));
        availableRoleSkills.add(getSkills().getString("insight"));
        availableRoleSkills.add(getSkills().getString("medicine"));
        availableRoleSkills.add(getSkills().getString("persuasion"));
        availableRoleSkills.add(getSkills().getString("religion"));
        return availableRoleSkills;
    }
}
