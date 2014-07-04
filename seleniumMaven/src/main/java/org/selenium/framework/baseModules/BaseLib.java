package org.selenium.framework.baseModules;

import java.util.Properties;

/**
 * Created by sudheerl on 5/28/14.
 */
public class BaseLib {

    static Properties prop;
    public static Browser browser;


    public static Properties getProperties(){
        return prop;
    }


    static{
        prop = new SystemConfigration().loadProperties(getBaseDir() + "/src/main/resources/framework.properties");
        prop.setProperty("basedir", getBaseDir());

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

}
