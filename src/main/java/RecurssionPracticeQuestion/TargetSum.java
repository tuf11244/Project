/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 *https://leetcode.com/problems/target-sum/
 * @author parth
 */

public class TargetSum {

    public static int findTargetSumWays(int[] nums, int target) {
        return calculate(nums, 0, target);
    }

    private static int calculate(int[] nums, int i, int target) {
        if (i == nums.length) {
            // If we have reached the end of the array, check if the sum is equal to the target.
            if(target == 0){
                return 1;
            } else{
                return 0;
            }
        } else {
            // Calculate the number of ways by either adding or subtracting the current element.
            return calculate(nums, i + 1, target - nums[i]) + calculate(nums, i + 1, target + nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        int result = findTargetSumWays(nums, target);
        System.out.println(result);
    }
}

