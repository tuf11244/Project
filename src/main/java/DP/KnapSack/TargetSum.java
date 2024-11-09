/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP.KnapSack;

/**
 *Date: 11/08/2024
 * https://leetcode.com/problems/target-sum/
 * @author parth
 */
public class TargetSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int findTargetSumWays(int[] arr, int difference) {
        int sum = 0;
        
        for(int num : arr){
            sum += num;
        }

        // If (sum + difference) is odd or less than 0, return 0 as there's no valid subset
        if((sum + difference) % 2 != 0 || sum + difference < 0) {
            return 0;
        }

        int target = (sum + difference) / 2;
        
        return helper(arr, target);
    }

    public static int helper(int[] arr, int target) {
        int[][] dp = new int[arr.length + 1][target + 1];
        
        // Base case: dp[i][0] = 1 for all i, as there is one way to form sum 0 (empty subset)
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the DP table
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j <= target; j++) {
                int value = arr[i - 1];
                
                // If the current element can be part of the subset
                if (j >= value) {
                    dp[i][j] = dp[i - 1][j - value] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[arr.length][target];
    }
}
