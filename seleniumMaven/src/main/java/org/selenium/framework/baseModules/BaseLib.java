package org.selenium.framework.baseModules;

import java.io.File;
import java.util.Properties;

/**
 * Created by sudheerl on 5/28/14.
 */
public class BaseLib {

    static Properties prop;
    public static Browser browser;
    public static String propFilePath;

    public BaseLib() {

    }


    public static Properties getProperties(){
        return prop;
    }

//    public BaseLib(Properties prop){
//        this.prop = prop;
//    }

    public BaseLib(String propFilePath){
        this.propFilePath = propFilePath;
    }

    static{
        try {
            prop = new SystemConfigration().loadProperties(getPropertyFilePath());
        } catch (Exception e){
            e.printStackTrace();
        }
        prop.setProperty("basedir", getBaseDir());
        prop.setProperty("framework.properties", getPropertyFilePath());

        if (browser == null) {
            browser = new Browser(prop.getProperty("browser"));
        } else{
            browser = new Browser();
        }
    }


    public static String getBaseDir(){
        return System.getProperty("user.dir");
    }

    public String getConfig(String key){
        return prop.getProperty(key);
    }

    public static String getPropertyFilePath(){
        String primaryFilePath = getBaseDir() + "/framework.properties";
        String secondaryFilePath = getBaseDir() + "/src/main/resources/framework.properties";

        if (new File(primaryFilePath).exists())
            propFilePath = primaryFilePath;
        else if (new File(secondaryFilePath).exists())
            propFilePath = secondaryFilePath;

        return System.getProperty("framework.properties", propFilePath);
    }

}
