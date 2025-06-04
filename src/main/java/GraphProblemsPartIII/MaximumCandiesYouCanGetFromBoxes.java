/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphProblemsPartIII;

import java.util.*;

/**
 * Date: 06/03/2025
 * https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/
 * Solved using DFS approach
 * 
 * We are given initial boxes, each of which may be:
 * - open or closed (status array)
 * - contain candies
 * - contain keys to other boxes
 * - contain more boxes
 * 
 * Our goal is to collect the maximum candies possible.
 */
public class MaximumCandiesYouCanGetFromBoxes {
    
    public static void main(String[] args) {
        // Test can be added here if needed
    }

    /**
     * Main method to compute the max candies we can collect
     */
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        
        int candy = 0;

        // Store the boxes that are currently locked but found
        HashSet<Integer> lockedBoxes = new HashSet<>();

        // To ensure we do not process a box more than once
        boolean[] visited = new boolean[candies.length];

        // Start DFS for each box in initialBoxes
        for (int box : initialBoxes) {
            candy += dfs(status, candies, keys, containedBoxes, lockedBoxes, visited, box);
        }

        return candy;
    }

    /**
     * Recursive DFS function to collect candies
     */
    private int dfs(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, 
                    HashSet<Integer> lockedBoxes, boolean[] visited, int box) {
        
        // Skip if already processed
        if (visited[box]) {
            return 0;
        }

        // If box is closed and we don't have a key yet, defer processing
        if (status[box] == 0) {
            lockedBoxes.add(box);
            return 0;
        }

        // Mark the box as visited
        visited[box] = true;

        // Start by collecting candies in the current box
        int candiesCollected = candies[box];

        // Recursively process all contained boxes
        for (int innerBox : containedBoxes[box]) {
            if (!visited[innerBox]) {
                candiesCollected += dfs(status, candies, keys, containedBoxes, lockedBoxes, visited, innerBox);
            }
        }

        // Process all keys found in this box
        for (int boxKey : keys[box]) {
            status[boxKey] = 1; // Unlock the box

            // If the box was found earlier but locked, now we can open it
            if (lockedBoxes.contains(boxKey)) {
                candiesCollected += dfs(status, candies, keys, containedBoxes, lockedBoxes, visited, boxKey);
            }
        }

        return candiesCollected;
    }
}
