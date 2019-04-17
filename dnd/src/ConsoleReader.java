import Classes.*;
import Classes.Backgrounds.Acolyte;
import Classes.Backgrounds.CriminalSpy;
import Classes.Races.*;
import Classes.Roles.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
ConsoleReader serves as the main data handler of the project. ConsoleReader uses intrinsic methods to assign player
values: Such as the players name, age, gender, race, role, skills, spells and background.
Prints the user input in the terminal.
@Author Trym Staurheim
 */
public class ConsoleReader {


    //the constructor for consolereader that handles all input and output.
    public ConsoleReader() {

        Statroller.rollstats();
        System.out.println("\nAssign the rolls to stats (NOTE: enter roll number not the value)");
        System.out.println("Available stats: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(Statroller.statTitles[i] + " ");

        }
        System.out.println(" ");
        Scanner s = new Scanner(System.in);
        choosePlayerStats(s);

        printStatrollerComplete();
        Player player = new Player(s.next());
        System.out.println("Your name is: " + player.getPlayerName());
        System.out.println("Choose your gender, type it in.");
        player.setGender(s.next());
        System.out.println("Your gender is: " + player.getGender());
        System.out.println("Chose your race: press 1 for Elf\n " +
                "press 2 for Human\n " +
                "press 3 for Dragonborn\n " +
                "press 4 for Dwarf\n " +
                "press 5 for Halfling\n" +
                "press 6 for Half-Elf\n" +
                "press 7 for Gnome\n " +
                "press 8 for Half-Orc\n" +
                "press 9 for Tiefling\n");
        Race race = selectRace(s);
        player.setRace(race);
        System.out.println("You have Chosen: " + player.getRace().getRaceName());
        IncreasePlayerStats(player);
        halfElfPickStats(player, s);
        System.out.println("Choose your age, type it in. ");
        isAgeSat(s, player);
        System.out.println("Choose your Background\n" +
                "press 1 for Acolyte \n" +
                "press 2 for Criminal/Spy");
        Background background = selectBackGround(s);
        player.setBackGround(background);
        System.out.println("you have chosen " + player.getBackGround().getBackGroundName() + "\n" +
                "You have learned the feature " + player.getBackGround().getFeature() + "\n");

        System.out.println("Chose your Class: press 1 for Rogue \n " +
                "press 2 for Fighter\n " +
                "press 3 for Cleric\n " +
                "press 4 for Paladin\n " +
                "press 5 for Barbarian\n " +
                "press 6 for Druid\n");


        Role role = selectRole(s);
        player.setRole(role);
        printPlayerRoleChosen(player);
        chooseRoleSkills(s, player.getRole());
        System.out.println("This is your character " + player.getPlayerName() + " \n"
                + "your gender is: " + player.getGender() + " and your race " + player.getRace().getRaceName() + " \n"
                + "your role is " + player.getRole().getRollerName() + " and your skills are " + Arrays.toString(player.getRole().getChosenRoleSkills()) + "\n"
                + "your age is " + player.getAge() + "\n"
                + "these are your current stats: Strength: \n " + Statroller.str + "\n"
                + "Dexterity: " + Statroller.dex + "\n"
                + "Constitution: " + Statroller.cons + " \n"
                + "Intelligence: " + Statroller.intl + "\n "
                + "Wisdom: " + Statroller.wis + "\n"
                + "Charisma: " + Statroller.chari);


    }

    //assures that age is properly sat and that the age is 10 or more.
    private void isAgeSat(Scanner s, Player player) throws InputMismatchException {
        boolean isAgeSat = false;
        while (!isAgeSat) {
            try {
                int temp = s.nextInt();
                if (temp >= 10) {
                    player.setAge(temp);
                    isAgeSat = true;
                    System.out.println("your age is: " + player.getAge());
                } else
                    System.out.println("Age is below mimimum of 10, please enter another number");
            } catch (InputMismatchException err) {
                s = new Scanner(System.in);
                System.out.println("Wrong input type, please use numbers");
            }
        }
    }


    //prints the current stat values the player just inputted.
    private void printStatrollerComplete() {
        System.out.println("\nCongratulation! You have set your stats! Here are you stats: ");
        System.out.println("Strength: " + Statroller.str);
        System.out.println("Dexterity: " + Statroller.dex);
        System.out.println("Constitution: " + Statroller.cons);
        System.out.println("Intelligence: " + Statroller.intl);
        System.out.println("Wisdom: " + Statroller.wis);
        System.out.println("Charisma: " + Statroller.chari);
        System.out.println("Choose your name");
    }

    private void printPlayerRoleChosen(Player player) {
        System.out.println("you have chosen " + player.getRole().getRollerName() + " " + "You can choose " + player.getRole().getAmountOfSkills() + " skills");
        System.out.println("Choose any of these " + Arrays.toString(player.getRole().getAvailableSkills()));
    }

