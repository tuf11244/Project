/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

import TreePracticeProblems.Solution8.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author parth
 */
public class MaximumWidthofBinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Solution8 tree = new Solution8();
        tree.insert(scanner);
        
        System.out.println(tree.widthofBinaryTree());
    }
}
class Solution8{
    private Node root;
    public Solution8(){
        
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
    public int widthofBinaryTree(){
        return widthofBinaryTree(root);
    }
    private int widthofBinaryTree(Node node){
        if(node == null){
            return 0;
        }
        int answer = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(node,0));
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            int min = queue.peek().num; // to make the id starting from zero 
            int first = 0;
            int last = 0;
            for(int i = 0; i < levelSize;i++){
                int currentId = queue.peek().num - min;
                 node = queue.peek().node;
                 queue.poll();
                 if(i==0){
                     first = currentId;
                 }
                 if(i == levelSize - 1){
                     last = currentId;
                 }
                 if(node.left!=null){
                     queue.offer(new Pair(node.left,currentId*2 + 1));
                 }
                 if(node.right!=null){
                     queue.offer(new Pair(node.right,currentId*2 + 2));
                 }
            }
            answer = Math.max(answer,last-first+1);
        }
        return answer;
        
    }
    
    
    public class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
}

class Pair{
    Node node;
    int num;
    Pair(Node node, int num){
        this.node = node;
        this.num = num;
    }   
}
