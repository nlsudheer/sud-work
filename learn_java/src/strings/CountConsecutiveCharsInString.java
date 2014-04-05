package strings;

import java.util.Collections;

/**
 * 
Example input string: BBSBSS 
output string: B2S1B1S2 

* ignore case . out put is always uppercase 
input : AaV 
output: A1V1
 * @author sudheerl
 *
 */

public class CountConsecutiveCharsInString {

   
   public static String altCount(String str) {
      String output = "";
      str = str.toUpperCase();
      
      for(int i = 0;i<str.length();i++) {
         int count = 1;
         output += str.charAt(i);
         while (i< str.length()-1 && str.charAt(i+1) == str.charAt(i)) {
            i++;
            count++;
         }
         output +=count;
      }
      return output;
   }
   
   public static void main(String args[]){
      Collections.emptyList();
      CountConsecutiveCharsInString cc = new CountConsecutiveCharsInString();
      String inStr = "BBACDDEE";
      
      System.out.println(cc.altCount(inStr));
      
      
    
   }
}
