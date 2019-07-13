package Roles;

import handlers.Skill;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import java.util.ArrayList;

import static handlers.Utilities.getSkills;

/*
The Rogue Class.
@Author Trym Staurheim
 */
@JsonTypeName("rogue")
public class Rogue extends Role {
    @JsonProperty("@type")
    private final String type = "rogue";

    private String expertise; // doubles the proficiency bonus for selected skills
    private String sneakAttack; //increases dmg by 2d6 if you are hidden, or target is prone, or ally is nearby target
    private String thievesCant; //language known by thieves.

    public Rogue() { }

    public Rogue(String roleNameIn, int baseHpIn, int amountOfSkillsIn, ArrayList<Skill> chosenRoleSkillsIn, String expertiseIn, String sneakAttackIn, String thievesCant, int valueIn) {
        super(roleNameIn, baseHpIn, amountOfSkillsIn, chosenRoleSkillsIn, valueIn);
        setExpertise(expertiseIn);
        setSneakAttack(sneakAttackIn);
        setThievesCant(thievesCant);
    }

    @Override
    public String toString() {
        return super.toString()
                + ",\n  expertise="
                + expertise
                + ",\n  sneak-attack="
                + sneakAttack
                + ",\n  thieves-cant"
                + thievesCant
                + "\n }";
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

    @Override
    public ArrayList<String> availableRoleSkills() {
        ArrayList<String> availableRoleSkills = new ArrayList<>();
        availableRoleSkills.add(getSkills().getString("acrobatics"));
        availableRoleSkills.add(getSkills().getString("athletics"));
        availableRoleSkills.add(getSkills().getString("deception"));
        availableRoleSkills.add(getSkills().getString("insight"));
        availableRoleSkills.add(getSkills().getString("intimidation"));
        availableRoleSkills.add(getSkills().getString("investigation"));
        availableRoleSkills.add(getSkills().getString("perception"));
        availableRoleSkills.add(getSkills().getString("performance"));
        availableRoleSkills.add(getSkills().getString("persuasion"));
        availableRoleSkills.add(getSkills().getString("sleightofhand"));
        availableRoleSkills.add(getSkills().getString("stealth"));
        return availableRoleSkills;
    }
}
// Acrobatics, Athletics, Deception, Insight, Intimidation, Investigation, Perception, Performance. Persuasion, Sleight of Hand, and Stealth