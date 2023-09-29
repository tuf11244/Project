/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

/**
 *Date: 09/28/2023
 * https://leetcode.com/problems/invert-binary-tree/
 * @author parth
 */
public class InvertBinaryTree {
    private Node root;
    public InvertBinaryTree(){
        
    }
    public Node invertBinaryTree(){
        return invertBinaryTree(root);
    }
    private Node invertBinaryTree(Node node){
        if(node == null){
            return null;
        }
        //swap the value 
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        //Recursively call the function
        invertBinaryTree(node.right);
        invertBinaryTree(node.left);
        
        return node;
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
