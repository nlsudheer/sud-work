package learnjava;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.*;

/**
 * @author lsudheer
 *         http://www.javatpoint.com/operators-in-java
 *         Using two variables //http://www.zacharyfox.com/blog/fibonacci-project/fibonacci-in-java
 *         using 3 variables: //http://www.freejavaguide.com/javasource1.htm
 */
public class Fibonacci {

    @Parameters({"fibonacciNumber"})
    @Test
    public void fib(int n) {
        long a, b = 0, c = 1;

        for (int i = 0; i <= n; i++) {

            System.out.println("Fibonacci series for the iteration " + i + " is: " + c);

            a = b;
            b = c;
            c = a + b;

        }
    }

    @Parameters({"fibonacciNumber"})
    @Test
    public void fibUsingTwoVariable(int n) {
        long a = 0, b = 1;

        for (int i = 0; i <= n; i++) {
            a = a + b;
            b = a - b;
            System.out.println("Fibonacci series for the iteration " + i + " is: " + a);
        }
    }
}
