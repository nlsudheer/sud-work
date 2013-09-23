package learnjava;

/**
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 16/9/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class SumOfDigits {


    public static void main(String args[]) {
        int num = 315;
        int rem = 0;
        int sum = 0;

        while (num > 0) {
            rem = num % 10;
            num = (int) num / 10;
            sum += rem;
        }
       System.out.println("Sum of digits is: " + sum);
    }
}
