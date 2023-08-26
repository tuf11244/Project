/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PracticeQuestions;

import java.util.ArrayList;

/**
 *https://leetcode.com/problems/number-of-ways-to-split-a-string/
 * Date: 08/25/2023
 * @author parth
 */
public class NumberofWaystoSplitaString {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        System.out.println(numWays("10101"));
        
        // TODO code application logic here
    }
    public static int numWays(String s) {
    int MOD = 1_000_000_007;
    int n = s.length();
    int totalOnes = 0;

    for (char c : s.toCharArray()) {
        if (c == '1') {
            totalOnes++;
        }
    }

    if (totalOnes % 3 != 0) {
        return 0;
    }

    if (totalOnes == 0) {
        // If there are no ones, then we need to split between every pair of zeros.
        // The number of splits between n zeros is (n - 1) + (n - 2) + ... + 1.
        // This is equivalent to (n - 1) * n / 2.
        long nZeros = n - 1;
        return (int)((nZeros * (nZeros + 1) / 2) % MOD);
    }

    int targetOnes = totalOnes / 3;
    int countOnes = 0;
    long countPart1 = 0;
    long countPart2 = 0;

    for (char c : s.toCharArray()) {
        if (c == '1') {
            countOnes++;
        }

        if (countOnes == targetOnes) {
            countPart1++;
        } else if (countOnes == 2 * targetOnes) {
            countPart2++;
        }
    }

    return (int)((countPart1 * countPart2) % MOD);
}
    
 
    
    
}
