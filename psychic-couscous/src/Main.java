
import handlers.ConsoleReader;


import java.io.*;
import java.util.Locale;
import java.util.Properties;

public class Main {

    private static Locale currentLocale = Locale.getDefault();

    public static void main(String[] args) {

        checkSettingsFile();

        ConsoleReader storyteller = new ConsoleReader();

        storyteller.start();


    }

    private static void checkSettingsFile() {

        try {

            FileInputStream settingsFile = new FileInputStream("settings/Settings.properties");

            Properties appProps = new Properties();

            appProps.load(settingsFile);

            settingsFile.close();

            if (appProps.getProperty("country") == null) {

                appProps.setProperty("country", currentLocale.getCountry());

            }

            if (appProps.getProperty("language") == null) {

                appProps.setProperty("language", currentLocale.getCountry());

            }

            FileOutputStream settingsFileWriter = new FileOutputStream("settings/Settings.properties");

            appProps.store(settingsFileWriter, "");

        }

        catch(IOException ioe) {

            createSettingsFile();

        }

    }

    private static void createSettingsFile() {

        File settingsFile = new File("settings/Settings.properties");

        try {

            settingsFile.createNewFile();

            checkSettingsFile();

        }

        catch(IOException ioe) {

            System.out.println();

            System.out.println("Critical error in creating a Settings file.");

            System.out.println();

        }

    }

}
