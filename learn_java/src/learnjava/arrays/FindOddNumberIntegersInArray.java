package learnjava.arrays;

/**
 * http://www.careercup.com/question?id=5074605773422592
 * @author sudheerl
 * Array of Integers with even number of same Integers.
 *  Find the Integer that is an odd number of times. Compare efficiency between different approaches.
 *
 */
public class FindOddNumberIntegersInArray {
   /**
    * 1) Use XOR operator - xor each element in the array then duplicated elements will reduce each other ; time O(n), space O(1) 
2) Use Set - add elements to the Set. If the set already contains given element then remove from the set. At the end set will contain only not duplicated element; time O(n), space O(n) 
3) Sort array and use running counter to find not duplicated element; time O(nlogn), space O(1)
    */
   
   public static void main(String []args){
      String s = null;
//      s.s
   int val=0;
   int a[] = {1,1,3,1,3,3}; // {1,1,3,1,3,3} --> ans is 2
    val = a[0] ^ a[1];
   for(int i=1; i< a.length-1; i++){
//      System.out.println("a value: "+i);
      val = val ^ a[i+1];
      
      
   }
   System.out.println(val);
   }
}
