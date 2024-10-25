/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;
import java.util.*;
/**
 *
 * @author parth
 */
public class MinimumCosttoCutaStick {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int minCost(int n, int[] cuts){
        int [] allCuts = new int[cuts.length+2];
        
        allCuts[0] = 0; //we add the boundary cases 
        allCuts[cuts.length + 1] = n; //we add the boundary cases 
        
        for(int i = 1; i < allCuts.length - 1;i++){
            allCuts[i] = cuts[i-1];
        }
        
        Arrays.sort(allCuts);
        int[][] dp = new int[allCuts.length][allCuts.length];
        
        for(int g = 0; g < dp.length;g++){
            for(int i = 0, j = g; j < dp.length;i++,j++){
                
                int min = Integer.MAX_VALUE;
                
                for(int k = i+1; k < j;k++){
                    int cost = allCuts[j] - allCuts[i];
                    int left = dp[i][k];
                    int right = dp[k][j];
                    
                    min = Math.min(min, cost + left + right);
                }
                
                dp[i][j] = min == Integer.MAX_VALUE ? 0 : min;
            }
        }
        
        return dp[0][dp.length -1];
    }
}
