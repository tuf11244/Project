/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

/**
 * Date: 09/27/2023
 *https://leetcode.com/problems/cousins-in-binary-tree/
 * @author parth
 */
public class CousinsinBinaryTree {
    private Node root;
    public CousinsinBinaryTree(){
        
    }
    public boolean isCousins(Node node,int x, int y){
        Node xx = findNode(node,x);
        Node yy = findNode(node,y);
        
        return (level(node,xx,0) == level(node,yy,0)) && (!isSibling(root,xx,yy));
    }
    private Node findNode(Node node, int x){
        if(node == null){
            return null;
        }
        if(node.value == x){
            return node;
        }
        Node n = findNode(node.left,x);
        if(n!=null){
            return n;
        }
        return findNode(node.right,x);
    }
    private int level(Node node, Node x,int level){
       if(node == null){
           return 0;
       }
       if(node == x){
           return level;
       }
       int l = level(node.left,x,level+1);
       if(l!=0){
           return l;
       }
       return level(node.right,x,level+1);
    }
    private boolean isSibling(Node node, Node x, Node y){
        if(node == null){
            return false;
        }
        return ((node.left == x && node.right == y) || (node.left == y && node.right == x) || 
                isSibling(node.left,x,y) || isSibling(node.right,x,y));
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
