package handlers;

import Races.*;
import Roles.Role;
import Roles.*;
import Backgrounds.Acolyte;
import Backgrounds.Background;
import Backgrounds.Criminal;


import java.lang.reflect.Array;
import java.util.*;

import static handlers.Utilities.*;

/**
 * The {@code Character} class represents the users character.
 * TODO: 2019-06-13  Add Half Elf versatility options...
 *
 * @author Trym Staurheim
 */
public class Character {
    /**
     * name stores the {@code String} on the instanced Character object
     */
    private String name;
    /**
     * age stores the {@code int} on the instanced character object
     */
    private int age;
    /**
     * stores the {@code String} on the instanced character object
     */
    private String gender;
    /**
     * declared for further dynamic type change during program execution to store {@code Race }  child on object
     */
    private Race race;
    /**
     * declared for further dynamic type change during program execution to store {@code Role} child on object
     */
    private Role role;
    /**
     * declared for dynamic type change during program execution to store {@code Background} child on object
     */
    private Background background;
    /**
     * declared for storing type {@code Stat} objects in a list to access them during runtime
     */
    private ArrayList<Stat> stat;
    /**
     * These  {@code Stat} variables are declared to differentiate between the different stats
     */
    private Stat strength, dexterity, constitution, intelligence, wisdom, charisma;
    /**
     * these {@code ResourceBundle} variables are used access the property bundles for  {@code String} handling
     */
    private ResourceBundle text = SettingsReader.getResourceBundle("Character");
    private ResourceBundle races = SettingsReader.getResourceBundle("Race");
    private ResourceBundle stats = SettingsReader.getResourceBundle("Stat");
    private ResourceBundle roles = SettingsReader.getResourceBundle("Role");
    private ResourceBundle backgrounds = SettingsReader.getResourceBundle("Background");


    /**
     * Constructor for the Character class. Creates an object of type Character with properties from Stat, Race, Role and Background
     *
     * @author Trym Staurheim
     */
    public Character() {

        System.out.println(Utilities.renderColoredString(text.getString("newCharacterWelcome"), "yellow"));

        System.out.println();

        setStats();
        chooseName();
        chooseGender();
        isRaceChosen();
        raceInfo();
        increaseCharacterStats();
        halfElfIncreaseStat();
        chooseAge();
        IsRoleChosen();
        checkRaceSkills();
        roleInfo();
        chooseRoleSkills();
        isBackGroundChosen();
        backGroundInfo();
        printCompleteCharacter();


    }

    /* This section includes all methods that handles the character creation.
     *
     */


    /**
     * The method setStats() generates the characters stat values from {@code Roller} and
     * instances a {@code RandomRoll} Array to store these values. These values are then
     * assigned to {@code Stat} objects that are initialized and put into the ArrayList stat.
     * These Stat values are then stored on the character object.
     * The method uses the {@code RandomRoll} inner class to control for used integers.
     * The method also calls on the  printStats() to iterate and print all elements of type Stat
     *
     * @throws NumberFormatException if the Integer converted to string is of incorrect format
     * @author Trym Staurheim
     * @author Kevin Rateni Laturo
     * @see Roller class for how the integers are generated.
     * @see Stat for how Stat type objets are constructed.
     * @see RandomRoll for methods
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
        printStats();
        System.out.println(Utilities.renderColoredString(text.getString("yourStatsWereChosen"), "green"));
    }


    /**
     * Handles the printing of the characters Stats
     * Uses the {@code Utilities} to format the type String and ResourceBundles to get the property file "Character".
     * prints to the user a colored text string: Your stats are:
     * followed by a for each loop that prints out  Elements of type {@code Stat} in ArrayList stat.
     *
     * @author Trym Staurheim
     */

    private void printStats() {
        System.out.println(Utilities.renderColoredString(text.getString("yourstatsare"), "green"));
        for (Stat stat1 : stat) System.out.println(stat1);
    }

