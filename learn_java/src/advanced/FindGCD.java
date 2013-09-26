package advanced;

import org.testng.annotations.Test;

/**
 * http://java67.blogspot.in/2012/08/java-program-to-find-gcd-of-two-numbers.html
 * http://people.cis.ksu.edu/~schmidt/301s12/Exercises/euclid_alg.html
 * <p/>
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 25/9/13
 * Time: 9:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindGCD {

    // assumes a is big number and b is small
    int getGCDByRecursion(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCDByRecursion(b, a % b);
    }

    //using Euclid's GCD Algorithm
    // making static to be called from other
    public static int getGCD(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        while (min != 0) {
            int r = max % min;
            max = min;
            min = r;
        }

        return max;
    }

    @Test
    public void findGCD() {
        int num1 = 3;
        int num2 = 4;

        int min, max;
        max = num1 > num2 ? num1 : num2;
        min = num1 < num2 ? num1 : num2;

        System.out.println("GCD of " + num1 + " and " + num2 + " is " + getGCDByRecursion(max, min));
        System.out.println("GCD of " + num1 + " and " + num2 + " is " + getGCD(max, min));

    }
}
