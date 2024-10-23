/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;

/**
 *Date: 10/22/2024
 *https://leetcode.com/problems/cousins-in-binary-tree-ii/
 * @author parth
 */
public class CousinsinBinaryTreeII {

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
    public TreeNode replaceValueInTree(TreeNode root) {
        //Get the levelSums 
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        List<Integer> levelSums = new ArrayList<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for(int i = 0; i < size;i++){
                TreeNode rem = queue.poll();
                sum = sum + rem.val;

                if(rem.left != null){
                    queue.add(rem.left);
                }
                if(rem.right!= null){
                    queue.add(rem.right);
                }
            }

            levelSums.add(sum);
            
        }
        //System.out.println(levelSums);
        queue.add(root);
        int level = 1;

        root.val= 0; //the root has no cousins

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size;i++){
                TreeNode rem = queue.poll();

                int siblingSum = 0;
                if(rem.left != null && rem.right != null){
                    siblingSum = rem.left.val + rem.right.val;
                }else if(rem.left!= null){
                    siblingSum = rem.left.val;
                }else if(rem.right!= null){
                    siblingSum = rem.right.val;
                }


                //Update left and right children with cousin sums
                if(rem.left!= null){
                    rem.left.val = levelSums.get(level) - siblingSum;
                    queue.add(rem.left);
                }

                if(rem.right!= null){
                    rem.right.val = levelSums.get(level) - siblingSum;
                    queue.add(rem.right);
                }

            }
            level++;
        }

        return root;
    }
}*/

