/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;
import java.util.*;
/**
 *Date: 10/21/2024
 *https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
 * @author parth
 */
public class SplitaStringIntotheMaxNumberofUniqueSubstrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    private int answer = 0;  // Make answer an instance variable

    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        backtrack(s, set, 0);  // Pass initial index 0
        return answer;
    }

    public void backtrack(String s, HashSet<String> set, int index) {
        if (index >= s.length()) {
            answer = Math.max(answer, set.size());
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);  // Extract substring correctly
            if (!set.contains(sub)) {
                set.add(sub);
                backtrack(s, set, i);  // Pass the correct index
                set.remove(sub);  // Remove the correct substring
            }
        }
    }
}
