/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;

/**
 *Date: 08/16/2024
 *https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
 * @author parth
 */
public class MinimumScoreofPolygonTriangulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length][values.length];
        
        for(int g = 0; g < dp.length;g++){
            for(int i = 0, j = g; j < dp.length;i++,j++){
                if(g == 0){  //only one point
                    dp[i][j] = 0;
                }else if(g == 1){ //only 2 points 
                     dp[i][j] = 0;
                }else if(g == 2){ // 3 points
                    dp[i][j] = values[i] * values[i+1] * values[j];
                }else{
                    int min = Integer.MAX_VALUE;
                    for(int k = i+1; k < j;k++){
                        int cutTriangle = values[i] * values[k] * values[j];
                        int leftPart = dp[i][k];
                        int rightPart = dp[k][j];
                        
                        int total = cutTriangle + leftPart + rightPart;
                        min = Math.min(total,min);
                    }
                    dp[i][j] = min;
                }
        }
    }
        return dp[0][dp.length - 1];
    }
}
