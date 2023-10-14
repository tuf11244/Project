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
       
       String answer = tree.getDirections(3, 6);
        System.out.println(answer);
    }
}
class Solution6{
    private Node root;
    StringBuilder startpath = new StringBuilder();
    StringBuilder endpath = new StringBuilder();
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
    public String getDirections(int start, int end){
        return getDirections(root,start,end);
    }
    private String getDirections(Node node, int start, int end){
        
        dfs(node,start,true);
        dfs(node,end,false);
        
        startpath.reverse();
        endpath.reverse();
        int i = 0;
        int j = 0;
        
        while(i < startpath.length() && j < endpath.length()){
            if(startpath.charAt(i) == endpath.charAt(j)){
                i++;
                j++;
            } else {
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while( i  < startpath.length() ){
            sb.append("U");
            i++;
        }
        sb.append(endpath.substring(j));
        return sb.toString();
    }
    private boolean dfs(Node node, int startValue, boolean start){
        if(node == null){
            return false;
        }
        if(node.value == startValue){
            return true;
        }
        boolean left = dfs(node.left,startValue,start);
        if(left){
            if(start){
                startpath.append("L");
            } else {
                endpath.append("L");
            }
            return true;
        }
        boolean right = dfs(node.right,startValue,start);
          if(right){
            if(start){
                startpath.append("R");
            } else {
                endpath.append("R");
            }
            return true;
        }
          return false;
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
