/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

import java.util.Scanner;
import java.util.HashMap;

/**
 *Date: 10/17/2023
 * https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/
 * @author parth
 */
public class KthAncestorinaBT {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      Scanner scanner = new Scanner(System.in);
      Ancestor tree = new Ancestor();
      tree.insert(scanner);
      
        System.out.println(tree.kthAncestor(1));
      
    }
}
class Ancestor{
    private Node root;
    
    public Ancestor(){
        
    }
    public int kthAncestor(int k){
        return kthAncestor(root.left.left,k);
    }
    private int kthAncestor(Node node, int k){
       if(node == null){
           return -1;
       }
       HashMap<Node,Node> parent = new HashMap<Node,Node>();
       preOrder(root,parent);
       Node currentNode = node;
       while(currentNode!= null & k > 0){
           currentNode = parent.get(currentNode);
           k--;
       }      
       if(currentNode == null){
           return -1;
       }
       return currentNode.value;
    }
    private void preOrder(Node node,HashMap<Node,Node> parent){
        if(node == null){
            return;
        }
        if(node.left!=null){
            parent. put(node.left, node); //Store the left children and the parent
        }
        if(node.right!=null){
            parent.put(node.right, node); //Store the right children and the parent
        }       
        preOrder(node.left,parent);
        preOrder(node.right,parent);
        
    }
    public void insert(Scanner scanner){
        System.out.println("Enter the root value :");
        int value = scanner.nextInt();
        root = new Node(value);
        insert(root,scanner);
    }
    private void insert(Node node, Scanner scanner){
        System.out.println("Do you want to enter the value to the left of " + node.value + "(true/false)");
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value to the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            insert(node.left,scanner);
        }
        System.out.println("Do you want to enter the value to the right of " + node.value + "(true/false)");
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value to the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            insert(node.right,scanner);
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
}
