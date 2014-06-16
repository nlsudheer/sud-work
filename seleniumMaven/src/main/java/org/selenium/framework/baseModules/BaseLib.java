package org.selenium.framework.baseModules;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by sudheerl on 5/28/14.
 */
public class BaseLib {

    Properties prop =  loadProperties();



    public  Properties loadProperties(){
        Properties prop = new Properties();
        InputStream in = null;
        try {
            in = getClass().getClassLoader().getResourceAsStream("framework.properties");
            prop.load(in);

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found with in the class path:" + e.getMessage());
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to load the properties: " + e.getMessage());
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
        }

        return prop;
    }

    public String getConfig(String key){
        return prop.getProperty(key);

    }

    public String getBaseDir(){
        return System.getProperty("user.dir");

    }
}
