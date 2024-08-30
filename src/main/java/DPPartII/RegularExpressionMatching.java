/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *https://leetcode.com/problems/regular-expression-matching/description/
 * Date: 01/10/2024
 * @author parth
 */
public class RegularExpressionMatching {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static boolean isMatch(String s, String p){
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        
        for(int i = 0; i < dp.length;i++){
            for(int j = 0; j < dp[0].length;j++){
                //First cell or the top left most corner
                if(i == 0 && j == 0){ //Empty character
                   dp[i][j] = true; 
                }else if(i == 0){ //Empty character cannot satisfy any characters in the String 
                    dp[i][j] = false;
                }else if(j == 0){
                   //pc == pattter character 
                   // i -1 because our matrix is set back by 1 
                    char pc = p.charAt(i-1);
                    
                    if(pc == '*'){
                        //GO two rows back
                      dp[i][j] = dp[i-2][j];  
                    }else{
                        dp[i][j] = false;
                    }
                                       
                }else{
                    //i-1 && j-1 because our matrix is set back by 1 
                    char pc = p.charAt(i-1);
                    char sc = s.charAt(j-1);
                    
                    if(pc == '*'){
                        dp[i][j] = dp[i-2][j];
                        
                        //pattern 2nd last character
                        char pslc = p.charAt(i-2);
                         if(pslc == '.' || pslc == sc){
                             dp[i][j] = dp[i][j] || dp[i][j-1];
                         }
                    }else if (pc == '.'){
                        dp[i][j] = dp[i-1][j-1];
                    }else if(pc == sc){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
