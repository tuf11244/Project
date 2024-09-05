/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LCS;

/**
 *Date: 09/04/2024
 *https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings
 * @author parth
 */
public class MinimumASCIIDeleteSumforTwoStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int minimumDeleteSum(String s1, String s2) {
       int[][] dp = new int[s1.length() + 1][s2.length() + 1];
       
       for(int i = dp.length - 1; i >= 0; i--){
           for(int j = dp[i].length - 1; j >= 0; j--){
               if(i == dp.length -1 && j == dp[i].length - 1){
                   dp[i][j] = 0; //last corner cell 
               }else if(i == dp.length - 1){ //last row
                   dp[i][j] = (int)s2.charAt(j) + dp[i][j+1];
               }else if(j == dp[i].length - 1){ //last column
                   dp[i][j] = (int)s1.charAt(i) + dp[i+1][j];
               }else{
                   char ch1 = s1.charAt(i);
                   char ch2 = s2.charAt(j);
                   
                   if(ch1 == ch2){
                       dp[i][j] = dp[i+1][j+1];
                   }else{
                       int option1 = s2.charAt(j) + dp[i][j+1];
                       int option2 = s1.charAt(i) + dp[i+1][j];
                       dp[i][j] = Math.min(option1,option2);
                   }
                  
               }
           }
       }
        return dp[0][0];
        
    }
}
