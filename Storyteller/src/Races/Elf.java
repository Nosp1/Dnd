package Races;
/*
This is the Core Elf race. Currently has all standard elf features added as strings.
@Author Trym Staurheim
Todo, add information to the property strings. e.g., darkvision, feyancestry etc.
 */

public class Elf extends Race {
    private String darkVision;
    private String feyAncestry;
    private String keenSenses;
    private String trance;


    public Elf(String nameIn, int maxAgeIn, String languagesIn, int raceIncreaseStatsIn, String[] availableStatsIn, String darkVisionIn, String feyAncestryIn, String keenSensesIn, String tranceIn) {
        super(nameIn, maxAgeIn, languagesIn, raceIncreaseStatsIn, availableStatsIn);
        setDarkVision(darkVisionIn);
        setFeyAncestry(feyAncestryIn);
        setKeenSenses(feyAncestryIn);
        setTrance(tranceIn);
    }



    public String getDarkVision() {
        return darkVision;
    }

    public void setDarkVision(String darkVisionIn) {
        this.darkVision = darkVisionIn;
    }

    public String getFeyAncestry() {
        return feyAncestry;
    }

    public void setFeyAncestry(String feyAncestryIn) {
        this.feyAncestry = feyAncestryIn;
    }

    public String getKeenSenses() {
        return keenSenses;
    }

    public void setKeenSenses(String keenSensesIn) {
        this.keenSenses = keenSensesIn;
    }

    public String getTrance() {
        return trance;
    }

    public void setTrance(String tranceIn) {
        this.trance = tranceIn;
    }


}
