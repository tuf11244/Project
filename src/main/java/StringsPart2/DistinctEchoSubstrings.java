/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;
import java.util.*;
/**
 *Date: 10/29/2024
 * https://leetcode.com/problems/distinct-echo-substrings/
 * @author parth
 */
public class DistinctEchoSubstrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int distinctEchoSubstrings(String text) {
        HashSet<String> set = new HashSet<>();
        int n = text.length();

        // Loop over possible lengths for the substring
        for (int len = 1; len <= n / 2; len++) { // Length of each half
            // Loop over starting indices for the substring
            for (int i = 0; i <= n - 2 * len; i++) {
                // Extract the substring
                String substr = text.substring(i, i + len);
                
                // Check if the same substring appears immediately after
                // Use a pointer for the second occurrence
                int j = i + len;
                boolean isEcho = true;

                // Compare character by character
                for (int k = 0; k < len; k++) {
                    if (text.charAt(i + k) != text.charAt(j + k)) {
                        isEcho = false; // If any character differs, it's not an echo
                        break;
                    }
                }

                // If it's an echo substring, add it to the set
                if (isEcho) {
                    set.add(substr);
                }
            }
        }

        return set.size(); // Return the count of distinct echo substrings
    }
}
