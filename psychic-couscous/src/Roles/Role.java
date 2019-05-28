package Roles;

import java.util.ArrayList;
/*
This is the Roles.Role Class. It serves as a skeleton for any types of sub classes of Roles.Role made,
to make implementation easier for  the extended DnD library, as well as custom Roles.
 The class contains all the minimum properties a role needs to have.
 Any intrinsic properties will be found in the inheriting class. e.g., Rogue will have an intrinsic property Thief´s Cant

 Note: As Both Java and Dungeons and Dragons uses the word Class to refer to different types of objects.
 I´ve chosen to refer to Dungeon and Dragons type classes as Roles to better reflect that role is a type object
 in java representing the classes of Dungeons and Dragons.
 @Author Trym Staurheim
 */

public abstract class Role {
    private String roleName;
    private int baseHp;
    private ArrayList<String> availableRoleSkills;
    private int amountOfSkills;
    private ArrayList<String> chosenRoleSkills;

    public Role(String roleNameIn, int baseHpIn, ArrayList<String> availableRoleSkillsIn, int amountOfSkillsIn, ArrayList<String> chosenRoleSkillsIn) {
        setRoleName(roleNameIn);
        setBaseHp(baseHpIn);
        setAvailableRoleSkills(availableRoleSkillsIn);
        setAmountOfSkills(amountOfSkillsIn);
        setChosenRoleSkills(chosenRoleSkillsIn);
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleNameIn) {
        this.roleName = roleNameIn;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(int baseHpIn) {
        this.baseHp = baseHpIn;
    }

    public ArrayList<String> getAvailableRoleSkills() {
        return availableRoleSkills;
    }

    public void setAvailableRoleSkills(ArrayList<String> availableRoleSkillsIn) {
        this.availableRoleSkills = availableRoleSkillsIn;
    }

    public int getAmountOfSkills() {
        return amountOfSkills;
    }

    public void setAmountOfSkills(int amountOfSkillsIn) {
        this.amountOfSkills = amountOfSkillsIn;
    }

    public ArrayList<String> getChosenRoleSkills() {
        return chosenRoleSkills;
    }

    public void setChosenRoleSkills(ArrayList<String> chosenRoleSkillsIn) {
        this.chosenRoleSkills = chosenRoleSkillsIn;
    }
}
