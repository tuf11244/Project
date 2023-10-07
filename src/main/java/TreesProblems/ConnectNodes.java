/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

import java.util.LinkedList;
import java.util.Queue;

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
    public Node connectNodeUsingQueue(Node node){
        if(node == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            Node previous= null;
            for(int i = 0; i < levelSize;i++){
                Node currentNode = queue.poll();
                if(previous!=null){
                    previous.next = currentNode;
                }
                previous = currentNode;
               
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            previous.next = null;
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
