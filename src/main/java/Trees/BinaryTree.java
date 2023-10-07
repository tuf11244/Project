/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Trees;

import java.util.Scanner;

/**
 *Date: 09/19/2023
 * @author parth
 */
public class BinaryTree {
    private Node root;
    
    public BinaryTree(){
        
    }
    //insert Elements
    public void insert(Scanner scanner){
        System.out.println("Enter the root node value : ");
        int value = scanner.nextInt();
        root = new Node(value);
        insert(scanner,root);
    }
    private void insert(Scanner scanner, Node node){
        System.out.println("Do you want to enter left of :" + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of :" + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            insert(scanner,node.left);
        }
        System.out.println("Do you want to enter right of : " + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of :" + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            insert(scanner, node.right); 
        }      
    }
    public void display(){
        display(root," ");
    }

    private void display(Node node, String indent) {
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");       
    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value + "-->");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + "--->");
        inOrder(node.right);
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + "--->");
        
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
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.insert(scanner);
        tree.display();
        tree.preOrder();
        System.out.println("");
        tree.inOrder();
        System.out.println("");
        tree.postOrder();
        
        // TODO code application logic here
    }
}
