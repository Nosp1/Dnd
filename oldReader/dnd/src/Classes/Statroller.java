package Classes;


import java.util.Arrays;
/*
The Statroller class. Generates the rolls for the player and enables the player to assign the values to specific stat attributes.
@Author Trym Staurheim
 */

public final class Statroller {
    public static int str, dex, cons, intl, wis, chari;

    public static int[] rolls = new int[6];
    public static int[] used = new int[6];
    public static String[] statTitles = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};

// Supplementary method to roll 6 rolls for the player: one for each stat.
    public static void rollstats() {

        System.out.println(" Roll Results: ");
        for (int i = 0; i < 6; i++) {
            rolls[i] = getRoll();
        }
        for (int i = 0; i < 6; i++) {
            int rollcount = i + 1;
            System.out.println(rollcount + ": " + rolls[i]);
        }


    }




// generates a number between 1-6 psudorandomly to simulate a dice roll of a six-sided dice.
    public static int getRandInt() {
        //double num = (int)(Math.random()*((6-1)+1))+1; fjernet da 6+1 er det samme.
        double num = (int) (Math.random() * 6 + 1);
        int res = (int) num;
        return res;
    }
// Runs four getRandInt() to simulate the player rolling 4 six sided dice and dropping the lowest.
    // the total is returned as a sum of the 3 highest rolls.
    public static int getRoll() {
        //rolls 4 times then returns the sum of the highest 3 rolls.
        int[] rolls = new int[4];
        for (int i = 0; i < 4; i++) {
            rolls[i] = getRandInt();
        }
        Arrays.sort(rolls);
        int total = rolls[1] + rolls[2] + rolls[3]; // sum of highest 3 of 4 rolls.
        return total;

    }

    public String[] getStatTitles() {
        return statTitles;
    }

    public static void setStatTitles(String[] statTitles) {
        Statroller.statTitles = statTitles;
    }

}
