/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;
import java.util.*;
/**
 *02/08/2025
 * https://leetcode.com/problems/count-number-of-bad-pairs/
 * @author parth
 */
public class CountNumberofBadPairs {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public long countBadPairs(int[] nums) {
        // Find the number of good pairs
        HashMap<Integer, Integer> goodPairs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - i;
            goodPairs.put(diff, goodPairs.getOrDefault(diff, 0) + 1);
        }

        long count = 0;
        for (int freq : goodPairs.values()) {
            if (freq > 1) {
                count += (long) freq * (freq - 1) / 2;
            }
        }

        long n = nums.length; 
        long totalPairs = (n * (n - 1)) / 2; // Ensure n is long to prevent overflow

        return totalPairs - count;
    }
}
