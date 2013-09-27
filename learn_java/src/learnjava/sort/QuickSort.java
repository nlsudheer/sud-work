package learnjava.sort;

import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;


/**
 * Quicksort. Quicksort is a divide-and-conquer method for sorting
 * http://www.vogella.com/articles/JavaAlgorithmsQuicksort/article.html
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 23/9/13
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */

@Test(groups = "pending", enabled = false)
public class QuickSort {
    int data[] = new int[]{3, 5, 7, 4, 3, 1, -19, 45, 25, 45, 0, -0};
    //Generate an integer array of length 7
    int[] input = generateRandomNumbers(7);
    int[] anArray = {100, 200, 300, 400, 500, 600, 700, -800, 900, 1000};


    @Test(groups = "pending", enabled = false)
    public void sort(Method method) {
        int[] a = Arrays.copyOf(data, data.length);
        if (a == null || a.length == 0) {
            return;
        }
        quickSort(a, 0, a.length - 1);
        System.out.println(method.getName() + " Insertion sort array result: " + Arrays.toString(a));
    }

    public void quickSort(int array[], int low, int n) {
        int lo = low;
        int hi = n;
        if (lo >= n) {
            return;
        }
        int mid = array[(lo + hi) / 2];

        while (lo < hi) {
            while ((array[lo] < mid)) {
                lo++;
            }
            while ((array[hi] > mid)) {
                hi--;
            }
            if (lo < hi) {
                swap(array, lo, hi);
            }
        }
        if (hi < lo) {
            int T = hi;
            hi = lo;
            lo = T;
        }
        quickSort(array, low, lo);
        quickSort(array, lo == low ? lo + 1 : lo, n);
    }


    //pending need correction
    private void quickSortPendnig(int[] a, int i, int j) {

        int pivot = a[i + (j - i) / 2];

        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(a, i, j);
                i--;
                j++;
            }
        }

        // Recursion
        if (i < j)
            quickSort(a, i, j);
        if (i < j)
            quickSort(a, i, j);
    }

    //pending
    public void quickSortString(String array[], int low, int n) {
        int lo = low;
        int hi = n - 1;
        if (lo >= n) {
            return;
        }
        String mid = array[(lo + hi) / 2];

        while (lo < hi) {
            while (lo < hi && (array[lo].compareTo(mid) < 0)) {
                lo++;
            }
            while (lo < hi && array[hi].compareTo(mid) > 0) {
                hi--;
            }
            if (lo < hi) {
                swap(array, lo, hi);
            }
        }
        if (hi < lo) {
            int T = hi;
            hi = lo;
            lo = T;
        }
        quickSortString(array, low, lo);
        quickSortString(array, lo == low ? lo + 1 : lo, n);
    }


    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * This method generate array of random integers with length n.
     *
     * @param n the length of the array to generate.
     * @return array of random integers with length n.
     */
    private int[] generateRandomNumbers(int n) {

        int[] result = new int[n];
        Random random = new Random();

        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(n * 10);
        }

        return result;
    }
}
