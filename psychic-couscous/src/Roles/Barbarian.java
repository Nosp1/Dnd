package Roles;

import java.util.ArrayList;
/*
The Barbarian Class contains all information intrinsic to the Barbarian Role/class.
@Author Trym Staurheim
 */
public class Barbarian extends Role {
    private String rage; //Takes half damage from slashing, blunt and piercing damage. for x turns.
    private String unArmoredDefense; // as long as the barbarian does not wear heavy or medium armor add dex modifier to armor class.

    public Barbarian(String roleNameIn, int baseHpIn, ArrayList<String> availableRoleSkillsIn, int amountOfSkillsIn, ArrayList<String> chosenRoleSkillsIn, String rageIn, String unArmoredDefenseIn) {
        super(roleNameIn, baseHpIn, availableRoleSkillsIn, amountOfSkillsIn, chosenRoleSkillsIn);
        setRage(rageIn);
        setUnArmoredDefense(unArmoredDefenseIn);
    }

    public String getRage() {
        return rage;
    }

    private void setRage(String rageIn) {
        this.rage = rageIn;
    }

    public String getUnArmoredDefense() {
        return unArmoredDefense;
    }

    private void setUnArmoredDefense(String unArmoredDefenseIn) {
        this.unArmoredDefense = unArmoredDefenseIn;
    }
}
