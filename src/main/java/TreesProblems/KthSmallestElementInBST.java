/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

import java.util.Scanner;

/**
 *Date: 09/28/2023
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * @author parth
 */
public class KthSmallestElementInBST {
    private Node root;
    public int count;
    public int k;
    
    public KthSmallestElementInBST(){
        this.count = 0;
        this.k = 5;
    }
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
    public int kthSmallest(){
        if(kthSmallest(root,k) == null){
            return -1;
        }
        return kthSmallest(root,k).value;
    }
    private Node kthSmallest(Node node, int k){
        if(node == null){
            return null;
        }
        Node left = kthSmallest(node.left,k); //search for it in the left hand
        count = count + 1; //increment the count 
        if(count == k){ //when count equals k return the node;
            return node;
        }
        if(left != null){ //answer is in the left hand side
            return left;
        }
        return kthSmallest(node.right,k); //answer is in the right hand side;
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
        KthSmallestElementInBST tree = new KthSmallestElementInBST();
        Scanner scanner = new Scanner(System.in);
        tree.insert(scanner);
        int answer = tree.kthSmallest();
        System.out.println("The Kth Smallest value in the tree is " + answer);
        // TODO code application logic here
    }
}
