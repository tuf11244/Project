/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

import java.util.Scanner;
import java.util.*;
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
       
        
    }
}
class BoundaryTraversal{
    private Node root;
    private List<Integer> left;
    private List<Integer> right;
    private List<Integer> boundary;
    public BoundaryTraversal(){
        
        boundaryTraversal(root);
        
    }
    
    public void  boundaryTraversal(Node node){
        List<Integer> answer = new ArrayList<>();
        
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){
            answer.add(node.value);
        }
        
        answer.add(node.value);
        left = new ArrayList<>();
        right = new ArrayList<>();
        boundary = new ArrayList<>();
        
        
        getLeftBoundary(node.left);
        getRightBoundary(node.right);
        getLeafNodes(node);
        
        for(int i = 0; i < left.size();i++){
            answer.add(left.get(i));
        }
        for(int i = 0; i < boundary.size();i++){
            answer.add(boundary.get(i));
        }
        
        for(int i = right.size()-1; i >= 0; i--){
            answer.add(right.get(i));
        }   
        
        System.out.println(answer);
    }
    
    public void getLeftBoundary(Node node){
        if(node == null){
            return;
        }
        while(node.left != null || node.right != null){
             
            if(node.left != null){
                left.add(node.value);
                node = node.left;
            }else if(node.right != null){
                left.add(node.value);
                node = node.right;
            }
                
        }
    }
    public void getRightBoundary(Node node){
        if(node == null){
            return;
        }
        while(node.left != null || node.right != null){
             
            if(node.right != null){
                right.add(node.value);
                node = node.right;
            }else if(node.left != null){
                right.add(node.value);
                node = node.left;
            }
                
        }
    }
    public void getLeafNodes(Node node){
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){
            boundary.add(node.value);
            return;
        }
        
        getLeafNodes(node.left);
        getLeafNodes(node.right);
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
