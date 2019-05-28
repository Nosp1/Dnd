package backgrounds;

import java.util.ArrayList;

/**
The Acolyte Background
 *
 * @Author Trym Staurheim
 */
public class Acolyte extends Background {
    private String acolyteworships; //which diety the player worhips.

    public Acolyte(String backGroundNameIn, String featureIn, String toolsIn, ArrayList<String> equipmentIn, ArrayList<String> skillsIn, String acolyteWorshipsIn) {
        super(backGroundNameIn, featureIn, toolsIn, equipmentIn, skillsIn);
        setAcolyteworhips(acolyteWorshipsIn);
    }

    public String getAcolyteworhips() {
        return acolyteworships;
    }

    private void setAcolyteworhips(String acolyteWorshipsIn) {
        this.acolyteworships = acolyteWorshipsIn;
    }
}
