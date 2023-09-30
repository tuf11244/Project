/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;

/**
 * Date: 09/29/2023
 *https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * @author parth
 */
public class SerializeandDeSerialize {
    private Node root;
    private int index;
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
       return deserializehelper(values);
    }
    private Node deserializehelper(String[] values){
        if(index >= values.length || values[index].equals("null")){
            index = index + 1;
            return null;
        }
        Node node = new Node(Integer.parseInt(values[index]));
        index = index + 1;
        node.left = deserializehelper(values);
        node.right = deserializehelper(values);
        
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
