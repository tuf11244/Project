/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 11/23/2024
 * https://leetcode.com/problems/maximum-matrix-sum/
 * @author parth
 */
public class MaximumMatrixSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public long maxMatrixSum(int[][] matrix) {
        long absSum = 0; // Sum of absolute values
        int negCount = 0; // Count of negative numbers
        int minAbsValue = Integer.MAX_VALUE; // Minimum absolute value

        // Step 1: Traverse the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[i][j];
                absSum += Math.abs(value); // Add absolute value to sum
                minAbsValue = Math.min(minAbsValue, Math.abs(value)); // Track smallest absolute value
                if (value < 0) {
                    negCount++; // Count negatives
                }
            }
        }

        // Step 2: Check negCount parity
        if (negCount % 2 == 0) {
            return absSum; // All negatives can be flipped
        } else {
            return absSum - 2 * minAbsValue; // One smallest absolute value remains unflipped
        }
    }
}
