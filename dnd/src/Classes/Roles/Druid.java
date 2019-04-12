package Classes.Roles;

import Classes.Role;

public class Druid extends Role {
    private String druidicLanguage;
    private String spells;
    private String tools;
    public Druid(String rollerName, int baseHp, String[] availableSkills, int amountOfSkills, String druidicLanguage, String spells, String tools) {
        super(rollerName, baseHp, availableSkills, amountOfSkills);
        this.druidicLanguage = druidicLanguage;
        this.spells = spells;
        this.tools = tools;

    }
}
