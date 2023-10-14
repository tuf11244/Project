/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

/**
 *Date: 10/13/2023
 * https://leetcode.com/problems/count-nodes-with-the-highest-score/
 * @author parth
 */
public class CountNodeswiththeHighestScore {
    public static void main(String args[]) {
       int[] parent = {-1,2,0,2,0};
       Solution9 tree = new Solution9(parent);
       
        System.out.println(tree.countNodewithHighestScore());
    }
}
class Solution9{
    private Node root;
    private int[] parent;
    // Variable to store the maximum score found in the tree
    private int maxScore = Integer.MIN_VALUE;
    // Variable to store the count of nodes with the maximum score
    private int count = 0;
    public Solution9(int[] parent){
        this.parent = parent;
        this.root = buildTree(parent);
    }
    private Node buildTree(int[] parent){
        Node[] nodes = new Node[parent.length];
       for(int i = 0; i < parent.length;i++){
           nodes[i] = new Node(i);
       }
       for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                Node parentNode = nodes[parent[i]];
                if (parentNode.left == null) {
                    parentNode.left = nodes[i];
                } else {
                    parentNode.right = nodes[i];
                }
            }
        }
        return nodes[0];
    }
    public int countNodewithHighestScore(){
        return countNodewithHighestScore(root);
    }
    private int countNodewithHighestScore(Node node){
      // Reset count and maxScore before processing the tree
        count = 0;
        maxScore = Integer.MIN_VALUE;
        // Call the recursive function to find the maximum score in the tree
        findMaxScore(root);
        // Return the count of nodes with the highest score
        return count;      
    }
    private void findMaxScore(Node node){
          // Base case: if the node is null, return
        if (node == null) {
            return;
        }
        // Update maxScore with the maximum value found so far
        maxScore = Math.max(maxScore, node.value);
        // If the node's value is equal to maxScore, increment the count
        if (node.value == maxScore) {
            count++;
        }
        // Recur for the left and right subtrees
        findMaxScore(node.left);
        findMaxScore(node.right);
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
