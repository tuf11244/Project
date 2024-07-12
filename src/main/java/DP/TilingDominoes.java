/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 07/11/2024
 *https://www.geeksforgeeks.org/tiling-problem/
 * https://www.geeksforgeeks.org/count-number-ways-tile-floor-size-n-x-m-using-1-x-m-size-tiles/
 * @author parth
 */
public class TilingDominoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int answer = tilingDominoes( 4,4);
        System.out.println(answer);
    }
    
    
    //https://www.geeksforgeeks.org/tiling-problem/
    public static int tilingDominoes(int n){
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3;i <= n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
    
    //https://www.geeksforgeeks.org/count-number-ways-tile-floor-size-n-x-m-using-1-x-m-size-tiles/
    public static int tilingDominoes(int m, int n){
        int[] dp = new int[n+1];
        
        for(int i = 1; i <= n;i++){
            if(i < m){
                dp[i] = 1;
            }else if(i == m){
                dp[i] = 2;
            }else{
                dp[i] = dp[i-1] + dp[i-m];
            }
        }
        return dp[n];
    }
    
}
