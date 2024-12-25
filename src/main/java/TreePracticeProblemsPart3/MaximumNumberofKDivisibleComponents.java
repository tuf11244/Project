/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart3;
import java.util.*;
/**
 *Date:10/22/2024
 *https://leetcode.com/problems/maximum-number-of-k-divisible-components/ 
 * @author parth
 */
public class MaximumNumberofKDivisibleComponents {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
     // Method to compute the maximum number of k-divisible components in a graph
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); // Initialize an empty list for each node
        }

        // Populate the adjacency list based on the input edges
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]); // Add edge from node 0 to node 1
            adj.get(edge[1]).add(edge[0]); // Add edge from node 1 to node 0 (undirected graph)
        }

        // Initialize a counter to track the number of k-divisible components
        int[] count = {0};

        // Perform a Depth-First Search (DFS) starting from node 0
        dfs(adj, values, k, count, 0, -1);

        // Return the final count of k-divisible components
        return count[0];
    }

    // Helper method to perform DFS and calculate sum modulo k for each subtree
    private int dfs(List<List<Integer>> adj, int[] values, int k, int[] count, int curr, int parent) {
        // Initialize the sum with the value of the current node
        long sum = values[curr];

        // Traverse all neighbors of the current node
        for (int nbr : adj.get(curr)) {
            // Skip the parent node to avoid revisiting it
            if (nbr != parent) {
                // Add the sum from the DFS of the neighbor
                sum += dfs(adj, values, k, count, nbr, curr);
            }
        }

        // Take modulo k of the sum to check divisibility
        sum %= k;

        // If the sum modulo k is 0, increment the count
        if (sum == 0) count[0]++;

        // Return the sum modulo k as an integer
        return (int) sum;
    }
}
