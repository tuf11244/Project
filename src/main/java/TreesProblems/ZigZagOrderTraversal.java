/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *Date: 09/27/2023
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * @author parth
 */
public class ZigZagOrderTraversal {
    private Node root;
    public ZigZagOrderTraversal(){
        
    }
    public List<List<Integer>> zigZagOrderTraversal(){
        return zigZagOrderTraversal(root);
    }
    private List<List<Integer>> zigZagOrderTraversal(Node node){
        List<List<Integer>> answer = new ArrayList<>();
        if(node == null){
            return answer;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        boolean reverse = false;
        while(!queue.isEmpty()){
        int levelSize = queue.size();
        List<Integer> currentLevelList = new ArrayList<>(levelSize);
        for(int i = 0; i < levelSize;i++){  
         if(!reverse){
         Node currentNode = queue.pollFirst();
         currentLevelList.add(currentNode.value); //Add the value to the current Level List
         if(currentNode.left!=null){
             queue.offerLast(currentNode.left);
         }
         if(currentNode.right!=null){
             queue.offerLast(currentNode.right);
         }          
         }else{
          Node currentNode = queue.pollLast();
          currentLevelList.add(currentNode.value); //Add the value to the current Level List
         if(currentNode.right!=null){
             queue.offerFirst(currentNode.right);
         }
         if(currentNode.left!=null){
             queue.offerFirst(currentNode.left);
         }            
         }
        }
        reverse = !reverse;
        answer.add(currentLevelList);
    }
        return answer;                
    }
    
    
    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    
    public List<List<Integer>> levelOrderBottom(){
        return levelOrderBottom(root);
    }
    private List<List<Integer>> levelOrderBottom(Node node){
        List<List<Integer>> answer = new ArrayList<>();
        if(node == null){
            return answer;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        boolean reverse = false;
        while(!queue.isEmpty()){
        int levelSize = queue.size();
        List<Integer> currentLevelList = new ArrayList<>(levelSize);
        for(int i = 0; i < levelSize;i++){  
         if(!reverse){
         Node currentNode = queue.pollFirst();
         currentLevelList.add(currentNode.value); //Add the value to the current Level List
         if(currentNode.left!=null){
             queue.offerLast(currentNode.left);
         }
         if(currentNode.right!=null){
             queue.offerLast(currentNode.right);
         }          
         }else{
          Node currentNode = queue.pollLast();
          currentLevelList.add(currentNode.value); //Add the value to the current Level List
         if(currentNode.right!=null){
             queue.offerFirst(currentNode.right);
         }
         if(currentNode.left!=null){
             queue.offerFirst(currentNode.left);
         }            
         }
        }
        reverse = !reverse;
        answer.add(0,currentLevelList);
    }
        return answer;                
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
    
    private class Node{
        int value;
        Node left;
        Node right;
        
        public Node(int value){
            this.value = value;
        }
    }
    public static void main(String args[]) {
        ZigZagOrderTraversal tree = new ZigZagOrderTraversal();
        Scanner scanner = new Scanner(System.in);
        
        tree.insert(scanner);
        
        List<List<Integer>> answer = tree.zigZagOrderTraversal();
        
        for(List<Integer> element : answer){
            System.out.print("The Zig Zag order is " + element);
        }
        // TODO code application logic here
    }
}
