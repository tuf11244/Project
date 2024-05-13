/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *Date: 10/12/2023
 * https://leetcode.com/problems/validate-binary-tree-nodes/
 * A binary tree is valid when 
 * - One one root is there 
 * - One one parent 
 * - Parent at most have 2 children 
 * - There is no cycle 
 * @author parth
 */
class Solution3{
    
    public Solution3(){
        
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    // Set to store unique child nodes
    Set<Integer> uniqueNode = new HashSet<>();
    
    // Iterate through leftChild array to find unique child nodes
    for(int left : leftChild){
        if(left != -1)
            uniqueNode.add(left);
    }
    
    // Iterate through rightChild array to find unique child nodes
    for(int right : rightChild){
        if(right != -1)
            uniqueNode.add(right);
    }
    
    // If any node is not a child of any other node, it's considered the root
    int root = -1;
    for(int i = 0; i < n; i++){
        if(uniqueNode.contains(i)){
            continue; // Skip nodes that are child nodes
        }
        root = i; // Set as root if not found in uniqueNode set
        break;
    }
    
    // If no root is found, return false
    if(root == -1){
        return false;
    }
    
    // Queue for BFS traversal, starting with root node
    Queue<Integer> queue = new LinkedList<>();
    // Set to track visited nodes
    Set<Integer> visited = new HashSet<>();
    queue.add(root); // Add root to queue
    
    // BFS traversal
    while(!queue.isEmpty()){
        int size = queue.size();
        while(size > 0){
            int node = queue.poll();
            
            // If node is visited more than once, return false (cycle detected)
            if(visited.contains(node)){
                return false;
            }
            
            visited.add(node); // Mark node as visited
            
            // Add left child to queue if exists
            if(leftChild[node] != -1){
                queue.add(leftChild[node]);
            }
            // Add right child to queue if exists
            if(rightChild[node] != -1){
                queue.add(rightChild[node]);
            }
            size--; // Decrement size to track level nodes
        }
    }
    
    // Check if all nodes are visited, return true if all nodes are visited exactly once
    return visited.size() == n;
}

}
public class ValidateBinaryTreeNodes {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Solution3 tree = new Solution3();
        int n = 4;
        int[] leftChild = {1,-1,3,-1};
        int[] rightChild = {2, -1, -1,-1};
        System.out.println(tree.validateBinaryTreeNodes(n, leftChild, rightChild));
    }
}
