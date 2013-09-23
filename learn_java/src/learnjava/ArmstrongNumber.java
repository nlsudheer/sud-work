package learnjava;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * 371 = 3**3 + 7**3 + 1**3 = 371.
 * an Armstrong number or a plus perfect number) is a number that is the sum of its own digits each raised to the power of the number of digits.
 * <p/>
 * A five digit ArmStrong number ABCDE is such that ABCDE = A^5+B^5+C^5+D^5+E^5.
 * let A,B,C,D,E be variables, then equation is
 * E+D*10+C*100+B*1000+A*10000 = A^5 + B^5 + C^5 + D^5 + E^5.
 * <p/>
 * 1. Return 4 digit armstrong numbers in he range of 1 to 10000
 * 2. Find whether a given number is armstrong number or not
 * 3. Return all armstrong numbers in the range of 0 to 999
 * <p/>
 * http://in.answers.yahoo.com/question/index?qid=20091118020348AAbKxA6
 * <p/>
 * http://www.programmingsimplified.com/java/source-code/java-program-armstrong-number
 * <p/>
 * http://www.javatpoint.com/operators-in-java
 * <p/>
 * <p/>
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 13/9/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArmstrongNumber {

    int getNumberOrder(int num) {
        int i = 1;
        while (num > 10) {
            num = (int) num / 10;
            i++;
        }
        return i;
    }

    boolean verifyIsArmStrong(int number, int numOrder) {
        int num = number;
        int tempNum = 0;
        int reminder = 0;
        for (int i = 0; i <= numOrder; i++) {
            reminder = num % 10;
            num = (int) num / 10;
            tempNum = tempNum + (int) Math.pow(reminder, numOrder);
        }
        return (number == tempNum);
    }

    @Parameters({"armStrongNumber"})
    @Test(groups = {"pending"})
    public boolean verifyIsArmStrong(int number) {
        int num = number;
        int numOrder = getNumberOrder(number);
        System.out.println("in method verifyIsArmStrong "+verifyIsArmStrong(number, numOrder));
        return verifyIsArmStrong(number, numOrder);
    }

    @Test (groups = {"pending"})
    @Parameters({"armStrongNumberMin", "armStrongNumberMax"})
    public ArrayList getArmStrongNumbers(int min, int max) {
        int order = 0;
        for (int i = min; i <= max; i++) {
            if (i < 9) {
                order = 1;
            } else if (i < 99) {
                order = 2;
            } else if (i < 999) {
                order = 3;
            } else {
                order = getNumberOrder(i);
            }
        }
        System.out.println("in method getArmStrongNumbers "+getArmStrongNumbers(min, max, order));
        return getArmStrongNumbers(min, max, order);
    }

    ArrayList getArmStrongNumbers(int min, int max, int numOrder) {
        ArrayList numArray = new ArrayList();

        for (int i = min; i <= max; i++) {
            if (verifyIsArmStrong(i, getNumberOrder(i))) {
                numArray.add(i);
            }
        }
        return numArray;
    }


    @Test(groups = {"run"})
    public void callByObject() {
        int num = 153;
        ArmstrongNumber an = new ArmstrongNumber();
        System.out.println("callByObject: " + an.getArmStrongNumbers(10, 700));
        System.out.println("callByObject: "+ num + " is:  " + an.verifyIsArmStrong(num));
    }

    @Test(groups = {"run"})
    public void callByMethod() {
        int num = 371;
        System.out.println("callByMethod: " + getArmStrongNumbers(101, 400, 3));
        System.out.println("callByMethod: " + verifyIsArmStrong(num, 3));
    }
}
