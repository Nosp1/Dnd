package handlers;

import java.util.ResourceBundle;


public class Utilities {

    private static ResourceBundle races = SettingsReader.getResourceBundle("Race");
    private static ResourceBundle stats = SettingsReader.getResourceBundle("Stat");
    private static ResourceBundle roles = SettingsReader.getResourceBundle("Role");
    private static ResourceBundle backgrounds = SettingsReader.getResourceBundle("Background");
    private static ResourceBundle tools = SettingsReader.getResourceBundle("Tool");
    private static ResourceBundle draconicancestries = SettingsReader.getResourceBundle("DraconicAncestry");
    private static ResourceBundle skills = SettingsReader.getResourceBundle("Skill");
    private static ResourceBundle gods = SettingsReader.getResourceBundle("God");

    public final static String[] RACES = {
            races.getString("dragonborn"),
            races.getString("dwarf"),
            races.getString("elf"),
            races.getString("gnome"),
            races.getString("halfelf"),
            races.getString("halfling"),
            races.getString("halforc"),
            races.getString("human"),
            races.getString("tiefling")
    };

    public final static String[] STATS = {
            stats.getString("strength"),
            stats.getString("dexterity"),
            stats.getString("constitution"),
            stats.getString("intelligence"),
            stats.getString("wisdom"),
            stats.getString("charisma")
    };

    public final static String[] SKILLS = {
            skills.getString("acrobatics"),
            skills.getString("animalhandling"),
            skills.getString("arcana"),
            skills.getString("athletics"),
            skills.getString("deception"),
            skills.getString("history"),
            skills.getString("insight"),
            skills.getString("intimidation"),
            skills.getString("investigation"),
            skills.getString("medicine"),
            skills.getString("nature"),
            skills.getString("perception"),
            skills.getString("performance"),
            skills.getString("persuasion"),
            skills.getString("religion"),
            skills.getString("sleightofhand"),
            skills.getString("stealth"),
            skills.getString("survival"),
    };

    public final static String[] ROLES = {
            roles.getString("barbarian"),
            roles.getString("cleric"),
            roles.getString("druid"),
            roles.getString("fighter"),
            roles.getString("paladin"),
            roles.getString("rogue")
    };

    public final static String[] BACKGROUNDS = {
            backgrounds.getString("acolyte"),
            backgrounds.getString("criminal")
    };

    public final static String[] TOOLS = {
            tools.getString("smithstools"),
            tools.getString("brewerssupplies"),
            tools.getString("masonstools")
    };

    public final static String[] DRACONICANCESTRY = {
            draconicancestries.getString("black"),
            draconicancestries.getString("blue"),
            draconicancestries.getString("brass"),
            draconicancestries.getString("bronze"),
            draconicancestries.getString("copper"),
            draconicancestries.getString("gold"),
            draconicancestries.getString("green"),
            draconicancestries.getString("red"),
            draconicancestries.getString("silver"),
            draconicancestries.getString("white"),
    };
    public final static String[] GODS = {
            gods.getString("auril"),
            gods.getString("azuth"),
            gods.getString("bane"),
            gods.getString("beshaba"),
            gods.getString("bhaal"),
            gods.getString("chauntea"),
            gods.getString("cyric"),
            gods.getString("deneir"),
            gods.getString("eldath"),
            gods.getString("gond"),
            gods.getString("helm"),
    };

    private final static String RESET_ESCAPE_CODE = "\u001b[0m";

    public static String renderColoredString(String text, String color) {

        return "\u001b[" + getColorEscapeCode(color) + "m" + text + RESET_ESCAPE_CODE;

    }



    public static String renderColoredString(String text, String color, boolean resetDefault) {

        String coloredString;

        if (resetDefault) {

            coloredString = renderColoredString(text, color);

        }

        else {

            coloredString = "\u001b[" + getColorEscapeCode(color) + "m" + text;

        }

        return coloredString;

    }

    private static int getColorEscapeCode(String color) {

        int colorEscapeCode;

        switch(color.toLowerCase()) {

            case "black":
                colorEscapeCode = 30;
                break;

            case "red":
                colorEscapeCode = 31;
                break;

            case "green":
                colorEscapeCode = 32;
                break;

            case "yellow":
                colorEscapeCode = 33;
                break;

            case "blue":
                colorEscapeCode = 34;
                break;

            case "magenta":
                colorEscapeCode = 35;
                break;

            case "cyan":
                colorEscapeCode = 36;
                break;

            case "white":
                colorEscapeCode = 37;
                break;

            default:
                colorEscapeCode = 0;
                break;

        }

        return colorEscapeCode;

    }

    public static ResourceBundle getRaces() {
        return races;
    }

    public static ResourceBundle getStats() {
        return stats;
    }
    public static ResourceBundle getTools(){
        return tools;

    }    public static ResourceBundle getSkills() {return skills;}
    public static ResourceBundle getGods(){
        return gods;
    }
    public static String[] getBACKGROUNDS(){
        return BACKGROUNDS;
    }

    public static String[] getRACES() {
        return RACES;
    }
    public static String[] getROLES(){
        return ROLES;
    }
    public static String[] getGODS(){
        return GODS;
    }
    public static String[] getTOOLS() {
        return TOOLS;
    }
    public static String[] getSKILLS() {
        return SKILLS;
    }
}
