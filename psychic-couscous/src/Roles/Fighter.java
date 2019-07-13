package Roles;

import Races.Race;
import handlers.SettingsReader;
import handlers.Skill;
import handlers.Utilities;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import static handlers.Utilities.getSkills;
import static handlers.Utilities.renderColoredString;

/**
 * The Fighter Role/class
 *
 * @author Trym Staurheim
 *
 */

public class Fighter extends Role {
    private String secondWind;
    private String fightingStyle;
    private ResourceBundle fightingStyles = SettingsReader.getResourceBundle("FightingStyle");

    public Fighter(String roleNameIn, int baseHpIn, int amountOfSkillsIn, ArrayList<Skill> chosenRoleSkillsIn, String secondWindIn, int valueIn) {
        super(roleNameIn, baseHpIn, amountOfSkillsIn, chosenRoleSkillsIn, valueIn);
        setFightingStyle(setFighterStyle());
        setSecondWind(secondWindIn);
    }

    /**
     * @author Trym Staurheim
     * @return fightingStyle as a @code String based on user input.
     */
    private String setFighterStyle() {
        System.out.println(fightingStyles.getString("style"));
        String[] temp = Utilities.getFIGHTINGSTYLES();
        int counter = 0;
        Race.printProperties(temp, counter);
        Scanner fighterScanner = new Scanner(System.in);
        boolean isStyleSat = false;
        while (!isStyleSat) {
            fightingStyle = chooseFightingStyle(fighterScanner.nextLine());
            if (fightingStyle != null) {
                isStyleSat = true;
            }
        }
        System.out.println(Utilities.renderColoredString(fightingStyles.getString("stylechosen"),"green") + " " + getFightingStyle());
        return fightingStyle;
    }
    private String chooseFightingStyle(String input){
        switch (input.toLowerCase()) {
            case "1": {
                return fightingStyles.getString("archery");
            }
            case "2": {
                return fightingStyles.getString("defense");

            }
            case "3": {
                return fightingStyles.getString("dueling");
            }
            case "4": {
                return fightingStyles.getString("greatweaponfighting");
            }
            case "5": {
                return fightingStyles.getString("protection");
            }
            case "6": {
                return fightingStyles.getString("twoweaponfighting");
            }
            default:
                System.out.println(renderColoredString(fightingStyles.getString("nostyle"),"red"));
                return null;
        }
    }


    public String getSecondWind() {
        return secondWind;
    }

    private void setSecondWind(String secondWindIn) {
        this.secondWind = secondWindIn;
    }

    public String getFightingStyle() {
        return fightingStyle;
    }

    private void setFightingStyle(String fightingStyleIn) {
        this.fightingStyle = fightingStyleIn;
    }

    @Override
    public ArrayList<String> availableRoleSkills() {
        ArrayList<String> availableRoleSkills = new ArrayList<>();
        availableRoleSkills.add(getSkills().getString("acrobatics"));
        availableRoleSkills.add(getSkills().getString("animalhandling"));
        availableRoleSkills.add(getSkills().getString("athletics"));
        availableRoleSkills.add(getSkills().getString("history"));
        availableRoleSkills.add(getSkills().getString("insight"));
        availableRoleSkills.add(getSkills().getString("intimidation"));
        availableRoleSkills.add(getSkills().getString("perception"));
        availableRoleSkills.add(getSkills().getString("survival"));
        return availableRoleSkills;
    }

}
