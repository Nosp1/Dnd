package Roles;

import java.util.ArrayList;
/*
The Rogue Class.
@Author Trym Staurheim
 */
public class Rogue extends Role {
    private String expertise; // doubles the proficiency bonus for selected skills
    private String sneakAttack; //increases dmg by 2d6 if you are hidden, or target is prone, or ally is nearby target
    private String thievesCant; //language known by thieves.

    public Rogue(String roleNameIn, int baseHpIn, ArrayList<String> availableRoleSkillsIn, int amountOfSkillsIn, ArrayList<String> chosenRoleSkillsIn, String expertiseIn, String sneakAttackIn, String thievesCant) {
        super(roleNameIn, baseHpIn, availableRoleSkillsIn, amountOfSkillsIn, chosenRoleSkillsIn);

    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertiseIn) {
        this.expertise = expertiseIn;
    }

    public String getSneakAttack() {
        return sneakAttack;
    }

    public void setSneakAttack(String sneakAttackIn) {
        this.sneakAttack = sneakAttackIn;
    }

    public String getThievesCant() {
        return thievesCant;
    }

    public void setThievesCant(String thievesCantIn) {
        this.thievesCant = thievesCantIn;
    }
}
