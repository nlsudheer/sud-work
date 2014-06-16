package org.selenium.framework.utils;

import org.selenium.framework.baseModules.BaseLib;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by sudheerl on 5/28/14.
 */
public class TestUtils extends BaseLib {

    // http://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string
    public String randomStringGenerator(){
        return RandomStringUtils.randomAlphanumeric(Integer.parseInt(getConfig("RandomStringCount")));
    }

    public String randomNumberGenerator(){
        return RandomStringUtils.randomNumeric(Integer.parseInt(getConfig("RandomStringCount")));
    }


}
