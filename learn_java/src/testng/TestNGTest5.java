package testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 20/9/13
 * Time: 7:39 PM
 * To change this template use File | Settings | File Templates.
 */

public class TestNGTest5 {
    static long n = 10;

    @Test
    public void fib() {
        long a, b = 0, c = 1;
        n = 10;
        for (int i = 0; i <= n; i++) {

            System.out.println("Fibonacci series for the iteration " + i + " is: " + c);

            a = b;
            b = c;
            c = a + b;

        }
    }

    @Test
    public void fibUsingTwoVariable() {
        long a = 0, b = 1;
        n = 10;

        for (int i = 0; i <= n; i++) {
            a = a + b;
            b = a - b;
            System.out.println("Fibonacci series for the iteration " + i + " is: " + a);
        }
    }
}
