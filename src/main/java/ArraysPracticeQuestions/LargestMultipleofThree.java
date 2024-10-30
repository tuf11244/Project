/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;
import java.util.*;
/**
 *Date:10/29/2024
 * https://leetcode.com/problems/largest-multiple-of-three/
 * @author parth
 */
public class LargestMultipleofThree {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public String largestMultipleOfThree(int[] digits){
        
        int prefixSum = 0;
        Arrays.sort(digits);  // Sort to make it easier to remove the smallest values when needed.

        for (int digit : digits) {
            prefixSum += digit;
        }
        
        if (prefixSum % 3 == 1) { // Remainder 1;
            if (removeSmallestRemainder(digits, 1, 1) == false) {
                if (removeSmallestRemainder(digits, 2, 2) == false) {
                    return ""; // No valid removal found
                }
            }
        } else if (prefixSum % 3 == 2) { // Remainder 2;
            if (removeSmallestRemainder(digits, 2, 1) == false) {
                if (removeSmallestRemainder(digits, 1, 2) == false) {
                    return ""; // No valid removal found
                }
            }
        }

        // Build the largest number from remaining digits
        StringBuilder sb = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != -1) {
                sb.append(digits[i]);
            }
        }

        // Handle case where result is all zeros or empty
        if (sb.length() == 0 || sb.charAt(0) == '0') {
            return sb.length() == 0 ? "" : "0";
        }
        
        return sb.toString();
    }
    
    // Helper function to remove a specific number of smallest digits with a given remainder
    private boolean removeSmallestRemainder(int[] digits, int remainder, int count) {
        for (int i = 0; i < digits.length && count > 0; i++) {
            if (digits[i] % 3 == remainder) {
                digits[i] = -1; // Mark as removed
                count--;
            }
        }
        return count == 0; // True if we removed the required number of digits
    }
}
