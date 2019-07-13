package Roles;

import handlers.Skill;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import java.util.ArrayList;

import static handlers.Utilities.getSkills;
/*
The Paladin Class
@Author Trym Staurheim
 */
@JsonTypeName("paladin")
public class Paladin extends Role {
    @JsonProperty("@type")
    private final String type = "paladin";

    private String layOnHands; //Heal target for your x hp, where x is your lvl + d4.
    private String divineSense; //Can sense evil and desecrated items

    public Paladin() { }

    public Paladin(String roleNameIn, int baseHpIn, int amountOfSkillsIn, ArrayList<Skill> chosenRoleSkillsIn, String layOnHandsIn, String divineSenseIn, int valueIn) {
        super(roleNameIn, baseHpIn, amountOfSkillsIn, chosenRoleSkillsIn, valueIn);
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

    @Override
    public ArrayList<String> availableRoleSkills() {
        ArrayList<String> availableRoleSkills = new ArrayList<>();
        availableRoleSkills.add(getSkills().getString("athletics"));
        availableRoleSkills.add(getSkills().getString("insight"));
        availableRoleSkills.add(getSkills().getString("intimidation"));
        availableRoleSkills.add(getSkills().getString("medicine"));
        availableRoleSkills.add(getSkills().getString("persuasion"));
        availableRoleSkills.add(getSkills().getString("religion"));
        return availableRoleSkills;
    }
}
