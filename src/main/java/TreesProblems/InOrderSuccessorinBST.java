/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

import java.util.Scanner;

/**
 *https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 * @author parth
 */
public class InOrderSuccessorinBST {
    private Node root;
    private Node target;
    public InOrderSuccessorinBST(){
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
    public Node InOrderSuccessorinBST(){
        return InOrderSuccessorinBST(root,root.left);
    }
    private Node InOrderSuccessorinBST(Node node, Node target){
        Node successor = null; //Node to hold the successor value
        
        //
        while(node!=null){
            //Case 1 : if the node.value is larger than the target value
            if(target.value < node.value){
                successor = node; //update the successor and move to the left child;
                node = node.left;  //traverse over to the left subtree              
        }  //Case 2 : if the node.value is smaller than the target value 
        else if(target.value > node.value){
                node = node.right;  //traverse over the right subtree
                }
            //Case 3 : if the node. value is equal to target.value 
        else{
            //if the current node has a right child, find minimum in right subtree
            if(node.right!=null){
                successor = findMin(node.right);
            }
            break;
        }
           
    }
        return successor;
    }
    private Node findMin(Node node){
        while(node.left!=null){
            node = node.left;
        }
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
        InOrderSuccessorinBST tree = new InOrderSuccessorinBST();
        Scanner scanner = new Scanner(System.in);
        tree.insert(scanner);
        
        Node successor = tree.InOrderSuccessorinBST();
        System.out.println("The successor of the node is " + successor.value);
        
    }
}
