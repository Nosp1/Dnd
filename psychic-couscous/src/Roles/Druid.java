package Roles;

import handlers.Skill;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import java.util.ArrayList;

import static handlers.Utilities.getSkills;
/*
The Druid Role/class
@Author Trym Staurheim
 */

@JsonTypeName("druid")
public class Druid extends Role {
    @JsonProperty("@type")
    private final String type = "";

    public Druid() { }

    public Druid(String roleNameIn, int baseHpIn, int amountOfSkillsIn, ArrayList<Skill> chosenRoleSkillsIn, int valueIn) {
        super(roleNameIn, baseHpIn, amountOfSkillsIn, chosenRoleSkillsIn, valueIn);
    }

    @Override
    public ArrayList<String> availableRoleSkills() {
        ArrayList<String> availableRoleSkills = new ArrayList<>();
        availableRoleSkills.add(getSkills().getString("arcana"));
        availableRoleSkills.add(getSkills().getString("animalhandling"));
        availableRoleSkills.add(getSkills().getString("insight"));
        availableRoleSkills.add(getSkills().getString("medicine"));
        availableRoleSkills.add(getSkills().getString("nature"));
        availableRoleSkills.add(getSkills().getString("perception"));
        availableRoleSkills.add(getSkills().getString("religion"));
        availableRoleSkills.add(getSkills().getString("survival"));
        return availableRoleSkills;

    }
    // Arcana, Animal Handling, Insight, Medicine, Nature, Perception, Religion, and Survival
}
