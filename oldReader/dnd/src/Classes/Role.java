package Classes;
/*
This is the Role Class. It serves as a skeleton for any types of Role classes made for easy implementation of the extended DnD library, as well as custom Roles.
The class contains all the minimum properties a role needs to have. Any intrinsic properties will be found in the inheriting class: E.g. Rouge will have an intrinsic property Thief´ Cant

 Note: As Both Java and Dungeons and Dragons uses the word Class to refer to different types of objects.
 I´ve chosen to refer to Dungeon and Dragons type classes as Roles to better reflect that role is a type object
 in java representing the classes of Dungeons.

 @Author Trym Staurheim
 */
public abstract class Role {
    private String rollerName;
    private int baseHp;
    private String[] availableSkills;
    private int amountOfSkills;
    private String[] chosenRoleSkills;

    public Role(String rollerName, int baseHp, String[] availableSkills, int amountOfSkills) {
        this.baseHp = baseHp;
        this.rollerName = rollerName;
        this.availableSkills = availableSkills;
        this.amountOfSkills = amountOfSkills;
        this.chosenRoleSkills = new String[amountOfSkills];
    }
/*
Below are simple getters and setters to get the object values.
 */
    public String getRollerName() {
        return rollerName;
    }

    public void setRollerName(String rollerName) {
        this.rollerName = rollerName;
    }

    public int getBaseHp() {
        return baseHp;
    }


    public void setBaseHp(int baseHp) {
        this.baseHp = baseHp;
    }

    public String[] getAvailableSkills() {
        return availableSkills;
    }

    public void setAvailableSkills(String[] availableSkills) {
        this.availableSkills = availableSkills;
    }

    public int getAmountOfSkills() {
        return amountOfSkills;
    }

    public void setAmountOfSkills(int amountOfSkills) {
        this.amountOfSkills = amountOfSkills;
    }

    public String[] getChosenRoleSkills() {
        return chosenRoleSkills;
    }

    public void setChosenRoleSkills(String[] chosenRoleSkills) {
        this.chosenRoleSkills = chosenRoleSkills;
    }
}

