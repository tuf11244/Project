/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

/**
 * Date: 09/27/2023
 *https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * @author parth
 */
public class ConnectNodes {
    private Node root;
    public ConnectNodes(){
        
    }
    public Node connectNode(Node node){
        if(node == null){
            return null;
        }
        Node leftMost = node;
        while(leftMost.left!=null){
            Node current = leftMost;
            while(current!=null){
                current.left.next = current.right;
            if(current.next!=null){
                current.right.next = current.next.left;
            }
            current = current.next;
        }
            leftMost = leftMost.left;
    }
        return node;
    }

    private class Node{
        int value;
        Node left;
        Node right;
        Node next;
        
        public Node(int value){
            this.value = value;
        }
    }
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
