/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;


/**
 *https://leetcode.com/problems/longest-univalue-path/
 * @author parth
 */
public class LongestUnivaluePath {
    // Node class representing a tree node
    private class Node {
        int value; // Value of the node
        Node left; // Left child of the node
        Node right; // Right child of the node

        // Constructor to initialize the node with a value
        public Node(int value) {
            this.value = value;
        }
    }

    private Node root; // Root node of the tree
    private int maxLength = 0; // Variable to store the maximum univalue path length

    // Method to find the length of the longest univalue path
    public int longestUnivaluePath() {
        // Call the helper function to perform the calculation
        longestUnivaluePathHelper(root);
        // Return the maximum univalue path length found
        return maxLength;
    }

    // Recursive helper function to find the length of the longest univalue path
    private int longestUnivaluePathHelper(Node node) {
        // Base case: if the node is null, return 0
        if (node == null) {
            return 0;
        }

        // Recursively find the lengths of univalue paths in left and right subtrees
        int leftLength = longestUnivaluePathHelper(node.left);
        int rightLength = longestUnivaluePathHelper(node.right);

        int leftArrow = 0, rightArrow = 0;

        // If the left child has the same value as the current node, extend the left univalue path
        if (node.left != null && node.left.value == node.value) {
            leftArrow = leftLength + 1;
        }

        // If the right child has the same value as the current node, extend the right univalue path
        if (node.right != null && node.right.value == node.value) {
            rightArrow = rightLength + 1;
        }

        // Update the maximum univalue path length found so far
        maxLength = Math.max(maxLength, leftArrow + rightArrow);

        // Return the maximum length of the univalue path extending from the current node
        return Math.max(leftArrow, rightArrow);
    }

    // Main method (not used in this example)
    public static void main(String[] args) {
        // Main method, you can create a tree and call the longestUnivaluePath method here
    }
}
