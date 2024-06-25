/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;

/**
 *Date: 06/24/2024
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * @author parth
 */
public class BSTtoGreaterSumTree {

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
class S {
    private int sum = 0;  // Declare sum as an instance variable
    public TreeNode bstToGst(TreeNode root) {
            reverseInorderTraversal(root);
        return root;

    }
     public void reverseInorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        reverseInorderTraversal(node.right);
        sum += node.val;
        node.val = sum;
        reverseInorderTraversal(node.left);
    }
    
}