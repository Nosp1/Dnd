package backgrounds;

import handlers.SettingsReader;
import handlers.Utilities;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * The Acolyte Background
 *
 * @author Trym Staurheim
 */
@JsonTypeName("acolyte")
public class Acolyte extends Background {
    @JsonProperty("@type")
    private final String type = "acolyte";

    private static ResourceBundle gods = SettingsReader.getResourceBundle("God");
    private String acolyteWorships;

    public Acolyte(String backGroundNameIn, String featureIn, String toolsIn) {
        super(backGroundNameIn, featureIn, toolsIn);
        setAcolyteworhips(isGodSat());
    }

    @Override
    public String toString() {
        return super.toString()
                + "acolyte worships="
                + acolyteWorships
                + "]";
    }

    @Override
    public ArrayList<String> equipment() {
        return null;
    }

    @Override
    public ArrayList<String> backgroundSkills() {
        return null;
    }

    public String getAcolyteworhips() {
        return acolyteWorships;
    }

    private void setAcolyteworhips(String acolyteWorshipsIn) {
        this.acolyteWorships = acolyteWorshipsIn;
    }

    private String isGodSat() {
        System.out.println(Utilities.renderColoredString(gods.getString("choosegod") + " ", "green"));
        String temp[] = Utilities.getGODS();
        int counter = 0;
        Background.printbackgroundProperties(temp, counter);
        Scanner godScanner = new Scanner(System.in);
        boolean isGodSat = false;
        while (!isGodSat) {
            acolyteWorships = chooseGod(godScanner.nextLine());
            if (acolyteWorships != null) {
                isGodSat = true;
            }
        }
        System.out.println(Utilities.renderColoredString(gods.getString("godchosen") + ": ", "green") + getAcolyteworhips());
        return acolyteWorships;
    }

    private String chooseGod(String input) {
        switch (input) {
            case "1": {
                return gods.getString("auril");
            }
            case "2": {
                return gods.getString("azuth");
            }
            case "3": {
                return gods.getString("bane");
            }
            case "4": {
                return gods.getString("beshaba");
            }
            case "5": {
                return gods.getString("bhaal");
            }
            case "6": {
                return gods.getString("chauntea");

            }
            case "7": {
                return gods.getString("cyric");
            }
            case "8": {
                return gods.getString("deneir");
            }
            case "9": {
                return gods.getString("eldath");
            }
            case "10": {
                return gods.getString("gond");
            }
            case "11": {
                return gods.getString("helm");
            }
            default: {
                System.out.println(Utilities.renderColoredString(gods.getString("notchosengod"), "red"));
                return null;
            }
        }

    }

}
