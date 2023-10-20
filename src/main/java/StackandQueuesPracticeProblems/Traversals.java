/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 *Date: 10/19/2023
 * https://practice.geeksforgeeks.org/problems/preorder-traversal-iterative/1
 * @author parth
 */
public class Traversals {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
class BinaryTreeTraversal{
    private Node root;
    public BinaryTreeTraversal(){
        
    }
    public void insert(Scanner scanner){
        System.out.println("Enter the root value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        insert(root,scanner);
    }
    private void insert(Node node, Scanner scanner){
        System.out.println("Do you want to enter the value to left of " + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value to left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            insert(node.left,scanner);
        }
        System.out.println("Do you want to enter the value to right of " + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value to right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            insert(node.right,scanner);
        }
    }
      public List<Integer> inOrderTraversal(){
            return inOrderTraversal(root);
      }
      private List<Integer> inOrderTraversal(Node node){
          List<Integer> result = new ArrayList<>();
          if(node == null){
              return null;
          }
          Stack<Node> stack = new Stack<>();
          Node currentNode = node;
          stack.push(currentNode);
          while(currentNode!= null || !stack.isEmpty()){
             while(currentNode!= null){
                 stack.push(currentNode);
                  currentNode = currentNode.left;
             }
             currentNode = stack.pop();
             result.add(currentNode.value);
             currentNode = currentNode.right;
          }
          return result;
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
