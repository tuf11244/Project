/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LCSVariation;
import java.util.*;
/**
 *Date:11/15/2024
 * @author parth
 */
public class PrintAllLCS {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        String s1 = "acbcf";
        String s2 = "abcdaf";
        
        printAllLCS(s1,s2);
    }
    
    public static void printAllLCS(String s1, String s2){
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        
        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = dp[0].length - 2; j >= 0;j--){
                 
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                
                if(ch1 == ch2){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            
            }
        }
        
        // Use a set to avoid duplicates
    Set<String> result = new HashSet<>();
    Queue<Pair> queue = new LinkedList<>();

    // Add the initial state
    queue.add(new Pair(0, 0, ""));

    while (!queue.isEmpty()) {
        Pair rem = queue.poll();

        // If we've reached the end of one of the strings
        if (rem.i == s1.length() || rem.j == s2.length()) {
            result.add(rem.psf); // Add to set to avoid duplicates
            continue;
        }

        // If characters match
        if (s1.charAt(rem.i) == s2.charAt(rem.j)) {
            queue.add(new Pair(rem.i + 1, rem.j + 1, rem.psf + s1.charAt(rem.i)));
        } else {
            // If the values in the DP table are equal, explore both paths
            if (dp[rem.i + 1][rem.j] >= dp[rem.i][rem.j + 1]) {
                queue.add(new Pair(rem.i + 1, rem.j, rem.psf));
            }
            if (dp[rem.i + 1][rem.j] <= dp[rem.i][rem.j + 1]) {
                queue.add(new Pair(rem.i, rem.j + 1, rem.psf));
            }
        }
    }

    // Print all unique LCSs
    for (String lcs : result) {
        System.out.println(lcs);
    }
        
        
    }
}

class Pair{
    int i;
    int j;
    String psf;
    
    public Pair(int i, int j, String psf){
        this.i = i;
        this.j = j;
        this.psf = psf;
    }
    
}
