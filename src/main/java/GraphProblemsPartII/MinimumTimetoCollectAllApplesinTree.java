/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 11/07/2024
 * https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
 * @author parth
 */
public class MinimumTimetoCollectAllApplesinTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // Build the adjacency list
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            graph[src].add(dest);
            graph[dest].add(src);
        }
        
        // Call DFS from the root node (0), assuming -1 as the parent of root
        return dfs(0, -1, graph, hasApple);
    }
    
    // DFS function to calculate the minimum time to collect apples
    private int dfs(int node, int parent, List<Integer>[] graph, List<Boolean> hasApple) {
        int totalTime = 0;
        
        // Traverse all neighbors except the parent to avoid cycles
        for (int neighbor : graph[node]) {
            if (neighbor == parent) continue;
            
            // Recursively calculate time for the subtree rooted at the neighbor
            int timeForSubtree = dfs(neighbor, node, graph, hasApple);
            
            // If there’s an apple in the subtree or in this node, add 2 to the time
            if (timeForSubtree > 0 || hasApple.get(neighbor)) {
                totalTime += timeForSubtree + 2;
            }
        }
        
        return totalTime;
    }
}
