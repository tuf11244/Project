/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
 * Date:10/13/2023
 * @author parth
 */
public class FlipBinaryTreeToMatchPreOrderTraversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Solution7 tree = new Solution7();
        tree.insert(scanner);
        
        List<Integer> Voyage = new ArrayList<>();
        Voyage.add(1);
        Voyage.add(3);
        Voyage.add(2);
        List<Integer> result = tree.flipMatchVoyage(Voyage);
        
        System.out.println(result);
                
    }
}

class Solution7{
    private Node root;
    private int index = 0;
    public Solution7(){
        
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
  
    public List<Integer> flipMatchVoyage(List<Integer> Voyage){
        List<Integer> result = new ArrayList<>();
        if(flipMatchVoyage(root,Voyage,result)){
            return result;
        }else{
            result.clear();
            result.add(-1);
            return result;
        }
    }
    private boolean flipMatchVoyage(Node node, List<Integer> Voyage, List<Integer> result){
        if(node == null){
            return true;
        }
        if(node.value!=Voyage.get(index)){
            return false;
        }
        
        index = index + 1;
        
        if (node.left != null && node.left.value != Voyage.get(index)) {
        result.add(node.value); // Add the current node's value to the result list
        // Recursively flip the right and left subtrees
        return flipMatchVoyage(node.right, Voyage, result) && flipMatchVoyage(node.left, Voyage, result);
    } else {
        // If no flipping is needed, continue checking the left and right subtrees
        return flipMatchVoyage(node.left, Voyage, result) && flipMatchVoyage(node.right, Voyage, result);
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
