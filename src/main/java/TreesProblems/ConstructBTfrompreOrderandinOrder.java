/*//
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;
import java.util.Arrays;

/**
 * Date:09/29/2023
 *https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author parth
 */
public class ConstructBTfrompreOrderandinOrder {
    private Node root;
    public ConstructBTfrompreOrderandinOrder(){
        
    }
    public Node buildTree(int[] preOrder, int[] inOrder){
        if(preOrder.length == 0){
            return null;
        }
        
        int root = preOrder[0]; //the root is always the first element in the pre Order array 
        int index = 0;
        
        //For loop to find the correct index of root in the inorder array
        for(int i = 0; i < inOrder.length;i++){
            if(inOrder[i]== root){
                index = i;
            }
        }
        Node node = new Node(root); //create a new node as root 
        
        //Recursion calls on the left tree and right tree
        node.left = buildTree(Arrays.copyOfRange(preOrder, 1, index+1), Arrays.copyOfRange(inOrder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preOrder, index+1, preOrder.length), Arrays.copyOfRange(inOrder, index+1, inOrder.length));
    
        return node;
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
        ConstructBTfrompreOrderandinOrder tree = new ConstructBTfrompreOrderandinOrder();
        int[] preOrder = {3,9,20,15,17};
        int[] inOrder ={9,3,15,20,17};
        
        tree.buildTree(preOrder, inOrder);
        // TODO code application logic here
    }
}
