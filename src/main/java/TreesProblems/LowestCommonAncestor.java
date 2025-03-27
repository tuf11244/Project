/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

/**
 *Date: 09/28/2023
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author parth
 */
public class LowestCommonAncestor {
    private Node root;
    private Node p;
    private Node q;
    private Node LCA;
    public LowestCommonAncestor(){
        
    }
    public Node lowestCommonAncestor(){
        LCA = null;
        lowestCommonAncestor(root,p,q);
        return LCA;
    }
    private boolean lowestCommonAncestor(Node node, Node p, Node q){
        if(node == null){
            return false;
        }
        boolean self = (node == p) || (node == q);
        
        boolean left = lowestCommonAncestor(node.left,p,q);
        boolean right = lowestCommonAncestor(node.right,p,q);
        
        if((left && right) || (self && left) || (self && right)){
            LCA = node;
        }
        
        return self || left || right;
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
