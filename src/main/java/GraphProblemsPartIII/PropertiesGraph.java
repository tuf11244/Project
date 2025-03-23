/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *Date: 03/23/2025
 * https://leetcode.com/problems/properties-graph/
 * @author parth
 */
public class PropertiesGraph {
    public static void main(String[] args) {
        
    }
    int[] parent;
    int[] rank;

    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        
        parent = new int[n];
        rank = new int[n];
        
        // Initialize both parent and rank
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;  // Same as DJSet default rank of 1
        }

        // Check all pairs and perform union if intersection count >= k
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersect(properties[i], properties[j]) >= k) {
                    union(i, j);
                }
            }
        }

        // Count unique roots to determine the number of connected components
        HashSet<Integer> uniqueRoots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uniqueRoots.add(find(i));  // Ensuring correct parent retrieval
        }

        return uniqueRoots.size();
    }

    // Find operation with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // Path compression
        }
        return parent[x];
    }

    // Union operation with rank optimization (translated from DJSet join())
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] >= rank[rootY]) {  // Equivalent to DJSet merging
                parent[rootY] = rootX;
                rank[rootX] += rank[rootY];  // Increase the rank like in DJSet
            } else {
                parent[rootX] = rootY;
                rank[rootY] += rank[rootX];  // Increase the rank like in DJSet
            }
        }
    }

    // Optimized intersection using boolean arrays (same as second implementation)
    private int intersect(int[] a, int[] b) {
        boolean[] flagA = new boolean[101];  // Given constraint: numbers are ≤ 100
        for (int num : a) {
            flagA[num] = true;
        }

        boolean[] flagB = new boolean[101];
        for (int num : b) {
            flagB[num] = true;
        }

        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (flagA[i] && flagB[i]) count++;
        }

        return count;
    }
    
}
