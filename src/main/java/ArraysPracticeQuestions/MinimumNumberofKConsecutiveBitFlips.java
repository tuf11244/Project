/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 06/24/2024
 *https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/
 * https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/
 * @author parth
 */
public class MinimumNumberofKConsecutiveBitFlips {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int minKBitFlips(int[] nums, int k) {
         int n = nums.length;

        int flips = 0;
        boolean[] isFlipped = new boolean[n];
        int flipCountFromPastForCurri = 0;

        for (int i = 0; i < n; i++) {
            // If there is a flip that started k steps before, it should be out of the current window
            if (i >= k && isFlipped[i - k]) {
                flipCountFromPastForCurri--;
            }
            // Check if the current bit needs to be flipped
            if (flipCountFromPastForCurri % 2 == nums[i]) {
                // If we cannot flip a subarray starting from i, return -1
                if (i + k > n) {
                    return -1;
                }
                // Mark the current index as flipped and update the counters
                flipCountFromPastForCurri++;
                isFlipped[i] = true;
                flips++;
            }
        }

        return flips;
    }
}
