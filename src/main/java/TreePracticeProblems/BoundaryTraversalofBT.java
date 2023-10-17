/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

import java.util.Scanner;

/**
 *
 * @author parth
 */
public class BoundaryTraversalofBT {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       BoundaryTraversal tree = new BoundaryTraversal();
       Scanner scanner = new Scanner(System.in);
       tree.insert(scanner);
       
       tree.printBoundary();
        
        
    }
}
class BoundaryTraversal{
    private Node root;
    public BoundaryTraversal(){
        
    }
    public void leafNodes(){
        leafNodes(root);
    }
    private void leafNodes(Node node){
        if(node == null){
            return;
        }
        leafNodes(node.left);
        if(node.left == null && node.right == null){
            System.out.print(node.value + " ");
        }
        leafNodes(node.right);
    }
    public void leftBoundary(){
        leftBoundary(root);
    }
    private void leftBoundary(Node node){
        if(node == null){
            return;
        }
        if(node.left!= null){
         System.out.print(node.value + " ");
         leftBoundary(node.left);
        }
        else if(node.right!= null){
         System.out.print(node.value + " ");
         leftBoundary(node.right);
    }
    }
    public void rightBoundary(){
        rightBoundary(root);
    }
    private void rightBoundary(Node node){
        if(node == null){
            return;
        }
        if(node.right!= null){ 
            rightBoundary(node.right);
            System.out.print(node.value + " ");
    } else if(node.left!= null){
            rightBoundary(node.left);
            System.out.println(node.value + " ");
    }
    }    
    public void printBoundary(){
        printBoundary(root);
    }
    private void printBoundary(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value + " ");
        
        //Print left Boundary 
        leftBoundary(node.left);
        
        //Print all leaf Nodes 
        leafNodes(node.left);
        leafNodes(node.right);
        
        //Print right Boundary
        rightBoundary(node.right);
    }
    public void insert(Scanner scanner){
        System.out.println("Please enter the root value : "); 
        int value = scanner.nextInt();
        root = new Node(value);
        insert(root,scanner);
    }
    private void insert(Node node, Scanner scanner){
        System.out.println("Do you want to enter the value to left of " + node.value + " true/false");
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value to the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            insert(node.left,scanner);
        }
        System.out.println("Do you want to enter the value to right of " + node.value + " true/false");
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value to the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            insert(node.right,scanner);
        }
    }
    public void display(){
        display(root, " Root value is : ");
    }
    private void display(Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details +  node.value);
        display(node.left, " The left child of " + node.value + " is " + node.left.value);
        display(node.right, " The right child of " + node.value + " is " + node.right.value);
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
