/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

import java.util.List;
import java.util.ArrayList;

/**
 * Date: 02/182024
 *https://leetcode.com/problems/find-leaves-of-binary-tree/
 * @author parth
 */
public class LeavesofBinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
}
    
class Solution {
    public List<List<Integer>> findLeaves(BTNode root) {
        List<List<Integer>> res = new ArrayList<>();
        BTNode prev = new BTNode(0, root, null);
        while (prev.left != null) {
            List<Integer> t = new ArrayList<>();
            dfs(prev.left, prev, t);
            res.add(t);
        }
        return res;
    }

    private void dfs(BTNode root, BTNode prev, List<Integer> t) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            t.add(root.value);
            if (prev.left == root) {
                prev.left = null;
            } else {
                prev.right = null;
            }
        }
        dfs(root.left, root, t);
        dfs(root.right, root, t);
    }
    private class BTNode{
        int value;
        BTNode left;
        BTNode right;
        public BTNode(int value){
            this.value = value;
        }
        public BTNode(int value, BTNode left, BTNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}

