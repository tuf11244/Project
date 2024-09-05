/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 09/04/2024
 * https://leetcode.com/problems/scramble-string/
 * @author parth
 */
public class ScrambleString {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    //Recursion + Memoization
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
       return helper(s1,s2,0,0,n, new Boolean[n][n][n+1]); 
    }

    public boolean helper(String s1, String s2, int i, int j, int length,Boolean[][][] dp){
        //i == starting index of s1
        //j == starting index of s2
        if(s1.substring(i,i+ length).equals(s2.substring(j,j+length))){
            return true;
        }

        if(dp[i][j][length] != null){
            return dp[i][j][length];
        }
        
        for(int k = 1; k < length;k++){
            
            // No swap case and swap case
            if(helper(s1,s2,i,j,k,dp) && helper(s1,s2,i+k,j+k,length-k,dp) || 
            helper(s1,s2,i,j + length-k,k,dp) && helper(s1,s2,i+k,j,length-k,dp)){

                dp[i][j][length] = true;
                return true;
            }
        }
         dp[i][j][length] = false; //Memoize result if no valid partition is found
        return false;
    }
}
