/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

/**
 *Date: 09/29/2023
 * You are given a tree and and arr of integers
 * the first element in the array is the root and based on the other elements you have find out if the path exists or not
 * @author parth
 */
public class PathExists {
    private Node root;
    public PathExists(){
        
    }
    public boolean pathexists(int[] arr){
        return pathexists(root,arr);
    }
    private boolean pathexists(Node node, int[] arr){
        if(node == null){
            return arr.length == 0;
        }
        return pathexists(node,arr,0);
    }
    private boolean pathexists(Node node, int[] arr, int index){
        if(node == null){
            return false;
        }
        if(index >= arr.length || node.value != arr[index]){
            return false;
        }
        if(node.left == null && node.right == null && index == arr.length-1){
            return true;
        }
        return pathexists(node.left,arr,index+1) || pathexists(node.right,arr,index+1);
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
