/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.Kadane;

/**
 * Date: 12/26/2024
 * Problem: https://leetcode.com/problems/best-sightseeing-pair
 * Author: Parth
 */
public class BestSightSeeingPair {

    /**
     * Entry point for the application.
     * This can be used to test the functionality of the `maxScoreSightseeingPair` method.
     * 
     * @param args Command-line arguments.
     */
    public static void main(String args[]) {
        // TODO Add test cases or logic to test the maxScoreSightseeingPair method.
    }
    
    /**
     * Computes the maximum score of a sightseeing pair in the array `values`.
     * 
     * The score of a pair (i, j) is defined as:
     *    values[i] + values[j] + i - j
     * 
     * To maximize the score, we rearrange it as:
     *    (values[i] + i) + (values[j] - j)
     * This allows us to maintain a running maximum of (values[i] + i) while iterating.
     * 
     * @param values Array of sightseeing values.
     * @return The maximum sightseeing pair score.
     */
    public int maxScoreSightseeingPair(int[] values) {
        // `maxSeen` keeps track of the maximum value of (values[i] + i) seen so far.
        int maxSeen = values[0] + 0; // Initialize with the first element (values[0] + its index, i = 0).
        
        // `maxScore` stores the maximum score encountered during the iteration.
        int maxScore = 0;

        // Iterate through the array starting from the second element (j = 1).
        for (int j = 1; j < values.length; j++) {
            // Calculate the score for the current pair (maxSeen contributes values[i] + i).
            // (values[j] - j) represents the contribution of the current element.
            maxScore = Math.max(values[j] - j + maxSeen, maxScore);
            
            // Update `maxSeen` to include the current element and index.
            // We consider (values[j] + j) for future calculations.
            maxSeen = Math.max(maxSeen, values[j] + j);
        }

        // Return the maximum score after checking all possible pairs.
        return maxScore; 
    }
}
