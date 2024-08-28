/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
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
        HashMap<Integer,Node> roots = new HashMap<>();
        HashMap<Integer,Node> leaves = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();
        
        // Step 1: Populate maps with potential roots and leaves
        for (Node root : trees) {
            if (roots.containsKey(root.value)) return null; // Duplicate root found
            roots.put(root.value, root);
            if (root.left != null) leaves.put(root.left.value, root);
            if (root.right != null) leaves.put(root.right.value, root);
        }

        // Step 2: Identify the true root of the final BST
        Node potentialRoot = null;
        for (Node root : trees) {
            if (!leaves.containsKey(root.value)) {
                if (potentialRoot != null) return null; // Multiple roots found
                potentialRoot = root;
            }
        }
        if (potentialRoot == null) return null; // No valid root found

        // Step 3: Merge the trees using BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(potentialRoot);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (!seen.add(currentNode.value)) return null; // Cycle detected

            // Process the left child
            if (currentNode.left != null && roots.containsKey(currentNode.left.value)) {
                // Replace the left child with the subtree and add it to the queue for further processing
                currentNode.left = roots.get(currentNode.left.value);
                queue.add(currentNode.left);
            }

            // Process the right child
            if (currentNode.right != null && roots.containsKey(currentNode.right.value)) {
                // Replace the right child with the subtree and add it to the queue for further processing
                currentNode.right = roots.get(currentNode.right.value);
                queue.add(currentNode.right);
            }
        }

        // Step 4: Validate the final BST
        if (seen.size() == trees.size() && isValidBST(potentialRoot, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return potentialRoot;
        }

        return null;
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
