package handlers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;

public class  ConsoleReader {

    private Character character;
    private ResourceBundle text;

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

    	while (!choice.equals("1") && !choice.equals("2")) {

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

        }
    	
    }

    private void newCharacter() {

        character = new Character();
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
