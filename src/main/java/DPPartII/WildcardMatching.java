/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 08/29/2024
 *https://leetcode.com/problems/wildcard-matching/
 * @author parth
 */
public class WildcardMatching {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        for(int i = dp.length - 1; i >= 0; i--){
            for(int j = dp[i].length - 1; j >= 0; j--){
                //Last Cell i.e. corner cell
                if(i == dp.length - 1 && j == dp[i].length - 1){
                    dp[i][j] = true;
                }
                else if(i == dp.length - 1){  //Last Row
                    dp[i][j] = false;

                }else if(j == dp[i].length - 1){ //Last Column
                    char ch = p.charAt(i);
                    if(ch == '*'){
                        dp[i][j] = dp[i+1][j];
                    }else{
                        dp[i][j] = false;
                    }

                }else{
                    char pc = p.charAt(i);
                    char sc = s.charAt(j);

                    if(pc == '?'){ //look at the diagonal
                        dp[i][j] = dp[i+1][j+1];
                    }else if(pc == '*'){
                        dp[i][j] = dp[i][j+1] || dp[i+1][j];
                    }else{
                        if(pc == sc){ //if the characters are same look at the diagonal
                            dp[i][j] = dp[i+1][j+1];
                        }else{ //its false becuase the characters are not same
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }

        return dp[0][0];
    }
}
