package advanced;

/*
 * http://www.careercup.com/question?id=13870747
 * Find the nth most frequent number in array
 * 
 * 
 * public static void main(String[] args) {
   int[] a = {3,3,3,5,10,44,11,44,100,102,102,102};
   System.out.println(getNthMostFrequent(a));
}
public static int getNthMostFrequent(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxCount=0, freqValue = -1;
        for(int i=0; i < a.length; i++) {
           if(map.get(a[i]) == null) { //Insert new.
              map.put(a[i], 1);
           }else { //Already exists. Just increment the count.
              int count = map.get(a[i])+1;
              map.put(a[i], count);
             if(count > maxCount) {
                 maxCount = count;
                 freqValue = a[i];
              }
              
           }
       
       }
           //incase all numbers are unique.
        if(freqValue == -1 && a.length>;0)
           return a[0];
        return freqValue;
      }
      
   }
 */

public class FindMostFrequentNumberInArray {

}
