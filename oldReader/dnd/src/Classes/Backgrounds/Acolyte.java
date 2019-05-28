package Classes.Backgrounds;

import Classes.Background;

public class Acolyte extends Background {

private  String god;

    public Acolyte(String backGroundName, String feature, String tools, String[] skills,String[] equipment, String god) {
        super(backGroundName, feature, tools,skills,equipment);
        //worships god
        //todo add a diety choise?
        this.god = god;
    }

    public String getGod() {
        return god;
    }

    public void setGod(String god) {
        this.god = god;
    }
}
