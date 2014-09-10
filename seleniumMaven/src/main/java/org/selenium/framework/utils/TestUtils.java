package org.selenium.framework.utils;

import org.selenium.framework.baseModules.BaseLib;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by sudheerl on 5/28/14.
 */
public class TestUtils extends BaseLib {

    // http://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string
    public String randomStringGenerator(){
        return randomStringGenerator(0);
    }

    public String randomStringGenerator(Integer count){
        if(count != 0)
            return RandomStringUtils.randomAlphanumeric(count);
        else
            return RandomStringUtils.randomAlphanumeric(Integer.parseInt(getConfig("RandomStringCount")));
    }

    public String randomNumberGenerator(){
        return randomNumberGenerator(0);

    }

    public String randomNumberGenerator(Integer count){
        if(count != 0)
            return RandomStringUtils.randomNumeric(count);
        else
            return RandomStringUtils.randomNumeric(Integer.parseInt(getConfig("RandomStringCount")));
    }
}
