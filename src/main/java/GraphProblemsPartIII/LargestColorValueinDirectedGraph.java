/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *Date: 05/26/2025
 * https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
 * @author parth
 */
public class LargestColorValueinDirectedGraph {
    
    public static void main(String[] args) {
        
    }
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length(); // Number of nodes in the graph

        // Step 1: Build the graph as an adjacency list
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>(); // Initialize empty list for each node
        }

        // Array to keep track of indegrees for Kahn's algorithm (topo sort)
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            graph[src].add(dest);     // Directed edge from src to dest
            indegree[dest]++;         // Increment indegree of destination node
        }

        // Step 2: Initialize a DP table: dp[i][c] = max count of color `c` on any path ending at node `i`
        int[][] dp = new int[n][26];
        for (int i = 0; i < n; i++) {
            int colorIndex = colors.charAt(i) - 'a';
            dp[i][colorIndex] = 1; // A node by itself has one instance of its color
        }

        // Step 3: Initialize queue for Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i); // Start with nodes that have no incoming edges
            }
        }

        int visitedCount = 0; // To detect cycles
        int maxLength = 0;    // To track the maximum color count

        // Step 4: Process nodes in topological order
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visitedCount++; // Count how many nodes we've visited

            // Update dp values for all neighbors
            for (int neighbor : graph[node]) {
                // For each possible color (a-z), update neighbor's color count
                for (int c = 0; c < 26; c++) {
                    int add = (colors.charAt(neighbor) - 'a' == c) ? 1 : 0;
                    dp[neighbor][c] = Math.max(dp[neighbor][c], dp[node][c] + add);
                }

                // Decrease indegree and add to queue if it's 0 now
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }

            // After processing this node, update the global max
            for (int c = 0; c < 26; c++) {
                maxLength = Math.max(maxLength, dp[node][c]);
            }
        }

        // Step 5: If we didn't visit all nodes, a cycle exists => return -1
        return (visitedCount == n) ? maxLength : -1;
    }

}
