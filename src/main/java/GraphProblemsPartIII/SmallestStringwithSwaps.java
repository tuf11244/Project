/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *Date: 01/24/2024
 * https://leetcode.com/problems/smallest-string-with-swaps/
 * @author parth
 */
public class SmallestStringwithSwaps {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    int[] parent;
    int[] rank;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        rank = new int[n];

        // Initialize Union-Find
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // Merge pairs
        for (List<Integer> pair : pairs) {
            int parent1 = find(pair.get(0));
            int parent2 = find(pair.get(1));
            if (parent1 != parent2) {
                merge(parent1, parent2);
            }
        }

        // Group indices by connected component
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            hm.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        // Create a mutable char array for the result
        char[] result = s.toCharArray();

        // Sort characters within each group
        for (List<Integer> group : hm.values()) {
            List<Character> chars = new ArrayList<>();
            for (int index : group) {
                chars.add(result[index]);
            }
            Collections.sort(chars);
            Collections.sort(group);

            // Place sorted characters back
            for (int i = 0; i < group.size(); i++) {
                result[group.get(i)] = chars.get(i);
            }
        }

        return new String(result);
    }

    // Find function with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by rank
    public void merge(int lx, int ly) {
        if (rank[lx] > rank[ly]) {
            parent[ly] = lx;
        } else if (rank[lx] < rank[ly]) {
            parent[lx] = ly;
        } else {
            parent[lx] = ly;
            rank[ly]++;
        }
    }
}


