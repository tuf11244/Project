/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 *Date: 06/04/2024
 * https://leetcode.com/problems/append-characters-to-string-to-make-subsequence
 * @author parth
 */
public class AppendCharacterstoStringtoMakeSubsequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int appendCharacters(String s, String t) {
           int i = 0; 
        int j = 0;

        // Iterate through both strings
        while (i < s.length() && j < t.length()) {
            // If characters match, move to the next character in t
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            // Always move to the next character in s
            i++;
        }

        // The number of characters to append to s to make t a subsequence
        return t.length() - j;
    }
}
