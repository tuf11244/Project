/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArraysPracticeQuestions;
import java.util.*;
/**
 *Date: 03/26/2025
 * https://leetcode.com/problems/minimum-index-of-a-valid-split/
 * @author parth
 */
public class MinimumIndexforaValidSplit {
    public static void main(String[] args) {
        
    }
     public int minimumIndex(List<Integer> nums) {
        // Find the dominant element using HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int dominant = -1, totalFrequency = 0;
        for (int key : hm.keySet()) {
            if (hm.get(key) * 2 > nums.size()) {
                dominant = key;
                totalFrequency = hm.get(key);
            }
        }

        if (dominant == -1) return -1; // No dominant element exists

        // Use a prefix count instead of recalculating for each i
        int prefixCount = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == dominant) {
                prefixCount++;
            }
            int remainingCount = totalFrequency - prefixCount;
            int leftSize = i + 1;
            int rightSize = nums.size() - leftSize;

            if (prefixCount * 2 > leftSize && remainingCount * 2 > rightSize) {
                return i;
            }
        }
        return -1;
    }
}
