/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 07/21/2024
 * https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
 * @author parth
 */
public class FindValidMatrixGivenRowandColumnSums {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;

        int[][] result = new int[rows][cols];

        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                int value = Math.min(rowSum[row], colSum[col]);
                result[row][col] = value;

                rowSum[row] -= value;
                colSum[col] -= value;
            }
        }

        return result;
    }
}
