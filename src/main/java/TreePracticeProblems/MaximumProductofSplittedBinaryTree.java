/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

import java.util.Scanner;

/**
 *Date: 10/12/2023
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
 * @author parth
 */
public class MaximumProductofSplittedBinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       Solution5 tree = new Solution5();
       Scanner scanner = new Scanner(System.in);
      
 
    }
}
class Solution5{
    public int MOD = (int)1e9 + 7;
    public long SUM;
    public long maxP;

    public int maxProduct(Node root) {
        if (root == null) {
            return 0;
        }

        // Calculate the total sum of the tree
        SUM = totalSum(root);

        // Calculate the maximum product
        find(root);

        // Return the result with modulo
        return (int)(maxP % MOD);
    }

    public long find(Node root) {
        if (root == null) {
            return 0;
        }

        // Get the sum of left and right subtrees
        long left = find(root.left);
        long right = find(root.right);

        // Calculate the sum of the current subtree
        long subTreeSum = root.value + left + right;

        // Calculate the remaining sum (totalSum - subTreeSum)
        long remainingSum = SUM - subTreeSum;

        // Update max product
        maxP = Math.max(maxP, remainingSum * subTreeSum);

        return subTreeSum;
    }

    public long totalSum(Node root) {
        if (root == null) {
            return 0;
        }
        // Recursively calculate the sum of left and right subtrees
        long left = totalSum(root.left);
        long right = totalSum(root.right);

        // Return the total sum of the current subtree
        return root.value + left + right;
    }
    private class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
}
