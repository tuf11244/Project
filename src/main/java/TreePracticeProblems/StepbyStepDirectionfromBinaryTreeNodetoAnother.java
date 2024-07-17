/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;
import java.util.*;
import java.util.Scanner;

/**
 * Date: 10/13/2023
 *https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
 * @author parth
 */
public class StepbyStepDirectionfromBinaryTreeNodetoAnother {

    public static void main(String args[]) {
       Solution6 tree = new Solution6();
       Scanner scanner = new Scanner(System.in);
       tree.insert(scanner);
       
       String answer = tree.getDirection(3, 6);
        System.out.println(answer);
    }
}
class Solution6{
    private Node root;
    public Solution6(){
        
    }
    
    
    public void insert(Scanner scanner){
        System.out.println("Enter the root value ");
        int value = scanner.nextInt();
        root = new Node(value);
        insert(root,scanner);
    }
    private void insert(Node node, Scanner scanner){
        System.out.println("Do you want to enter value to the left of " + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value to the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            insert(node.left,scanner);
        }
        System.out.println("Do you want to enter value to the right of " + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value to the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            insert(node.right,scanner);
        }
    }
    
    //Naive way 
    //We are finding the parentNode of each node 
    //and than doing a normal bfs to find the shortest path
    public String getDirection(int start, int end){
         return helper(root, start, end);
    }
    public Node findNode(int val, Node root){
        if(root == null){
            return null;
        }
        if(root.value == val){
            return root;
        }
        
        Node left = findNode(val,root.left);
        
        if(left != null){
            return left;
        }
        return findNode(val,root.right); 
    }
    public String helper(Node root, int start, int end){
        HashMap<Node,Node> parentMap = new HashMap<>();
        function(root,null,parentMap);
        Queue<Pair> queue = new LinkedList<>();
        
        Node startNode = findNode(start,root);
        Node endNode = findNode(end,root);
        queue.add(new Pair(startNode,""));
        Set<Integer> visited = new HashSet<>();
        
        while(!queue.isEmpty()){
            Pair rem = queue.poll();
            
            if(visited.contains(rem.node.value)){
                continue;
            }
            if(rem.node.value == end){
                return rem.psf;
            }
            
            visited.add(rem.node.value);
            
            if(rem.node.left != null && !visited.contains(rem.node.left.value)){
                queue.add(new Pair(rem.node.left,rem.psf + "L"));
            }
            if(rem.node.right != null && !visited.contains(rem.node.right.value)){
                queue.add(new Pair(rem.node.right,rem.psf + "R"));
            }
            Node parentN = parentMap.get(rem.node);
            if(parentN!= null && !visited.contains(parentN.value)){
                queue.add(new Pair(parentN,rem.psf + "U"));
            }
        }
        return "";
        
    }
    public void function(Node root,Node parent, HashMap<Node,Node> parentMap){
        if(root == null){
            return;
        }
        
        parentMap.put(root,parent);
        function(root.left,root,parentMap);
        function(root.right,root,parentMap);
        
    }

   private class Pair{
       Node node;
       String psf;
       
       public Pair(Node node, String psf){
           this.node = node;
           this.psf = psf;
       }
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

//Optimized Approach 

// Definition for a binary tree node.
   class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 

class Soln {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = lowestCommonAncestor(root, startValue, destValue);
        
        StringBuilder lcaToStart = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();
        
        getPath(lca, startValue, lcaToStart);
        getPath(lca, destValue, lcaToDest);
        
        // Replace all characters in lcaToStart with 'U'
        for (int i = 0; i < lcaToStart.length(); i++) {
            lcaToStart.setCharAt(i, 'U');
        }
        
        // Concatenate the paths
        String result = lcaToStart.toString() + lcaToDest.toString();
        
        return result;
    }

    private boolean getPath(TreeNode root, int value, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        }
        
        path.append('L');
        if (getPath(root.left, value, path)) {
            return true;
        }
        path.setLength(path.length() - 1); // backtrack
        
        path.append('R');
        if (getPath(root.right, value, path)) {
            return true;
        }
        path.setLength(path.length() - 1); // backtrack
        
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int sv, int dv) {
        if (root == null) {
            return null;
        }
        if (root.val == sv || root.val == dv) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, sv, dv);
        TreeNode right = lowestCommonAncestor(root.right, sv, dv);
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }
}

