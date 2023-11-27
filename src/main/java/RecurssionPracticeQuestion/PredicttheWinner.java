/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 *https://leetcode.com/problems/predict-the-winner/
 * Date: 11/25/2023
 * @author parth
 */
public class PredicttheWinner {

   
    public static void main(String args[]) {
        int[] nums = {1,5,233,7};
        System.out.println(Winner(nums));
    }
    public static boolean Winner(int[] nums){
        
        if(nums.length == 0 || nums.length == 1){
            return true;
        }
      int[][] dp = new int[nums.length][nums.length];
      
      int sum = 0;
      for(int gap = 0; gap < dp.length;gap++){
          for(int i = 0, j = gap; j < dp.length;i++,j++){
              if(gap == 0){
                dp[i][j] = nums[i];  
                sum = sum + nums[i];
              }
              else if(gap == 1){
                  dp[i][j] = Math.max(nums[i], nums[j]);
              }else{
                  int val1 = nums[i] + Math.min(dp[i+2][j],dp[i+1][j-1]);
                  int val2 = nums[j] + Math.min(dp[i+1][j-1], dp[i][j-2]);
                  int val = Math.max(val1, val2);
                  dp[i][j] = val;
              }
          }
      }
       int rest = sum - dp[0][nums.length-1];

        if (rest > dp[0][nums.length-1]) {
            return false;
        }
        return true; 
    }
  
}
