/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *Date: 01/25/2025
 * https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/
 * @author parth
 */
public class MakeLexicographicallySmallestArrayBySwappingElements {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    // Arrays to keep track of parent and rank for union-find
    int[] parent;
    int[] rank;

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        parent = new int[n];
        rank = new int[n];

        // Initialize the parent and rank arrays for union-find
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // Create an array of Element objects to store value-index pairs
        Element[] elements = new Element[n];
        for (int i = 0; i < n; i++) {
            elements[i] = new Element(nums[i], i);
        }

        // Sort the elements based on their value (natural ordering)
        Arrays.sort(elements);

        // Iterate through the sorted elements and merge indices within the limit
        for (int i = 1; i < n; i++) {
            if (Math.abs(elements[i].value - elements[i - 1].value) <= limit) {
                int parent1 = find(elements[i].index);
                int parent2 = find(elements[i - 1].index);
                if (parent1 != parent2) {
                    merge(parent1, parent2);
                }
            }
        }

        // Create a HashMap to group elements by their connected components
        HashMap<Integer, List<Element>> groupedElements = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            groupedElements.computeIfAbsent(root, k -> new ArrayList<>())
                           .add(new Element(nums[i], i));
        }

        // Prepare the final answer array
        int[] answer = new int[n];
        for (List<Element> group : groupedElements.values()) {
            // Extract values and indices of the group
            int[] values = new int[group.size()];
            int[] indices = new int[group.size()];
            for (int i = 0; i < group.size(); i++) {
                values[i] = group.get(i).value;
                indices[i] = group.get(i).index;
            }

            // Sort both the values and indices arrays
            Arrays.sort(values);
            Arrays.sort(indices);

            // Map sorted values back to their sorted indices in the answer
            for (int i = 0; i < indices.length; i++) {
                answer[indices[i]] = values[i];
            }
        }

        return answer;
    }

    // Find function with path compression for union-find
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    // Union function with rank optimization for union-find
    private void merge(int x, int y) {
        if (rank[x] > rank[y]) {
            parent[y] = x;
        } else if (rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[x] = y;
            rank[y]++;
        }
    }
}

// Class to store elements with value and index, replacing Pair
class Element implements Comparable<Element> {
    int value;
    int index;

    public Element(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Element other) {
        return Integer.compare(this.value, other.value);
    }
}


