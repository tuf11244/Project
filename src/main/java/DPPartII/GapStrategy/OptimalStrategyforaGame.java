/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;

/**
 *Date: 09/10/2024
 * https://www.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/
 * @author parth
 */
public class OptimalStrategyforaGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] arr = {5, 3, 7, 10};
        System.out.println(maximumAmount(arr));
    }
    
    public static int maximumAmount(int[] arr){
        
        int[][] dp = new int[arr.length][arr.length];
        
        for(int g = 0; g < dp.length;g++){
            for(int i = 0, j = g; j < dp.length;i++,j++){
                if(g == 0){
                  dp[i][j] = arr[i];  
                }else if(g == 1){
                   dp[i][j] = Math.max(arr[i],arr[j]);
                }else{
                    int option1 = arr[i] + Math.min(dp[i+2][j],dp[i+1][j-1]);
                    /*
                    for option1
                    I took the coin at i, so the opponent gets to choose from i+1 till j;
                    if opponent choose i+1 -- than I get i+2 till j
                    if opponent choose j -- than I get i+1 till j-1;
                    */
                    int option2 = arr[j] + Math.min(dp[i][j-2],dp[i+1][j-1]);
                    /*
                    for option2
                    I took the coin at j, so the opponent gets to choose from i till j-1;
                    if opponent choose i -- than I get i+1 till j-1
                    if opponent choose j-1 -- than I get i till j-2;
                    */
                    dp[i][j] = Math.max(option1,option2);
                }
            }
        }
        return dp[0][dp.length - 1];
    }
}
