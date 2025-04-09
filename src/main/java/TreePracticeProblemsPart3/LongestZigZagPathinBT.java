/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TreePracticeProblemsPart3;

/**
 * Date: 04/08/2025
 * Problem: https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 * 
 * Objective: Given a binary tree, return the length of the longest ZigZag path.
 * A ZigZag path starts at any node and alternates between going left and right at each step.
 * 
 * Example of a ZigZag:
 *     1
 *      \
 *       2
 *      /
 *     3
 *      \
 *       4
 * The ZigZag path here is 1 -> 2 -> 3 -> 4 with 3 direction changes (length = 3).
 * 
 * @author parth
 */
public class LongestZigZagPathinBT extends TreeNodes {
    
    // Main function to be called which returns the length of the longest ZigZag path
    public int longestZigZag(TreeNode root){
        Values v = helper(root);  // Perform DFS and compute Values for the whole tree
        return v.maxLength;       // Return the global max length
    }

    /**
     * Helper function that does post-order traversal (bottom-up) and returns:
     * - forwardSlope: max ZigZag starting by going to the left from current node
     * - backwardSlope: max ZigZag starting by going to the right from current node
     * - maxLength: maximum ZigZag path seen so far in the subtree rooted at current node
     */
    public Values helper(TreeNode root){
        // Base case: if the node is null, return default Values with slope = -1, maxLength = 0
        if(root == null){
            return new Values();
        }
        
        // Recurse on left and right children
        Values left = helper(root.left);
        Values right = helper(root.right);
        
        // Create a new Values object to store results for current node
        Values answer = new Values();
        
        // Compute the maxLength seen so far:
        // Either it's in the left subtree, right subtree,
        // or it's a ZigZag formed by left.backwardSlope -> current node -> right.forwardSlope
        answer.maxLength = Math.max(Math.max(left.maxLength, right.maxLength),
                                    Math.max(left.backwardSlope, right.forwardSlope) + 1);
        
        // Update the forwardSlope:
        // If we go left from this node, the next move should be to the right (i.e., left.backwardSlope + 1)
        answer.forwardSlope = left.backwardSlope + 1;
        
        // Update the backwardSlope:
        // If we go right from this node, the next move should be to the left (i.e., right.forwardSlope + 1)
        answer.backwardSlope = right.forwardSlope + 1;
        
        return answer;  // Return result for current node
    }
}

// Class to store forward and backward slope values, and max length seen so far
class Values {
    int forwardSlope = -1;  // ZigZag length if we go left first
    int backwardSlope = -1; // ZigZag length if we go right first
    int maxLength = 0;      // Max ZigZag length in subtree
}
