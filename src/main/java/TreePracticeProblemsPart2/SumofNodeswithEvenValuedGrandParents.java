/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;
import java.util.*;
/**
 *Date: 07/24/2024
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * @author parth
 */
public class SumofNodeswithEvenValuedGrandParents {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}


class GrandParents {
    public int sum;
    public int sumEvenGrandparent(TreeNode root) {
        HashMap<TreeNode,TreeNode> hm = new HashMap<>();
        getParents(root,null,hm);
        sum = 0;
        inOrder(root,hm);
        return sum;
    }
    public void getParents(TreeNode root, TreeNode parent, HashMap<TreeNode,TreeNode> hm){
        if(root == null){
            return;
        }
        hm.put(root,parent);
        getParents(root.left,root,hm);
        getParents(root.right,root,hm);
    }

    public void inOrder(TreeNode root,HashMap<TreeNode,TreeNode> hm){
      if (root == null) {
            return;
        }

        inOrder(root.left, hm);

        TreeNode parent = hm.getOrDefault(root, null);
        TreeNode grandParent = hm.getOrDefault(parent, null);

        if (grandParent != null && grandParent.val % 2 == 0) {
            sum += root.val;
        }

        inOrder(root.right, hm);
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
