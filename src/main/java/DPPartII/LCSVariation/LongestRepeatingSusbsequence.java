/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LCSVariation;

/**
 *
 * @author parth
 */
public class LongestRepeatingSusbsequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.println(longestRepeatingSubsequence("abacbc"));
    }
    
    public static int longestRepeatingSubsequence(String s){
        //We are taking LCS of the String with itself 
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        
        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = dp[0].length - 2; j >= 0;j--){
                
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                
                if(ch1 == ch2){
                    if(i!= j){
                        dp[i][j] = 1 + dp[i+1][j+1];
                    }else{
                       dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                    }
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
