package learnjava;

/*
 * http://www.careercup.com/question?id=5358150211338240
 * 
 * if(str == null){
 return;
}
i =0;
j = str.length() -1;
while(i< j){
     swap(str.charAt(i), str.charAt(j));
      i++;
      j--;
}
 */

import org.testng.annotations.Test;


import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 27/9/13
 * Time: 6:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseString {


     @Test
    public void reversrString(){

        String original, reverse = "";
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a string to reverse");
        original = in.nextLine();

        int length = original.length();

        for(int i =length-1; i >= 0; i--){
            reverse += original.charAt(i);

        }
         System.out.println("Enter a string to reverse: " + reverse);
    }
}
