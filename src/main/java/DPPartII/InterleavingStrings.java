/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 10/22/2024
 * https://leetcode.com/problems/interleaving-string/
 * @author parth
 */
public class InterleavingStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    
    //Recursion + Memoization
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return helper(s1,s2,s3,0,0, dp);
    }

    public boolean helper(String s1, String s2, String s3, int i, int j, Boolean[][] dp){
        if(i == s1.length() && j == s2.length()){
            return true;
        }
    
        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j)){
            boolean f1 = helper(s1,s2,s3,i+1,j,dp);
            dp[i][j] = f1;

            if(f1 == true){
                return true;
            }
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j)){
            boolean f2 = helper(s1,s2,s3,i,j+1,dp);

            dp[i][j] = f2;

            if(f2 == true){
                return true;
            }
        }

        dp[i][j] = false;

        return false;
    }
    
    
    //Tabulation
    public boolean isInterleaveTabulations(String s1, String s2, String s3){
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        
        
        
        for(int i = 0; i < dp.length;i++){
            for(int j = 0; j < dp[0].length;j++){
                
                if(i == 0 && j == 0){
                    dp[i][j] = false;
                }
                else if(i == 0){
                    if(s2.charAt(j-1) == s3.charAt(i+j-1)){
                        dp[i][j] = dp[i][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                    
                }else if(j == 0){
                    if(s1.charAt(i-1) == s3.charAt(i+j-1)){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                     //compare the last characters
                    if(s1.charAt(i-1) == s3.charAt(i+j-1)){
                        dp[i][j] = dp[i-1][j];
                    }
                    
                    if(!dp[i][j] && s2.charAt(j-1) == s3.charAt(i+j-1)){
                        dp[i][j] = dp[i][j-1];
                    }
                    
                 }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
