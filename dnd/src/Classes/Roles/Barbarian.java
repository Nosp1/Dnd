package Classes.Roles;

import Classes.Role;

public class Barbarian extends Role {
    private String rage, unArmoredDefense;
    public Barbarian(String rollerName, int baseHp, String[] availableSkills, int amountOfSkills, String rage, String unArmoredDefense) {
        super(rollerName, baseHp, availableSkills, amountOfSkills);
        this.rage = rage;
        this.unArmoredDefense = unArmoredDefense;
    }
}
