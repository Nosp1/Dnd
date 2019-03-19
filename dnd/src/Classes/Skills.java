package Classes;


import java.util.ArrayList;

public class Skills {
    private ArrayList<String> skills;

    public Skills() {
        ArrayList<String> skills = new ArrayList<>();
        skills.size();
        addSkills();
    }

    private int skillsproficiency() {


        int modifier = 0;
        if (Statroller.dex == 16 || Statroller.dex == 17) {
            modifier = 3;
        }
        if (Statroller.dex == 14 || Statroller.dex == 15) {
            modifier = 2;
        }
        if (Statroller.dex == 12 || Statroller.dex == 13) {
            modifier = 1;
        }
        if (Statroller.dex == 10 || Statroller.dex == 11) {
            modifier = 0;
        }
        if (Statroller.dex == 8 || Statroller.dex == 9) {
            modifier = -1;
        }
        return modifier;
    }

    public int getSkillsProficiency() {
        return skillsproficiency();
    }

    private void addSkills() {
        skills.add("Atlethics");
        skills.add("Animal Handeling");
        skills.add("Acrobatics");
        skills.add("Arcana");
        skills.add("Deception");
        skills.add("History");
        skills.add("Insight");
        skills.add("Intimidation");
        skills.add("Investigation");
        skills.add("Medicine");
        skills.add("Nature");
        skills.add("Perception");
        skills.add("Performance");
        skills.add("Persuasion");
        skills.add("Religion");
        skills.add("Sleight of Hand");
        skills.add("Stealth");
        skills.add("Survival");


    }
}

