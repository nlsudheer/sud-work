package advanced;

import org.testng.annotations.Test;

/**
 * http://www.roseindia.net/tutorial/java/core/findLCM.html
 * http://www.javaforschool.com/124-program-to-find-the-lcm-of-two-numbers-method-2/
 *
 * http://www.wikihow.com/Find-the-Least-Common-Multiple-of-Two-Numbers
 * num1 and num2
 * now divide num1 and num2 with 2 till reminder is 0
 * again divide with 2 or 3 till no more common factors or numbers are not divisible further
 * now multiply all divisors
 * <p/>
 * dividend ÷ divisor = quotient
 * <p/>
 * Example: in 12 ÷ 3 = 4, 3 is the divisor
 * <p/>
 *
 * Enter the 1st number : 336
 Enter the 2nd number : 224
 L.C.M. = 672

 Explanation:

 In this program we are using the following logic:

 1. If their is an LCM of two numbers, i.e. if they have any common multiple except 1, then it will always be greater than or equal to the maximum number. It cannot be less than it.

 2. LCM of two numbers is a number which is a multiple of both the numbers.
 For Example, if the 2 numbers are 336 and 224, then there LCM is 672 which is both a multiple of the maximum number (336 x 2 = 672) and also a multiple of the minimum number (224 x 3 = 672).
 [Yes it is true. If you don't believe me, then take any 2 numbers, find their LCM and check whether what I say is true or not.]

 3. So since LCM is the multiple of both the maximum and the minimum number, then it won’t be wrong to use the following logic:

 ● Find multiples of the maximum number. [Since, LCM is either equal to or greater than the maximum number]
 ● Check whether this multiple is also a multiple of the minimum number or not, i.e. whether this multiple is divisible by the minimum number or not.
 ● If it is divisible, then this is our LCM and we have to stop, because though there may be many other such multiples, but we wanted to find the least multiple of both the numbers.

 4. Finally, we are printing the LCM as the output.

 That is it. In this program, we have used the above logic only in order to find the LCM.



 Source: http://www.javaforschool.com/124-program-to-find-the-lcm-of-two-numbers-method-2/#ixzz2fv8VBRfg
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 25/9/13
 * Time: 6:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindLCM {

    public void getLCM(int a, int b) {
        int min, max, lcm;
        min = a < b ? a : b;
//        max = b < a ? a : b; //or
        max = a < b ? b : a;


        for (int i = 1; i <= min; i++) {
             lcm = (max * i);
            if (lcm % min == 0) {
                System.out.println("LCM of " + min + " and " + max + " is " + lcm);
                break;
            }
        }

    }


    // set the num1 as lower, num2 as higher
    public int getLCMBasic(int a, int b) {
        int min, max;

        if (a < b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }

        for (int i = 1; i <= min; i++) {

            if ((max * i) % min == 0) {
                return max * i;
            }

        }
        throw new Error("Error");
    }

    public void getLCMForLoop(int a, int b){

        for (int i =1; i <= a * b; i++){
            if ((i % a) == 0 && (i % b) == 0){
                System.out.println("LCM of " + a + " and " + b + " is " + i);

            }

        }


    }

    @Test
    public void getLCM() {
        int num1 = 7;
        int num2 = 8;

        System.out.println("LCM of " + num1 + " and " + num2 + " is " + getLCMBasic(num1, num2));
        getLCM(num1, num2);
        getLCMForLoop(8,7);
    }
}
