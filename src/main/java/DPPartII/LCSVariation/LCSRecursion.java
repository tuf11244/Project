/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LCSVariation;
import java.util.*;
/**
 *Date: 11/15/2024
 * @author parth
 */
public class LCSRecursion {

    /**
     * @param args the command line arguments
     */
    
    public static int[][] dp;
    public static void main(String args[]) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first String ");
        String s1 = scanner.nextLine();
        System.out.println("Enter the second String ");
        String s2 = scanner.nextLine();
        
        dp = new int[s1.length() + 1][s2.length() +1];
        
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        
        int answer = lcs(s1,s2,s1.length() - 1, s2.length() - 1);
        
        System.out.println(answer);
    }
    
    public static int lcs(String s1, String s2, int i, int j){
        if(i < 0 || j< 0){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1 + lcs(s1,s2,i-1,j-1);
            return dp[i][j];
        }
        
        int option1 = lcs(s1,s2,i,j-1);
        int option2 = lcs(s1,s2,i-1,j);
        
        dp[i][j] = Math.max(option1, option2);
        
        return dp[i][j];
    }
}
