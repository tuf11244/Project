/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 06/27/2024
 * https://leetcode.com/problems/climbing-stairs/
 * @author parth
 */
public class ClimbingStairs {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int countPathsMemo(int n, int[] memo){
        if(n == 0){
        return 1;
       }else if(n < 0){
        return 0;
       }

       if(memo[n] != 0){
        return memo[n];
       }

       int onestep = countPathsMemo(n-1,memo);
       int twostep = countPathsMemo(n-2,memo);
       int countPaths = onestep + twostep;

       memo[n] = countPaths;

       return countPaths;
    }
    
    public static int countPathsTabulation(int n){
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        
        for(int i = 1; i <= n;i++){
            if(i == 1){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
    
    //Climb Stairs with variable jumps 
    public static int variableJumps(int n, int[] jumps){
        int[] dp = new int[n+1];
        
        dp[n] = 1;
        for(int i = n - 1; i >= 0; i--){
            for(int j = 1; j <= jumps[i] && i + j < dp.length; j++){
                dp[i] = dp[i] + dp[i+j];
            }
        }
        return dp[0];
        
    }
}
