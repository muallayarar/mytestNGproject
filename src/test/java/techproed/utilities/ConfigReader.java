package techproed.utilities;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.index.qual.PolyUpperBound;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    //Create a static block to run first
    static {
        //Path of properties file
        String path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //creating a method that will accept a key and returns the value
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

//  TEST
    public static void main(String[] args) {
        System.out.println(properties.getProperty("url_techproed"));
        System.out.println(properties.getProperty("url_uat_techproed"));
        System.out.println(properties.getProperty("111"));
    }
}
