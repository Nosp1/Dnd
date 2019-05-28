package backgrounds;

import java.util.ArrayList;
/*
The Background class serves a  skeleton for all the DnD backgrounds,
containing all the specific properties a background needs.
Enables the user to create custom backgrounds by inheriting from this class.
@Author Trym Staurheim
 */

public abstract class Background{
    private String backGroundName;
    private String feature;
    private String tools;
    private ArrayList<String> Equipment;
    private ArrayList<String> Skills;

    public Background(String backGroundNameIn,String featureIn, String toolsIn, ArrayList<String> equipmentIn, ArrayList<String> skillsIn){
        setBackGroundName(backGroundNameIn);
        setFeature(featureIn);
        setTools(toolsIn);
        setEquipment(equipmentIn);
        setSkills(skillsIn);
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

    public ArrayList<String> getEquipment() {
        return Equipment;
    }

    private void setEquipment(ArrayList<String> equipmentIn) {
        Equipment = equipmentIn;
    }

    public ArrayList<String> getSkills() {
        return Skills;
    }

    private void setSkills(ArrayList<String> skillsIn) {
        Skills = skillsIn;
    }
}
