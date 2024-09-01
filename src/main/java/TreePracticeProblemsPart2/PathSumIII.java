/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;
import java.util.*;
/**
 *
 * @author parth
 */
public class PathSumIII {

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
    public HashMap<Long, Integer> hm;
    public int count;
    public long sum;
    
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        hm = new HashMap<>();
        hm.put(0L, 1); // Use 0L to indicate long type
        count = 0;
        sum = 0;
        function(root, targetSum);
        return count;
    }

    public void function(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        
        sum += root.val;
        
        // Check if there's a subpath that sums up to target
        if (hm.containsKey(sum - target)) {
            count += hm.get(sum - target);
        }
        
        // Add the current sum to the map
        hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        
        // Explore the left and right subtrees
        function(root.left, target);
        function(root.right, target);
        
        // Backtrack: Remove the current sum from the map
        hm.put(sum, hm.get(sum) - 1);
        sum -= root.val;
    }
}
