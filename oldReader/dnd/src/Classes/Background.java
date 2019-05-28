package Classes;

// todo, add all backgrounds as subclasses.
//todo add list for tools,
//todo add list for Feature,

public abstract class Background {

    private String backGroundName;
    private String feature;
    private String tools;
    private String[] equipment;
    private String[] skills;

    public Background(String backGroundName, String feature, String tools, String[] skills, String[] equipment) {
        this.backGroundName = backGroundName;
        this.feature = feature;
        this.tools = tools;
        this.skills = skills;
        this.equipment = equipment;
    }

    public String getBackGroundName() {
        return backGroundName;
    }

    public void setBackGroundName(String backGroundName) {
        this.backGroundName = backGroundName;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

    public String[] getEquipment() {
        return equipment;
    }

    public void setEquipment(String[] equipment) {
        this.equipment = equipment;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }
}
