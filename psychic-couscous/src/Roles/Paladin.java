package Roles;

import java.util.ArrayList;
/*
The Paladin Class
@Author Trym Staurheim
 */

public class Paladin extends Role {
    private String layOnHands; //Heal target for your x hp, where x is your lvl + d4.
    private String divineSense; //Can sense evil and desecrated items

    public Paladin(String roleNameIn, int baseHpIn, ArrayList<String> availableRoleSkillsIn, int amountOfSkillsIn, ArrayList<String> chosenRoleSkillsIn, String layOnHandsIn, String divineSenseIn) {
        super(roleNameIn, baseHpIn, availableRoleSkillsIn, amountOfSkillsIn, chosenRoleSkillsIn);
        setDivineSense(divineSenseIn);
        setLayOnHands(layOnHandsIn);
    }

    public String getLayOnHands() {
        return layOnHands;
    }

    public void setLayOnHands(String layOnHandsIn) {
        this.layOnHands = layOnHandsIn;
    }

    public String getDivineSense() {
        return divineSense;
    }

    public void setDivineSense(String divineSenseIn) {
        this.divineSense = divineSenseIn;
    }
}
