package utils;


import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtil {

    public static Properties readConfigFile(String filename) throws Exception {


        FileInputStream fileInputStream = new FileInputStream(filename);

        Properties properties = new Properties();

        properties.load(fileInputStream);

        return properties;


    }
    
}