    // while looper som sjekker om isRacechosen blir ulik null.
    // a While loop that makes sure the player object is assign a race object.
    private Race selectRace(Scanner s) {
        boolean isRaceChosen = false;
        Race race = null;
        while (!isRaceChosen) {
            race = chooseRace(s.next());
            if (race != null)
                isRaceChosen = true;
        }
        return race;
    }

    //lar spiller sette de tilfeldige tallene på spesifikke atributter.
    // Allows player to set their rolls to specific attributes: E.g. Strength, Dexterity etc.
    private void choosePlayerStats(Scanner s) {

        int ans;
        for (int i = 0; i < 6; i++) {
            try {
                System.out.print(Statroller.statTitles[i] + ": ");
                ans = s.nextInt();
                boolean checkUsed = false;
                for (int c = 0; c < Statroller.used.length; c++) {
                    if (Statroller.used[c] == ans) {
                        checkUsed = true;
                    }
                }
                if (checkUsed) {
                    System.out.println("Value has already been used, try again");
                    i--;
                } else if (ans > 6) {
                    System.out.println("the value is out of range, try again");
                    i--;
                } else {
                    switch (i) {
                        case 0:
                            Statroller.str = Statroller.rolls[ans - 1];
                        case 1:
                            Statroller.dex = Statroller.rolls[ans - 1];
                        case 2:
                            Statroller.cons = Statroller.rolls[ans - 1];
                        case 3:
                            Statroller.intl = Statroller.rolls[ans - 1];
                        case 4:
                            Statroller.wis = Statroller.rolls[ans - 1];
                        case 5:
                            Statroller.chari = Statroller.rolls[ans - 1];
                    }
                    Statroller.used[i] = ans; //adds selection to the array.
                }
            } catch (Exception ex) {
                System.out.println("The value is invalid, try again");
                i--;
                s = new Scanner(System.in);

            }

        }
    }
    //Todo fix Background so the skills from background are checked against class.
private void CheckSkills(Role role, Player player){
        if (player.getBackGround().getBackGroundName().matches("Acolyte")){
            role.getAvailableSkills();
        }
}

    // iterer over players sine stats og øker de med x amount hvor x er race sin statøkning.
    // Iterates over the players assigned stat-values and increments them by x amount.
    // X is based on the race property stat increase.
    private void IncreasePlayerStats(Player player) {
        int n = player.getRace().getRaceInrease();

        for (String val : player.getRace().getAvailableStats()) {
            switch (val) {

                case "str":
                    Statroller.str += player.getRace().getRaceInrease();
                    System.out.println(String.format("Your Strength has increased by: %d. It is now: %d", n, Statroller.str));
                    break;
                case "dex":
                    Statroller.dex += player.getRace().getRaceInrease();
                    System.out.println(String.format("Your Dexterity has increased by: %d. It is now: %d", n, Statroller.dex));
                    break;
                case "cons":
                    Statroller.cons += player.getRace().getRaceInrease();
                    System.out.println(String.format("Your Constitution has increased by: %d. It is now: %d", n, Statroller.cons));
                    break;
                case "intl":
                    Statroller.intl += player.getRace().getRaceInrease();
                    System.out.println(String.format("Your Intelligence has increased by: %d. It is now: %d", n, Statroller.intl));
                    break;
                case "wis":
                    Statroller.wis += player.getRace().getRaceInrease();
                    System.out.println(String.format("Your Wisdom has increased by: %d. It is now: %d", n, Statroller.wis));
                    break;
                case "chari":
                    Statroller.chari += player.getRace().getRaceInrease();
                    System.out.println(String.format("Your Charisma has increased by: %d. It is now: %d", n, Statroller.chari));
                    break;

            }
        }
    }

    // Help method for when player chooses Half-elf to allow the player to manually increase two stats by one.
    public void halfElfPickStats(Player player, Scanner s) {
        if (player.getRace().getRaceName().matches("Half-elf")) {
            System.out.println("Half-elf can increase their stats by choice");
            System.out.println("You can now increase two stats by 1: press 1,2,3,4,5,6 for the respective stats: ");
            for (int i = 0; i < 2; i++) {
                int n = 1;
                switch (s.next().trim().toLowerCase()) {
                    case "1": {
                        Statroller.str += n;
                        System.out.println(String.format("Your Strength has increased by: %d. It is now: %d", n, Statroller.str));
                        break;
                    }
                    case "2": {
                        Statroller.dex += n;
                        System.out.println(String.format("Your Dexterity has increased by: %d. It is now: %d", n, Statroller.dex));
                        break;
                    }
                    case "3": {
                        Statroller.cons += n;
                        System.out.println(String.format("Your Constitution has increased by: %d. It is now: %d", n, Statroller.cons));
                        break;
                    }
                    case "4": {
                        Statroller.intl += n;
                        System.out.println(String.format("Your Intelligence has increased by: %d. It is now: %d", n, Statroller.intl));
                        break;
                    }
                    case "5": {
                        Statroller.wis += n;
                        System.out.println(String.format("Your Wisdom has increased by: %d. It is now: %d", n, Statroller.wis));
                        break;
                    }
                    case "6": {
                        Statroller.chari += n;
                        System.out.println(String.format("Your Charisma has increased by: %d. It is now: %d", n, Statroller.chari));
                        break;
                    }

                }
            }
        }
    }


