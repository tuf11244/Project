/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

import java.util.ArrayList;

/**
 *https://leetcode.com/problems/letter-tile-possibilities/
 * Date: 11/27/2023
 * @author parth
 */
public class LetterTilePossibilities {

   
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];  // Frequency array for letters
        for (char c : tiles.toCharArray()) {
            count[c - 'A']++;
        }
        return backtrack(count);
    }

    private int backtrack(int[] count) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                count[i]--;  // Use one character
                sum += 1 + backtrack(count);  // Count current string + recursive calls
                count[i]++;  // Restore character frequency
            }
        }
        return sum;
    }
}
