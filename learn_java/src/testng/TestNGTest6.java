package testng;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 20/9/13
 * Time: 10:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestNGTest6 {

    @Test
    @Parameters(value="number")
    public void parameterIntTest(int number) {
        System.out.println("Parameterized Number is : " + number);
    }
}
