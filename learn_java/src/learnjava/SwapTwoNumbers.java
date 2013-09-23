package learnjava;

/**
 * 5) Program of swapping two numbers without using third variable.
 * http://www.javatpoint.com/operators-in-java
 *
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 16/9/13
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class SwapTwoNumbers {

    void swapByDivison(double a, double b){

        System.out.println(a +" "+ b + " " + "numbers before swapByDivison");
        a = a * b;
        b = a / b;
        a = a / b;
        System.out.println(a +" "+ b + " " + "numbers after swapByDivison");

    }


    public static void main(String args[]){
        int a = 10;
        int b = 12;
        System.out.println(a +" "+ b + " " + "numbers before swap");
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a +" "+ b + " " + "numbers after swap");

        SwapTwoNumbers swap = new SwapTwoNumbers();
        swap.swapByDivison(9.9, 10);
    }

}
