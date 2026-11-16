package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties props = new Properties();

    static {
        try (InputStream is = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            props.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Could not load config.properties", e);
        }
    }

    // A value passed with -Dkey=value on the command line wins over the file
    public static String get(String key) {
        return System.getProperty(key, props.getProperty(key));
    }
}