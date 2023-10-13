/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

/**
 *Date: 10/12/2023
 * https://leetcode.com/problems/validate-binary-tree-nodes/
 * @author parth
 */
class Solution3{
    private Node root;
    
    public Solution3(){
        
    }
    public boolean validateBinaryTreeNodes(int n,int[] leftchild, int[] rightchild){
       int[] indegrees = new int[n];
       
       //Calculate in-degrees for each node
       for(int i = 0; i < n; i++){
           if(leftchild[i]!= -1){
               indegrees[leftchild[i]]++;
               if(indegrees[leftchild[i]] > 1){
                   return false;
               }
           }
           if(rightchild[i]!= -1){
               indegrees[rightchild[i]]++;
               if(indegrees[rightchild[i]] > 1){
                   return false;
               }
           }
       }
       int rootcount = 0;
       
       // Check in-degrees and count the root nodes
       for(int degree : indegrees){
           if(degree == 0){
               rootcount = rootcount + 1;
               if(rootcount > 1){
                   return false;
               }
           } else if (degree > 1){
               return false;
           }
       }
       
       boolean visited[] = new boolean[n];
       
       // If there is not exactly one root node, it's not a valid binary tree
       if(rootcount!= 1){
           return false;
       }
       
       //Perform dfs on each node
       return helper(0,leftchild, rightchild,visited);
       
    }
    private boolean helper(int node, int[] leftchild, int[] rightchild, boolean[] visited){
        if(node == -1){
            return true; //// Not a valid node, return true
        }
        if(visited[node]){
            return false;  // Already visited, return false
        }
        visited[node] = true;
        return helper(leftchild[node],leftchild,rightchild,visited) && helper(rightchild[node],leftchild,rightchild,visited);
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
