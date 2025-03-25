/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;
import java.util.Scanner;
/**
 *Date: 09/23/2023
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * https://leetcode.com/problems/path-sum/ (Date: 09/29/2023 : function hasPathSum)
 * https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/ (Date : 11/25/2024 : function maximumPathSumLeafToLeaf())
 * @author parth
 */
public class MaximumPathSum {
    private Node root;
    public int result;
    
    public MaximumPathSum(){
        this.result = Integer.MIN_VALUE;
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
            System.out.println("Enter value to the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            insert(node.left,scanner);
        }
        System.out.println("Do you want to enter value to the right of " + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter valye to the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            insert(node.right,scanner);
        }
    }
     public void display(){
        display(root," ");
    }

    private void display(Node node, String indent) {
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");       
    }
    public int maximumPathSum(){
        maximumPathSum(root);
        return result;
    }
    private int maximumPathSum(Node node){
        if(node == null){
            return 0;
        }
        int left = maximumPathSum(node.left);
        int right = maximumPathSum(node.right);
        
        int temp = Math.max(Math.max(left, right) + node.value,node.value); //When it doesn't want to be the part
        int answer = Math.max(left+right+node.value, temp); //when it wants to be the part
        result = Math.max(result,answer);
        return temp;
    }
    public int maximumPathSumLeafToLeaf(){
        Pair p = maximumPathSumLeaftoLeaf(root);
        return p.LTLMaxPathSum;
    }
    private Pair maximumPathSumLeaftoLeaf(Node node){
        
        if(node == null){
            Pair p = new Pair();
            p.LTLMaxPathSum = Integer.MIN_VALUE;
            p.NTLMaxPathSum = Integer.MIN_VALUE;
            return p;
        }
        
        //Its a leaf Node
        if(node.left == null && node.right == null){
            Pair p = new Pair();
            p.LTLMaxPathSum = Integer.MIN_VALUE; //since its a leaf node , a leaf to Leaf Max Path Sum cannot exits
            p.NTLMaxPathSum = node.value;
            
            return p;
        } 
        
        Pair left = maximumPathSumLeaftoLeaf(node.left);
        Pair right = maximumPathSumLeaftoLeaf(node.right);
        
        Pair answer = new Pair();
        answer.LTLMaxPathSum = Integer.MIN_VALUE;
        answer.NTLMaxPathSum = Integer.MIN_VALUE;
        
        answer.LTLMaxPathSum = Math.max(left.LTLMaxPathSum,right.LTLMaxPathSum);
        
        if(node.left != null && node.right != null){
            answer.LTLMaxPathSum = Math.max(answer.LTLMaxPathSum, left.NTLMaxPathSum + right.NTLMaxPathSum + node.value);
        }
        
        answer.NTLMaxPathSum = Math.max(left.NTLMaxPathSum,right.NTLMaxPathSum) + node.value;
        
        return answer;
    }
    public boolean hasPathSum(){
        return hasPathSum(root,22);
    }
    private boolean hasPathSum(Node node, int target){
        if(node == null){
            return false;
        }
        //Found the answer
        if(node.value == target && node.left == null && node.right == null){
            return true;
        }
        //call recurssion
        return hasPathSum(node.left,target-node.value) || hasPathSum(node.right,target-node.value);
    }
    
    
    
    private class Pair{
        int LTLMaxPathSum;
        int NTLMaxPathSum;
    }
    
    private class Node{
        int value;
        Node left; 
        Node right;
        
        public Node(int value){
            this.value = value;
        }
        public Node(int value,Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    
    public static void main(String args[]) {
        MaximumPathSum tree = new MaximumPathSum();
        Scanner scanner = new Scanner(System.in);
        tree.insert(scanner);
        System.out.println("Maximum Path sum " + tree.maximumPathSum());
        System.out.println("Maximum Path sum from leaf node to leaf node " + tree.maximumPathSumLeafToLeaf());
    }
}
/*
class Solution {
    
    public int maxPathSum(TreeNode root) {
        // Call the helper function to compute the max path sum
        Pair p = helper(root);
        return p.NTNMaxPathSum; // Return the max node-to-node path sum
    }

    public Pair helper(TreeNode root) {
        // Base case: If the node is null, return default values
        if (root == null) {
            Pair p = new Pair();
            p.NTNMaxPathSum = Integer.MIN_VALUE; // Since there's no path, set it to the smallest possible value
            p.RTNMaxPathSum = 0; // No contribution from an empty node
            return p;
        }

        // Recursively compute left and right subtree results
        Pair left = helper(root.left);
        Pair right = helper(root.right);

        Pair answer = new Pair();

        // Calculate root-to-node max path sum
        // Either take the current node alone or extend from left/right subtree
        answer.RTNMaxPathSum = Math.max(root.val, Math.max(left.RTNMaxPathSum, right.RTNMaxPathSum) + root.val);
       
        // Calculate node-to-node max path sum
        // This considers:
        // 1. Max path sum from the left subtree
        // 2. Max path sum from the right subtree
        // 3. A new path that includes the root and both left and right subtree contributions
        // 4. Just the root itself (in case it's the highest value alone)
        // 5. The best root-to-node path sum (ensuring a path is always considered)
        answer.NTNMaxPathSum = getMax(
            left.NTNMaxPathSum,  // Max path in the left subtree
            right.NTNMaxPathSum, // Max path in the right subtree
            left.RTNMaxPathSum + root.val + right.RTNMaxPathSum, // Path through the root
            root.val, // The root node alone
            answer.RTNMaxPathSum // The best root-to-node path sum
        );

        return answer;
    }

    // Utility function to find the maximum value among multiple integers
    public int getMax(int... arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}

// Helper class to store two values for each node
class Pair {
    int NTNMaxPathSum; // Node-to-Node Max Path Sum
    int RTNMaxPathSum; // Root-to-Node Max Path Sum (includes root)
}

*/