/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

/**
 *Date: 02/15/2025
 * https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
 * @author parth
 */
public class ConstructLexicographicallyLargestValidSequence {
    

     
    
    
    public int[] constructDistancedSequence(int n) {
        int length = 2 * n - 1;
        int[] result = new int[length];
        boolean[] used = new boolean[n + 1];  // To track used numbers
        backtrack(result, used, 0, n);
        return result;
    }

    private boolean backtrack(int[] result, boolean[] used, int index, int n) {
        // If we've placed all numbers, return true
        if (index == result.length) {
            return true;
        }

        // If already filled, move to the next index
        if (result[index] != 0) {
            return backtrack(result, used, index + 1, n);
        }

        // Try placing numbers from n to 1
        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;

            // If `num == 1`, it only appears once; otherwise, it must be placed twice
            if (num == 1 || (index + num < result.length && result[index + num] == 0)) {
                // Place `num` at `index` and `index + num`
                result[index] = num;
                if (num != 1) result[index + num] = num;
                used[num] = true;

                // Recur to fill the next position
                if (backtrack(result, used, index + 1, n)) return true;

                // Undo changes (backtrack)
                result[index] = 0;
                if (num != 1) result[index + num] = 0;
                used[num] = false;
            }
        }
        return false;
    }
}