    /**
     * Prints the entire character to the user, when the character is complete.
     * uses printChosenSkills for easier printing of the characters skills.
     * uses printStats for printing the characters stats.
     *
     * @author Trym Staurheim
     */
    private void printCompleteCharacter() {

        System.out.println("\n");
        System.out.println(Utilities.renderColoredString(text.getString("comepletecharacter"), "green") + "\n" +
                Utilities.renderColoredString(text.getString("characterNameChosen"), "green") + " " + name + "\n" +
                Utilities.renderColoredString(text.getString("characterAgeChosen"), "green") + " " + age + "\n" +
                Utilities.renderColoredString(text.getString("characterGenderChosen") + ": ", "green") + " " + gender + "\n" +
                Utilities.renderColoredString(text.getString("characterRaceChosen"), "green") + " " + race.getName() + "\n" +
                Utilities.renderColoredString(text.getString("characterRoleChosen"), "green") + " " + role.getRoleName() + "\n" +
                Utilities.renderColoredString(text.getString("characterHp"), "green") + " " + role.getBaseHp() + "\n" +
                Utilities.renderColoredString(text.getString("backgroundchosen"), "green") + " " + background.getBackGroundName() + "\n" +
                Utilities.renderColoredString(text.getString("chosenbackgroundfeature"), "green") + " " + background.getFeature() + "\n" +
                Utilities.renderColoredString(text.getString("characterSkills"), "green") + " ");
        printChosenSkills();
        printStats();


    }

    /**
     * Prints the stored {@code Skill} objects in the {@code Role} objects ArrayList of Type {@code Skill}
     * which are then printed with a for each loop.
     *
     * @author Trym Staurheim
     */

    private void printChosenSkills() {
        for (Skill skill : role.getChosenRoleSkills()) {
            System.out.println(skill.getName());
        }

    }

