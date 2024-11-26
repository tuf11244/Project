/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;
import java.util.Scanner;
/**
 *Date: 09/23/2023
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * https://leetcode.com/problems/path-sum/ (Date: 09/29/2023 : function hasPathSum)
 * https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/ (Date : 11/25/2024 : function maximumPathSumLeafToLeaf())
 * @author parth
 */
public class MaximumPathSum {
    private Node root;
    public int result;
    
    public MaximumPathSum(){
        this.result = Integer.MIN_VALUE;
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
            System.out.println("Enter value to the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            insert(node.left,scanner);
        }
        System.out.println("Do you want to enter value to the right of " + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter valye to the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            insert(node.right,scanner);
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
    public int maximumPathSum(){
        maximumPathSum(root);
        return result;
    }
    private int maximumPathSum(Node node){
        if(node == null){
            return 0;
        }
        int left = maximumPathSum(node.left);
        int right = maximumPathSum(node.right);
        
        int temp = Math.max(Math.max(left, right) + node.value,node.value); //When it doesn't want to be the part
        int answer = Math.max(left+right+node.value, temp); //when it wants to be the part
        result = Math.max(result,answer);
        return temp;
    }
    public int maximumPathSumLeafToLeaf(){
        maximumPathSumLeaftoLeaf(root);
        return result;
    }
    private int maximumPathSumLeaftoLeaf(Node node){
        if(node == null){
            return 0;
        }
        int left = maximumPathSumLeaftoLeaf(node.left);
        int right = maximumPathSumLeaftoLeaf(node.right);
        
        int temp = Math.max(left, right) + node.value;
        if(node.left == null && node.right == null){
            temp = Math.max(temp,node.value);
        }
        int answer = Math.max(temp,left+right+node.value);
        result = Math.max(result, answer);
        return temp;
    }
    public boolean hasPathSum(){
        return hasPathSum(root,22);
    }
    private boolean hasPathSum(Node node, int target){
        if(node == null){
            return false;
        }
        //Found the answer
        if(node.value == target && node.left == null && node.right == null){
            return true;
        }
        //call recurssion
        return hasPathSum(node.left,target-node.value) || hasPathSum(node.right,target-node.value);
    }
    
    
    
    
    
    private class Node{
        int value;
        Node left; 
        Node right;
        
        public Node(int value){
            this.value = value;
        }
        public Node(int value,Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    
    public static void main(String args[]) {
        MaximumPathSum tree = new MaximumPathSum();
        Scanner scanner = new Scanner(System.in);
        tree.insert(scanner);
        System.out.println("Maximum Path sum " + tree.maximumPathSum());
        System.out.println("Maximum Path sum from leaf node to leaf node " + tree.maximumPathSumLeafToLeaf());
    }
}
