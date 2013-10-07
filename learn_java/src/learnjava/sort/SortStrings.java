package learnjava.sort;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * http://viralpatel.net/blogs/java-tip-how-to-sort-array-in-java-java-util-arrays/
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 1/10/13
 * Time: 2:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class SortStrings {
    @Test
    // http://stackoverflow.com/questions/605891/sort-a-single-string-in-java
    public void sortStringWithOutLibraryOne() {

        String wordSt = "watch";
        char word[] = wordSt.toCharArray();
        // or
//        String word[] = wordSt.split("");

        // using insertion sort
        for (int i = 1; i < word.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (word[j] < word[j + 1]) {
                    char temp = word[j];
                    word[j] = word[j + 1];
                    word[j + 1] = temp;
                }

            }

        }
        wordSt = String.valueOf(word);
        System.out.println("sortStringWithOutLibrary: " + wordSt);
    }

    @Test
    public void sortStringWithOutLibraryTwo() {
        String wordSt = "aAwatchzZ";
        char[] word = wordSt.toCharArray();

        for (int i = 0; i < (word.length - 1); i++) {
            for (int j = i + 1; j > 0; j--) {
                if (word[j] > word[j - 1]) {
                    char temp = word[j - 1];
                    word[j - 1] = word[j];
                    word[j] = temp;
                }
            }
        }
        wordSt = String.valueOf(word);
        System.out.println("sortStringWithOutLibraryTwo: "+wordSt);
    }

    @Test
    public void sortString() {
        String[] stringArray = {"ab", "aB", "c", "0", "2", "1Ad", "a10"};

        System.out.println("****** Unsorted String Array *******");
        for (String str : stringArray) {
            System.out.println(str);
        }

        //Sort array in ascending order
        Arrays.sort(stringArray);

        System.out.println("****** Sorted String Array *******");
        for (String str : stringArray) {
            System.out.println(str);
        }
    }

    @Test
    public void selectiveSorting() {
        String[] stringArray = {"ab", "aB", "c", "0", "2", "1Ad", "a10"};

        System.out.println("****** Unsorted String Array *******");
        for (String str : stringArray) {
            System.out.println(str);
        }

//        Arrays.sort (Object [], int startIndex, int endIndex)
        //Sorting array starting from index 3 till 6
        Arrays.sort(stringArray, 3, 6);

        System.out.println("****** Selective Sort String Array *******");
        for (String str : stringArray) {
            System.out.println(str);
        }

    }
}
