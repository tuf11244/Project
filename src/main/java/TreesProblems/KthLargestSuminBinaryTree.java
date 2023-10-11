/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/
 * @author parth
 */
class Solution1{
    private Node root;
    public Solution1(){
        
    }
    public void insert(Scanner scanner) {
        System.out.println("Enter the root value:");
        int value = scanner.nextInt();
        root = new Node(value);
        insert(root, scanner);
    }

    // Recursive helper method to insert nodes into the binary tree
    private void insert(Node node, Scanner scanner) {
        System.out.println("Do you want to enter a value to the left of " + node.value + "? (true/false)");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value to the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            insert(node.left, scanner);
        }
        System.out.println("Do you want to enter a value to the right of " + node.value + "? (true/false)");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value to the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            insert(node.right, scanner);
        }
    }
    
    public List<Integer>  sumAtEachLevel(){
        return sumAtEachLevel(root);
    }
    private List<Integer> sumAtEachLevel(Node node){
        List<Integer> answer = new ArrayList<>();
        if(node == null){
            return answer;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        while(!queue.isEmpty()){
          int levelSize = queue.size();
          int sum = 0;
          for(int i=0; i < levelSize;i++){
              Node currentNode = queue.poll();
              sum = sum + currentNode.value;
              if(currentNode.left!=null){
                  queue.offer(currentNode.left);
              }
              if(currentNode.left!=null){
                  queue.offer(currentNode.right);
              }
          }
         answer.add(sum);
        }
        return answer;
    }
    public int kthLargestLevelSum(int k){
        List<Integer> answer = sumAtEachLevel();
        Collections.sort(answer);
        if(k > answer.size()){
            return -1;
        }
        return answer.get(k-1);
    }
    
     private class Node {
        int value;
        Node left;
        Node right;

        // Constructor for the Node class
        public Node(int value) {
            this.value = value;
        }
    }
}
public class KthLargestSuminBinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Solution1 tree = new Solution1();
        Scanner scanner = new Scanner(System.in);
        tree.insert(scanner);
        
        List<Integer> answer = tree.sumAtEachLevel();
        System.out.println(answer);
        System.out.println(tree.kthLargestLevelSum(2));
    }
}
