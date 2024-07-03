/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 07/02/2024
 * https://www.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1
 * @author parth
 */
public class BinaryStringswithConsescutiveOs {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    //Count of binary Strings with consecutive 0's not allowed
        public static int countBinaryStrings(int n) {
        int old0s = 1;  // Number of binary strings of length 1 ending in 0
        int old1s = 1;  // Number of binary strings of length 1 ending in 1

        for (int i = 2; i <= n; i++) {
            int n0s = old1s;         // Current strings of length i ending in 0 (must be old1s)
            int n1s = old0s + old1s; // Current strings of length i ending in 1 (can be either old0s or old1s)

            old0s = n0s;  // Update old0s to the current count
            old1s = n1s;  // Update old1s to the current count
        }

        return old0s + old1s;  // Total count of binary strings of length n without consecutive 0s
        }
        
        public static int TotalWays(int N){
        
        int buildings = 1;
        int spaces = 1;
        
        for(int i = 2; i <= N;i++){
            int nbuildings = spaces;
            int nspaces = buildings + spaces;
            
            buildings = nbuildings;
            spaces = nspaces;
        }
        
        int total = buildings + spaces;
        return total * total;
    }
}
