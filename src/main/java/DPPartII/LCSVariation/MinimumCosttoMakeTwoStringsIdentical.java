/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LCSVariation;

/**
 *Date: 09/05/2024
 *https://www.geeksforgeeks.org/minimum-cost-make-two-strings-identical/
 * @author parth
 */
public class MinimumCosttoMakeTwoStringsIdentical {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int lcs(String s1,String s2, int costX, int costY){
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        
        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = dp[i].length - 2; j >= 0; j--){
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                
                if(ch1 == ch2){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        
        int lcs = dp[0][0];
        
        int s1r = s1.length() - lcs;
        int s2r = s2.length() - lcs;
        
        int cost = (s1r * costX) + (s2r * costY);
        return  cost;
    }
}
