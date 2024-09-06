/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LCSVariation;

/**
 *Date: 09/03/2024
 *https://leetcode.com/problems/edit-distance/
 * @author parth
 */
public class EditDistance {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        for(int i = 0; i < dp.length;i++){
            for(int j = 0; j < dp[i].length;j++){
                
                if(i == 0 && j == 0){
                    dp[i][j] = 0;
                }else if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else{
                    char ch1 = word1.charAt(i-1);
                    char ch2 = word2.charAt(j-1);
                    
                    if(ch1 == ch2){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j])) + 1;
                    }
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
