/**
 * From JetBrains Academy
 * 
 * Given the number n, not exceeding 10, and a matrix of size n × n.
 * 
 * Check whether this matrix is symmetric in relation to the main diagonal.
 * Output the word “YES”, if it is symmetric and the word “NO” otherwise.
 * 
 * Keep in mind that the main diagonal runs from the top left corner
 * to the bottom right corner.
 * 
 * Sample input ...
 * 3
 * 0 1 2
 * 1 2 3
 * 2 3 4
 * 
 * Output 
 * YES
 * 
 * From Wikipedia... 
 * "In linear algebra, a symmetric matrix is a square matrix
 * that is equal to its transpose."
 */

import java.util.Scanner;

public class SymmetricArray {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(isSymmetric(matrix)? "YES" : "NO");
        sc.close();
    }

    static boolean isSymmetric(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}