package org.selenium.framework.baseModules;

/**
 * Created by sudheerl on 5/26/14.
 */
public class BaseTest extends BaseLib {
    public Browser browser = new Browser();

    @Override
    public String getConfig(String key){
        return prop.getProperty(key);

    }

}
