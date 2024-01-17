/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *https://leetcode.com/problems/sort-array-by-increasing-frequency/
 * Date: 01/17/2024
 * @author parth
 */
public class SortArraybyIncreasingFrequency {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int[] frequencySort(int[] nums) {
    // Step 1: Create a HashMap to store the frequency of each element
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    // Step 2: Populate the HashMap with the frequency of each element in the array
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i])) {
            map.put(nums[i], map.get(nums[i]) + 1);
        } else {
            map.put(nums[i], 1);
        }
    }

    // Step 3: Create a list containing unique elements from the HashMap
    List<Integer> list = new ArrayList<Integer>(map.keySet());

    // Step 4: Sort the list based on the frequency and value of elements
    Collections.sort(list, (a, b) -> {
        if (map.get(a) == map.get(b)) {
            return b - a; // Sort in descending order if frequencies are equal
        } else {
            return map.get(a) - map.get(b); // Sort based on frequency
        }
    });

    // Step 5: Create a new array to store the sorted elements
    int result[] = new int[nums.length];
    int index = 0;

    // Step 6: Populate the result array with elements from the sorted list based on their frequency
    for (int num : list) {
        for (int i = 0; i < map.get(num); i++) {
            result[index++] = num;
        }
    }

    // Step 7: Return the sorted array
    return result;
}

}
