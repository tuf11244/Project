/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Date : 09/27/2023
 * We are returning level order Successor of a Node 
 * for example below is the tree 
 *                       3
 *                     4    8
 *                  12 14  7 11
 * you will be given a value to find the successor, for example if you are given a value 14 and than the successor should 7
 * as the item is right next in the queue;
 * Breadth First Search is Used
 * @author parth
 */
public class SuccessorofNode {
    private Node root;
    public SuccessorofNode(){
        
    }
    public void insert(Scanner scanner){
        System.out.println("Enter the root value ");
        int value = scanner.nextInt();
        root = new Node(value);
        insert(root,scanner);
    }
    private void insert(Node node, Scanner scanner){
        System.out.println("Do you want to enter value to the left of " + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value to the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            insert(node.left,scanner);
        }
        System.out.println("Do you want to enter value to the right of " + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value to the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            insert(node.right,scanner);
        }
    }
    private Node succesorofNode(){
        return successorofNode(root,14);
    }
    private Node successorofNode(Node node,int key){
        if(node == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            if(currentNode.left!=null){
                queue.offer(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.offer(currentNode.right);
            }
            if(currentNode.value == key){
                break;
            }
        }
        return queue.peek(); //return the value next to it;
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
       SuccessorofNode tree = new SuccessorofNode();
       Scanner scanner = new Scanner(System.in);
       tree.insert(scanner);
       Node successor = tree.succesorofNode();
       System.out.println(successor.value);
    }
}
