/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LCSVariation;

/**
 *Date: 09/25/2024
 *https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 * Same code as longest common substring
 * @author parth
 */
public class MaximumLengthofRepeatedSubarray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int findLength(int[] nums1, int[] nums2) {
        
        int[][] dp = new int[nums2.length + 1][nums1.length + 1];
        int maxLength = 0;
        for(int i = 1; i < dp.length;i++){
            for(int j =1; j < dp[0].length;j++){
                    int n1 = nums2[i-1];
                    int n2 = nums1[j-1];
                    if(n1 == n2){
                        dp[i][j] =  1 + dp[i-1][j-1];
                        maxLength = Math.max(maxLength,dp[i][j]);
                    }
                    
                }
            }
        return maxLength;
    }
}
