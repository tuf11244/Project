/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 08/06/2024
 *https://leetcode.com/problems/longest-increasing-subsequence/
 * @author parth
 */
public class LongestIncreasingSubsequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    //Time Complexity = 0(N^2);
    public static int lengthofLIS(int[] nums){
        
        int[] dp = new int[nums.length];
        int answer = 0;
        for(int i = 0; i < dp.length;i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                   max = Math.max(dp[j], max);                    
            }
            }
            dp[i] = max + 1;
            answer = Math.max(answer,dp[i]);
        
    }
      return answer;  
    }
}
