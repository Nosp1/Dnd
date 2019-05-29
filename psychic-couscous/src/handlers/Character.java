package handlers;

import Races.*;
import Roles.*;
import Roles.Role;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * todo add Skills choice method.
 * todo complete switch case for roles.
 * todo add Race proficiencies: dwarf, orc, elf, half-elf -> Ref.Background
 * todo add Background choice method
 *
 */
public class Character {
    private String name;
    private int age;
    private String gender;
    private Race race;
    private Role role;
    private ArrayList<Skill> skills;
    private ArrayList<Stat> stat;
    private Stat strength, dexterity, constitution, intelligence, wisdom, charisma;

    private ResourceBundle text = SettingsReader.getResourceBundle("Character");
    private ResourceBundle races = SettingsReader.getResourceBundle("Race");
    private ResourceBundle stats = SettingsReader.getResourceBundle("Stat");
    private ResourceBundle roles = SettingsReader.getResourceBundle("Role");


    /**
     *
     */
    public Character() {

        System.out.println(Utilities.renderColoredString(text.getString("newCharacterWelcome"), "yellow"));

        System.out.println();

        setStats();
        printStats();
        chooseName();
        chooseGender();
        isRaceChosen();
        raceInfo();
        increaseCharacterStats();
        halfElfIncreaseStat();
        chooseAge();
        IsRoleChosen();
        roleInfo();




    }

    /* This section includes all methods that handles the character creation.
     *
     */

    /**
     * @author Trym Staurheim
     */