    // Enables the player to choose the race they want. Generates the array with stats that increase for IncreasePlayerStats Method.
    //Todo maybe add example of custom race?
    private Race chooseRace(String input) {

        switch (input.toLowerCase()) {
            case "1": {
                String[] stats = {"dex"};
                return new Elf("Elf", 700, "advantage on charm and sleep checks", 2, "Common, Elvish", "Can see in the dark",
                        "Has proficieny in perception", "does not need to sleep", stats); //legge til perception i skills array
            }


            case "2": {
                String[] stats = {"str", "dex", "cons", "intl", "wis", "chari"};
                return new Human("Human", 100, 1, "Common", "Choose an extra language", stats);
            }
            case "3": {
                String[] stats = {"str", "chari"};
                return new Dragonborn("DragonBorn", 80, 2, "Common, Draconic", stats, "Choose what type of dragon", "what sort of fire");
            }
            case "4": {
                String[] stats = {"cons"};
                return new Dwarf("Dwarf", 350, 2, "Common, Dwarfish", stats, "Can see in the dark", "has dwarwen weapon training", "can identify stonework", "Has advantage on saving throws against poisen", "You can choose proficiency in any of these artistans tools.");
            }
            case "5": {
                String[] stats = {"dex"};
                return new Halfling("Halfling", 250, 2, "Common, Halfling", stats, "Can see in the dark", "Advantage on saving throws against frightened", "can use the hide action when obscured", "Can move through the space of any creature one size larger than yours");
            }
            case "6": {
                String[] stats = {"chari"};
                return new HalfElf("Half-elf", 180, 2, "Common, Elvish", stats, "advantage on charm and sleep", "can see in the dark", "can pick 2 extra skills");
            }
            case "7": {
                String[] stats = {"intl"};
                return new Gnome("Gnome", 500, 2, "Common, Gnomish", stats, "Has advvantage on intelligence, wisdom and charisma saving throws against magic", "can see in the dark");
            }
            case "8": {
                String[] stats = {"str", "str", "cons"};
                return new HalfOrc("Half-orc", 75, 1, "Common, Orc", stats, "Can see in the dark", "When you are reduced to 0 hit points but not killed outright, you can drop to 1 hit point instead. You can’t use this feature again until you finish a long rest.", "When you score a critical hit, you can add an extra damage dice to your roll", "gain proficiency in Intimidation");
            }
            case "9": {
                String[] stats = {"intl", "chari", "chari"};
                return new Tiefling("Tiefling", 110, 1, "Common, Infernal", stats, "Can see in the dark", "Gains resistance to fire damage", "gets Thaumathurgy cantrip");
            }
            default:
                System.out.println("you have not chosen a race, please type 1, 2, 3, 4, 5 or 7");
                return null;
        }

    }

    /*
    @Params Scanner S & Role role
    Enables the player to choose skills to be proficient in: Based on the role chosen.

     */
    private void chooseRoleSkills(Scanner s, Role role) {
        //gets the chosen roles skills, and stores them in a temporary array,
        String[] temp = role.getChosenRoleSkills();
        // local variable to handle the player input.
        int ans;
        //prints the available skills for the chosen role.
        printAvaiableRoleSkills(role);
        for (int i = 0; i < role.getAmountOfSkills(); i++) {
            try {
                ans = s.nextInt();
                if (ans >= role.getAvailableSkills().length) {
                    System.out.println("You have chosen a skill that does not exsist. Try another number ");
                    i--;
                    continue;
                }
                int pos = ans;
                // Checks to see if ans matches any of the positions in the available skills.
                if (Arrays.stream(temp).anyMatch(x -> x == role.getAvailableSkills()[pos])) {
                    //prints message to the user that the skill chosen has already been used.
                    System.out.println("Value has already been used, try again");
                    i--;
                    continue;
                }
                // changes the array to store the answered skill
                temp[i] = role.getAvailableSkills()[ans];
                // prints the chosen skill.
                System.out.println("You have chosen the skill: " + temp[i]);
                //Checks is the entire array is filled
                if (temp[temp.length - 1] != null) {
                    //sets all the values in temp to the role object.
                    role.setChosenRoleSkills(temp);
                    //prints message to the user.
                    System.out.println("You have selected all your skills ");
                }
                //catches error.
            } catch (Exception ex) {
                //error message to the user.
                System.out.println("The Value is invalid, try again");
                //assigns new scanner to reset.
                s = new Scanner(System.in);
                if (temp != null) {
                    temp = role.getChosenRoleSkills();
                }
            }
        }
    }


