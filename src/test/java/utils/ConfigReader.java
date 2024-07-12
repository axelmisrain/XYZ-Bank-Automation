package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    //This is for reading sensitive data from file and avoid hard coding
    public static String readProperty(String key){

        File file = new File("configuration.properties");
        Properties properties= new Properties();

        try {//we through the exception in case we do not provide the correct data so the code would run, but it will show us the exception at the end.
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties.getProperty(key);
    }
}
