/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LCS;

/**
 *Date: 09/03/2024
 * https://www.geeksforgeeks.org/longest-common-substring-dp-29/
 * @author parth
 */
public class LongestCommonSubstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        longestCommonSubstring("pqabcxy","xyabcp");
    }
    
    public static void longestCommonSubstring(String s1, String s2){
        int[][] dp = new int[s1.length() +1][s2.length() + 1];
        int max = 0;
        //0th row would be 0 because of blank
        //0th col would be 0 becuase of blank
        for(int i = 1; i < dp.length;i++){
            for(int j = 1; j < dp[0].length;j++){
                char ch1 = s1.charAt(i-1);
                char ch2 = s2.charAt(j-1);
                
                if(ch1 == ch2){
                    dp[i][j] = 1 + dp[i-1][j-1]; //look at diagonal above
                }else{
                    dp[i][j] = 0;
                }
                max = Math.max(dp[i][j] , max);
            }
        }
        
        System.out.println("The length of the longest common substring is " + max);
    }
}
