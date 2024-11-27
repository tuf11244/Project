package StringsPart2;
import java.util.*;

/**
 * Date: 11/26/2024
 * https://leetcode.com/problems/palindrome-pairs/description/
 * @author parth
 */
public class PalindromePairs {

    public static void main(String args[]) {
        // Example input for testing
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> result = palindromePairs(words);
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }
    }
    
    
    //Time Complexity : O(n×L^2)
    public static List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result = new ArrayList<>();

        if (words == null || words.length < 2) {
            return result;
        }

        // Map to store reversed words and their indices
        HashMap<String, Integer> hm = new HashMap<>();

        // Store the reversed words in the map
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            String reverse = sb.reverse().toString();
            hm.put(reverse, i);
        }

        // Check for valid palindrome pairs
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            for (int j = 0; j <= word.length(); j++) {
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);

                // Check if the prefix is a valid reversed word and suffix is a palindrome
                if (hm.containsKey(prefix) && isPalindrome(suffix) && hm.get(prefix) != i) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(hm.get(prefix)); // Corrected line to add the index of the reversed word
                    result.add(temp);
                }

                // Check if the suffix is a valid reversed word and prefix is a palindrome
                if (prefix.length() > 0 && hm.containsKey(suffix) && isPalindrome(prefix) && hm.get(suffix) != i) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(hm.get(suffix)); // Corrected line to add the index of the reversed word
                    temp.add(i);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
