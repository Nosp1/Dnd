package handlers;

/**
 * The {@code Skill} class handles the properties of skills stored on the {@code character object}.
 * It uses a boolean to control for proficiency and a {@code String} name variable to assert the name of the Skill object.
 * @author Trym Staurheim
 */
public class Skill {
    /** stores the {@code String} on the instanced Skill object */
    private String name;
    /** stores the {@code boolean} on the instanced Skill object */
    private boolean isProficient;

    /**
     * The constructor for {@code Skill} sets the variable name and the boolean isProficient on the instanced object Skill.
     * @param nameIn is the {@code String} characters to be sat on instanced object Skill
     * @param isProficientIn is the {@code boolean} value of the instanced object Skill
     */
    public Skill(String nameIn, boolean isProficientIn){
        setName(nameIn);
        setProficient(isProficientIn);

    }

    /**
     * @author Trym Staurheim
     * @return name variables stored {@code String} properties.
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the instanced Skill object.
     * @author Trym Staruheim
     * @param nameIn is the {@code String}  which is sat on the variable name.
     */

    public void setName(String nameIn) {
        this.name = nameIn;
    }

    /**
     * returns the boolean value of the variable isProficient on the instanced Skill object.
     * @author Trym Staurheim
     * @return isProficient true or false property
     */
    public boolean isProficient() {
        return isProficient;
    }

    /**
     * Sets the boolean value of the variable isProficient on the instanced Skill object
     * @param proficientIn the value true or false is sat on the isProficient variable.
     */
    public void setProficient(boolean proficientIn) {
        isProficient = proficientIn;
    }
}
