/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 *Date: 03/22/2024
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 * @author parth
 */
public class KdiffPairsinArray {

    /**
     * Good Questions
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       int[] nums = {3,1,4,1,5};
        System.out.println(findPairs(nums,2));
    }
    public static int findPairs(int[] nums, int k) {
        int count = 0;
        //Prepare a HashMap of Frequencies
        HashMap<Integer,Integer> fmap = new HashMap<>(); 
        for(int i = 0; i < nums.length;i++){
            fmap.put(nums[i],fmap.getOrDefault(nums[i],0)+1);
        }
        System.out.println(fmap);
        // Now iterate over the HashMap
        for (int key : fmap.keySet()) {
            if (k == 0) {
                if (fmap.get(key) > 1) { // Same element paired with itself
                    count++;
                }
            } else {
                if (fmap.containsKey(key + k)) {
                    count++;
                }
            }
        }
        return count;
}
}
