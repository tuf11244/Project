/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 08/19/2024
 * https://leetcode.com/problems/stone-game-ii/
 * @author parth
 */
public class StoneGameII {
      public static int n;
      public static int[][][] dp;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[2][101][101];
        
        for(int[][] arr2D : dp){
            for(int[] arr1D : arr2D){
            
            Arrays.fill(arr1D, -1);
                    
        }
    }
        
        return solveForAlice(1,piles,0,1);
    }
    
    public static int solveForAlice(int person, int[] piles, int index, int M){
        if(index >= n){
            return 0;
        }
        if(dp[person][index][M] != -1){
            return dp[person][index][M];
        }
        int result = person == 1 ? -1 : Integer.MAX_VALUE;
        int stones = 0;
        for(int x = 1; x <= Math.min(2 * M, n-index);x++){
            
            stones = stones + piles[index + x - 1];
            
            if(person == 1){ //Alice Turn
                result = Math.max(result, stones + solveForAlice(0,piles,index + x,Math.max(x,M)));
            }else{
                result = Math.min(result,solveForAlice(1,piles,index+x,Math.max(x,M)));
            }
        }
        
        dp[person][index][M] = result;
        
        return result;
    }
}
