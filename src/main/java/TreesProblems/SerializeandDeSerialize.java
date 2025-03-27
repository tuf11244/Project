/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;
import java.util.*;
/**
 * Date: 09/29/2023
 *https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * @author parth
 */
public class SerializeandDeSerialize {
    private Node root;
    public SerializeandDeSerialize(){
            
        }
    
    public String serialize(Node node){
        if(node == null){
            return "null";
        }
        String left = serialize(node.left);
        String right = serialize(node.right);
        
        return node.value + "," + left + "," + right;
    }
    public Node deserialize(String data){
       String[] values = data.split(","); //converting the string to array
       Queue<String> queue = new LinkedList<>();
       
       for(int i = 0; i < values.length;i++){
           queue.add(values[i]);
       }
       return deserializehelper(queue);
    }
    private Node deserializehelper(Queue<String> queue){
        if(queue.isEmpty()){
            return null;
        }
        
        String rem = queue.poll();
        if(rem.equals("null")){
            return null;
        }
        Node node = new Node(Integer.valueOf(rem));
        
        node.left = deserializehelper(queue);
        node.right = deserializehelper(queue);
        
        return node;
        
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
