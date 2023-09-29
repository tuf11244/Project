/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

/**
 *Date: 09/28/2023
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * @author parth
 */
public class KthSmallestElementInBST {
    private Node root;
    public int count;
    public int k;
    
    public KthSmallestElementInBST(){
        this.count = 0;
        this.k = k;
    }
    public int kthSmallest(){
        return kthSmallest(root,k).value;
    }
    private Node kthSmallest(Node node, int k){
        if(node == null){
            return null;
        }
        Node left = kthSmallest(node.left,k); //search for it in the left hand
        count = count + 1; //increment the count 
        if(count == k){ //when count equals k return the node;
            return node;
        }
        if(left != null){ //answer is in the left hand side
            return left;
        }
        return kthSmallest(node.right,k); //answer is in the right hand side;
    }
    
    private class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
