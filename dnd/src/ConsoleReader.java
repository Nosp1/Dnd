import Classes.Player;
import Classes.Race;
import Classes.Races.Dragonborn;
import Classes.Races.Dwarf;
import Classes.Races.Elf;
import Classes.Races.Human;
import Classes.Role;
import Classes.Roles.Cleric;
import Classes.Roles.Fighter;
import Classes.Roles.Rogue;
import Classes.Statroller;

import java.util.Arrays;
import java.util.Scanner;
/*
ConsoleReader serves as the main data handler of the project. ConsoleReader uses intrinsic methods to assign player
values: Such as the players name, age, gender, race, role, skills, spells and background.
Prints the user input in the terminal.
 */
public class ConsoleReader {



//the constructor for consolereader that handles all the input from the reader.
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
                "press 4 for Dwarf ");
        Race race = selectRace(s);
        player.setRace(race);
        System.out.println("You have Chosen: " + player.getRace().getRaceName());
        IncreasePlayerStats(player);
        System.out.println("Chose your Class: press 1 for Rogue \n " +
                "press 2 for Fighter\n " +
                "press 3 for Cleric");
        Role role = selectRole(s);
        player.setRole(role);
        printPlayerRoleChosen(player);
        chooseRoleSkills(s, player.getRole());
        System.out.println("This is your character " + player.getPlayerName() + " \n"
        + "your gender is: " + player.getGender() + " and your race " + player.getRace().getRaceName() + " \n"
        + "your role is " + player.getRole().getRollerName() + " and your skills are " + Arrays.toString(player.getRole().getChosenRoleSkills()) + "\n"
        + "these are your current stats: Strength: " + Statroller.str + "\n"
        + "Dexterity: " + Statroller.dex + "\n"
        + "Constitution: " + Statroller.cons + " \n"
        + "Intelligence: " + Statroller.intl + "\n "
        + "Wisdom: " + Statroller.wis + "\n"
        + "Charisma: " + Statroller.chari);



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

// Enables the player to choose the race they want. Generates the array with stats that increase for IncreasePlayerStats Method.
    //Todo Add rest of the races in core game, maybe add example of custom race?
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
                return new Dwarf("Dwarf", 350, 2, "Common, Dwarfish", stats, "Can see in the dark", "has dwarwen weapon training", "can identify stonework");
            }
            default:
                System.out.println("you have not chosen a race, please type 1, 2, 3, or 4");
                return null;
        }

    }

/*
Velger rollens skills basert på tilgjengelige skills og antall skills de kan velge
@Params Scanner S & Role role
Enables the player to choose skills to be proficient in: Based on the role chosen.

 */
    private void chooseRoleSkills(Scanner s, Role role) {

        String[] temp = role.getChosenRoleSkills();
        int ans;
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

                if (Arrays.stream(temp).anyMatch(x -> x == role.getAvailableSkills()[pos])) {
                    System.out.println("Value has already been used, try again");
                    i--;
                    continue;
                }
                temp[i] = role.getAvailableSkills()[ans];
                System.out.println("You have chosen the skill: " + temp[i]);

                if (temp[temp.length - 1] != null) {
                    role.setChosenRoleSkills(temp);
                    System.out.println("You have selected all your skills ");
                }
            } catch (Exception ex) {
                System.out.println("The Value is invalid, try again");
                s = new Scanner(System.in);
                if (temp != null) {
                    temp = role.getChosenRoleSkills();
                }
            }
        }
    }

    //printer tilgjengelig skills for spilleren
    //Prints the available skills for the player
    private void printAvaiableRoleSkills(Role role) {
        for (int i = 0; i < role.getAvailableSkills().length; i++) {
            System.out.println(role.getAvailableSkills()[i] + ": " + i);
        }
    }

    //Sørger for at Role blir satt på Role objektet
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

    /*
    Chooses which Role object to store on the players based on case input: E.g 1,2,3 etc.
    @Params String input
    @Returns new Role object
    Todo: Further inplement the missing core classes/roles.
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
            default:
                System.out.println("you have not chosen a role, please type 1,2,3,4");
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

