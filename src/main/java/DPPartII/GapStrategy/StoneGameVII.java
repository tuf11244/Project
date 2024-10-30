/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;

/**
 *Date: 10/28/2024
 *https://leetcode.com/problems/stone-game-vii/
 * @author parth
 */
public class StoneGameVII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int stoneGameVII(int[] stones) {
        
        //gap strategy;
        int[][] dp = new int[stones.length][stones.length];

         // Calculate cumulative prefix sum
        int[] prefixSum = new int[stones.length + 1];
        for (int i = 0; i < stones.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + stones[i];
        }


        for(int g = 0; g < dp.length;g++){
            for(int i = 0, j = g; j < dp.length;i++,j++){
                if(g == 0){
                    dp[i][j] = 0;
                }else if(g == 1){
                    dp[i][j] = Math.max(stones[i],stones[j]);
                }else{
                    
                int sumWhenRemovingLeft = prefixSum[j + 1] - prefixSum[i + 1];  // Sum excluding stones[i]
                int sumWhenRemovingRight = prefixSum[j] - prefixSum[i];  // Sum excluding stones[j]
                
                int option1 = sumWhenRemovingLeft - dp[i + 1][j];
                int option2 = sumWhenRemovingRight - dp[i][j-1];
                    dp[i][j] = Math.max(option1,option2);
                }
            }
        }

        
        return dp[0][dp.length-1];
    }
    
}
