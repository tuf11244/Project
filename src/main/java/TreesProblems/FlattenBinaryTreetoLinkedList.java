/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 09/28/2023
 *https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * @author parth
 */
public class FlattenBinaryTreetoLinkedList {
    private Node root;
    public FlattenBinaryTreetoLinkedList(){
        
    }
    public void flatten(){
        flatten(root);
    }
    private void flatten(Node node){
        if(node == null){
            return;
        }
        Node currentNode = node;
        while(currentNode!=null){
            if(currentNode.left!=null){
            Node temp = currentNode.left;
           while(temp.right!=null){
               temp = temp.right; //Find the right most avalaible Node
           }
           
           temp.right = currentNode.right; //Move all the elements from right to the temp.right
           currentNode.right = currentNode.left; //Start moving the first elemet from left to right 
           currentNode.left = null; //Assing currentNdoe.left equal to null
        }
            currentNode = currentNode.right; //Traverse along the path
    }
    }    
    public void flattenBadSolution(){
        flatten(root);
    }
    private void flatteBadSolution(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node); //Add the root the root node
    
        while(!queue.isEmpty()){  //Traverse the entire tree 
           Node currentNode = queue.poll();  //Take current Node as the root node 
            if(currentNode.left!=null){  //Store the values in the queue
                queue.offer(currentNode);
            }
            if(currentNode.right!=null){  //Store the values in the queue
                queue.offer(currentNode);

            }
            if(!queue.isEmpty()){
                currentNode.right = queue.peek();
            }
            currentNode.left = null;
        }
        
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
