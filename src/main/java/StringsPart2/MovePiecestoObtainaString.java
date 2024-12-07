/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 *Date: 12/06/2024
 * https://leetcode.com/problems/move-pieces-to-obtain-a-string/
 * @author parth
 */
public class MovePiecestoObtainaString {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public boolean canChange(String start, String target) {
        if (!start.replace("_", "").equals(target.replace("_", ""))) {
            return false; // Non-'_' characters must match in order and type.
        }

        int i = 0; // Pointer for start
        int j = 0; // Pointer for target

        while (i < start.length() && j < target.length()) {
            // Skip '_' characters in both strings
            while (i < start.length() && start.charAt(i) == '_') {
                i++;
            }
            while (j < target.length() && target.charAt(j) == '_') {
                j++;
            }

            // If either pointer reaches the end, they both must reach simultaneously
            if (i == start.length() || j == target.length()) {
                return i == j;
            }

            // Characters must match
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }

            // Validate movement constraints
            if (start.charAt(i) == 'L' && i < j) {
                return false; // 'L' can't move right
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false; // 'R' can't move left
            }

            // Move to the next non-'_' character
            i++;
            j++;
        }

        return true;
    }
}
