/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 10/09/2024
 * https://leetcode.com/problems/arithmetic-slices/
 * @author parth
 */
public class ArithmeticSlices {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        int[] dp = new int[nums.length];
        int count = 0;
        for(int i = 2; i < dp.length;i++){
          
          if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
            dp[i] = dp[i-1] + 1;
            count = count + dp[i];
          }
        }

        return count;
    }
}
