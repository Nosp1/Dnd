package handlers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

public class SettingsReader {

    private static Locale currentLocale;

    private static void setLocale(String country, String language) {

        currentLocale = new Locale(language, country);

    }

    private static void loadLocale() {

        Properties appProps = new Properties();

        try {

            FileInputStream settingFile = new FileInputStream("settings/Settings.properties");
            appProps.load(settingFile);
            settingFile.close();

            String country = appProps.getProperty("country");
            String language = appProps.getProperty("language");

            setLocale(country, language);

        }

        catch(FileNotFoundException fnfe) {

            System.out.println(getResourceBundle("Settings").getString("missingSettings"));

        }

        catch(IOException ioe) {

            System.out.println("Settings file is not correctly formatted.");

        }

    }

    public static ResourceBundle getResourceBundle(String bundleName) {

        loadLocale();

        try {

            return ResourceBundle.getBundle("languages." + bundleName, currentLocale);

        }

        catch(MissingResourceException mre) {

            return ResourceBundle.getBundle("languages." + bundleName, new Locale("en", "US"));

        }



    }

}
