package backgrounds;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.util.ArrayList;
/*
The Background class serves a  skeleton for all the DnD Backgrounds,
containing all the specific properties a background needs.
Enables the user to create custom Backgrounds by inheriting from this class.
@Author Trym Staurheim
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
        @Type(value = Acolyte.class, name = "acolyte"),
        @Type(value = Criminal.class, name = "criminal")
})
public abstract class Background{
    private String backGroundName;
    private String feature;
    private String tools;

    public Background() { }

    public Background(String backGroundNameIn,String featureIn, String toolsIn){
        setBackGroundName(backGroundNameIn);
        setFeature(featureIn);
        setTools(toolsIn);

    }

    @Override
    public String toString() {
        return "{"
                + "\n  background name="
                + backGroundName
                + ",\n  feature="
                + feature
                + ",\n  tools=["
                + tools
                + "]";
    }

    public String getBackGroundName() {
        return backGroundName;
    }

    private void setBackGroundName(String backGroundNameIn) {
        this.backGroundName = backGroundNameIn;
    }

    public String getFeature() {
        return feature;
    }

    private void setFeature(String featureIn) {
        this.feature = featureIn;
    }

    public String getTools() {
        return tools;
    }

    private void setTools(String toolsIn) {
        this.tools = toolsIn;
    }

    public abstract ArrayList<String> equipment();
    public abstract ArrayList<String> backgroundSkills();

    protected static void printbackgroundProperties(String[] temp, int counter) {
        for (String s : temp) {
            System.out.println(" # " + (counter + 1) + " " + s);
            counter++;
        }
    }
}