    //Prints the available skills for the player
    private void printAvaiableRoleSkills(Role role) {
        for (int i = 0; i < role.getAvailableSkills().length; i++) {
            System.out.println(role.getAvailableSkills()[i] + ": " + i);
        }
    }


    // A While loop that checks whether a Role object is put on the player object.
    private Role selectRole(Scanner s) {
        boolean isRoleChosen = false;
        Role role = null;
        while (!isRoleChosen) {
            role = chooseRole(s.next());
            if (role != null)
                isRoleChosen = true;
        }
        return role;
    }
    //A While loop that cheks whether background is not null.
    private Background selectBackGround(Scanner s){
        boolean isBackGroundChosen = false;
        Background background = null;
        while(!isBackGroundChosen){
            background = chooseBackGround(s.next());
            if (background != null)
                isBackGroundChosen = true;
        }
        return background;
    }

    /*
    Chooses which Role object to store on the players based on case input: E.g 1,2,3 etc.
    @Params String input from the user.
    @Returns new Role object
    Todo: Further implement the missing core classes/roles.
    Todo: Add druidic, paladin, and Cleric spells.
     */
    private Role chooseRole(String input) {

        switch (input.toLowerCase()) {
            case "1": {
                String[] skills = {"Acrobatics", "Athletics", "Deception", "Insight", "Intimidation", "Investigation", "Perception", "Performance", "Persuasion", "Sleight of Hand", "Stealth"};


                return new Rogue("Rogue", 8, "has expertise", "Can sneak attack", "can secret thief language", skills, 6);
            }
            case "2": {
                String[] skills = {"Acrobatics", "Animal Handling", "Athletics", "History", "Insight", "Intimidation", "Perception", "Survival"};

                return new Fighter("Fighter", 12, skills, "can choose specific weapon", "can heal for 1d12 per long rest", 4);
            }
            case "3": {
                String[] skills = {"History", "Religion", "Persuasion", "Medicine", "Insight"};
                return new Cleric("Cleric", 8, skills, 2);
            }
            case "4": {
                String[] skills = {"Medicine", "Religion", "Intimidation", "persuasion", "Insight", "Athletics"};
                return new Paladin("Paladin", 10, skills, 2, "can heal for total amount of 5 x level", "can sense evil");
            }
            case "5": {
                String[] skills = {"Animal Handling", "Intimidation", "Athletics", "Nature", "Survival", "Perception"};
                return new Barbarian("Barbarian", 12, skills, 2, "can rage to decrease damage and increase damage", "as long as not wearing armor: AC equals 10 + dex mod + cons mod. You can also use a shield.");
            }
            case "6": {
                String[] skills = {"Animal Handling", "Arcana", "Nature", "Medicine", "Insight", "Perception", "Religion", "Survival"};
                return new Druid("Druid", 8, skills, 2, "Can speak the druidic language", "can choose spells", "Is proficient in Herbalist kit");
            }
            default:
                System.out.println("you have not chosen a role, please type 1,2,3,4,5 or 6");
                return null;
        }
    }
    /*
    Chooses which Background to store on the player based on case input: e.g 1,2,3 etc
    @params String input from the user.
    @returns a new Background object
     */
    private Background chooseBackGround(String input){
        switch (input.toLowerCase()){
            case "1": {
                String[] skills = {"Religion, Insight"};
                String[] equipment = {"Holy Symbol", "A prayer book", "5 sticks of inscense", "Vestments", "set of fine clothes", " pouch with 15 gold pieces."};

                return new Acolyte("Acolyte","Shelter Of the faithful", "none",skills,equipment,"worships a diety");
            }
            case "2": {
                String[] skills = {"Deception", "Stealth"};
                String[] equipment = {"A crowbar", " A set of common clothes, including a hood", "pouch with 15gp" };

                return new CriminalSpy("Criminal/Spy","Criminal Contact", "Thieves tools, A gaming set",skills,equipment );
            }
            default:
                System.out.println("you have not chosen a backroungd, please type 1,2,3,4");
                return null;
        }
    }

    // Currently not used.
    private boolean ensureString(Object string) {
        return string instanceof String;
    }

    //currently not used.
    private boolean ensureInteger(Object integer) {
        return integer instanceof Integer;
    }
}

