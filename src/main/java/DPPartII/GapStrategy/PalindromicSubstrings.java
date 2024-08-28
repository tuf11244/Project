/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;

/**
 *Date : 08/27/2024
 *https://leetcode.com/problems/palindromic-substrings/
 * @author parth
 */
public class PalindromicSubstrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
   
    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count =0;
        for(int g =0; g < dp.length;g++){
            for(int i = 0,j = g; j < dp.length;i++,j++){
                if(g == 0){
                    dp[i][j] = true;
                    count++;
                }else if(g == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                        count++;
                    }else{
                        dp[i][j] = false;
                    }

                }else{
                    if(s.charAt(i) == s.charAt(j)){
                         if(dp[i+1][j-1] == true){
                            dp[i][j] = true;
                            count++;
                         }else{
                            dp[i][j] = false;
                         }
                    }else{
                        dp[i][j] = false;
                    }

                }
            }
        }
        return count;
    }
}

