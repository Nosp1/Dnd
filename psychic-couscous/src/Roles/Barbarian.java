package Roles;

import handlers.Skill;
import handlers.Utilities;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import java.util.ArrayList;

import static handlers.Utilities.getSkills;


/*
The Barbarian Class contains all information intrinsic to the Barbarian Role/class.
@Author Trym Staurheim

 */
@JsonTypeName("barbarian")
public class Barbarian extends Role {
    @JsonProperty("@type")
    private final String type = "barbarian";

    private String rage; //Takes half damage from slashing, blunt and piercing damage. for x turns.
    private String unArmoredDefense; // as long as the barbarian does not wear heavy or medium armor add dex modifier to armor class.

    public Barbarian() { }

    public Barbarian(String roleNameIn, int baseHpIn, int amountOfSkillsIn, ArrayList<Skill> chosenRoleSkillsIn, String rageIn, String unArmoredDefenseIn, int valueIn) {
        super(roleNameIn, baseHpIn, amountOfSkillsIn, chosenRoleSkillsIn, valueIn);
        setRage(rageIn);
        setUnArmoredDefense(unArmoredDefenseIn);
        availableRoleSkills();

    }

    @Override
   public  ArrayList<String> availableRoleSkills(){

        ArrayList<String> availableRoleSkills = new ArrayList<>();
        availableRoleSkills.add(getSkills().getString("animalhandling"));
        availableRoleSkills.add(getSkills().getString("athletics"));
        availableRoleSkills.add(getSkills().getString("intimidation"));
        availableRoleSkills.add(getSkills().getString("nature"));
        availableRoleSkills.add(getSkills().getString("perception"));
        availableRoleSkills.add(getSkills().getString("survival"));

        return availableRoleSkills;
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
