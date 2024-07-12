/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;
import java.util.*;
/**
 *https://www.geeksforgeeks.org/friends-pairing-problem/
 * @author parth
 */
public class FriendsPairing {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int ans = waysofPairing(19);
        System.out.println(ans);
    }
    
    
    public static int waysofPairing(int n){
        if(n ==0 || n == 1|| n == 2){
            return n;
        }
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n;i++){
            dp[i] = dp[i-1] + (i-1) * dp[i-2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