    /**
     * The method increases the Character objects stored {@code Stat} values by the amount asserted
     * by the instanced {@code Race} objects getRaceIncreaseStats method and getAvailableStats method.
     * These values are instanced by the {@code Race ChooseRace} method.
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
     * Sets the character name on {@code Character} object
     * with a instanced Scanner and prints the name to the user
     * note: as this is a program for a fantasy game,
     * there are no limit for what a name can be, thus any symbol is allowed.
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
     * Sets the character gender on {@code Character} object
     * with a instanced Scanner and prints the gender to the user,
     * note: We have no limits on gender to support gender diversity in a fantasy setting.
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

    /**
     * Sets the character age on {@code Character} object
     * with a instanced Scanner and prints the age to the user.
     * The age is affected by the {@code Race} child objects maxAge value variable.
     *
     * @throws NumberFormatException if the Integer converted to String is of the wrong format
     */
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
        System.out.println(Utilities.renderColoredString(text.getString("characterAgeChosen"), "green") + " " + age);
    }

    /**
     * This method asserts through a loop that the instanced {@code Race} object is not null
     * by instancing a scanner that runs the {@code chooseRace} method
     * when the instanced race object is not equal to null the loop exits.
     *
     * @return race with a dynamic type of the chosen race child instanced by the chooseRace() method.
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
     * printChoices() is a helper method that loops over an Array and prints the choices.
     *
     * @param temp represents the temporary {@code String} array that printChoices() loops over.
     * @author Trym Staurheim
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
     * chooseRace() uses the instanced Scanner from isRaceChosen() method and returns a new {@code Race} child
     * based on the users input.
     *
     * @param input reader from isRaceChosen() to set a child on {@code Race} object.
     * @return new race object child with the child properties from the {@code Race} child constructors.
     * @author Trym Staurheim
     * @see Races.Dragonborn
     * @see Races.Dwarf
     * @see Races.Elf
     * @see Races.Gnome
     * @see Races.HalfElf
     * @see Races.Halfling
     * @see Races.HalfOrc
     * @see Races.Human
     * @see Races.Race
     * @see Races.Tiefling
     **/
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
                System.out.println(Utilities.renderColoredString(races.getString("norace"), "red"));
                return null;
        }

    }

    /**
     * Helper method to print the instanced {@code Race} child {@code String} name with race.getName() method.
     *
     * @author Trym Staurheim
     */
    private void raceInfo() {
        System.out.println(Utilities.renderColoredString(races.getString("satRace") + ": ", "green") + this.race.getName());
    }

    /**
     * Helper method to print the instanced {@code Role} child {@code String} name with role.getRoleName() method.
     *
     * @author Trym Staurheim
     */

    private void roleInfo() {
        System.out.println(Utilities.renderColoredString(roles.getString("chosenrole") + ": ", "green") + this.role.getRoleName());

    }

    /**
     * Helper method to print the instanced {@code Background} child {@code String} name with background.getBackGroundName() method.
     *
     * @author Trym Staurheim
     */

    private void backGroundInfo() {
        System.out.println(Utilities.renderColoredString(backgrounds.getString("chosenbackground") + ": ", "green") + this.background.getBackGroundName());

    }

    /**
     * This method handles the manual stat increase done by the user
     * if the instanced (@code Race) child String {@code String} name is of dynamic type Half-Elf.
     * Else it prints that the user have successfully increased all their stats.
     *
     * @author Trym Staurheim
     */

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
                int elfIncrease = 1;
                switch (halfElf.nextLine()) {
                    case "1": {
                        if (strength.changeValueIfAvailable(elfIncrease)) {
                            System.out.println(String.format(stats.getString("strengthincrease"), elfIncrease, strength.getValue()));
                        } else {
                            System.out.println(Utilities.renderColoredString(stats.getString("statincreased"), "red"));
                            h--;
                        }
                        break;
                    }
                    case "2": {
                        if (dexterity.changeValueIfAvailable(elfIncrease)) {
                            System.out.println(String.format(stats.getString("dexterityincrease"), elfIncrease, dexterity.getValue()));
                        } else {
                            System.out.println(Utilities.renderColoredString(stats.getString("statincreased"), "red"));
                            h--;
                        }
                        break;
                    }
                    case "3": {
                        if (constitution.changeValueIfAvailable(elfIncrease)) {
                            System.out.println(String.format(stats.getString("constitutionincrease"), elfIncrease, constitution.getValue()));
                        } else {
                            System.out.println(Utilities.renderColoredString(stats.getString("statincreased"), "red"));
                            h--;
                        }
                        break;
                    }
                    case "4": {
                        if (intelligence.changeValueIfAvailable(elfIncrease)) {
                            System.out.println(String.format(stats.getString("intelligenceincrease"), elfIncrease, intelligence.getValue()));
                        } else {
                            System.out.println(Utilities.renderColoredString(stats.getString("statincreased"), "red"));
                            h--;
                        }
                        break;
                    }
                    case "5": {
                        if (wisdom.changeValueIfAvailable(elfIncrease)) {
                            System.out.println(String.format(stats.getString("wisdomincrease"), elfIncrease, wisdom.getValue()));
                        } else {
                            System.out.println(Utilities.renderColoredString(stats.getString("statincreased"), "red"));
                            h--;
                        }
                        break;
                    }
                    case "6": {
                        if (charisma.changeValueIfAvailable(elfIncrease)) {
                            System.out.println(String.format(stats.getString("charismaincrease"), elfIncrease, charisma.getValue()));
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

    /**
     * This method asserts through a loop that the instanced {@code Role} object is not null
     * by instancing a scanner that runs the {@code chooseRole} method
     * when the instanced race object is not equal to null the loop exits.
     *
     * @return role with a dynamic type of the chosen {@code Role} child instanced by the chooseRace() method.
     * @author Trym Staurheim
     */


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

    // TODO: 2019-06-01  add spells, to cleric and druid. + properties

    /**
     * chooseRole() uses the instanced Scanner from isRoleChosen() method and returns a new {@code Role} child
     * based on the users input.
     * It also instances an arrayList of type {@code Skills} to store of skills object of that type on object
     *
     * @param input reader from isRoleChosen() to set a child on {@code Role} object.
     * @return new role object child with the child properties from the {@code Role} child constructors.
     * @author Trym Staurheim
     * @see Roles.Barbarian
     * @see Roles.Cleric
     * @see Roles.Druid
     * @see Roles.Fighter
     * @see Roles.Paladin
     * @see Roles.Rogue
     */
    private Role chooseRole(String input) {
        switch (input.toLowerCase()) {
            case "1": {
                ArrayList<Skill> temp = new ArrayList<>();
                return new Barbarian(roles.getString("barbarian"), 12, 2, temp, roles.getString("rage"), roles.getString("unarmoreddefense"), constitution.getModifier());
            }
            case "2": {
                ArrayList<Skill> temp = new ArrayList<>();
                return new Cleric(roles.getString("cleric"), 8, 2, temp, constitution.getModifier());
            }
            case "3": {
                ArrayList<Skill> temp = new ArrayList<>();
                return new Druid(roles.getString("druid"), 8, 2, temp, constitution.getModifier());

            }
            case "4": {
                ArrayList<Skill> temp = new ArrayList<>();
                return new Fighter(roles.getString("fighter"), 10, 2, temp, "fightingstyle", roles.getString("secondwind"), constitution.getModifier());

            }
            case "5": {
                ArrayList<Skill> temp = new ArrayList<>();
                return new Paladin(roles.getString("paladin"), 10, 2, temp, roles.getString("layonhands"), roles.getString("divinesense"), constitution.getModifier());

            }
            case "6": {
                ArrayList<Skill> temp = new ArrayList<>();
                return new Rogue(roles.getString("rogue"), 8, 4, temp, "add method", roles.getString("sneakattack"), roles.getString("thievescant"), constitution.getModifier());

            }
            default:
                System.out.println(Utilities.renderColoredString(roles.getString("norole"), "red"));
                return null;
        }

    }

    /**
     * Checks if selected Race has intrinsic proficiency in any of the skills and adds that skill to Role.get.Chosenskillslist.
     *
     * @author Trym Staurheim
     */
    private void checkRaceSkills() {
        String raceName = race.getName();
        if (raceName.matches("Elf") | raceName.matches("Half-Orc") | raceName.matches("Half-Elf")) {
            switch (raceName) {
                case "Elf": {
                    Skill skill = new Skill(Utilities.getSkills().getString("perception"), true);
                    role.getChosenRoleSkills().add(skill);
                    break;
                }
                case "Half-Orc":
                    Skill skill = new Skill(Utilities.getSkills().getString("intimidation"), true);
                    role.getChosenRoleSkills().add(skill);
                    break;

                case "Half-Elf": {
                    halfElfSkillVersatility();
                }
            }

        }
    }

    /**
     * Helper method for {@code checkRaceSkills} in the case chosen Race is Half-Elf.
     * Initiates a Scanner that gets the skill from array and instances that skill into the chosenRoleSkill list.
     * @author Trym Staurheim
     * @throws NumberFormatException if the input is of wrong format this error is thrown.
     * @throws InputMismatchException  required type is: integers: if the input is of wrong type; in this case a char or symbol.
     */

    private void halfElfSkillVersatility() throws NumberFormatException, InputMismatchException {
        System.out.println(Utilities.renderColoredString(Utilities.getRaces().getString("halfelfskillversatility"), "yellow"));
        int i = 1;
        for (String e : Utilities.getSKILLS()) {
            System.out.println(i + ": " + e);
            i++;
        }
        Scanner halfElf = new Scanner(System.in);
        for (int h = 0; h < 2; h++) {
            int halfElfChoice = Integer.parseInt(halfElf.nextLine()) - 1;
            try {
                if (halfElfChoice > getSKILLS().length) {
                    System.out.println(renderColoredString(text.getString("numbertohigh"), "red") + "\n" +
                            "please try another number.");
                    i--;
                    continue;
                }

                String halfElfChosen = getSKILLS()[halfElfChoice];
                if (role.isProficient(halfElfChosen)) {
                    for (Skill s : role.getChosenRoleSkills()) {
                        System.out.println(Utilities.renderColoredString(getSkills().getString("alreadyproficient"), "red") + s.getName());
                        h--;
                    }

                } else {
                    Skill skill = new Skill(halfElfChosen, true);
                    role.getChosenRoleSkills().add(skill);
                    System.out.println(getSkills().getString("proficient") + " " + halfElfChosen);
                }
            } catch (NumberFormatException | InputMismatchException err) {
                System.out.println("thats not a number");
                h--;
            }

        }

    }


    /**
     * Helper method that prints the available type {@code String} objects
     * stored in the instanced {@code Role} child objects role.availableRoleSkills() method
     *
     * @author Trym Staurheim
     */

    private void printRoleSkills() {
        int counter = 0;
        for (String r : role.availableRoleSkills()) {
            System.out.println(" # " + (counter + 1) + " " + r);
            counter++;
        }

    }

    /**
     * chooseRoleSkills() uses the instanced {@code Role} child get.AmountOfSkills() method.
     * It instances a {@code Scanner} object for the user to choose which skills they want to be proficient in.
     * The method loops til the amountOfSkills condition is met and adds the selected skill to the
     * {@code Role} child objects {@code Skill} ArrayList getChosenRoleSkills().
     *
     * @throws NumberFormatException if the parsed  {@code String} is of the wrong format.
     * @author Trym Staurheim
     */

    private void chooseRoleSkills() throws NumberFormatException, InputMismatchException {
        System.out.println(getSkills().getString("chooseskills") + " " +
                role.getRoleName() + " " + getSkills().getString("choices") + " " + role.getAmountOfSkills());
        System.out.println();
        printRoleSkills();
        Scanner roleSkills = new Scanner(System.in);


        for (int i = 0; i < role.getAmountOfSkills(); i++) {
            int choice = Integer.parseInt(roleSkills.nextLine()) - 1;
            try {

                if (choice > role.availableRoleSkills().size()) {
                    System.out.println(Utilities.renderColoredString(text.getString("numbertohigh"), "red") + "\n" +
                            "please try another number.");
                    i--;
                    continue;
                }
                String chosenSkill = role.availableRoleSkills().get(choice);
                if (role.isProficient(chosenSkill)) {
                    System.out.println(Utilities.renderColoredString(getSkills().getString("alreadyproficient"), "red"));
                    i--;
                    for (Skill s : role.getChosenRoleSkills()) {
                        System.out.print(s.getName() + " ");
                        System.out.println();
                    }
                } else {
                    Skill skill = new Skill(chosenSkill, true);
                    role.getChosenRoleSkills().add(skill);
                    System.out.println(getSkills().getString("proficient") + " " + chosenSkill);
                }
            } catch (NumberFormatException | InputMismatchException ex) {
                System.out.println(Utilities.renderColoredString(text.getString("notvalidinput"), "red"));
                i--;
            }
        }
        System.out.println(Utilities.renderColoredString(getSkills().getString("skillsuccess"), "green"));

    }

    /**
     * This method asserts through a loop that the instanced {@code Background} object is not null
     * by instancing a scanner that runs the {@code chooseBackground} method.
     * When the instanced race object is not equal to null the loop exits.
     *
     * @return background with a dynamic type of the chosen {@code Background} child instanced by the chooseBackground() method.
     * @author Trym Staurheim
     */
    private Background isBackGroundChosen() {
        System.out.println(text.getString("characterBackGround") + " " + text.getString("characterBackGroundOptions") + ": ");
        String[] temp = Utilities.getBACKGROUNDS();
        printChoices(temp);
        Scanner backGroundScanner = new Scanner(System.in);
        boolean isBackGroundSat = false;
        while (!isBackGroundSat) {
            background = chooseBackground(backGroundScanner.nextLine());
            if (background != null) {
                isBackGroundSat = true;
            }
        }
        return background;
    }


    /**
     * chooseBackground() uses the instanced Scanner from isBackGroundChosen() method and
     * returns a new {@code Background} child based on the users input.
     * It also runs any inherent methods of the {@code Background} child, if there are any
     * during instancing of the new {@code Background} child object.
     *
     * @param input reader from isBackGroundChosen() to set a child on {@code Background} object.
     * @return new Background object child with the child properties from the {@code Background} child constructors.
     * @author Trym Staurheim
     * @see Backgrounds.Acolyte
     * @see Backgrounds.Criminal
     * @see Backgrounds.Background
     */
    private Background chooseBackground(String input) {
        switch (input) {
            case "1": {
                return new Acolyte(backgrounds.getString("acolyte"), backgrounds.getString("acolytefeature"), backgrounds.getString("notools"));
            }
            case "2": {
                return new Criminal(backgrounds.getString("criminal"), backgrounds.getString("criminalfeature"), getTools().getString("thievestool"));
            }
            default:
                System.out.println(Utilities.renderColoredString(backgrounds.getString("nobackground"), "red"));
                return null;
        }
    }

    /*
    Below are getters and Setters and inner-classes.
     */

    /**
     * sets the name of the instanced  {@code Character} object during construction.
     *
     * @param nameIn takes the {@code String} characters and sets in on the variable name.
     * @author Trym Staurheim
     */
    private void setName(String nameIn) {

        name = nameIn;

    }

    /**
     * sets the age of the instanced {@code Character} object during construction.
     *
     * @param ageIn takes the {@code int} value and sets it on the variable age.
     * @author Trym Staurheim
     */
    private void setAge(int ageIn) {

        age = ageIn;

    }

    /**
     * sets the gener of the instanced {@code Character} object during construction.
     *
     * @param genderIn takes the {@code String} characters and sets it on the variable gender.
     * @author Trym Staurheim
     */
    private void setGender(String genderIn) {

        gender = genderIn;

    }


    /**
     * The RandomRoll class handles the integers parsed with scanner to SetStats Method.
     *
     * @author Trym staurheim
     */

    class RandomRoll {
        int value;
        boolean isChosen;

        /**
         * Constructor for RandomRoll.
         *
         * @param value    represents the integer enumeration of the variable.
         * @param isChosen represents whether the Roll instanced is chosen
         * @author Trym Staurheim
         */

        RandomRoll(int value, boolean isChosen) {
            this.value = value;
            this.isChosen = isChosen;
        }

        /**
         * getValueAndSetChosen()  is used as a getter and changes the boolean value of the instanced Roll to true.
         * Used to assert that a Integer has been used. For simpler conditioning when handling user input.
         *
         * @return value. value is returned as pre-method call.
         */

        int getValueAndSetChosen() {
            this.isChosen = true;
            return value;
        }
    }


}


