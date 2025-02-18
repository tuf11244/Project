/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

/**
 *Date: 02/17/2025
 * https://leetcode.com/problems/construct-smallest-number-from-di-string/
 * @author parth
 */
public class ConstructSmallestNumberfromDIString {
  
    private String result = null;

    public String smallestNumber(String pattern) {
        int n = pattern.length() + 1;
        boolean[] used = new boolean[n + 1];
        backtrack(new StringBuilder(), pattern, used, 0, n);
        return result;
    }

    private boolean backtrack(StringBuilder sb, String pattern, boolean[] used, int idx, int n) {
        if (idx == n) { 
            result = sb.toString();
            return true; // Stop as soon as we find the lexicographically smallest valid number
        }

        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;

            if (idx == 0 || (pattern.charAt(idx - 1) == 'I' && sb.charAt(idx - 1) - '0' < i) ||
                            (pattern.charAt(idx - 1) == 'D' && sb.charAt(idx - 1) - '0' > i)) {
                
                sb.append(i);
                used[i] = true;

                if (backtrack(sb, pattern, used, idx + 1, n)) return true; // Stop recursion if found

                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }

        return false;
    }
    
    
}
