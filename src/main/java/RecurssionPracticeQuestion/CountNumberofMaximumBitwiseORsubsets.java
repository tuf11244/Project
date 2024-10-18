/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 *Date: 10/17/2024
 * https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
 * @author parth
 */
public class CountNumberofMaximumBitwiseORsubsets {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    private int maxBitWiseOr;
    private int count;

    public int countMaxOrSubsets(int[] nums) {
        // Step 1: Calculate the maximum bitwise OR for the entire array.
        maxBitWiseOr = 0;
        for (int num : nums) {
            maxBitWiseOr |= num;  // OR all the numbers to get the maximum OR value
        }

        // Step 2: Use backtracking to count the number of subsets with the max OR.
        count = 0;
        backtrack(nums, 0, 0);  // Start backtracking from index 0, with current OR value as 0

        return count;
    }

    private void backtrack(int[] nums, int index, int currentOr) {
        // If we've processed all elements, check if the current OR is equal to max OR
        if (index == nums.length) {
            if (currentOr == maxBitWiseOr) {
                count++;
            }
            return;
        }

        // Option 1: Include the current element in the subset
        backtrack(nums, index + 1, currentOr | nums[index]);

        // Option 2: Exclude the current element from the subset
        backtrack(nums, index + 1, currentOr);
    }
}
