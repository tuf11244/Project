/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;

/**
 *Date: 08/15/2024
 *https://leetcode.com/problems/burst-balloons/
 * @author parth
 */
public class BurstBallons {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static  int maxCoins(int[] nums) {
        
        int[][] dp = new int[nums.length][nums.length];
        
        for(int g = 0; g < nums.length;g++){   // g is the gap between i and j
            for(int i = 0,j = g; j < nums.length;i++,j++){  // i is the start index, j is the end index

                   int max = Integer.MIN_VALUE;
                for(int k = i; k <= j;k++){ // k is the index of the last balloon to burst in the range [i, j]
                    int left = (k == i) ? 0 : dp[i][k-1]; // Coins from the left side subarray
                    int right = (k == j) ? 0 : dp[k+1][j]; // Coins from the right side subarray
                    int val = (i == 0 ? 1 : nums[i-1]) * nums[k] * (j == nums.length - 1 ? 1 : nums[j+1]);
                    
                    int total = left + right + val;
                    
                    max = Math.max(total, max); // Maximize the result for dp[i][j]
                    
                }
                
                dp[i][j] = max;
            }
        }
        
        return dp[0][dp.length-1]; // Final answer is the max coins for bursting all balloons
    }
}
