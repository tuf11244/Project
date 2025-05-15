/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StringsPart2;

/**
 *Date: 05/13/2025
 *https://leetcode.com/problems/total-characters-in-string-after-transformations-i/
 * @author parth
 */
public class TotalCharactersinStringAfterTransformationsI {
    private static final int MOD = 1_000_000_007;

    // Fix: Method renamed to match the expected driver call
    public int lengthAfterTransformations(String s, int t) {
        // Step 1: Count initial frequency of each character in s
        long[] count = new long[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Step 2: Perform t transformations
        for (int i = 0; i < t; i++) {
            long[] newCount = new long[26]; // Next generation count

            for (int j = 0; j < 26; j++) {
                if (count[j] == 0) continue; // Skip if no such character

                if (j == 25) { // If character is 'z'
                    newCount[0] = (newCount[0] + count[25]) % MOD; // Add to 'a'
                    newCount[1] = (newCount[1] + count[25]) % MOD; // Add to 'b'
                } else {
                    newCount[j + 1] = (newCount[j + 1] + count[j]) % MOD; // Move to next letter
                }
            }

            count = newCount; // Update for next round
        }

        // Step 3: Sum all character counts to get final string length
        long total = 0;
        for (long c : count) {
            total = (total + c) % MOD;
        }

        return (int) total;
    }
}
