package backgrounds;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

import java.util.ArrayList;
/*
The Crimal Background.
@author Trym Staurheim
 */
@JsonTypeName("criminal")
public class Criminal extends Background {
    @JsonProperty("@type")
    public final String type = "criminal";

    public Criminal() { }

    public Criminal(String backGroundNameIn, String featureIn, String toolsIn) {
        super(backGroundNameIn, featureIn, toolsIn);
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n }";
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
