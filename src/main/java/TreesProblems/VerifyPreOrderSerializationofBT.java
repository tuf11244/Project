/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;
import java.util.Scanner;

class Solution {
    private Node root;

    // Constructor for the Solution class
    public Solution() {
    }

    // Method to insert nodes into the binary tree
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

    // Method to serialize the binary tree into a string using preorder traversal
    public String serialization() {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // Recursive helper method to serialize the binary tree
    private void serialize(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(",");
        } else {
            sb.append(node.value).append(",");
            serialize(node.left, sb);
            serialize(node.right, sb);
        }
    }

    // Method to check if the given preorder serialization is valid or not
    public boolean isValidSerialization(String preOrder) {
        String[] nodes = preOrder.split(",");
        return isValidSerialization(nodes);
    }

    // Recursive helper method to validate the preorder serialization
    private int index = 0;

    private boolean isValidSerialization(String[] nodes) {
        if (index >= nodes.length) {
            return false;
        }
        String nodeValue = nodes[index++];
        if (nodeValue.equals("#")) {
            return true;
        }
        return isValidSerialization(nodes);
    }

    // Node class representing a node in the binary tree
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

// Main class
public class VerifyPreOrderSerializationofBT {

    // Main method
    public static void main(String[] args) {
        // Example preorder serialization
        String preOrder = "9,3,4,#,#,1,#,#,2,#,6,#,#";

        // Create a Solution object
        Solution tree = new Solution();

        // Create a scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Insert nodes into the binary tree
        tree.insert(scanner);

        // Print the serialized tree
        System.out.println("Serialized Tree: " + tree.serialization());

        // Check if the given preorder serialization is valid and print the result
        System.out.println("Is valid preorder serialization? " + tree.isValidSerialization(preOrder));
    }
}


