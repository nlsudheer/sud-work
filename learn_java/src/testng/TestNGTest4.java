package testng;

import org.testng.annotations.*;

/**
 * TestNG TimeOut Test
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 20/9/13
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestNGTest4 {

    @Test(timeOut = 1000)
    public void timeout() {
        int count = 0;
        System.out.println("TestNGTest4: @Test - timeOut");
        while (true) {
            if (count == 0){
            System.out.println("TestNGTest4: @Test - in while loop");
                count++;
            }
        }
    }
}
