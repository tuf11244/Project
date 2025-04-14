/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MathsforDSA;

/**
 * Date: 04/12/2025
 * LeetCode Problem: https://leetcode.com/problems/count-the-number-of-powerful-integers/
 * Author: Parth
 * 
 * Problem Summary:
 * Count how many integers in the range [start, finish] are "powerful".
 * A powerful integer is one whose last digits match a given suffix string `s`,
 * and **all preceding digits** (before the suffix) are ≤ a given limit.
 */

public class CountNumberofPowerfulIntegers {
    
    public static void main(String[] args) {
        // Driver code can be added here for testing.
    }

    /**
     * Main method to count powerful integers in range [start, finish].
     * 
     * @param start  - Starting point of the range (inclusive).
     * @param finish - Ending point of the range (inclusive).
     * @param limit  - Maximum allowed digit value before the suffix.
     * @param s      - The suffix string that powerful numbers must end with.
     * @return       - Total number of powerful integers in the given range.
     */
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        // Convert start and finish into strings for digit-wise processing
        String startStr = String.valueOf(start - 1);  // Subtract 1 to handle inclusive range correctly
        String finishStr = String.valueOf(finish);
        
        // Count powerful integers <= finish - Count powerful integers < start
        return solve(finishStr, limit, s) - solve(startStr, limit, s);
    }

    /**
     * Helper function to count how many powerful integers are ≤ a given number represented as a string.
     * 
     * @param str    - The upper bound of the number range as a string.
     * @param limit  - Maximum allowed digit for non-suffix digits.
     * @param suffix - The suffix string all powerful numbers must end with.
     * @return       - Count of powerful integers ≤ str.
     */
    public long solve(String str, int limit, String suffix) {
        // If the number's length is shorter than the suffix, it can't be powerful
        if (str.length() < suffix.length()) {
            return 0;
        }

        long count = 0;

        // Extract the suffix part from the input number (last digits)
        String trailing = str.substring(str.length() - suffix.length());

        // Calculate how many digits are there before the suffix
        int remaining = str.length() - suffix.length();

        // Loop through each digit before the suffix
        for (int i = 0; i < remaining; i++) {
            int digit = str.charAt(i) - '0';  // Get current digit

            if (digit <= limit) {
                // If digit is within limit, calculate how many combinations we can make with remaining digits
                // Math.pow(limit+1, remaining-i-1) gives all combinations of future digits
                count += (digit * Math.pow(limit + 1, remaining - i - 1));
            } else {
                // If current digit exceeds limit, we can take all combinations for this digit
                count += Math.pow(limit + 1, remaining - i);
                return count;  // Early exit: because further digits won't be valid anyway
            }
        }

        // Check if the trailing digits (suffix) of the number is >= required suffix
        // If yes, then this number itself is a valid powerful number
        if (trailing.compareTo(suffix) >= 0) {
            count++;
        }

        return count;
    }
}
