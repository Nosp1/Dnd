package Races;

/*
The Race of Dragonborn. Currently has two defining properties.
@Author: Trym Staurheim
 */

import handlers.SettingsReader;
import handlers.Utilities;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import java.util.ResourceBundle;
import java.util.Scanner;
@JsonTypeName("dragonborn")
public class Dragonborn extends Race {
    @JsonProperty("@type")
    private final String type = "dragonborn";

    private String draconicAncestry;
    private String breathWeapon;
    private ResourceBundle draconicancestries = SettingsReader.getResourceBundle("DraconicAncestry");

    public Dragonborn() { }

    public Dragonborn(String nameIn, int maxAgeIn, String languagesIn, int raceIncreaseStatIn, String[] availableStatsIn, String breathWeaponIn) {

        super(nameIn, maxAgeIn, languagesIn, raceIncreaseStatIn, availableStatsIn);
        setDraconicAncestry(setDraconicAncestor());
        setBreathWeapon(breathWeaponIn);

    }

    @Override
    public String toString() {
        return super.toString()
                + ",\n  draconigAncestry="
                + draconicAncestry
                + ",\n  breathWeapon="
                + breathWeapon
                + "\n }";
    }

    private void setDraconicAncestry(String draconicAncestryIn) {
        draconicAncestry = draconicAncestryIn;

    }

    private void setBreathWeapon(String breathWeaponIn) {
        breathWeapon = breathWeaponIn;
    }

    public String getBreathWeapon() {
        return breathWeapon;
    }

    public String getDraconicAncestry() {
        return draconicAncestry;
    }

    private String setDraconicAncestor() {
        System.out.println(Utilities.renderColoredString(draconicancestries.getString("dragonchoice"), "green") + "\n");
        String[] temp = Utilities.DRACONICANCESTRY;
        int counter = 0;
        Race.printProperties(temp, counter);
        Scanner draconicAncestor = new Scanner(System.in);
        boolean isDraconicAncestrySat = false;
        while (!isDraconicAncestrySat) {
            draconicAncestry = chooseDraconicAncestor(draconicAncestor.nextLine());
            if (draconicAncestry != null) {
                isDraconicAncestrySat = true;
            }
        }
        System.out.println(Utilities.renderColoredString(draconicancestries.getString("dragonchosen"), "green") + " " + getDraconicAncestry());
        return draconicAncestry;
    }

    private String chooseDraconicAncestor(String input) {
        switch (input.toLowerCase()) {
            case "1": {
                return draconicancestries.getString("black");
            }
            case "2": {
                return draconicancestries.getString("blue");
            }
            case "3": {
                return draconicancestries.getString("brass");
            }
            case "4": {
                return draconicancestries.getString("bronze");
            }
            case "5": {
                return draconicancestries.getString("copper");
            }
            case "6": {
                return draconicancestries.getString("gold");
            }
            case "7": {
                return draconicancestries.getString("green");
            }
            case "8": {
                return draconicancestries.getString("red");
            }
            case "9": {
                return draconicancestries.getString("silver");
            }
            case "10": {
                return draconicancestries.getString("white");
            }
            default: {
                System.out.println("You have not chosen what type of dragon you are: Please type 1-10");
                return null;
            }
        }
    }
}
