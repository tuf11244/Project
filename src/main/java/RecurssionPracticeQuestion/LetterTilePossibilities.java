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


/* Easy way but use space
public int numTilePossibilities(String tiles) {
       HashSet<String> set = new HashSet<>();
       StringBuilder sb = new StringBuilder();
       boolean[] used = new boolean[tiles.length()];

        backtrack(tiles,set,sb,used);
       return set.size()-1;
    }

    public void backtrack(String tiles, HashSet<String> set, StringBuilder sb, boolean[] used){

        set.add(sb.toString());

        for(int i = 0; i < tiles.length();i++){
            if(used[i] == false){
                used[i] = true;
                sb.append(tiles.charAt(i));
                backtrack(tiles,set,sb,used);
                used[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

*/