/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

/**
 *Date: 02/18/2025
 * https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
 * @author parth
 */
public class KthLexicographicallyStringofallHappyStringsofLengthn {
    
    private int count;
    private String result;
    
    public String getHappyString(int n, int k) {
        count = 0;
        result = "";
        backtrack(new StringBuilder(), n, k, ' '); // Start with an empty character
        return result;
    }

    private void backtrack(StringBuilder sb, int n, int k, char lastChar) {
        if (sb.length() == n) {
            count++;
            if (count == k) {
                result = sb.toString();
            }
            return;
        }

        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (ch != lastChar) {
                sb.append(ch);
                backtrack(sb, n, k, ch);
                sb.deleteCharAt(sb.length() - 1);
                if (!result.isEmpty()) return; // Stop once k-th string is found
            }
        }
    }
}
