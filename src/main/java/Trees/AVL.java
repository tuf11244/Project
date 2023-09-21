/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Trees;

/**
 *Date: 09/20/2023
 * @author parth
 */
public class AVL {


    private Node root;
    
    public AVL(){     
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
        return rotate(node);       
    }
    private Node rotate(Node node){
        //Left heavy tree
        if(height(node.left) - height(node.right) > 1){
            if(height(node.left.left) - height(node.left.right) > 0){
                //Left-Left case 
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){
                //Left-Right Case 
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        
        //Right heavy tree 
         if(height(node.left) - height(node.right) < -1){
            if(height(node.right.left) - height(node.right.right) < 0){
                //Right-Right case 
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                //Right - Left Case 
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
         return node;
    }
    public Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;
        
        c.right = p;
        p.left = t;
        
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }
    
    public Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left;
        
        p.left = c;
        c.right = t;
        
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        
        return p;
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
      //  int[] arr = {1,2,3,4,5,6,7,8,9,10};
        AVL tree = new AVL();
        for(int i = 0; i < 1000; i++){
            tree.insert(i);
        }
        tree.display();
        System.out.println(tree.height());
       
        
    }
}


