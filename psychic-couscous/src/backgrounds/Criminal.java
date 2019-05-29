package backgrounds;

import java.util.ArrayList;
/*
The Crimal Background.
@author Trym Staurheim
 */
public class Criminal extends Background {

    public Criminal(String backGroundNameIn, String featureIn, String toolsIn) {
        super(backGroundNameIn, featureIn, toolsIn);
    }

    @Override
    public ArrayList<String> equipment() {
        return null;
    }

    @Override
    public ArrayList<String> backgroundSkills() {
        return null;
    }
}
