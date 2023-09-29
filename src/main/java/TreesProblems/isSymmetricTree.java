/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 09/28/2023
 *https://leetcode.com/problems/symmetric-tree/
 * @author parth
 */
public class isSymmetricTree {
    private Node root;
    public isSymmetricTree(){
        
    }
    public boolean isSymmetricTree(){
        return isSymmetricTree(root,root);
    }
    private boolean isSymmetricTree(Node left, Node right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.value!=right.value){
            return false;
        }
        return isSymmetricTree(left.left,right.right) && isSymmetricTree(left.right,right.left);
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
