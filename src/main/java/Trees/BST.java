/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Trees;

/**
 *Date:09/19/2023
 * @author parth
 */
public class BST {
    private Node root;
    
    public BST(){     
    }
    public int height(){
        return height(root);
    }
    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty(){
        return root == null;
    }
    //inserting elements 
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
        node.height = Math.max(height(node.left),height(node.right)) + 1;
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
    public void populate(int[] arr){
        for(int i = 0; i < arr.length;i++){
            this.insert(arr[i]);
        }
    }
    public void populateSorted(int[] arr){
        populateSorted(arr,0,arr.length);
    }
    private void populateSorted(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int middle = (start + end)/2;
        this.insert(arr[middle]);
        populateSorted(arr,start,middle);
        populateSorted(arr,middle+1,end);
    }
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
    
    private class Node{
        int value;
        Node left; 
        Node right;
        int height;
        
        public Node(int value){
            this.value = value;
        }
        
        public int getValue(){
        return value ;
        }
        
        }

    public static void main(String args[]) {
      // int [] arr = {5,27,31,9,2,79,65,89,0,1};
      //  int[] arr = {1,2,3,4,5,6,7,8,9,10};
        BST tree = new BST();
    //    tree.populate(arr);
    for(int i = 0; i < 1000; i++){
        tree.insert(i);
    }
        tree.display();
        System.out.println(tree.balanced());
        System.out.println(tree.height());
    }
}