    private void setStats() {

        stat = new ArrayList<>();

        System.out.println(text.getString("randomStats") + ":");

        System.out.println();

        RandomRoll[] rolls = new RandomRoll[6];

        for (int i = 0; i < 6; i++) {

            rolls[i] = new RandomRoll(Roller.generateRoll(), false);

            System.out.println(text.getString("roll") + " #" + (i + 1) + ": " + rolls[i].value);

        }

        System.out.println();

        Scanner statReader = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {

            boolean validChoice = false;

            do {

                System.out.print(text.getString("selectRoll") + " " + Utilities.STATS[i] + ": ");

                try {

                    int chosenRoll = Integer.parseInt(statReader.nextLine()) - 1;

                    if (chosenRoll < 0 || chosenRoll >= 6) {

                        System.out.println(Utilities.renderColoredString(text.getString("invalidRoll"),
                                "red"));

                    } else if (rolls[chosenRoll].isChosen) {

                        System.out.println(Utilities.renderColoredString(text.getString("alreadyChosenRoll"),
                                "red"));

                    } else {

                        switch (i) {
                            case 0:
                                strength = new Stat(stats.getString("strength"), rolls[chosenRoll].getValueAndSetChosen());
                                stat.add(strength);
                                break;
                            case 1:
                                dexterity = new Stat(stats.getString("dexterity"), rolls[chosenRoll].getValueAndSetChosen());
                                stat.add(dexterity);
                                break;
                            case 2:
                                constitution = new Stat(stats.getString("constitution"), rolls[chosenRoll].getValueAndSetChosen());
                                stat.add(constitution);
                                break;
                            case 3:
                                intelligence = new Stat(stats.getString("intelligence"), rolls[chosenRoll].getValueAndSetChosen());
                                stat.add(intelligence);
                                break;
                            case 4:
                                wisdom = new Stat(stats.getString("wisdom"), rolls[chosenRoll].getValueAndSetChosen());
                                stat.add(wisdom);
                                break;
                            case 5:
                                charisma = new Stat(stats.getString("charisma"), rolls[chosenRoll].getValueAndSetChosen());
                                stat.add(charisma);
                                break;

                        }
                        validChoice = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println(Utilities.renderColoredString(text.getString("invalidRoll"), "red"));
                }
            }
            while (!validChoice);
        }
    }

    /**
     *
     */

    private void printStats() {
        System.out.println(text.getString("yourstatsare") + " ");
        for (Stat stat1 : stat) System.out.println(stat1);
        System.out.println(Utilities.renderColoredString(text.getString("yourStatsWereChosen"), "green"));
    }

    /**
     *
     */

    private void increaseCharacterStats() {
        int n = race.getRaceIncreaseStats();
        for (String val : race.getAvailableStats()) {
            switch (val) {
                case "Strength":
                    strength.changeValue(n);
                    System.out.println(String.format(stats.getString("strengthincrease"), n, strength.getValue()));
                    break;
                case "Dexterity":
                    dexterity.changeValue(n);
                    System.out.println(String.format(stats.getString("dexterityincrease"), n, dexterity.getValue()));
                    break;
                case "Constitution":
                    constitution.changeValue(n);
                    System.out.println(String.format(stats.getString("constitutionincrease"), n, constitution.getValue()));
                    break;
                case "Intelligence":
                    intelligence.changeValue(n);
                    System.out.println(String.format(stats.getString("intelligenceincrease"), n, intelligence.getValue()));
                    break;
                case "Wisdom":
                    wisdom.changeValue(n);
                    System.out.println(String.format(stats.getString("wisdomincrease"), n, wisdom.getValue()));
                    break;
                case "Charisma":
                    charisma.changeValue(n);
                    System.out.println(String.format(stats.getString("charismaincrease"), n, charisma.getValue()));
                    break;
            }
        }

    }

    /**
     * Sets the character name.
     *
     * @author Trym Staurheim
     */

    private void chooseName() {
        System.out.println(text.getString("characterName"));
        Scanner nameScanner = new Scanner(System.in);
        name = nameScanner.nextLine();
        setName(name);
        System.out.println(Utilities.renderColoredString(text.getString("characterNameChosen") + ": ", "green") + name);
    }

    /**
     * Sets characters gender
     *
     * @author Trym Staurheim
     */
    private void chooseGender() {
        System.out.println(text.getString("characterGender"));
        Scanner genderScanner = new Scanner(System.in);
        gender = genderScanner.nextLine();
        setGender(gender);
        System.out.println(Utilities.renderColoredString(text.getString("characterGenderChosen") + ": ", "green") + gender);
    }

    private void chooseAge() throws NumberFormatException {
        boolean isAgeSat = false;
        System.out.println(text.getString("characterAge"));
        Scanner ageScanner = new Scanner(System.in);

        while (!isAgeSat) {
            try {
                age = Integer.parseInt(ageScanner.nextLine());
                if (age > race.getMaxAge()) {
                    System.out.println(Utilities.renderColoredString(text.getString("characterAgeTohigh") + " " + race.getName(), "red"));

                } else if (age <= 10) {
                    System.out.println(Utilities.renderColoredString(text.getString("characterAgeToLow"), "red"));

                } else if (age < race.getMaxAge()) {
                    isAgeSat = true;
                    setAge(age);
                }

            } catch (NumberFormatException err) {
                System.out.println(Utilities.renderColoredString(text.getString("invalidAge"), "red"));
            }
        }
        System.out.println(Utilities.renderColoredString(text.getString("characterAgeSat"), "green") + " " + age);
    }

    /**
     * @returns race object
     * @author Trym Staurheim
     */

    private Race isRaceChosen() {
        System.out.println(text.getString("characterRace") + ", " + text.getString("characterRaceOptions") + " : ");
        String[] temp = Utilities.getRACES();
        printChoices(temp);
        Scanner raceScanner = new Scanner(System.in);
        Stat.statModifier(stat);
        boolean isRaceSet = false;
        while (!isRaceSet) {
            race = chooseRace(raceScanner.nextLine());
            if (race != null) {
                isRaceSet = true;
            }
        }
        return race;
    }

    /**
     * @param temp
     */

    private void printChoices(String[] temp) {
        int counter = 0;
        for (String s : temp) {
            System.out.println(" # " + (counter + 1) + " " + s);
            counter++;
        }
        System.out.println();
    }

    /**
     * @param input reader from isRaceChosen()
     * @return new race object
     */// TODO: 2019-05-27 fix gnome, elf, half-orc, when skills are added.
    private Race chooseRace(String input) {
        switch (input.toLowerCase()) {

            case "1": {
                String[] temp = {stats.getString("strength"), stats.getString("strength"), stats.getString("charisma")};
                return new Dragonborn(races.getString("dragonborn"), 80, "Draconic, Common", 1, temp,
                        "Based on your Ancestor");
            }
            case "2": {
                String[] temp = {stats.getString("constitution")};
                return new Dwarf(races.getString("dwarf"), 350, "Common,Dwarish", 2, temp,
                        races.getString("darkvision"), races.getString("dwarwencombattraining"), races.getString("stonecunning"),
                        races.getString("dwarwenresilience"));
            }
            case "3": {
                String[] temp = {stats.getString("dexterity")};
                return new Elf(races.getString("elf"), 700, "Elvish, Common", 2, temp,
                        races.getString("darkvision"), races.getString("feyancestry"), "proficient in Perception", races.getString("trance"));

            }
            case "4": {
                String[] temp = {stats.getString("intelligence")};
                return new Gnome(races.getString("gnome"), 500, "Common, Gnomish", 2, temp,
                        races.getString("darkvision"), races.getString("gnomecunning"));
            }
            case "5": {
                String[] temp = {stats.getString("charisma")};
                return new HalfElf(races.getString("halfelf"), 180, "Common, elvish", 2, temp,
                        races.getString("darkvision"), races.getString("feyancestry"), "gain proficiency in two skills");
            }
            case "6": {
                String[] temp = {stats.getString("dexterity")};
                return new Halfling(races.getString("halfling"), 250, "Common, Halfling", 2, temp,
                        races.getString("lucky"), races.getString("naturallystealthy"), races.getString("halflingnimbleness"), races.getString("brave"));
            }
            case "7": {
                String[] temp = {stats.getString("strength"), stats.getString("strength"), stats.getString("constitution")};
                return new HalfOrc(races.getString("halforc"), 75, "Common, Orcish", 1, temp,
                        races.getString("darkvision"), "gains proficiency in intimidate", races.getString("relentlessendurance"), races.getString("savageattacks"));
            }
            case "8": {
                String[] temp = {stats.getString("strength"), stats.getString("dexterity"),
                        stats.getString("constitution"), stats.getString("intelligence"), stats.getString("wisdom"), stats.getString("charisma")};
                return new Human(races.getString("human"), 100, "common", 1, temp, "choose extra langauge");

            }
            case "9": {
                String[] temp = {stats.getString("intelligence"), stats.getString("charisma"), stats.getString("charisma")};
                return new Tiefling(races.getString("tiefling"), 110, "Common, Infernal", 1, temp, races.getString("darkvision"), "learns some spells", "learns langauge");
            }
            default:
                System.out.println(Utilities.renderColoredString(races.getString("norace"),"red"));
                return null;
        }

    }

    private void raceInfo() {
        System.out.println(Utilities.renderColoredString(races.getString("satRace")  + ": ", "green") + this.race.getName());
    }
    private void roleInfo(){
        System.out.println(Utilities.renderColoredString(roles.getString("chosenrole") + ": ","green") + this.role.getRoleName());

    }
    private void halfElfIncreaseStat() {

        if (race.getName().matches(races.getString("halfelf"))) {

            System.out.println(races.getString("halfelfincreasestat") + "\n");
            int i = 1;
            for (Stat e : stat) {
                System.out.println(i + ": " + e);
                i++;
            }
            Scanner halfElf = new Scanner(System.in);
            for (int h = 0; h < 2; h++) {
                int elfIncrese = 1;
                switch (halfElf.nextLine()) {

                    case "1": {
                        if (strength.changeValueIfAvailable(elfIncrese)) {
                            System.out.println(String.format(stats.getString("strengthincrease"), elfIncrese, strength.getValue()));
                        } else {
                            System.out.println(Utilities.renderColoredString(stats.getString("statincreased"), "red"));
                            h--;
                        }
                        break;
                    }
                    case "2": {
                        if (dexterity.changeValueIfAvailable(elfIncrese)) {
                            System.out.println(String.format(stats.getString("dexterityincrease"), elfIncrese, dexterity.getValue()));
                        } else {
                            System.out.println(Utilities.renderColoredString(stats.getString("statincreased"), "red"));
                            h--;
                        }
                        break;
                    }
                    case "3": {
                        if (constitution.changeValueIfAvailable(elfIncrese)) {
                            System.out.println(String.format(stats.getString("constitutionincrease"), elfIncrese, constitution.getValue()));
                        } else {
                            System.out.println(Utilities.renderColoredString(stats.getString("statincreased"), "red"));
                            h--;
                        }
                        break;
                    }
                    case "4": {
                        if (intelligence.changeValueIfAvailable(elfIncrese)) {
                            System.out.println(String.format(stats.getString("intelligenceincrease"), elfIncrese, intelligence.getValue()));
                        } else {
                            System.out.println(Utilities.renderColoredString(stats.getString("statincreased"), "red"));
                            h--;
                        }
                        break;
                    }
                    case "5": {
                        if (wisdom.changeValueIfAvailable(elfIncrese)) {
                            System.out.println(String.format(stats.getString("wisdomincrease"), elfIncrese, wisdom.getValue()));
                        } else {
                            System.out.println(Utilities.renderColoredString(stats.getString("statincreased"), "red"));
                            h--;
                        }
                        break;
                    }
                    case "6": {
                        if (charisma.changeValueIfAvailable(elfIncrese)) {
                            System.out.println(String.format(stats.getString("charismaincrease"), elfIncrese, charisma.getValue()));
                        } else {
                            System.out.println(Utilities.renderColoredString(stats.getString("statincreased"), "red"));
                            h--;
                        }
                        break;
                    }
                    default:
                        System.out.println(Utilities.renderColoredString(stats.getString("nostatincreased"), "red"));
                        h--;
                        break;

                }
            }

        }
        System.out.println(Utilities.renderColoredString(stats.getString("increasedall"), "green"));

    }

    private Role IsRoleChosen() {
        System.out.println(text.getString("characterRole") + ", " + text.getString("characterRoleOptions") + " : ");
        String[] temp = Utilities.getROLES();
        printChoices(temp);
        boolean isRoleSet = false;
        Scanner roleScanner = new Scanner(System.in);
        while (!isRoleSet) {
            role = chooseRole(roleScanner.nextLine());
            if (role != null) {
                isRoleSet = true;
            }
        }
        return role;
    }
//todo add spells, to cleric and druid. + properties
    private Role chooseRole(String input) {
        switch (input.toLowerCase()) {
            case "1": {
                ArrayList<Skill> temp = new ArrayList<>();
                return new Barbarian(roles.getString("barbarian"), 12,2,temp, roles.getString("rage"),roles.getString("unarmoreddefense"), constitution.getModifier());
            }
            case "2":{
                ArrayList<Skill> temp = new ArrayList<>();
                return new Cleric(roles.getString("cleric"),8,2,temp,constitution.getModifier());
            }
            case "3":{
                ArrayList<Skill> temp = new ArrayList<>();
                return new Druid(roles.getString("druid"),8,2,temp,constitution.getModifier());

            }
            case "4":{
                ArrayList<Skill> temp = new ArrayList<>();
                return new Fighter(roles.getString("fighter"),10,2,temp,"fightingstyle", roles.getString("secondwind"),constitution.getModifier());

            }
            case "5":{
                ArrayList<Skill> temp = new ArrayList<>();
                return new Paladin(roles.getString("paladin"),10,2,temp,roles.getString("layonhands"),roles.getString("divinesense"),constitution.getModifier());

            }
            case "6":{
                ArrayList<Skill> temp = new ArrayList<>();
                return new Rogue(roles.getString("rogue"),8, 4,temp,"add method",roles.getString("sneakattack"),roles.getString("thievescant"),constitution.getModifier());

            }
            default:
                System.out.println(Utilities.renderColoredString(roles.getString("norole"),"red"));
                return null;
        }

    }

    public void printRoleSkills(){
        int counter = 0;
        for (String r:role.availableRoleSkills()){
            System.out.println(" # " + (counter + 1) + " " + r);
            counter++;
        }

    }
    public void chooseRoleSkills() throws NumberFormatException {
        printRoleSkills();
        Scanner roleSkills = new Scanner(System.in);

        try {
            int choice = Integer.parseInt(roleSkills.nextLine());
            for (int i = 0; i < role.getAmountOfSkills(); i++) {


            }
        }
        catch (NumberFormatException nfe){


        }    }


    /* getters and setters.
     *
     *
     */
    private void setName(String nameIn) {

        name = nameIn;

    }

    private void setAge(int ageIn) {

        age = ageIn;

    }

    private void setGender(String genderIn) {

        gender = genderIn;

    }


    /**
     * The RandomRoll class handles the integers parsed with scanner to SetStats Method.
     *
     * @author Trym staurheim
     * @return value
     */

    class RandomRoll {
        int value;
        boolean isChosen;

        /**
         * Constructor for RandomRoll.
         *
         * @param value
         * @param isChosen
         * @author Trym Staurheim
         */

        RandomRoll(int value, boolean isChosen) {
            this.value = value;
            this.isChosen = isChosen;
        }

        int getValueAndSetChosen() {
            this.isChosen = true;
            return value;
        }
    }


}

