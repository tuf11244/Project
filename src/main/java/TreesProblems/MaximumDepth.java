/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

/**
 *Date: 09/28/2023
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * @author parth
 */
public class MaximumDepth {
    private Node root;
    public MaximumDepth(){
        
    }
    public int maximumDepth(){
        return maximumDepth(root);
    }
    private int maximumDepth(Node node){
        if(node == null){
            return 0;
        }
        int left = maximumDepth(node.left);
        int right = maximumDepth(node.right);
        
        return Math.max(left, right) + 1;
    }
    public int minimumDepthofTree(){
        return minimumDepthofTree(root);
    }
    private int minimumDepthofTree(Node node){
        if(node == null){
            return 0;
        }
        
        int left = minimumDepthofTree(node.left);
        int right = minimumDepthofTree(node.right);
        if(left == 0 || right == 0){
            return Math.max(left, right) + 1;
        }
       
        return Math.min(left, right) + 1;
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
