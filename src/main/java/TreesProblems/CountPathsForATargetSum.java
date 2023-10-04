/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *Date: 10/03/2023
 * Description: Count Paths for a target Sum and that are from any node to any node
 * @author parth
 */
public class CountPathsForATargetSum {
    private Node root;
    public CountPathsForATargetSum(){
        
    }
    public int countPath(){
       return countPath(root,4);      
    }
    private int countPath(Node node, int sum){
        List<Integer> path = new ArrayList<>();
        return countPathHelper(node,sum,path);
    }
    private int countPathHelper(Node node, int sum, List<Integer> path){
        if(node == null){
            return 0;
        }
        path.add(node.value); //Back tracking
        int count = 0;
        int currentSum = 0;
        //how many path I can make;
        ListIterator<Integer> itr = path.listIterator(path.size());
        while(itr.hasPrevious()){
            currentSum = currentSum + itr.previous();
            if(currentSum == sum){
                count = count + 1;
            }
        }
              
        path.remove(path.size()-1);
        count = count + countPathHelper(node.left,sum,path) + countPathHelper(node.right,sum,path);
        return count;
    }
    public List<List<Integer>> printPaths(Node node,int sum){
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helperPrintPaths(node,sum,path,paths);
        return paths;
    }
    private void helperPrintPaths(Node node, int sum, List<Integer> path, List<List<Integer>> paths){
        if(node == null){
            return;
        }
        path.add(node.value);
        if(node.value == sum && node.left == null && node.right == null){
            paths.add(new ArrayList<>(path));
        }
        helperPrintPaths(node.left,sum-node.value,path,paths);
        helperPrintPaths(node.right,sum-node.value,path,paths);
        
        path.remove(path.size()-1);
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
        // TODO code application logic here
    }
}
