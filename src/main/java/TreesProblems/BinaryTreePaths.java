/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *https://leetcode.com/problems/binary-tree-paths/
 * @author parth
 */
public class BinaryTreePaths {
      private Node root;
      public BinaryTreePaths(){
          
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
    public List<String> binaryPaths(){
        List<String> answer = new ArrayList<>();
        binaryPaths(root,"",answer);
        return answer;
    }
    public void binaryPaths(Node node,String str,List<String> answer){
        if(node == null){
            return;
        }
         str= str + node.value+"->";
        if(node.left == null && node.right == null){
            answer.add(str.substring(0,str.length()-2));
        }
        binaryPaths(node.left,str,answer);
        binaryPaths(node.right,str,answer);
    }

      private class Node{
        int value;
        Node left;
        Node right;
        
        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node left, Node right){
            this.value = value;
            this.left =left;
            this.right = right;
        }
    }
    public static void main(String args[]) {
        BinaryTreePaths tree = new BinaryTreePaths();
        Scanner scanner = new Scanner(System.in);
        tree.insert(scanner);
        List<String> element = tree.binaryPaths();
        for(String i : element){
            System.out.println(i);
        }
    }
}
