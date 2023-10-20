/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;

import java.util.ArrayList;
import java.util.List;

/**
 *Date: 10/19/2023
 * https://leetcode.com/problems/merge-bsts-to-create-single-bst/
 * 
 */
public class MergeBSTstoCreateSingleBST {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        MergeBST tree = new MergeBST();
        List<MergeBST.Node> trees = new ArrayList<>();

        // Create BST nodes here (example nodes)
        MergeBST.Node node1 = tree.new Node(5);
        node1.left = tree.new Node(4);
        
        MergeBST.Node node3 = tree.new Node(3);

        // Add BST nodes to the list
        trees.add(node1);
       // trees.add(node2);
        trees.add(node3);

        // Call canMerge method to merge BSTs
        MergeBST.Node mergedRoot = tree.canMerge(trees);
        
        if (mergedRoot != null) {
            System.out.println("Merged BST is valid.");
        } else {
            System.out.println("Merged BST is not valid.");
        }
        
    }
}
class MergeBST{
    private Node root;
    public MergeBST(){
    } 
    public void createAnswer(){
  
    }
    public Node canMerge(List<Node> trees){
        if(trees.size() == 0 || trees == null){
            return null;
        }
        
        //Start with the first BST and merge it with the rest
        Node mergedRoot = trees.get(0);
        for(int i = 0; i < trees.size();i++){
            mergedRoot = merge(mergedRoot,trees.get(i));
        }
       
        if(isValidBST(mergedRoot,Integer.MIN_VALUE,Integer.MAX_VALUE)){
            return mergedRoot;
        }   
        return null;
    }
    private Node merge(Node node1,Node node2){
        if(node1 == null){
            return node2; //if node1 is null return node2
        }
        if(node2 == null){
            return node1; //if node2 is null return node1
        }
        //Compare the node value and merge them accordingly 
        if(node1.value < node2.value){
            node1.right = merge(node1.right,node2);
            return node1;
        }
        else{
            node2.left = merge(node1,node2.left);
            return node2;
        }
    }
    private boolean isValidBST(Node node,int min, int max){
        if(node == null){
            return true;
        }
        if(node.value > max || node.value < min){
            return false;
        }
        boolean left = isValidBST(node.left,min,node.value);
        boolean right = isValidBST(node.right,node.value,max);
        
        return left && right;
    }
    public class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
}
