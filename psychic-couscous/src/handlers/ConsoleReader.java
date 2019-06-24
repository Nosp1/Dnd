package handlers;
import java.io.*;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class  ConsoleReader {

    private Character character;
    private ResourceBundle text;

    private Gson gson;

    public ConsoleReader() {
    	
        text = SettingsReader.getResourceBundle("ConsoleReader");
        
    }
    
    public void start() {
    	
    	Scanner reader = new Scanner(System.in);
        System.out.println(text.getString("copyDnD"));

        System.out.println();
    	
    	System.out.println(text.getString("start"));

    	System.out.println();
    	
    	System.out.println("[1] " + text.getString("new"));
    	System.out.println("[2] " + text.getString("load"));

    	System.out.println();

    	System.out.print(text.getString("enterChoice") + ": ");

    	String choice = reader.nextLine();

    	while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {

    	    System.out.println();

    	    System.out.println(text.getString("wrongChoice"));

    	    System.out.println();

            System.out.print(text.getString("enterChoice") + ": ");

    	    choice = reader.nextLine();

        }

    	System.out.println();

    	switch (choice) {

            case "1":
                newCharacter();
                break;

            case "2":
                loadCharacter();
                break;

            case "3":
                testChar();
                break;
        }
    	
    }

    private void testChar() {
        this.character = new Character(true);
        saveCharacter(character);
    }

    private void newCharacter() {
        this.character = new Character();
        saveCharacter(character);
    }

    private void saveCharacter(Character character) {
        //TODO: gjøre om karakterens attributer til JSON og lagre det i en fil
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

        //gsonBuilder.registerTypeAdapter(Character.class, new CharacterSerializer());

        gson = gsonBuilder.create();

        String json = gson.toJson(character.toString());
        System.out.println(json);

/*
        // Skriving til fil
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(character.getName() + ".json"));

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
        */
    }
    
    private void loadCharacter() {

        System.out.println(text.getString("loadReminder"));

        System.out.println();

        File characterFolder = new File("./characters");
        File[] charactersFound = characterFolder.listFiles((dir, name) -> name.endsWith(".stc"));

        if (charactersFound == null || charactersFound.length == 0) {

            System.out.println(text.getString("noCharactersFound"));

        }

        else {

            System.out.println("### " + text.getString("charactersFound") + " ###");

            System.out.println();

            for (int i = 0; i < charactersFound.length; i++) {

                String characterName = charactersFound[i].getName().split("\\.")[0];

                System.out.println("[" + (i + 1) + "] " + characterName);
            }

        }
    	
    }


}
