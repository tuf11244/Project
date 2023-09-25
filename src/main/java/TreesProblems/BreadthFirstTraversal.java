/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *Date: 09/24/2023
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @author parth
 */
public class BreadthFirstTraversal {
    private Node root;
    public BreadthFirstTraversal(){
        
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
    public List<List<Integer>> breadthFirstTraversal(){
        return breadthFirstTraversal(root);
    }
    public List<List<Integer>> breadthFirstTraversal(Node node){
        List<List<Integer>> answer = new ArrayList<>();
        if(node == null){
            return answer;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>(levelSize);
            for(int i=0; i < levelSize;i++){
                Node currentNode = queue.poll();
                currentLevelList.add(currentNode.value);
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            answer.add(currentLevelList);
        }
        
       
        
        
        return answer;
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
        BreadthFirstTraversal tree = new BreadthFirstTraversal();
        Scanner scanner = new Scanner(System.in);
        tree.insert(scanner);
        List<List<Integer>> answer = tree.breadthFirstTraversal();
        for(List<Integer> element : answer){
            System.out.print(element + " " );
        }
        // TODO code application logic here
    }
}
