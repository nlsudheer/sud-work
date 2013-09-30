package learnjava.matrix;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://www.programmingsimplified.com/java/source-code/java-program-multiply-two-matrices
 *
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 30/9/13
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class MatrixMultiplication {


    @Test
    public void matrixMultiplication() {
        int m, n, p, q, sum = 0, c, d, k;
        m = 2;
        n = 3;
        p = 3;
        q = 2;
//        int first[][] = new int[m][n];
//        int second[][] = new int[p][q];

        int first[][] = {{1, 3, 4}, {2, 3, 5}};
        int second[][] = {{2, 3}, {2, 1}, {5, 7}};

        if (n != p) {
            System.out.println("Matrices with entered orders can't be multiplied with each other.");
        } else {
            int multiply[][] = new int[m][q];

            for (c = 0; c < m; c++) {
                for (d = 0; d < q; d++) {
                    for (k = 0; k < p; k++) {
                        sum = sum + first[c][k] * second[k][d];
                    }

                    multiply[c][d] = sum;
                    sum = 0;
                }

            }
            System.out.println("Product of entered matrices:-" + Arrays.deepToString(multiply));
        }
    }

    @Test
    public void matrixMultiplicationEnterData() {
        int m, n, p, q, sum = 0, c, d, k;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns of first matrix");
        m = scan.nextInt();
        n = scan.nextInt();

        System.out.println("Enter the number of rows and columns of second matrix");
        p = scan.nextInt();
        q = scan.nextInt();


        int first[][] = new int[m][n];
        int second[][] = new int[p][q];

        System.out.println("Enter first matrix data ");
        for (c = 0; c < m; c++) {
            for (d = 0; d < n; d++) {
                first[c][d] = scan.nextInt();
            }
        }

        System.out.println("Enter first matrix data ");
        for (c = 0; c < p; c++) {
            for (d = 0; d < q; d++) {
                second[c][d] = scan.nextInt();
            }
        }


        if (n != p) {
            System.out.println("Matrices with entered orders can't be multiplied with each other.");
        } else {
            int multiply[][] = new int[m][q];

            for (c = 0; c < m; c++) {
                for (d = 0; d < q; d++) {
                    for (k = 0; k < p; k++) {
                        sum = sum + first[c][k] * second[k][d];
                    }

                    multiply[c][d] = sum;
                    sum = 0;
                }

            }
            System.out.println("Product of entered matrices:-" + Arrays.deepToString(multiply));
        }
    }
}
