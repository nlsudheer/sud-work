package learnjava;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Insertion sort
 * Selection sort
 * Quicksort
 * Heapsort
 * Bubble sor
 * <p/>
 * http://en.wikipedia.org/wiki/Sorting_algorithm
 * <p/>
 * 3.1 Simple sorts
 * 3.1.1 Insertion sort
 * 3.1.2 Selection sort
 * 3.2 Efficient sorts
 * 3.2.1 Merge sort
 * 3.2.2 Heapsort
 * 3.2.3 Quicksort
 * 3.3 Bubble sort and variants
 * 3.3.1 Bubble sort
 * 3.3.2 Shell sort
 * 3.3.3 Comb sort
 * 3.4 Distribution sort
 * 3.4.1 Counting sort
 * 3.4.2 Bucket sort
 * 3.4.3 Radix sort
 * <p/>
 * http://introcs.cs.princeton.edu/java/42sort/
 * <p/>
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 23/9/13
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sort {
    ArrayList<Integer> ar = new ArrayList<Integer>();

//    ar.add(1);
//    ar.add(3);
//    ar.add(5);
//    ar.add(7);
//    ar.add(15);
//    ar.add(1);
//    ar.add(49);

    int data[] = new int[]{3, 5, 7, 4, 3, 1, -19, 45, 25, 45, 0, -0};

    //Generate an integer array of length 7
    int[] input = generateRandomNumbers(7);
    int[] anArray = {100, 200, 300, 400, 500, 600, 700, -800, 900, 1000};

    @Test
    public void insertionSort() {
        int[] a = data.clone();
        int lengthB4Sort = a.length;
        System.out.println("Insertion sort array: " + Arrays.toString(a));
        for (int i = 1; i < lengthB4Sort; i++) {
            int temp = a[i]; // not using this for better understanding
            int j;
            for (j = i - 1; j >= 0 && a[i] < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = a[i];
        }
        System.out.println("Insertion sort array result: " + Arrays.toString(a));

        int lengthAfterSort = a.length;
        System.out.println("Insertion sort array lengthB4Sort: " + lengthB4Sort);
        System.out.println("Insertion sort array lengthAfterSort: " + lengthAfterSort);
    }

    @Test
    public void insertionSortUseWhile() {
        int[] a = data.clone();
        int lengthB4Sort = a.length;
        System.out.println("Insertion sort array: " + Arrays.toString(a));
        for (int i = 1; i < lengthB4Sort; i++) {
            int temp = a[i]; // not using this for better understanding
            int j = i;
            while ((j > 0) && (temp < a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;

        }
        System.out.println("Insertion sort array result: " + Arrays.toString(a));

        int lengthAfterSort = a.length;
        System.out.println("Insertion sort array lengthB4Sort: " + lengthB4Sort);
        System.out.println("Insertion sort array lengthAfterSort: " + lengthAfterSort);
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
