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
    public LowestCommonAncestor(){
        
    }
    public Node lowestCommonAncestor(){
        return lowestCommonAncestor(root,p,q);
    }
    private Node lowestCommonAncestor(Node node, Node p, Node q){
        if(node == null){
            return null;
        }
        if(node == p || node == q){
            return node;
        }
        Node left = lowestCommonAncestor(node.left,p,q);
        Node right = lowestCommonAncestor(node.right,p,q);
        
        if(left!=null && right!=null){
            return node;
        }
        if(left == null){
            return right;
        }
        return left;
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
