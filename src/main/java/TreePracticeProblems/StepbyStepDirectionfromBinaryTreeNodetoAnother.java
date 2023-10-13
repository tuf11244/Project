/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

import java.util.Scanner;

/**
 * Date: 10/13/2023
 *https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
 * @author parth
 */
public class StepbyStepDirectionfromBinaryTreeNodetoAnother {

    public static void main(String args[]) {
       Solution6 tree = new Solution6();
       Scanner scanner = new Scanner(System.in);
       tree.insert(scanner);
       
       String answer = tree.directions(5);
        System.out.println(answer);
    }
}
class Solution6{
    private Node root;
    public Solution6(){
        
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
    public String directions(int start){
        return directionsfromNodetoStart(root,start);
    }
   public String directionsfromNodetoStart(Node node, int start) {
    if (node == null) {
        return "";
    }
    
    if (node.value == start) {
        return "";
    }
    
    String left = directionsfromNodetoStart(node.left, start);
    if (!left.isEmpty()) {
        return "L" + left;
    }
    
    String right = directionsfromNodetoStart(node.right, start);
        return "R" + right;
   }
   public String directionfromNodetoEnd(Node node, int end){
       if (node == null) {
        return "";
    }
    
    if (node.value == end) {
        return "";
    }
    
    String left = directionsfromNodetoStart(node.left, end);
    if (!left.isEmpty()) {
        return "L" + left;
    }
    
    String right = directionsfromNodetoStart(node.right, end);
        return "R" + right; 
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
