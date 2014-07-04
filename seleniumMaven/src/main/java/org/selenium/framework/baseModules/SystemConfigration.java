package org.selenium.framework.baseModules;

import java.io.*;
import java.util.Properties;

/**
 * Created by sudheerl on 7/7/14.
 */
public class SystemConfigration {

    public static Properties loadProperties(String propertyFile){
        Properties prop = new Properties();
        InputStream is = null;
        try {
//            is = getClass().getClassLoader().getResourceAsStream(propertyFile); //"framework.properties"

//            ClassLoader.getResourceAsStream(propertyFile);

            is = new FileInputStream(new File(propertyFile));
            prop.load(is);

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found with is the class path:" + e.getMessage());
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to load the properties: " + e.getMessage());
        } finally {
            if (is != null)
                try {
                    is.close();
                } catch (IOException e) {
                }
        }
        return prop;
    }


}
