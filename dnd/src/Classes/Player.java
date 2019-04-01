package Classes;
/*
The Player class only handles getters and setters from other classes to set values on the player.
Todo add Alignment choice.. if needed

 */
public class Player {
    private String playerName; // name of the player
    private String gender; // gender of the player
    private Race race; // the race chosen by the player
    private int age; // the age set by the player
    private Skills skills; // skills chosen by the player.
    private String Alignment; //alignment chosen by player.
    private Role role; // to handle role objects on the player

    public String getAlignment() {
        return Alignment;
    }

    public void setAlignment(String alignment) {
        Alignment = alignment;
    }

    public Player(String playerName){
       this. playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
