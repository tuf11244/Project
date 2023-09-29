/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

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
               temp = temp.right;
           }
           
           temp.right = currentNode.right;
           currentNode.right = currentNode.left;
           currentNode.left = null;
        }
            currentNode = currentNode.right;
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
