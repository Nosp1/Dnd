package Races;
/*
This is the Core Dwarf. Currently has String properties for all dwarf features.
@Author Trym Staurheim
 */


import handlers.SettingsReader;
import handlers.Utilities;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import java.util.ResourceBundle;
import java.util.Scanner;

import static handlers.Utilities.TOOLS;
import static handlers.Utilities.getTOOLS;
@JsonTypeName("dwarf")
public class Dwarf extends Race {
    @JsonProperty("@type")
    private final String type = "dwarf";

    private String darkVision; // can see in the dark
    private String dwarvenCombatTraining; //gets proficiency with special dwarven weapons and armor
    private String stoneCunning; //Can identify stoneworks origin
    private String dwarvenResilience; //immune to poison damage
    private String toolProficiency; // gains proficiency in a toolset
    private ResourceBundle tools = SettingsReader.getResourceBundle("Tool");

    public Dwarf() { }

    public Dwarf(String nameIn, int maxAgeIn, String languagesIn, int raceIncreaseStatsIn, String[] availableStatsIn, String darkVisionIn, String dwarvenCombatTrainingIn, String stoneCunningIn, String dwarvenResilienceIn) {
        super(nameIn, maxAgeIn, languagesIn, raceIncreaseStatsIn, availableStatsIn);
        setDarkVision(darkVisionIn);
        setDwarvenCombatTraining(dwarvenCombatTrainingIn);
        setStoneCunning(stoneCunningIn);
        setDwarvenResilience(dwarvenResilienceIn);
        setToolProficiency(setDwarfToolproficiency());
    }

    @Override
    public String toString() {
        return super.toString()
                + ",\n  dark vision="
                + darkVision
                + ",\n  dwarvern combat training="
                + dwarvenCombatTraining
                + ",\n  stone cunning="
                + stoneCunning
                + ",\n  dwarvern resilience="
                + dwarvenResilience
                + ",\n  tool proficiency="
                + toolProficiency
                + "\n }";
    }

    private String setDwarfToolproficiency() {
        System.out.println("As a dwarf you need to chose your artisan tools: " + "\n" + Utilities.renderColoredString("If you want information on tools press 4:", "yellow"));
        String temp[] = Utilities.getTOOLS();
        int counter = 0;
        Race.printProperties(temp, counter);
        Scanner dwarfTool = new Scanner(System.in);
        boolean isDwarftoolSat = false;
        while (!isDwarftoolSat) {
            toolProficiency = chooseDwarfToolproficiency(dwarfTool.nextLine());
            if (toolProficiency != null) {
                isDwarftoolSat = true;
            }
        }
        System.out.println(Utilities.renderColoredString("You have chosen" + ": ", "green") + getToolProficiency());
        return toolProficiency;

    }

    private String chooseDwarfToolproficiency(String input) {
        switch (input.toLowerCase()) {
            case "1": {
                return tools.getString("smithstools");
            }
            case "2": {
                return tools.getString("brewerssupplies");
            }
            case "3": {
                return tools.getString("masonstools");
            }
            case "4": {
                System.out.println(tools.getString("toolinfo"));
            }
            default:
                System.out.println("You have not chosen a toolset, try numbers 1-3");
                return null;
        }
    }

    public String getDarkVision() {
        return darkVision;
    }

    private void setDarkVision(String darkVisionIn) {
        darkVision = darkVisionIn;
    }

    public String getDwarvenCombatTraining() {
        return dwarvenCombatTraining;
    }

    private void setDwarvenCombatTraining(String dwarvenCombatTrainingIn) {
        this.dwarvenCombatTraining = dwarvenCombatTrainingIn;
    }

    public String getStoneCunning() {
        return stoneCunning;
    }

    private void setStoneCunning(String stoneCunningIn) {
        this.stoneCunning = stoneCunningIn;
    }

    public String getDwarvenResilience() {
        return dwarvenResilience;
    }

    private void setDwarvenResilience(String dwarvenResilienceIn) {
        this.dwarvenResilience = dwarvenResilienceIn;
    }

    public String getToolProficiency() {
        return toolProficiency;
    }

    private void setToolProficiency(String toolProficiencyIn) {
        toolProficiency = toolProficiencyIn;

    }

    public String getSettoolproficiency() {
        return setDwarfToolproficiency();
    }
}
