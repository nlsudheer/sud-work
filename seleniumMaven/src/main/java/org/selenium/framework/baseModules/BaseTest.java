package org.selenium.framework.baseModules;


import org.testng.annotations.AfterClass;
import java.util.Properties;

/**
 * Created by sudheerl on 5/26/14.
 */
public class BaseTest {

    static Properties props = BaseLib.getProperties();
    public static Browser browser = BaseLib.browser;

    public BaseTest(){
//        if (browser == null) {
//            this.browser = new Browser(props.getProperty("browser"));
//        } else{
//            this.browser = new Browser();
//        }
    }


    public String getConfig(String key){
        return props.getProperty(key);
    }

    @AfterClass
    public void tearDown() {
        browser.driver.close();
        browser.driver.quit();
    }

}
