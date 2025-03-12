/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HashMapsSlidingWindow;
import java.util.*;
/**
 *Date: 03/11/2025
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 * @author parth
 */
public class NumberofSubstringsContainingAllThreeCharacters {
    
    public static void main(String[] args){
        
    }
    
    
    public int numberOfSubstrings(String s) {
         int i = -1, j = -1;
        int count = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        while (true) {
            // Acquire characters
            while (i < s.length() - 1) {
                i++;
                char ch = s.charAt(i);
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);

                // When all 'a', 'b', 'c' are present, break
                if (hm.size() == 3) {
                    break;
                }
            }

            // Release characters and count substrings
            while (j < i && hm.size() == 3) {
                j++;
                char ch = s.charAt(j);

                // Count all substrings ending at `i`
                count += (s.length() - i);

                // Reduce frequency or remove character
                if (hm.get(ch) == 1) {
                    hm.remove(ch);
                } else {
                    hm.put(ch, hm.get(ch) - 1);
                }
            }

            // If `i` reaches the last character and we can't form "abc", break
            if (i == s.length() - 1 && hm.size() < 3) {
                break;
            }
        }

        return count;
    }
    
}
