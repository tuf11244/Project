/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2; // Package name indicating that this code is part of the StringsPart2 module.

import java.util.ArrayList; // Import statement for ArrayList (not used in this code).

/**
 * Date: 12/19/2023
 * https://leetcode.com/problems/shifting-letters/;
 * Author: Parth
 */
public class ShiftingLetters {

    public static void main(String args[]) {
        // Initialize an array of shifts and call the shiftingLetters method with example input.
        int[] shifts = {3, 5, 9};
        System.out.println(shiftingLetters("abc", shifts)); // Expected Output: "rpl"
    }

    /**
     * Shifts each character of the input string `s` based on the cumulative effect
     * of the values in the `shifts` array. Each shift is applied in reverse order.
     * 
     * @param s      The input string consisting of lowercase English letters.
     * @param shifts An array of integers representing the number of shifts to apply to characters.
     * @return A new string with all characters shifted accordingly.
     */
    public static String shiftingLetters(String s, int[] shifts) {
        StringBuilder result = new StringBuilder(); // To efficiently build the final result.
        int totalShifts = 0; // Tracks cumulative shifts to be applied.

        // Iterate over the string in reverse (from last character to first).
        for (int i = s.length() - 1; i >= 0; i--) {
            totalShifts = (totalShifts + shifts[i]) % 26; // Update the cumulative shifts modulo 26.
            
            // Calculate the new character after shifting.
            // ('a' ensures we remain in the lowercase alphabet range).
            char shiftedChar = (char) ((s.charAt(i) - 'a' + totalShifts) % 26 + 'a');
            
            // Debug: Print the shifted character for tracing.
            System.out.println(shiftedChar);
            
            // Insert the shifted character at the beginning of the result.
            result.insert(0, shiftedChar); // Efficient because shifts are applied in reverse.
        }

        // Convert the StringBuilder object to a String and return.
        return result.toString();
    }
}
