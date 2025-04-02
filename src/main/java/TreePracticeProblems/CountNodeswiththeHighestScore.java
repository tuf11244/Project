/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;
import java.util.*;
/**
 *Date: 10/13/2023
 * https://leetcode.com/problems/count-nodes-with-the-highest-score/
 * @author parth
 */
public class CountNodeswiththeHighestScore {
    public static void main(String args[]) {
       int[] parent = {-1,2,0,2,0};
          
    }
    
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;

        // Create adjacency list for parent-child relationships
        HashMap<Integer, List<Integer>> parentMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parentMap.putIfAbsent(parents[i], new ArrayList<>());
            parentMap.get(parents[i]).add(i);
        }

        // Array to store subtree sizes (memoization)
        int[] subtreeSize = new int[n];
        computeSubtreeSize(0, parentMap, subtreeSize);  // Start from root (node 0)

        long maxScore = -1;
        int maxCount = 0;

        // Calculate scores for each node
        for (int i = 0; i < n; i++) {
            long score = 1;
            int subtreeSum = 0;

            // Multiply subtree sizes of children
            if (parentMap.containsKey(i)) {
                for (int child : parentMap.get(i)) {
                    score *= subtreeSize[child];
                    subtreeSum += subtreeSize[child];
                }
            }

            // Consider remaining nodes outside the subtree
            int outsideNodes = n - subtreeSum - 1;
            if (outsideNodes > 0) {
                score *= outsideNodes;
            }

            // Update max score count
            if (score > maxScore) {
                maxScore = score;
                maxCount = 1;
            } else if (score == maxScore) {
                maxCount++;
            }
        }
        return maxCount;
    }

    // **Compute subtree sizes once (memoization)**
    private int computeSubtreeSize(int node, HashMap<Integer, List<Integer>> parentMap, int[] subtreeSize) {
        subtreeSize[node] = 1;  // Start with 1 (including the node itself)
        if (!parentMap.containsKey(node)) {
            return 1;
        }
        for (int child : parentMap.get(node)) {
            subtreeSize[node] += computeSubtreeSize(child, parentMap, subtreeSize);
        }
        return subtreeSize[node];
    }
}
