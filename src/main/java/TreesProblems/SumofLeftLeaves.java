/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *https://leetcode.com/problems/sum-of-left-leaves/
 * Date:10/08/2023
 * @author parth
 */
public class SumofLeftLeaves {
    private Node root;
    public SumofLeftLeaves(){
        
    }
    public int sumOfLeftLeaves(){
        return sumofLeftLeaves(root);
    }
    private int sumofLeftLeaves(Node node){
       int sum = 0;
       List<Integer> answer = new ArrayList<>();
       if(node == null){
           return 0;
       }
       Queue<Node> queue = new LinkedList<>();
       queue.offer(node);
       while(!queue.isEmpty()){
           Node currentNode = queue.poll();
           if(currentNode.left!=null){
               if(currentNode.left.left == null && currentNode.right.right == null){
                   sum = sum + currentNode.left.value;
                   queue.offer(currentNode.left);
               }
           }
           if(currentNode.right!=null){
               queue.offer(currentNode.right);
           }
       }
      
        return sum;
       
    }
    private int sumofLeftLeavesRecurrsion(Node node){
        if(node == null){
            return 0;
        }
        int sum = 0;
        if(node.left!=null && node.left.left == null && node.left.right == null){
            sum = sum + node.left.value;
        }
        return sumofLeftLeavesRecurrsion(node.left) + sumofLeftLeavesRecurrsion(node.right) + sum;
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
        // TODO code application logic here
    }
}
