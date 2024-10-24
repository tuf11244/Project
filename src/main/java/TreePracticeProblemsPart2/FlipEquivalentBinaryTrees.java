/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;

/**
 *Date: 10/23/2024
 * https://leetcode.com/problems/flip-equivalent-binary-trees
 * @author parth
 */
public class FlipEquivalentBinaryTrees {

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
/*class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if(root1 == null && root2 == null){
                return true;
            }
            if((root1 == null && root2 != null) || (root1 != null && root2 == null) || root1.val != root2.val){
                return false;
            }

            

            boolean isSimilar1 = flipEquiv(root1.left, root2.left);
            boolean isSimilar2 = flipEquiv(root1.right,root2.right);
            boolean isSymmetric1 = flipEquiv(root1.left, root2.right);
            boolean isSymmetric2 = flipEquiv(root1.right,root2.left);

            return (isSimilar1 && isSimilar2) || (isSymmetric1 && isSymmetric2);
    }

    
}*/
