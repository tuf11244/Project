/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Trees;

/**
 *
 * @author parth
 */
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class UpdateandDeleteinBT {
    public static void main(String[] args) {
        Solution tree = new Solution();
        Scanner scanner = new Scanner(System.in);
        tree.insert(scanner);
        tree.display();
        System.out.println();
        tree.update(21,7);
        tree.display();
        
        System.out.println();
        tree.delete(5);
        tree.display();
        
    }
}

class Solution{
    private Node root;
    public Solution(){
        
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
    public void display(){
        display(this.root,"Root value is :");
    }
    public void display(Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.value);
        display(node.left,"The left child of " + node.value + ":");
        display(node.right,"The right child of " + node.value + ":");
    }
    public void update(int oldValue, int newValue){
       root = update(root,oldValue,newValue);
    }
    private Node update(Node node, int oldValue,int newValue){
        if(node == null){
            return node;
        }
        if(node.value == oldValue){
            node.value = newValue;
        }
        node.left = update(node.left,oldValue,newValue);
        node.right =  update(node.right,oldValue,newValue);
        return node;
    }
    public void delete(int value) {
        deleteNode(root, value);
    }
    private void deleteNode(Node node, int value) {
        if (node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Node deepestNode = null;
        Node nodeToDelete = null;

        // Level-order traversal to find the deepest node and the node to delete
        while (!queue.isEmpty()) {
            deepestNode = queue.poll();

            if (deepestNode.value == value) {
                nodeToDelete = deepestNode;
            }

            if (deepestNode.left != null) {
                queue.add(deepestNode.left);
            }

            if (deepestNode.right != null) {
                queue.add(deepestNode.right);
            }
        }

        // Delete the deepest node
        deleteDeepest(node, deepestNode);

        // Copy the value of the deepest node to the node to be deleted
        if (nodeToDelete != null) {
            nodeToDelete.value = deepestNode.value;
        }
    }
  
    private void deleteDeepest(Node node, Node nodeToDelete) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.right != null) {
                if (temp.right == nodeToDelete) {
                    temp.right = null;
                    return;
                } else {
                    queue.add(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == nodeToDelete) {
                    temp.left = null;
                    return;
                } else {
                    queue.add(temp.left);
                }
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
}
