/*
 * Class to recover a binary tree from preorder traversal with dashes indicating depth.
 */
package TreePracticeProblemsPart3;

/**
 * Date: 02/21/2025
 * https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
 * @author Parth
 */
public class RecoverATreeFromPreOrderTraversal extends TreeNodes {
    
    /**
     * Main function to start the tree reconstruction process.
     * @param traversal - The string representation of preorder traversal.
     * @return The root node of the reconstructed binary tree.
     */
    public TreeNode recoverFromPreOrder(String traversal) {
        int[] index = new int[1]; // Pass-by-reference index to track traversal position.
        return helper(traversal, index, 0);
    }
    
    /**
     * Recursive function to reconstruct the tree from preorder traversal.
     * @param traversal - The input preorder string.
     * @param index - Array storing the current index position in traversal string.
     * @param level - The expected depth (number of dashes before a value).
     * @return The constructed TreeNode for the current subtree.
     */
    public TreeNode helper(String traversal, int[] index, int level) {
        
        // Base Case: If we have processed the entire string, return null.
        if (index[0] >= traversal.length()) {
            return null;
        }
        
        // Count the number of dashes (indicating tree depth).
        int numDashes = 0;
        while (index[0] < traversal.length() && traversal.charAt(index[0]) == '-') {
            numDashes++;
            index[0]++;
        }
        
        // If the depth of the current node is incorrect, backtrack.
        if (numDashes != level) {
            index[0] -= numDashes; // Reset index to where dashes started.
            return null;
        }
        
        // Extract the numerical value of the node.
        int val = 0;
        while (index[0] < traversal.length() && Character.isDigit(traversal.charAt(index[0]))) {
            val = val * 10 + (traversal.charAt(index[0]) - '0'); // Convert character to integer.
            index[0]++;
        }
        
        // Create the current node.
        TreeNode root = new TreeNode(val);
        
        // Recursively construct the left and right subtrees.
        root.left = helper(traversal, index, level + 1);
        root.right = helper(traversal, index, level + 1);
        
        // Return the constructed subtree.
        return root;
    }
}
