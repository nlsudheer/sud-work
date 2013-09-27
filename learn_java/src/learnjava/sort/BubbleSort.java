package learnjava.sort;

import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * http://www.programmingsimplified.com/java/source-code/java-program-to-bubble-sort
 * <p/>
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 27/9/13
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class BubbleSort {

    public int[] bubbleSortMethod(int a[]) {
        int n = a.length - 1;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }


    @Test
    public void bubbleSort(Method method) {
        String name = method.getName();
        System.out.println("testName : " + name);

        int data[] = new int[]{3, 5, 7, 4, 3, 1, -19, 45, 25, 45, 0, -0};
        System.out.println(name + "sort array: " + Arrays.toString(data));

        System.out.println(name + "sort array result: " + Arrays.toString(bubbleSortMethod(data)));
    }

}
