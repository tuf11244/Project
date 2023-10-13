/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

import java.util.Scanner;

/**
 *Date: 10/12/2023
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
 * @author parth
 */
public class MaximumProductofSplittedBinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       Solution5 tree = new Solution5();
       Scanner scanner = new Scanner(System.in);
       tree.insert(scanner);
       
       int ans = tree.maxProduct();
        System.out.println(ans);
    }
}
class Solution5{
    private Node root;
    private int maxProduct = Integer.MIN_VALUE;
    private int totalSum = 0;
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
    public int maxProduct(){
    totalSum = subtreeSum(root);
        maxProduct(root);
        return maxProduct;
    }
    private int subtreeSum(Node node){
        if(node == null){
            return 0;
        }
        int sumLeft = subtreeSum(node.left);
        int sumRight = subtreeSum(node.right);
        int subtreeSum = node.value + sumLeft + sumRight;
        totalSum = totalSum + subtreeSum;
        return subtreeSum;
    }
    
    private int maxProduct(Node node){
        if(node == null){
            return 0;
        }
         int sumLeft = maxProduct(node.left);
        int sumRight = maxProduct(node.right);
        int subtreeSum = node.value + sumLeft + sumRight;
        int product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);
        return subtreeSum;
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
