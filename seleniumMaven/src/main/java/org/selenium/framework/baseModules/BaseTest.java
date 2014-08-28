package org.selenium.framework.baseModules;


import org.testng.annotations.AfterSuite;

import java.util.Properties;

/**
 * Created by sudheerl on 5/26/14.
 */
public class BaseTest {

    static Properties props; // =  BaseLib.getProperties();
    public static Browser browser; // = BaseLib.browser;



    public BaseTest(){
        props =  BaseLib.getProperties();
        browser = BaseLib.browser;

    }


    public String getConfig(String key){
        return props.getProperty(key);
    }

    @AfterSuite
    public void tearDown() {
        if (browser.driver != null)
            browser.driver.quit();
    }

}
