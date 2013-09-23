package testng;

import org.testng.annotations.*;

/**
 * TestNG Ignore Test
 * @author mkyong
 *
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 20/9/13
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestNGTest3 {
    @Test(enabled=false)
    public void ignoreTest() {
        System.out.println("TestNGTest3: Method is not ready yet");
    }

    @Test(enabled=true)
    public void doNotIgnoreTest() {
        System.out.println("TestNGTest3: Method is not ready yet");
    }
}
