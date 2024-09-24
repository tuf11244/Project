/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LIS;
import java.util.*;
/**
 *Date: 09/24/2024
 *https://leetcode.com/problems/largest-divisible-subset/
 * @author parth
 */
public class LongestDivisibleSubset {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        if (nums.length == 0) {
            return answer;
        }

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: DP array to store the largest divisible subset size ending at each index
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            dp.add(new ArrayList<>());
        }

        // Step 3: Populate the DP array
        for (int i = 0; i < nums.length; i++) {
            List<Integer> maxSubset = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp.get(j).size() > maxSubset.size()) {
                    maxSubset = dp.get(j);
                }
            }
            // Add nums[i] to the largest divisible subset ending at nums[i]
            dp.get(i).addAll(maxSubset);
            dp.get(i).add(nums[i]);
        }

        System.out.println(dp.get(nums.length-1));

        // Step 4: Find the largest subset in dp
        for (List<Integer> subset : dp) {
            if (subset.size() > answer.size()) {
                answer = subset;
            }
        }

        return answer;
    }
}
