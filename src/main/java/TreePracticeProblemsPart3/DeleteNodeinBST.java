/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TreePracticeProblemsPart3;

/**
 *Date: 03/21/2025
 * https://leetcode.com/problems/delete-node-in-a-bst/
 * Kinda Similar as Inorder Successor of BST
 * @author parth
 */
public class DeleteNodeinBST  extends TreeNodes{
    public static void main(String[] args) {
        
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key); // Recur to left subtree
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key); // Recur to right subtree
        } else {
            // Node to be deleted found

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Two children → Find inorder successor (smallest in right subtree)
            TreeNode successor = findMin(root.right);
            root.val = successor.val; // Copy the successor's value
            root.right = deleteNode(root.right, successor.val); // Delete the successor
        }

        return root;
    }

    // Helper function to find the smallest value in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
