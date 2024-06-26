/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;

/**
 *Date: 04/20/2024
 * https://leetcode.com/problems/recover-binary-search-tree/
 * @author parth
 */
public class RecoverBinarySearchTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
 /* Definition for a binary tree node.*/
class TNode {
      int val;
      TNode left;
      TNode right;
      TNode() {}
      TNode(int val) { this.val = val; }
      TNode(int val, TNode left, TNode right) {
          this.val = val;
         this.left = left;
          this.right = right;
      }
 }
class Solution {
    private TNode first;
    private TNode previous;
    private TNode middle;
    private TNode second;

    public void recoverTree(TNode root) {
     /* Intution :  There will be 2 violations or 2 nodes that we have been swapped 
       so, we have to find them nodes and just swap them. We can used InOrder traversal 
       as in Binary Tree Inorder traveral gives you a sorted Array */
       first = null;
       middle = null;
       second = null;
       previous = new TNode(Integer.MIN_VALUE);
        inOrderTraversal(root);
        //We the 2 values are not adjacent in array
        if(first != null && second != null){
            //Swap them 
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
            return;

            //When 2 values are adjacent 
        }else if(first!= null && middle!=null){
             //Swap them 
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
            return;
        }
        
}
    private void inOrderTraversal(TNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        if(previous!= null && previous.val > root.val){
            //If this is the first violation 
            //Mark first and middle nodes as previous and root 
            if(first == null){
                first = previous;
                middle = root;
            }
            else{
                //If this is the second violation
                second = root;
            }
            
        }
        previous = root;
        inOrderTraversal(root.right);

    }
}
