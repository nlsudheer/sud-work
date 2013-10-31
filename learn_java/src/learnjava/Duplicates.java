package learnjava;

import org.bouncycastle.jce.provider.JCESecretKeyFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.*;

/**
 * http://stackoverflow.com/questions/12697202/remove-duplicate-elements-in-an-arraylist-without-using-hashset
 * <p/>
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 7/10/13
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Duplicates {

    int data[] = new int[]{3, 5, 5, -7, 7, 4, 3, 1, -19, 45, 25, 45, 0, -0};


    @Test
    public void removeDuplicateUseHashSet() {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(7);
        al.add(7);
        al.add(7);
        al.add(72);
        al.add(71);
        al.add(-7);

        System.out.println("With duplicate:   " + al);
        // add elements to al, including duplicates
        HashSet hs = new HashSet();
        hs.addAll(al);
        al.clear();
        al.addAll(hs);

        System.out.println("With out duplicate:   " + al);
    }

    //http://stackoverflow.com/questions/12697202/remove-duplicate-elements-in-an-arraylist-without-using-hashset
//    @Test
    public void removeDuplicateArrayList() {
        ArrayList<String> wordDulicate = new ArrayList<String>();
        ArrayList<String> tempList = new ArrayList<String>();

        wordDulicate.add("Tom");
        wordDulicate.add("Jones");
        wordDulicate.add("Sam");
        wordDulicate.add("Sam");

        System.out.println("With duplicate: removeDuplicateArrayList  " + wordDulicate);

        for (String dupWord : wordDulicate) {
            if (!tempList.contains(dupWord)) {
                tempList.add(dupWord);
            }
        }

        System.out.println("With out duplicate: removeDuplicateArrayList  " + (tempList));
    }


    //    @Test(groups = "pending")
    public void findOutDuplicateHashMap() {

        int[] a = Arrays.copyOf(data, data.length); // using Arrays.copyOf method
        Map<Integer, Integer> dup = new HashMap<Integer, Integer>();
        for (int i : a) {

            dup.put(a[i], dup.get(a[i]) + 1);

        }

        for (Map.Entry entry : dup.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }


    //    @Test
    public void findOutDuplicateNoLibraries() {

        int[] a = Arrays.copyOf(data, data.length); // using Arrays.copyOf method
        int aLength = a.length - 1;

        for (int i = 0; i <= aLength; i++) {
            for (int j = i + 1; j <= aLength; j++) {
                if (a[i] == a[j]) {
                    System.out.println("Duplicate in Array: " + a[i]);
                }
            }
        }
    }

}