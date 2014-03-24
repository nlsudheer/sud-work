package advanced;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/*
 * http://www.careercup.com/question?id=5617192120877056
 * 
 * 5! = 5 * 4 * 3 * 2 * 1 = 120 (it contains 1 zero). 
How many zeroes will be contained in 100! then. 
Explain with logic.

public int countTrailingZerosOfFactorial(int n) {
    int count = 0;
    for (int powerOfFive = 5; n / powerOfFive > 0; powerOfFive *= 5) {
        count += n / powerOfFive;
    }
    return count;
}
 */


public class ZerosInFactorialValue {
   
   public int countTrailingZerosOfFactorial(int n) {
      int count = 0;
      for (int powerOfFive = 5; n / powerOfFive > 0; powerOfFive *= 5) {
          count += n / powerOfFive;
      }
      return count;
  }
   
   public static void main(String []args){
      
      List li = new LinkedList();
      
      List li1 = new ArrayList();
      
      ZerosInFactorialValue zfv = new ZerosInFactorialValue();
      int n = 100;
      System.out.println("No.of Zeros in factorial "+ n + "is "+ zfv.countTrailingZerosOfFactorial(n));
      
      
      
   }

}
