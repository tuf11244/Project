/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;
import java.util.*;
/**
 *Date: 01/04/2025
 * https://leetcode.com/problems/shifting-letters-ii/
 * @author parth
 */
public class ShiftingLettersII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public String shiftingLetters(String s, int[][] shifts) {
        
        // Step 1: Initialize a difference array to store shift changes.
        // The diff array will help efficiently process ranges of shifts.
        int[] diff = new int[s.length()];

        // Step 2: Populate the difference array based on the shifts input.
        for (int[] shift : shifts) {
            int start = shift[0];  // Starting index of the range
            int end = shift[1];    // Ending index of the range
            int direction = shift[2];  // Direction of the shift: 0 = backward, 1 = forward

            if (direction > 0) { // Forward shift
                diff[start] += 1;  // Increase the start index by 1
                if (end + 1 < s.length()) {
                    diff[end + 1] -= 1;  // Decrease the value after the end index
                }
            } else { // Backward shift
                diff[start] -= 1;  // Decrease the start index by 1
                if (end + 1 < s.length()) {
                    diff[end + 1] += 1;  // Increase the value after the end index
                }
            }
        }

        // Step 3: Calculate the prefix sum to determine the net shifts for each character.
        // This gives the cumulative effect of all range-based operations.
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];  // Add the previous value to the current one
        }

        // Step 4: Apply the shifts to the original string.
        StringBuilder result = new StringBuilder();  // StringBuilder to efficiently build the final result
        for (int i = 0; i < s.length(); i++) {
            int shift = diff[i] % 26;  // Modulo 26 to keep the shift within the alphabet's bounds

            if (shift < 0) {
                shift += 26;  // Handle negative shifts by wrapping around
            }

            // Compute the new character after applying the shift
            // 'a' corresponds to 0, so subtract 'a', apply the shift, then add 'a' back.
            char newChar = (char) (((s.charAt(i) - 'a' + shift) % 26) + 'a');
            result.append(newChar);  // Add the shifted character to the result
        }

        // Step 5: Return the final result as a string.
        return result.toString();
    }
}
