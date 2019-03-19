package Classes.Roles;

import Classes.Role;

public class Rogue extends Role {
    private String expertise; //doubles the proficieny bonus for selected skill
    private String sneakAttack;//increases dmg by 2d6 if you are hidden, or target is prone, a friend is nearby
    private String thievesCant; //language for rogues

    public Rogue(String rollerName, int baseHp, String expertise, String sneakAttack, String thievesCant, String[] availableSkills, int amountOfSkills) {
        super(rollerName, baseHp, availableSkills,amountOfSkills);
        this.sneakAttack = sneakAttack;
        this.expertise = expertise;
        this.thievesCant = thievesCant;



    }

}
