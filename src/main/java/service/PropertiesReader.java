package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static Properties properties;
    private PropertiesReader() {}

    public static Properties getInstance() {
        if (properties == null) {
            try (InputStream input = PropertiesReader.class.getResourceAsStream("/application.properties")) {
                Properties prop = new Properties();
                prop.load(input);
                properties = prop;
            } catch (IOException ex) {
                throw new IllegalArgumentException("Произошла ошибка: " + ex.getMessage());
            }
        }
        return properties;
    }

    public static String getProperty(String key) {
        return getInstance().getProperty(key);
    }
}