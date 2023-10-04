/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

import java.util.Scanner;
import java.util.Stack;

/**
 *Date: 10/03/2023
 * DFS using stack --- iterative approach;
 * @author parth
 */
public class DFSusingStack {
    private Node root;
    public DFSusingStack(){
        
    }
    public void insert(Scanner scanner){
        System.out.println("Enter the root value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        insert(root,scanner);
    }
    private void insert(Node node, Scanner scanner){
        System.out.println("Do you want enter the value left of " + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value to the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            insert(node.left,scanner);
        }
        System.out.println("Do you want enter the value right of " + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value to the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            insert(node.right,scanner);
        }
    }
    public void dfs(){
         dfs(root);
    }
    private void dfs(Node node){
        if(node == null){
           return; 
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        
        while(!stack.isEmpty()){
            Node removed = stack.pop();
            System.out.print(removed.value + " ");
            if(removed.right!=null){
                stack.push(removed.right);
            }
            if(removed.left!=null){
                stack.push(removed.left);
            }
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
        DFSusingStack tree = new DFSusingStack();
        Scanner scanner = new Scanner(System.in);
        tree.insert(scanner);
        tree.dfs();
        // TODO code application logic here
    }
}
