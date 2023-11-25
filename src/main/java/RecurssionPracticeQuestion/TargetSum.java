/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 *
 * @author parth
 */

public class TargetSum {

    public static int findTargetSumWays(int[] nums, int S) {
        return calculate(nums, 0, S);
    }

    private static int calculate(int[] nums, int i, int S) {
        if (i == nums.length) {
            // If we have reached the end of the array, check if the sum is equal to the target.
            return S == 0 ? 1 : 0;
        } else {
            // Calculate the number of ways by either adding or subtracting the current element.
            return calculate(nums, i + 1, S - nums[i]) + calculate(nums, i + 1, S + nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int target = 3;
        int result = findTargetSumWays(nums, target);
        System.out.println(result);
    }
}

