package Classes.Roles;

import Classes.Role;

public class Paladin extends Role {
    private String layOnHands, divineSense;

    public Paladin(String rollerName, int baseHp, String[] availableSkills, int amountOfSkills, String layOnHands, String divineSense) {
        super(rollerName, baseHp, availableSkills, amountOfSkills);
        this.layOnHands = layOnHands;
        this.divineSense = divineSense;
    }
}
