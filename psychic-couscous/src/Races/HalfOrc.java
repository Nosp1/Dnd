package Races;

import org.codehaus.jackson.annotate.JsonTypeName;

/*
The Core HalfOrc with all properties as strings.
@Author Trym staurheim
 */
@JsonTypeName("halforc")
public class HalfOrc extends Race {
    private String darkVision;
    private String relentlessEndurance; // when half-orcs is reduced to 0 hp, you are instead recued to 1hp
    private String savageAttacks; //can add dmg dice to crits
    private String menacing; // gains profiency in intimdation


    public HalfOrc(String nameIn, int maxAgeIn, String languagesIn, int raceIncreaseStatsIn, String[] availableStatsIn, String darkVisionIn, String menacingIn, String relentlessEndurancIn, String savageAttacksIn) {
        super(nameIn, maxAgeIn, languagesIn, raceIncreaseStatsIn, availableStatsIn);
        setDarkVision(darkVisionIn);
        setMenacing(menacingIn);
        setRelentlessEndurance(relentlessEndurancIn);
        setSavageAttacks(savageAttacksIn);
    }

    public String getDarkVision() {
        return darkVision;
    }

    public void setDarkVision(String darkVisionIn) {
        this.darkVision = darkVisionIn;
    }

    public String getRelentlessEndurance() {
        return relentlessEndurance;
    }

    private void setRelentlessEndurance(String relentlessEnduranceIn) {
        this.relentlessEndurance = relentlessEnduranceIn;
    }

    public String getSavageAttacks() {
        return savageAttacks;
    }

    private void setSavageAttacks(String savageAttacksIn) {
        this.savageAttacks = savageAttacksIn;
    }

    public String getMenacing() {
        return menacing;
    }

    private void setMenacing(String menacingIn) {
        this.menacing = menacingIn;
    }
}
