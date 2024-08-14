/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 08/08/2024
 * Catalan Numbers 
 * https://leetcode.com/problems/unique-binary-search-trees/
 * Count Number of valleys and mountains hackerearth
 * Combinations of Balanced parantheses
 * Non Intersecting Chords in Circle = catalan (n/2)
 * Ways of Polygon Triangulation = catalan(n-2)
 * Dyck Words
 * Maze Paths above Diagonal = catalan(n-1)
 * @author parth
 */
public class CatalanNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.println(catalanNumber(4));
    }
    
    public static int catalanNumber(int num){
        int[] dp = new int[num+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i < dp.length;i++){
            
            for(int j = 0; j < i;j++){
                dp[i] = dp[i] + dp[j] * dp[i-j-1];
            }
        }
        return dp[num];
    }
}
