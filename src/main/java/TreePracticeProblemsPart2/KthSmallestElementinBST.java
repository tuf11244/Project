/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;

import java.util.PriorityQueue;

/**
 *Date: 04/18/2024
 *https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * @author parth
 */
public class KthSmallestElementinBST {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        helper(root,pq);
        System.out.println(pq);
        if(k == 1){
            return pq.peek();
        }
        while(k > 1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
    public void helper(TreeNode root, PriorityQueue pq){
        if(root == null){
            return;
        }
        helper(root.left,pq);
        pq.add(root.val);
        //Recursion Calls
        helper(root.right,pq);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
