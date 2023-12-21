/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 *https://leetcode.com/problems/swap-adjacent-in-lr-string/
 * Date: 12/20/2023
 * @author parth
 */
public class SwapAdjacentinLRString {

    
    public static void main(String args[]) {
        System.out.println(canTransform("RXXLRXRXL","XRLXXRRLX"));
    }
    public static boolean canTransform(String start, String end) {
        // Check if the characters in start and end are the same, excluding 'X'
        if (!start.replaceAll("X", "").equals(end.replaceAll("X", ""))) {
            return false;
        }

        int n = start.length();
        int i = 0, j = 0;

        while (i < n && j < n) {
            // Skip 'X' characters
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }

            // Check if the non-'X' characters are the same
            if (i < n && j < n) {
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }

                // Check the direction of movement ('L' moves to the left, 'R' moves to the right)
                if (start.charAt(i) == 'L' && i < j) {
                    return false;
                }
                if (start.charAt(i) == 'R' && i > j) {
                    return false;
                }
            }

            i++;
            j++;
        }

        return true;
    }
}
