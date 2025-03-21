/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphProblemsPartIII;

/**
 *Date: 03/20/2025
 * https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/
 * @author parth
 */
public class MinimumCostWalkinWeightedGraph {
    
    int[] parent;
    int[] rank;
    int[] minWeight;  // Tracks minimum weight for each component
    
    public int[] minimumCost(int n, int[][] edges, int[][] queries) {
        parent = new int[n];
        rank = new int[n];
        minWeight = new int[n];
        
        // Initialize arrays
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;  // Rank starts at 0
            minWeight[i] = (1 << 30) - 1;  // Initialize with all 1s (max possible AND result)
        }
        
        // Process all edges first
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            int pu = find(u);
            int pv = find(v);
            
            if(pu != pv) {
                // Only update weight when actually merging components
                merge(pu, pv);
                minWeight[find(u)] &= w;  // Update weight after merge
            } else {
                // If already in same component, still need to update weight
                minWeight[pu] &= w;
            }
        }
        
        // Process queries
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            int pu = find(u);
            int pv = find(v);
            
            answer[i] = (pu == pv) ? minWeight[pu] : -1;
        }
        
        return answer;
    }
    
    public void merge(int x, int y) {
        if(rank[x] < rank[y]) {
            parent[x] = y;
            minWeight[y] &= minWeight[x];  // Combine weights
        } else if(rank[x] > rank[y]) {
            parent[y] = x;
            minWeight[x] &= minWeight[y];
        } else {
            parent[y] = x;
            rank[x]++;
            minWeight[x] &= minWeight[y];
        }
    }
    
    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);  // Path compression
        }
        return parent[x];
    }
}