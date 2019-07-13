public class Gender {
    private GenderEnum gender;
    private String genderString;

    public Gender(String gender) {
        this.genderString = gender.toLowerCase().trim();

        if(!(genderString.equals("female") || genderString.equals("male"))) {
            this.gender = GenderEnum.OTHER;
            return;
        }

        if(genderString.equals("female")) {
            this.gender = GenderEnum.FEMALE;
        } else {
            this.gender = GenderEnum.MALE;
        }
    }

    public GenderEnum getGenderEnum() {
        return this.gender;
    }

    public String getGenderString() {
        return this.genderString;
    }
}
