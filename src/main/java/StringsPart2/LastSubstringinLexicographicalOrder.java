/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/last-substring-in-lexicographical-order/
 *Date: 01/04/2024
 * @author parth
 */
public class LastSubstringinLexicographicalOrder {

    /**
     * 
     * If at any index, the 1st string's letter is larger than 2nd string's letter at the same index, 
     * the 1st string is lexicographically larger
     * 
     * Keep 2 pointers indicating the start index of 2 substrings.
     * If the current index characters are the same, both strings can extend their length to their respective next character.
     * If the letters are not equal, move the smaller substring pointer to a new position and 
     * repeat the comparison cycle from the very start of the substrings.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       String answer = lastSubstring("leetcodedfsdjdeffjs");
        System.out.println(answer);
    }
    public static String lastSubstring(String s) {
        // Initialize pointers and length
        int xStart = 0, yStart = 1, len = 0;
        int sLen = s.length();

        // Iterate through the string
        while (xStart < sLen && yStart < sLen && len < sLen) {
            // Check if we have reached the end of the string
            if (xStart + len >= sLen || yStart + len >= sLen) {
                break;
            }

            // Compare characters at current positions
            int diff = s.charAt(xStart + len) - s.charAt(yStart + len);

            if (diff == 0) {
                // Characters are equal, increment the length
                len++;
            } else {
                // Characters are different, update pointers
                if (diff < 0) {
                    xStart += len + 1;
                } else {
                    yStart += len + 1;
                }

                // If the pointers coincide, move yStart to the next position
                if (xStart == yStart) {
                    yStart++;
                }

                // Reset the length
                len = 0;
            }
        }

        // Determine the starting index of the lexicographically largest substring
        int start = Math.min(xStart, yStart);

        // Return the substring starting from the determined index
        return s.substring(start);
    }
   
    
   
}
