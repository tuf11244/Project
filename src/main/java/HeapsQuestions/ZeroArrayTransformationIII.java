/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HeapsQuestions;
import java.util.*;
/**
 *Date: 05/22/2025
 * https://leetcode.com/problems/zero-array-transformation-iii/
 * @author parth
 */
public class ZeroArrayTransformationIII {
    public static void main(String[] args) {
        
    }
    
    public int maxRemoval(int[] nums, int[][] queries) {

        // Max heap to prioritize the queries that end the farthest (so we get more coverage)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Min heap to track end indices of queries that were already used (active range trackers)
        PriorityQueue<Integer> pastQueries = new PriorityQueue<>();

        // Sort queries based on their starting index
        Arrays.sort(queries, (a, b) -> (a[0] - b[0]));

        int usedQueries = 0; // Counter for the number of queries we end up using
        int j = 0; // Pointer to iterate over queries

        // Iterate over every index of nums array
        for (int i = 0; i < nums.length; i++) {

            // Add all queries whose start index is equal to current index `i`
            // We add their end index to the maxHeap
            while (j < queries.length && queries[j][0] == i) {
                maxHeap.add(queries[j][1]); // Add end of query to maxHeap
                j++;
            }

            // Apply all past active queries that still cover index `i`
            // Every active past query reduces current nums[i] by 1
            nums[i] = nums[i] - pastQueries.size();

            // If nums[i] is still > 0, we need to apply new queries
            // We'll use the queries with farthest end first (maxHeap)
            while (nums[i] > 0 && !maxHeap.isEmpty() && maxHeap.peek() >= i) {
                int ending = maxHeap.poll();     // Get the farthest-reaching query
                nums[i] -= 1;                    // Apply it to current index
                pastQueries.add(ending);         // Track it in pastQueries (active for future indices too)
                usedQueries++;                   // Increment count of used queries
            }

            // If after using all available queries covering this index, nums[i] is still > 0
            // Then it's impossible to reduce it to zero
            if (nums[i] > 0) {
                return -1;
            }

            // Remove all pastQueries which are no longer applicable (their end < current index)
            while (!pastQueries.isEmpty() && pastQueries.peek() <= i) {
                pastQueries.poll();
            }
        }

        // Return the number of unused queries
        return queries.length - usedQueries;
    }

}
