package learnjava;

import java.util.Scanner;

/**
 * In Floyd triangle there are n integers in the nth row and a total of (n(n+1))/2 integers in n rows.
 * This is a simple pattern to print but helpful in learning how to create other patterns.
 * Key to develop pattern is using nested loops appropriately.
 */
class FloydTriangle {
    public static void main(String args[]) {
        int n, num = 1, c, d;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of rows of floyd's triangle you want");
        n = in.nextInt();

        System.out.println("Floyd's triangle :-");

        for (c = 1; c <= n; c++) {
            for (d = 1; d <= c; d++) {
                System.out.print(num + " ");
                num++;
            }

            System.out.println();
        }
    }
}