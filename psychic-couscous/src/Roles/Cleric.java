package Roles;



import handlers.Skill;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import java.util.ArrayList;

import static handlers.Utilities.getSkills;
/*
The Cleric Role/class
@Author Trym Staurheim
todo add domain choice
 */

@JsonTypeName("cleric")
public class Cleric extends Role{
    @JsonProperty("@type")
    private final String type = "cleric";

    public Cleric() { }

    public Cleric(String roleNameIn, int baseHpIn, int amountOfSkillsIn, ArrayList<Skill> chosenRoleSkillsIn, int valueIn) {
        super(roleNameIn, baseHpIn, amountOfSkillsIn, chosenRoleSkillsIn, valueIn);
    }

    //TODO: Hver sub-klasse må override sin egen toString, og kalle på super.toString() først
    public String toString() {
        return super.toString()
                + "\n }";
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
