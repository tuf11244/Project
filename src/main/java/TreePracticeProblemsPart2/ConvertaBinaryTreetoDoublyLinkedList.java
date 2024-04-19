/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;

/**
 * Date: 04/18/2024
 *https://www.geeksforgeeks.org/convert-binary-tree-to-doubly-linked-list-by-keeping-track-of-visited-node/
 * 
 * Can be solved using Morris Traversal Also
 * @author parth
 */
public class ConvertaBinaryTreetoDoublyLinkedList {
    private static Node previous = null;
    
    public ConvertaBinaryTreetoDoublyLinkedList(){
       
    }
    //We are treating right pointer as a next pointer of DLL
    //We are treating left pointers as a previous pointer of DLL
    public Node convertDLL(Node root){
        Node dummy = new Node(-1);
        previous = dummy;
        
        convertDLLHelper(root);
        
        Node head = dummy.right;
        dummy.right = null;
        head.left = null;
        
        //For circular linkedlist 
       /* head.left = previous;
        previous.right = head;*/
        
        return head;
    }
    private void convertDLLHelper(Node root){
        if(root == null){
            return;
        }
        //Inorder traversal 
        convertDLLHelper(root.left);
        previous.right = root;
        root.left = previous;
        previous = root;
        
        
        convertDLLHelper(root.right);
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
            this.left = left;
            this.right = right;
        }
                     
    }

   
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
