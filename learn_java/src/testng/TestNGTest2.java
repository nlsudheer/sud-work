package testng;

import org.testng.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 20/9/13
 * Time: 7:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestNGTest2 {
    @Test(expectedExceptions = ArithmeticException.class)
      public void divisionWithException() {
        System.out.println("TestNGTest2: @Test - in divisionWithException");
        int i = 1/0;
    }

    @Test
    public void divisionWithOutException() {
        System.out.println("TestNGTest2: @Test - in divisionWithOutException");
        int i = 1/0;
    }
}
