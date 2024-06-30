/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;
import java.util.*;
/**
 *Date: 06/29/2024
 * https://leetcode.com/problems/coin-change-ii/
 * https://leetcode.com/problems/combination-sum-iv/
 * https://leetcode.com/problems/coin-change/
 * @author parth
 */
public class CoinChange {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    //Coin change Combination 
    //https://leetcode.com/problems/coin-change-ii/
    public static int change(int amount, int[] coins) {
        
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 0; i < coins.length;i++){
            for(int j = coins[i]; j < dp.length;j++){
                dp[j] = dp[j] + dp[j- coins[i]];
            }
        }
        return dp[amount];
        
    }
    
    //Coin Change Permuation 
    //https://leetcode.com/problems/combination-sum-iv/
    public static int changePermuations(int amount, int[] coins){
        
        int[] dp = new int[amount+1];
        dp[0] = 1;
        
        for(int amt = 1; amt <= amount;amt++){
            for(int coin : coins){
                if(coin <= amt){
                    int remainingAmt = amt - coin;
                    dp[amt] = dp[amt] + dp[remainingAmt];
                }
            }
        }
        return dp[amount];
            
    }
    
    //Minimum number of coins 
    //https://leetcode.com/problems/coin-change/
    public int coinChange(int[] coins, int amount) {
         // Initialize dp array with a value larger than the maximum possible result
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        
        // Fill the dp array
        for (int amt = 1; amt <= amount; amt++) {
            for (int coin : coins) {
                if (coin <= amt) {
                    int remainingAmt = amt - coin;
                    dp[amt] = Math.min(dp[amt], dp[remainingAmt] + 1);
                }
            }
        }
        
        // If dp[amount] is still max, it means amount can't be formed with given coins
        return dp[amount] == max ? -1 : dp[amount];
    }
}
