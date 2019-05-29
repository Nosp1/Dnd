package handlers;

public class Skill {

    private String name;
    private boolean isProficient;

    public Skill(String nameIn, boolean isProficientIn){
        setName(nameIn);
        setProficient(isProficientIn);

    }


    public String getName() {
        return name;
    }

    public void setName(String nameIn) {
        this.name = nameIn;
    }

    public boolean isProficient() {
        return isProficient;
    }

    public void setProficient(boolean proficientIn) {
        isProficient = proficientIn;
    }
}
