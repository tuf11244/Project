/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;
import java.util.*;
/**
 *Date: 06/26/2024
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 * @author parth
 */
public class BalanceaBST {

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
class Soln {
    public Node balanceBST(Node root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        Node node = construct(0,list.size()-1,list);
        return node;
    }
    
    public void inorderTraversal(Node root, List<Integer> list){
        if(root == null){
            return;
        }
        inorderTraversal(root.left,list);
        list.add(root.val);
        inorderTraversal(root.right,list);
    }

    public Node construct(int left,int right, List<Integer> list){
            if(left > right){
                return null;
            }
            int mid = left + (right - left)/2;
            Node root = new Node(list.get(mid));
            root.left = construct(left,mid-1,list);
            root.right = construct(mid+1,right,list);
            return root;
    }
}