package learnjava.matrix;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: sudheern
 * Date: 27/9/13
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransposeAMatrix {

    @Test
    public void transposeAMatrix() {

        int c, d, m, n;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows of matrix");
        m = scan.nextInt();
        System.out.println("Enter the number of columns of matrix");
        n = scan.nextInt();

        int matrix[][] = new int[m][n];
//        m = 2;
//        n = 3;
//        int matrix[][] = {{1,2,4}, {3,4,1}};
        int transposeMatrix[][] = new int[n][m];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter the elements of matrix " + i + j);
                matrix[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }

        //print multi dimension array
        System.out.println("matrix" + Arrays.deepToString(matrix));
        System.out.println("transposeMatrix" + Arrays.deepToString(transposeMatrix));

    }
}





