/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;
import java.util.*;
/**
 *Date: 07/10/2024
 * https://leetcode.com/problems/create-binary-tree-from-descriptions/
 * @author parth
 */
public class CreateaBinaryTreeFromDesciptions {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
       Map<Integer, TreeNode> nodeMap = new HashMap<>();
        HashSet<TreeNode> children = new HashSet<>();

        // Process descriptions to create nodes and build the tree
        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;

            // Get or create the parent node
            TreeNode parent = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
            nodeMap.put(parentVal, parent);

            // Get or create the child node
            TreeNode child = nodeMap.getOrDefault(childVal, new TreeNode(childVal));
            nodeMap.put(childVal, child);

            // Set the left or right child
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            // Mark this node as a child
            children.add(child);
        }

        // The root will be the node that is not a child of any node
        for (int val : nodeMap.keySet()) {
            if (!children.contains(nodeMap.get(val))) {
                return nodeMap.get(val);
            }
        }

        return null; // Just in case there is no root (should not happen with valid input)
    }
}
