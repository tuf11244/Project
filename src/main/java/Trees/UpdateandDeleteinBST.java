/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Trees;

/**
 *
 * @author parth
 */
public class UpdateandDeleteinBST{
	public static void main(String[] args) {
	System.out.println("Hello World");
	BST tree = new BST();
	    tree.insert(100);
	    tree.insert(50);
	    tree.insert(90);
	    tree.insert(30);
	    tree.insert(70);
	    tree.insert(80);
	    tree.insert(110);
	    
	    tree.display();
	    
	    tree.update(50,60);
	    
	    tree.display();
	}
}
class BST{
    private Node root;
    public BST(){
        
    }
    public void insert(int value){
        root = insert(root,value);
    }
    private Node insert(Node node, int value){
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value < node.value){
           node.left = insert(node.left,value);
        }
        if(value > node.value){
            node.right = insert(node.right,value);
        }
        return node;       
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
    private Node update(Node node, int oldValue, int newValue){
    if(node == null){
        return null;
    }
    
    if(node.value == oldValue){
        node.value = newValue;
    }
    // Recur for the left subtree if the new value is less than the current node's value
    if(newValue < node.value){
        node.left = update(node.left, oldValue, newValue);
    }
    // Recur for the right subtree if the new value is greater than the current node's value
    else if(newValue > node.value){
        node.right = update(node.right, oldValue, newValue);
    }
    
    return node;
}public void delete(int value) {
    root = deleteNode(root, value);
}

private Node deleteNode(Node node, int value) {
    if (node == null) {
        return node;
    }

    if (node.value == value) {
        // Node found, perform deletion based on the number of children

        // Node with one child or no child
        if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        }

        // Node with two children
        // Find the minimum value in the right subtree
        int minValue = minValue(node.right);

        // Update the node's value with the minimum value from the right subtree
        node.value = minValue;

        // Delete the node with the minimum value from the right subtree
        node.right = deleteNode(node.right, minValue);
    } else if (value < node.value) {
        node.left = deleteNode(node.left, value);
    } else {
        node.right = deleteNode(node.right, value);
    }

    return node;
}

private int minValue(Node node) {
    int minValue = node.value;
    while (node.left != null) {
        minValue = node.left.value;
        node = node.left;
    }
    return minValue;
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
