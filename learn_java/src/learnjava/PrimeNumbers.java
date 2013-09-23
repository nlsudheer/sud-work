package learnjava;

import org.testng.annotations.Test;

/**
 * Formula/ logic: Numbers are not divisible by more than half of the number
 * <p/>
 * http://javarevisited.blogspot.in/2012/04/java-program-to-print-prime-numbers-in.html
 * http://www.javatrainingprojects.com/JavaPrograms.htm
 * <p/>
 * <p/>
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 16/9/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrimeNumbers {


    public boolean isPrime_Simple(int num) {
        for (int i = 2; i < num; i++) {
            if ((num % i) == 0)
                return false;
        }
        return true;
    }


    public boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if ((num % i) == 0)
                return false;
        }
        return true;
    }

    @Test(groups = {"done"})
    public void result() {
        PrimeNumbers pn = new PrimeNumbers();
        System.out.println("PrimeNumbers: " + pn.isPrime(6));
        System.out.println("PrimeNumbers: " + pn.isPrime_Simple(7));
    }
}
