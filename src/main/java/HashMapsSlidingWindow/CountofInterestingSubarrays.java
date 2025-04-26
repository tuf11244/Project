/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HashMapsSlidingWindow;
import java.util.*;
/**
 *https://leetcode.com/problems/count-of-interesting-subarrays/
 * Date: 04/25/2025
 * @author parth
 */
public class CountofInterestingSubarrays {
    public static void main(String[] args) {
        
    }
    
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1); // base case

        long result = 0;
        int prefixCount = 0;

        for (int num : nums) {
            if (num % modulo == k) {
                prefixCount++;
            }

            int currMod = prefixCount % modulo;
            // looking for (prefixCount - x) % modulo == k
            // -> x % modulo == (currMod - k + modulo) % modulo
            int targetMod = (currMod - k + modulo) % modulo;
            result += countMap.getOrDefault(targetMod, 0);

            // update map for future prefix sums
            countMap.put(currMod, countMap.getOrDefault(currMod, 0) + 1);
        }

        return result;
    }
}

