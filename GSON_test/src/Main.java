/*
    Test til Trym sitt dnd prosjekt

    Ved character creation:
    1: rolling and assigning stats - 6 verdier:
        - Charisma, Constitution, Dexterity, Intelligence, Strength and Wisdom.
    2: character name
    3: gender - 3 verdier:
        - male, female or a third option
    4: race - 9 verdier:
        - Dragonborn, Dwarf, Elf, Gnome, Half Elf, Half Orc, Halfling, Human and Tiefling.
        Disse har ulike perks, lagre det som arrays?
        TODO: sjekk source code hvordan det fungerer
    5: age
    6: role - 6 verdier:
        - Barbarian, Cleric, Druid, Fighter, Paladin and Rogue
        Hver rolle gir tilgang til ulike skills, lagre det som arrays?
    7: choosing a background - 2 verdier:
        - Acolyte or a Criminal
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private Gson gson;

    @Expose
    private int[] stats = new int[6];
    @Expose
    private String name;
    @Expose
    private Gender gender;

    public Main() {
        stats[0] = 1;
        stats[1] = 11;
        stats[2] = 111;
        stats[3] = 1111;
        stats[4] = 11111;
        stats[5] = 111111;

        name = "Rolf";

        gender = new Gender("apache helicopter");
    }

    public static void save(String filename, String json) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            try {
                writer.write(json);
            } catch(IOException ioe) {
                ioe.printStackTrace();
            } finally {

                try {
                    writer.close();
                } catch(IOException ioe) {
                    ioe.printStackTrace();
                }

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Main main = new Main();
        String json = gson.toJson(main);
        save("json_output.txt", json);
        System.out.println(json);
    }
}
