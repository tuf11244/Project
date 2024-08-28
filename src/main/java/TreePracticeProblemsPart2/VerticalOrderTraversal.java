/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * Date: 04/19/2024
 * Did this question by myself
 * @author parth
 */
public class VerticalOrderTraversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}

class Vertical{
    
    private class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
}



 /* Definition for a binary tree node.*/
 class Node {
      int val;
      Node left;
      Node right;
      Node() {}
      Node(int val) { this.val = val; }
      Node(int val, Node left, Node right) {
          this.val = val;
         this.left = left;
          this.right = right;
      }
 }
 
class Solution {
    public List<List<Integer>> verticalTraversal(Node root) {
       HashMap<Integer,List<Pair>> hm = new HashMap<>();
       List<List<Integer>> answer = new ArrayList<>();
       helper(root,hm,0,0);
       
       List<Integer> sortedKeys = new ArrayList<>(hm.keySet()); //This step is to sort the hashMap by sorting the keys 
       Collections.sort(sortedKeys);

       for(int x : sortedKeys){
        List<Pair> removed = hm.get(x);
        List<Integer> temp = new ArrayList<>();
        for(Pair p : removed){
            temp.add(p.value);
        }
        answer.add(temp); 
       }   
    

        return answer;
    }
    public void helper(Node root, HashMap<Integer,List<Pair>> hm, int row, int column){
        if(root == null){
            return;
        }
        if(hm.containsKey(column)){
         List<Pair> list = hm.get(column);
         list.add(new Pair(row,column,root.val));
         Collections.sort(list);
        }else{
            Pair p = new Pair(row,column,root.val);
            List<Pair> list = new ArrayList<>();
            list.add(p);
            hm.put(column,list);
        }

        //Recursion calls 
        helper(root.left,hm,row+1,column-1);        
        helper(root.right,hm,row+1,column+1);

    }
    
}
class Pair implements Comparable<Pair>{
    int row;
    int column;
    int value;

    public Pair(int row, int column, int value){
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int compareTo(Pair o){
        if(this.row != o.row){
            return this.row - o.row;
        }
        return this.value - o.value;   //if the row is also same

    }
    public String toString(){
        return "Pair " + row + " " + column + " " + value;
    }
}