/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 10/25/2024
 *https://leetcode.com/problems/delete-and-earn/
 * Same code and logic as house robber problem
 * @author parth
 */
public class DeleteandEarn {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int deleteAndEarn(int[] nums) {

      int[] dp = new int[10001];
      
      
      //Frequency Map
      for(int val : nums){
        dp[val] = dp[val] + 1;
      }

      int include = dp[0];
      int exclude = 0;
      
      for(int i = 1; i < dp.length;i++){
        int newInclude = exclude + (dp[i] * i);
        int newExclude = Math.max(include,exclude);

        include = newInclude;
        exclude = newExclude;
      }

      return Math.max(include,exclude);
    }
}
