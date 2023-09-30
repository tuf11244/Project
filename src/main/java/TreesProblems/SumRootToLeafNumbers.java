/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

/**
 *https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * Date: 09/29/2023
 * @author parth
 */
public class SumRootToLeafNumbers {
    private Node root;
    public SumRootToLeafNumbers(){
        
    }
    public int sumRootToLeaf(){
        return sumRootToLeaf(root,0);
    }
    private int sumRootToLeaf(Node node, int sum){
        if(node == null){
            return 0;
        }
        //calculate sum of root to leaf paths 
        sum = sum*10 + node.value;
        
        //if its a leaf node return the sum;
        if(node.left == null && node.right == null){
            return sum;
        }
        
        int left = sumRootToLeaf(node.left,sum);
        int right = sumRootToLeaf(node.right,sum);
        
        //Return total sum 
        return left + right;
    }
    
    private class Node{
        int value;
        Node left; 
        Node right;
        public Node(int value){
            this.value= value;
        }
    }

    public static void main(String args[]) {
        // TODO code application logic here
    }
}
