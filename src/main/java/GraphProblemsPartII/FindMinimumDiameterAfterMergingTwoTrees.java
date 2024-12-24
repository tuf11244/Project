/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 12/23/2024
 * https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/
 * @author parth
 */
public class FindMinimumDiameterAfterMergingTwoTrees {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int diameter1 = treeDiameter(edges1);
        int diameter2 = treeDiameter(edges2);

        // Maximum of the existing diameters or the new diameter after merging
        int answer = Math.max(
            Math.max(diameter1, diameter2), 
            (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1
        );

        return answer;
    }

    public static int treeDiameter(int[][] edges) {
        int n = edges.length + 1;

        // Build the adjacency list
        List<List<Integer>> adj = buildGraph(edges, n);

        // Find the tree's diameter using DFS
        int[] diameter = {0}; // Use an array to hold the diameter as it's mutable
        boolean[] visited = new boolean[n];
        dfs(adj, visited, 0, diameter);

        return diameter[0];
    }

    private static List<List<Integer>> buildGraph(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
        return adj;
    }

    private static int dfs(List<List<Integer>> adj, boolean[] visited, int node, int[] diameter) {
        visited[node] = true;

        int firstChild = 0, secondChild = 0;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                int subtreeHeight = dfs(adj, visited, neighbor, diameter);

                // Update the two largest heights
                if (subtreeHeight > firstChild) {
                    secondChild = firstChild;
                    firstChild = subtreeHeight;
                } else if (subtreeHeight > secondChild) {
                    secondChild = subtreeHeight;
                }
            }
        }

        // Update the diameter
        diameter[0] = Math.max(diameter[0], firstChild + secondChild);

        return firstChild + 1;
    }
}
