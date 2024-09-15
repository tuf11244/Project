/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.Kadane;

/**
 *Date: 09/05/2024
 * https://leetcode.com/problems/k-concatenation-maximum-sum/
 * @author parth
 */
public class KConcatenationMaximumSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    private static final int MOD = 1000000007;

    public int kConcatenationMaxSum(int[] arr, int k) {
        int totalSum = 0;
        int maxSumSingleArray = kadane(arr);
        
        // Calculate the total sum of the array
        for (int num : arr) {
            totalSum = (totalSum + num) % MOD;
        }

        // If k == 1, return the result of Kadane's on a single array
        if (k == 1) {
            return Math.max(maxSumSingleArray, 0);  // Return maxSum or 0 if it's negative
        }

        // Create a new array with two copies of arr
        int[] copyArr = new int[2 * arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
            copyArr[i + arr.length] = arr[i];
        }

        // Kadane's algorithm on the two concatenated arrays
        int maxSumTwoConcat = kadane(copyArr);

        // If totalSum is negative or zero, return max result from two concatenations
        if (totalSum <= 0) {
            return Math.max(maxSumTwoConcat, 0);
        }

        // If totalSum is positive and k >= 2, compute the maximum sum
        // maxSum = max sum of two concatenations + (k - 2) * totalSum
        long result = (long) maxSumTwoConcat + (long) (k - 2) * totalSum;
        return (int) (Math.max(result % MOD, 0));  // Return result % MOD
    }

    // Kadane's algorithm for max subarray sum
    private int kadane(int[] arr) {
        int currentSum = 0;
        int maxSum = 0;

        for (int num : arr) {
            currentSum = Math.max(currentSum + num, num);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
