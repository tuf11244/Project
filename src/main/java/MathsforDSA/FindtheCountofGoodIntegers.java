/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MathsforDSA;

import java.util.*;

/**
 *Date: 04/11/2025
 * https://leetcode.com/problems/find-the-count-of-good-integers/
 * @author parth
 */
public class FindtheCountofGoodIntegers {
   
    // Main function to count all "good" integers of length `n` divisible by `k`
    public long countGoodInteger(int n, int k){
        
        // Set to store unique digit permutations of good palindromes
        HashSet<String> duplicates = new HashSet<>();
        
        // Number of digits needed to form the left half of the palindrome
        int digits = (n + 1) / 2;
        
        // Start and end range for the left half (to avoid leading zeros)
        int start = (int) Math.pow(10, digits - 1);
        int end = (int) (Math.pow(10, digits) - 1);
        
        // Generate all palindromic numbers of length `n`
        for (int num = start; num <= end; num++) {
            String left = String.valueOf(num); // Left half of the palindrome
            String full = "";

            // Construct the full palindrome based on even or odd `n`
            if (n % 2 == 0) {
                // If `n` is even, mirror the entire left side
                StringBuilder right = new StringBuilder(left);
                full = left + right.reverse().toString();      
            } else {
                // If `n` is odd, omit the last digit from the mirror
                StringBuilder right = new StringBuilder(left.substring(0, digits - 1));
                full = left + right.reverse().toString();         
            }
            
            long number = Long.valueOf(full);

            // Skip numbers not divisible by `k`
            if (number % k != 0) {
                continue;
            }

            // Sort digits of the palindrome to normalize its structure for uniqueness
            char[] arr = full.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);

            // Skip duplicate permutations
            if (duplicates.contains(s)) {
                continue;
            }

            // Store unique sorted digit permutation
            duplicates.add(s);
        }
        
        long result = 0;

        // Precompute factorials from 0! to 10! (as digits are 0-9)
        long[] factorial = new long[11];
        Arrays.fill(factorial, 1);
        for (int i = 1; i <= 10; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // Calculate permutations for each unique digit arrangement
        for (String s : duplicates) {
            
            char[] freq = new char[10]; // Frequency of each digit (0-9)

            // Count frequency of each digit
            for (char ch : s.toCharArray()) {
                freq[ch - '0']++;
            }

            int totalDigits = s.length();
            int zeroDigits = freq[0];
            int nonZeroDigits = s.length() - zeroDigits;

            // Total permutations by fixing each non-zero digit in the first place
            long perm = nonZeroDigits * factorial[totalDigits - 1];

            // Divide by factorial of frequencies to account for duplicate digits
            for (int i = 0; i < 10; i++) {
                perm = perm / factorial[freq[i]];
            }

            // Accumulate result
            result = result + perm;
        }

        return result;
    }
}
