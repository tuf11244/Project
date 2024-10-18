/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 10/17/2024
 *https://leetcode.com/problems/super-ugly-number/
 * Can also be done using PriorityQueue
 * @author parth
 */
public class SuperUglyNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] dp = new int[n]; // DP array to store the ugly numbers
        dp[0] = 1; // The first ugly number is always 1
        int[] pointers = new int[primes.length]; // Pointers for each prime

        for (int i = 1; i < dp.length; i++) {
            long min = Long.MAX_VALUE; // Use long to prevent overflow

            // Find the minimum ugly number for this iteration
            for (int k = 0; k < primes.length; k++) {
                min = Math.min((long)primes[k] * dp[pointers[k]], min); // Cast to long for multiplication
            }

            // Assign the minimum value to the current position in the DP array
            dp[i] = (int) min; // Cast back to int as dp stores ugly numbers

            // Increment the pointer(s) that matched the minimum value
            for (int k = 0; k < primes.length; k++) {
                if ((long)primes[k] * dp[pointers[k]] == min) {
                    pointers[k]++;
                }
            }
        }

        return dp[n - 1]; // Return the nth super ugly number
    }
    
}

