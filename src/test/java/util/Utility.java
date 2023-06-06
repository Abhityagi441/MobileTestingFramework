package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utility {

    static Properties properties;
    static InputStream input;
    public static Properties loadConfigProperties() {
        String defaultConfig = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        return Utility.loadProperties(defaultConfig);
    }
    public static Properties loadProperties(String path) {
        try {
            input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            return properties;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
