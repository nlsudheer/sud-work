package learnjava;

/**
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 16/9/13
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Biggest3 {

    public static void main(String args[]) {
        int big, n1, n2, n3;
        n1 = 12;
        n2 = 13;
        n3 = 14;

        if (n1 > n2 && n1 > n3) {
            big = n1;
        } else if (n2 > n3 && n2 > n1) {
            big = n2;
        } else {
            big = n3;
        }
        System.out.println("Big num is :" + big);

//        using nested if

        if (n1 > n2) {
            if (n1 > n3)
                big = n1;
            else
                big = n3;
        } else {
            if (n2 > n3)
                big = n2;
            else
                big = n3;
        }
        System.out.println("Biggest No: " + big);
    }
}
