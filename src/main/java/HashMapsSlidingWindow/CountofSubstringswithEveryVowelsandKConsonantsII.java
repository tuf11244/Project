package HashMapsSlidingWindow;
import java.util.*;

/**
 * Date: 03/09/2025
 * Problem: https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/
 * Author: Parth
 */
public class CountofSubstringswithEveryVowelsandKConsonantsII {
    
    public static void main(String[] args) {
        String word = "cdaeeaepkbiouaeeip";
        System.out.println(countOfSubstring(word, 3));
    }
    
    public static long countOfSubstring(String word, int k) {
        long answer = 0; // Stores the final count of valid substrings
        
        HashMap<Character, Integer> vowels = new HashMap<>(); // Track vowel frequency in the window
        int consonants = 0; // Track number of consonants in the current window
        
        int[] nearestConsonants = getMeNearestConsonants(word); // Precompute nearest consonants for efficiency
        System.out.println(Arrays.toString(nearestConsonants));
        
        int i = -1, j = -1; // Sliding window pointers
        
        while (true) {
            boolean failingOnConsonants = false;
            boolean isValid = false;
            
            // Acquire phase: Expand the window by moving `i` until we get a valid substring
            while (i < word.length() - 1) {
                i++;
                char ch = word.charAt(i);
                
                if (isVowel(ch)) {
                    vowels.put(ch, vowels.getOrDefault(ch, 0) + 1);
                } else {
                    consonants++;
                }
                
                // Check if we have all 5 vowels and exactly k consonants
                if (vowels.size() == 5 && consonants == k) {
                    isValid = true;
                    break;
                }
                
                // If consonants exceed k, we must release characters from the left
                if (consonants > k) {
                    failingOnConsonants = true;
                    break;
                }
            }
            
            // Release phase: Reduce window size from the left until consonants == k
            while (failingOnConsonants) {
                j++;
                char ch = word.charAt(j);
                
                if (isVowel(ch)) {
                    vowels.put(ch, vowels.get(ch) - 1);
                    if (vowels.get(ch) == 0) {
                        vowels.remove(ch);
                    }
                } else {
                    consonants--;
                }
                
                if (consonants == k) {
                    failingOnConsonants = false;
                }
            }
            
            // Valid window found, count the substrings
            while (j < i && isValid) {
                j++;
                char ch = word.charAt(j);
                
                // Add to the result: Count all substrings ending at `i`
                answer += nearestConsonants[i] - i;
                
                if (isVowel(ch)) {
                    vowels.put(ch, vowels.get(ch) - 1);
                    if (vowels.get(ch) == 0) {
                        vowels.remove(ch);
                    }
                } else {
                    consonants--;
                }
                
                // If we lose a required vowel or go below k consonants, break
                if (vowels.size() < 5 || consonants < k) {
                    isValid = false;
                    break;
                }
            }
            
            // If we reach the end and conditions are not met, break
            if (i == word.length() - 1 && (vowels.size() < 5 || consonants < k)) {
                break;
            }
        }
        
        return answer;
    }
    
    // Precompute the index of the nearest consonant for each character
    public static int[] getMeNearestConsonants(String word) {
        int[] arr = new int[word.length()];
        int next = word.length(); // Default value if no consonant exists after a position
        
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            
            if (isVowel(ch)) {
                arr[i] = next;
            } else {
                arr[i] = next;
                next = i; // Update next consonant position
            }
        }
        return arr;
    }
    
    // Helper function to check if a character is a vowel
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
