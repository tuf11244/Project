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
    private class TreeNode {
        int val; // Value of the node
        TreeNode left; // Left child of the node
        TreeNode right; // Right child of the node

        // Constructor to initialize the node with a value
        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode root; // Root node of the tree

    // Method to find the length of the longest univalue path
    public int longestUnivaluePath() {
        // Call the helper function to perform the calculation
        Length answer = longestUnivaluePathHelper(root);
       
        return answer.nodePath;
    }

    // Recursive helper function to find the length of the longest univalue path
    private Length longestUnivaluePathHelper(TreeNode root) {
        // Base case: if the node is null, return 0
       if(root == null){
           Length l = new Length();
           l.value = -1001;
           l.rootPath = 0;
           l.nodePath = 0;
           
           return l;
       }
       
       Length left = longestUnivaluePathHelper(root.left);
       Length right = longestUnivaluePathHelper(root.right);
       
       Length answer = new Length();
       answer.value = root.val;
       answer.rootPath  = 1;
       answer.nodePath = Math.max(left.nodePath,right.nodePath);
       
       // Calculate rootPath based on child values
        int leftPath = (root.left != null && root.left.val == root.val) ? left.rootPath + 1 : 0;
        int rightPath = (root.right != null && root.right.val == root.val) ? right.rootPath + 1 : 0;
        
        answer.rootPath = Math.max(leftPath, rightPath);
        
        // Update nodePath: longest found in subtree or leftPath + rightPath
        answer.nodePath = Math.max(answer.nodePath, leftPath + rightPath);
       
        return answer;
    }

    // Main method (not used in this example)
    public static void main(String[] args) {
        // Main method, you can create a tree and call the longestUnivaluePath method here
    }
}
class Length{
    int value;
    int rootPath; // Longest univalue path including current node
    int nodePath; //Longest univalue path excluding current node
    
    public Length(){
        
    }
    public Length(int value, int rootPath, int nodePath) {
        this.value = value;
        this.rootPath = rootPath;
        this.nodePath = nodePath;
    }
}