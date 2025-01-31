/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;
import java.util.*; 
/**
 *01/31/2025
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 * @author parth
 */
public class PartitiontoKequalSumSubsets {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int numsSum = 0;
        for (int num : nums) {
            numsSum += num;
        }
        
        if (numsSum % k != 0) {
            return false;
        }
        
        int subsetSum = numsSum / k;
        
        Arrays.sort(nums); // Reverse the array to start with the largest elements
        
        boolean[] visited = new boolean[nums.length];
        
        return canPartition(nums, visited, k, 0, 0, subsetSum);
    }

    private boolean canPartition(int[] nums, boolean[] visited, int k, int curSum, int nextIndex, int subsetSum) {
        if (k == 1) {
            return true;
        }
        
        if (curSum == subsetSum) {
            return canPartition(nums, visited, k - 1, 0, 0, subsetSum);
        }
        
        for (int i = nextIndex; i < nums.length; i++) {
            if (!visited[i] && curSum + nums[i] <= subsetSum) {
                visited[i] = true;
                if (canPartition(nums, visited, k, curSum + nums[i], i + 1, subsetSum)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        
        return false;
    }
}
