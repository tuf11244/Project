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
public class PathSumII {

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
class PathsumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(root, targetSum, answer, temp, 0);
        return answer;
    }

    public void helper(TreeNode root, int target, List<List<Integer>> answer, List<Integer> temp, int current) {
        if (root == null) {
            return;
        }

        // Add the current node's value to the path
        temp.add(root.val);

        // Check if it's a leaf node and the path sum equals the target sum
        if (root.left == null && root.right == null && target == current + root.val) {
            answer.add(new ArrayList<>(temp));
        } else {
            // Continue the search in the left and right subtree
            helper(root.left, target, answer, temp, current + root.val);
            helper(root.right, target, answer, temp, current + root.val);
        }

        // Backtrack: remove the last node from the path
        temp.remove(temp.size() - 1);
    }
}