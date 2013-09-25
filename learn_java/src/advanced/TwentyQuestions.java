package advanced;

/**
* http://introcs.cs.princeton.edu/java/42sort/TwentyQuestions.java.html
* Created with IntelliJ IDEA.
* User: sudheern
* Date: 24/9/13
* Time: 4:59 PM
* To change this template use File | Settings | File Templates.
*/


import org.testng.annotations.Test;

import java.util.Scanner;

/*************************************************************************
*  Compilation:  javac TwentyQuestions.java
*  Execution:    java TwentyQuestions n
*  Dependencies  StdIn.java
*
*  This code uses binary search to play the game of twenty questions.
*  It takes a command-line argument n, asks you to think of a number
*  between 0 and N-1, where N = 2^n, and always guesses the answer
*  with n questions.
*
*  %  java TwentyQuestions 7
*  Think of an integer between 0 and 127
*  Is it less than 64?  false
*  Is it less than 96?  true
*  Is it less than 80?  true
*  Is it less than 72?  false
*  Is it less than 76?  false
*  Is it less than 78?  true
*  Is it less than 77?  false
*  Your number is 77
*
*************************************************************************/
   @Test(groups="pending")
public class TwentyQuestions {

    // invariant: answer is in [lo, hi)
    public static int search(int lo, int hi) {
        if ((hi - lo) == 1) return lo;
        int mid = lo + (hi - lo) / 2;
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

//        System.out.printf("Your number is %d: ", str );
        System.out.printf("Is it less than %d?  ", mid);

        String enteredStr = scan.nextLine();


        if (!enteredStr.isEmpty()) return search(lo, mid);
        else                     return search(mid, hi);
    }

    public static void main(String[] args) {
//        int n = Integer.parseInt(args[0]);
        int n = 7;
        int N = (int) Math.pow(2, n);
        System.out.printf("Think of an integer between %d and %d", 0, N-1);
        int v = search(0, N);
        System.out.printf("Your number is %d\n", v);
    }

}

