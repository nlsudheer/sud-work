package learnjava.search;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * http://www.programmingsimplified.com/java/source-code/java-program-for-binary-search
 *
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 26/9/13
 * Time: 8:39 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Java program for binary search: This code implements binary search algorithm.
 * Please note input numbers must be in ascending order.
 */
public class BinarySearch {
    int a[] = new int[]{3, 5, 7, 4, 3, 1, -19, 45, 25, 45, 0, -0};
//    Arrays.binarySearch(a[], "3")


    public int searchValue(int a[], int search) {
        Arrays.sort(a);

        int first, last, middle;
        first = 0;
        last = a.length - 1;
        middle = (first + last) / 2;

        while (first <= last) {
            if (a[middle] < search)
                first = middle + 1;
            else if (a[middle] == search)
                return middle;
            else
                last = middle - 1;

            middle = (first + last) / 2;
        }
        throw new Error("Number not found");
    }


    public int searchValueJavaSourceCode(int a[], int search) {
        Arrays.sort(a);
        int first, last, middle;
        first = 0;
        last = a.length - 1;
        while (first <= last) {
            middle = (first + last) >>> 1;
            if (a[middle] < search)
                first = middle + 1;
            else if (a[middle] > search)
                last = middle - 1;
            else
                return middle;
        }
        return -(first + 1);
    }

    @Test
    public void binarySearch() {
        System.out.println("Before sorting " + Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("After sorting " + Arrays.toString(a));

        System.out.println("position of value in the given array : " + searchValue(a, 17));
        System.out.println("position of value in the given array : " + searchValueJavaSourceCode(a, 17));

    }

}
