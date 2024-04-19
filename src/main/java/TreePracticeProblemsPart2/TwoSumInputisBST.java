/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 *Date:04/18/2024
 * 
 * @author parth
 */
public class TwoSumInputisBST {
    private Node root;
    
    //Brute Force Method 
    public boolean findTarget(Node root, int k) {
     //brute force
     List<Integer> list = new ArrayList<>();
     //Fill the arrayList;
     helper(list,root);
     System.out.println(list);
     //Convert the list to array for manipulation 
     int[] arr = new int[list.size()];

     for(int i = 0; i < list.size();i++){
        arr[i] = list.get(i);
     }

     //Take 2 pointers 
     int i = 0;
     int j = arr.length-1;

     while(i < j){
        if(i > 0 && arr[i] == arr[i-1]){
            i++;
            continue;
        }
        int sum = arr[i] + arr[j];
        if(sum == k){
            return true;
        }
        else if(sum < k){
            i++;
        }else{
            j--;
        }
     }
     return false;
    }

    public void helper(List<Integer> list, Node root){
        if(root == null){
            return;
        }
        helper(list,root.left);
        list.add(root.value);
        helper(list,root.right);
    }
    
    
    //A bit optimized version 
    public boolean findTargetOptimized(Node root, int k){
        HashSet<Integer> set = new HashSet<>();
        return helperOptimized(set,root,k);
    }
    
    public boolean helperOptimized(HashSet<Integer> set, Node root, int k){
        if(root == null){
            return false;
        }
        if(set.contains(k-root.value)){
            return true;
        }
        set.add(root.value);
        return helperOptimized(set,root.left,k) || helperOptimized(set,root.right,k);
    }
    
    

    private class Node{
    int value;
    Node left;
    Node right;
    public Node(){
        
    }
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


